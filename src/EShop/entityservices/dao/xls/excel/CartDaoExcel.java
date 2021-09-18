package EShop.entityservices.dao.xls.excel;

import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import EShop.entityservices.converter.xlstoentity.IXlsToEntityConversor;
import src.entity.Cart;
import src.inter.IServiceLocator;

@RequestScoped
public class CartDaoExcel implements IXlsToEntityConversor<Cart> {
	


	@Override
	public Cart rowToEntity(Row row, IServiceLocator serviceLocator) {		
		//ID-VALUE
		DataFormatter formatter = new DataFormatter();
		Cart nuevo = serviceLocator.getCartServices().getTransferObject();
				
		nuevo.setId(Integer.valueOf(formatter.formatCellValue(row.getCell(1)))); 
		nuevo.setValue(Float.valueOf(formatter.formatCellValue(row.getCell(2)))); 
		
		return nuevo;		
	}

	@Override
	public Row entityToRow(Cart entity, Row row) {
		// TODO Auto-generated method stub
		return null;
	}

}
