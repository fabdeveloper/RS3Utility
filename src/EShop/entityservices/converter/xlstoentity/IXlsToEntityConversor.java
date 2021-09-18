package EShop.entityservices.converter.xlstoentity;

import org.apache.poi.ss.usermodel.Row;

import src.inter.IServiceLocator;

public interface IXlsToEntityConversor<E> {
	
	public E rowToEntity(Row row, IServiceLocator serviceLocator);
	
	public Row entityToRow(E entity, Row row);
	
	

}
