package EShop.entityservices.dao.xls.excel;

import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import EShop.entityservices.converter.xlstoentity.IXlsToEntityConversor;
import src.entity.Order;
import src.inter.IServiceLocator;

@RequestScoped
public class OrderDaoExcel implements IXlsToEntityConversor<Order> {
	


	@Override
	public Order rowToEntity(Row row, IServiceLocator serviceLocator) {
		//ID - CONFIRMATION_DATE - CREATION_DATE - LAST_MODIFICATION_DATE - CLIENT_ID - CART_ID - DELIVERYDETAILS_ID - PURCHASESTATUS_ID

		DataFormatter formatter = new DataFormatter();
		Order nuevo = serviceLocator.getOrderServices().getTransferObject();
				
//		nuevo.setId(Integer.valueOf(formatter.formatCellValue(row.getCell(1)))); 
//		nuevo.setConfirmationDate(Float.valueOf(formatter.formatCellValue(row.getCell(2)))); 
//		nuevo.setCreationDate(Float.valueOf(formatter.formatCellValue(row.getCell(2)))); 
//		nuevo.setLastModificationDate(Float.valueOf(formatter.formatCellValue(row.getCell(2)))); 
//		nuevo.setClient(Float.valueOf(formatter.formatCellValue(row.getCell(2)))); 
//		nuevo.setCart(Float.valueOf(formatter.formatCellValue(row.getCell(2)))); 
//		nuevo.setDeliveryDetails(Float.valueOf(formatter.formatCellValue(row.getCell(2)))); 
//		nuevo.setPurchaseStatus(Float.valueOf(formatter.formatCellValue(row.getCell(2)))); 

		
		return nuevo;	
	}

	@Override
	public Row entityToRow(Order entity, Row row) {
		// TODO Auto-generated method stub
		return null;
	}

}
