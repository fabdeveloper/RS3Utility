package EShop.entityservices.dao.entityloader.loader;

import EShop.entityservices.dao.xls.excel.IDaoExcel;

public interface IEntityLoader<E, P> extends IDaoExcel<E> {
	
	
	public void loadFromXLSFile();
	public void loadFromDB();
//	public void persistListToDB();
	
//	public IEntityServices<E> getEntityServices(); // servicios de persistencia en BD
//	public IDaoExcel<E> getConversor(); // servicios de acceso a datos en XLS
	
	public void bindToParentEntity(P parent_entity);
	
	
//	public void setFileName(String fname);
//	public String getFileName();
//	public void setSheetName(String sheet_name);
//	public List<E> getList();


}
