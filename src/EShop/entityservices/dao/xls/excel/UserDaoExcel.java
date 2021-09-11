package EShop.entityservices.dao.xls.excel;

import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import src.entity.User;
import src.inter.IServiceLocator;

@RequestScoped
public class UserDaoExcel implements IXlsToEntityConversor<User> {


	@Override
	public User rowToEntity(Row row, IServiceLocator serviceLocator) {
		//ID	ADDRESS	EMAIL	NAME	NICK	PASS	TELEPHONE

		DataFormatter formatter = new DataFormatter();
		User nuevo = serviceLocator.getUserServices().getTransferObject();
				
		nuevo.setId(Integer.valueOf(formatter.formatCellValue(row.getCell(1)))); 
		nuevo.setAddress(formatter.formatCellValue(row.getCell(2))); 
		nuevo.setEmail(formatter.formatCellValue(row.getCell(2))); 
		nuevo.setName(formatter.formatCellValue(row.getCell(2))); 
		nuevo.setNick(formatter.formatCellValue(row.getCell(2))); 
		nuevo.setPassword(formatter.formatCellValue(row.getCell(2))); 
		nuevo.setTelephone(formatter.formatCellValue(row.getCell(2))); 

		
		return nuevo;	
	}

}
