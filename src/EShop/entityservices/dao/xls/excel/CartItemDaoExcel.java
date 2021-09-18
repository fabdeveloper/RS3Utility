package EShop.entityservices.dao.xls.excel;

import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import EShop.entityservices.converter.xlstoentity.IXlsToEntityConversor;
import src.entity.CartItem;
import src.inter.IServiceLocator;

@RequestScoped
public class CartItemDaoExcel implements IXlsToEntityConversor<CartItem> {
	



	@Override
	public CartItem rowToEntity(Row row, IServiceLocator serviceLocator) {


		DataFormatter formatter = new DataFormatter();


		//ID-COUNTER-CART-OFERTA
		CartItem nuevo = serviceLocator.getCartItemServices().getTransferObject();
				
		nuevo.setId(Integer.valueOf(formatter.formatCellValue(row.getCell(1)))); //row.getCell(1).getRichStringCellValue().getString());
		nuevo.setCounter(Integer.valueOf(formatter.formatCellValue(row.getCell(2)))); //row.getCell(2).getRichStringCellValue().getString());
		
//		pppppppppppppp
//		nuevo.setCart(row.getCell(3).getRichStringCellValue().getString());
//		nuevo.setOferta(row.getCell(4).getRichStringCellValue().getString());		
		
		
		return nuevo;
	}

	@Override
	public Row entityToRow(CartItem entity, Row row) {
		// TODO Auto-generated method stub
		return null;
	}

}
