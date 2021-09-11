package EShop.entityservices.dao.xls.excel;

import org.apache.poi.ss.usermodel.Row;

import src.inter.IServiceLocator;

public interface IXlsToEntityConversor<E> {
	
	public E rowToEntity(Row row, IServiceLocator serviceLocator);
	
	

}
