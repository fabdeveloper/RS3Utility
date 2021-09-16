package EShop.entityservices.converter.xlstoentity;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import src.entity.Product;
import src.exception.RS3Exception;
import src.inter.IServiceLocator;


@RequestScoped
public class ProductXlsToEntityConverter extends AbstractXlsToEntityConverter<Product> {

	@Override
	public Product rowToEntity(Row row, IServiceLocator serviceLocator) {
		
		Product prod = serviceLocator.getProductServices().getTransferObject();
		DataFormatter formatter = new DataFormatter();
		
		String errorMsg = new Date() + " - ->  ProductXlsToEntityConverter.rowToEntity() - ERRORLIST: ";
		Boolean bAlgunError = false;		
		/*
		 * ID - primary key
		 * NAME - not null
		 * TYPE - not null
		 */
		
		// ID
		String sid = formatter.formatCellValue(row.getCell(0));
		Integer id = null;
		if(sid != null && !sid.isEmpty()) {
			try {
				id = Integer.parseInt(sid);
			}catch(Throwable t) {
				errorMsg += "ID value = " + sid + " / ";
				bAlgunError = true;				
			}
		}
		
		// NAME
		String name = formatter.formatCellValue(row.getCell(1));
		if(name.isEmpty() || name == null) {			
			errorMsg += "NAME is mandatory" + " / ";
			bAlgunError = true;
		}
		
		
		// TYPE
		String type = formatter.formatCellValue(row.getCell(2));
		if(type.isEmpty() || type == null) {			
			errorMsg += "TYPE is mandatory" + " / ";
			bAlgunError = true;
		}
		
		if(bAlgunError) {
			throw new RS3Exception(errorMsg);
		}

		
		prod.setId(id);
		prod.setName(name);
		prod.setType(type);
		prod.setUrlImage(row.getCell(3).getRichStringCellValue().getString());	
		
	
//		String msg = "ProductDaoExcel.rowToEntity() - loaded from excel with entityId= " + prod.getId() + ", name= " + prod.getName();
//		publish(msg);					
		return prod;
	}

}
