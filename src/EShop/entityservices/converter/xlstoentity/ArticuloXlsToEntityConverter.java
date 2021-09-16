package EShop.entityservices.converter.xlstoentity;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import src.entity.Articulo;
import src.entity.Product;
import src.exception.RS3Exception;
import src.inter.IServiceLocator;


@RequestScoped
public class ArticuloXlsToEntityConverter extends AbstractXlsToEntityConverter<Articulo> {

	@Override
	public Articulo rowToEntity(Row row, IServiceLocator serviceLocator) {
//		System.out.println(new Date() + " - ->  ArticuloXlsToEntityConverter.rowToEntity() - processing row");
		
		String errorMsg = new Date() + " - ->  ArticuloXlsToEntityConverter.rowToEntity() - ERRORLIST: ";
		Boolean bAlgunError = false;	
		
		DataFormatter formatter = new DataFormatter();
		Articulo art = serviceLocator.getArticuloServices().getTransferObject();
		/*
		 * ID - primary key
		 * NAME - not null
		 * PRODUCT - not null
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
		if(name == null || name.isEmpty()) {			
			errorMsg += "NAME is mandatory" + " / ";
			bAlgunError = true;
		}
		
		// PRODUCT
		String sProduct_id = formatter.formatCellValue(row.getCell(5));
		if(sProduct_id != null && !sProduct_id.isEmpty()) {
			try {
				Integer product_id = Integer.valueOf(sProduct_id);
				if(product_id != null) {
					Product prod = serviceLocator.getProductServices().read(product_id);
					art.setProduct(prod);
				}
			}catch(Throwable t) {
			
			}
		}
		
		// PRICE
		Float price = null;
		try {
			price = Float.valueOf(formatter.formatCellValue(row.getCell(3)));
		}catch(Throwable t) {
			
		}
		

		if(bAlgunError) {
			throw new RS3Exception(errorMsg);
		}
		
		// ALL OTHER
		art.setId(id);
		art.setName(name);
		art.setDescripcion(formatter.formatCellValue(row.getCell(2)));
		art.setPrice(price);
		art.setUrlImage(formatter.formatCellValue(row.getCell(4)));
		
		
		return art;
	}

}
