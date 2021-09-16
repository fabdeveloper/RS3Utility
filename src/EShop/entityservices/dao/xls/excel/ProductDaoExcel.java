package EShop.entityservices.dao.xls.excel;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

import org.apache.poi.ss.usermodel.Row;

import src.entity.Product;
import src.exception.RS3Exception;
import src.inter.IServiceLocator;

//@RequestScoped
//@Alternative
public class ProductDaoExcel implements IXlsToEntityConversor<Product> {


	@Override
	public Product rowToEntity(Row row, IServiceLocator serviceLocator) {
		Product prod = serviceLocator.getProductServices().getTransferObject();
		try {				
//			prod.setId((int)row.getCell(0).getNumericCellValue());
			prod.setName(row.getCell(1).getRichStringCellValue().getString());
			prod.setType(row.getCell(2).getRichStringCellValue().getString());
			prod.setUrlImage(row.getCell(3).getRichStringCellValue().getString());			
			
		}catch(Throwable t) {	
			String msg = "ProductDaoExcel.rowToEntity() - ERROR - msg= " + t.getMessage();
			throw new RS3Exception(msg);			
		}		
//		String msg = "ProductDaoExcel.rowToEntity() - loaded from excel with entityId= " + prod.getId() + ", name= " + prod.getName();
//		publish(msg);					
		return prod;
	}

}

