package EShop.entityservices.dao.xls.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import EShop.entityservices.converter.xlstoentity.IXlsToEntityConversor;
import src.entityservices.IEntityServices;
import src.exception.DBException;
import src.inter.IServiceLocator;

public abstract class AbstractDaoExcel<E> implements IDaoExcel<E> {
	


	@Inject
	private IServiceLocator serviceLocator; // servicios de BD, persistencia
	
	@Inject
	private IXlsToEntityConversor<E> conversor;



	
	
	private List<E> list;	
	private String sheetName;
	private String fileName;

	private Workbook workbook;
	private Sheet sheet;
	
	


//	public abstract E rowToEntity(Row row);
//	public abstract void init();
	
	
	protected void publish(String msg) {
		publishStandard(msg);
		publishFaces(msg);
		//publishLog(msg, level);
	}
	
	private void publishStandard(String msg) {
		System.out.println(msg);
	}
	
	private void publishFaces(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}
	
	
	// carga datos desde un fichero excel 
	// los datos se almacenan en el objeto "workbook"
	@Override
	public void loadFile() {

			FileInputStream file;
			try {
				file = new FileInputStream(new File(fileName));		
				setWorkbook(new HSSFWorkbook(file));
//				workbook = new HSSFWorkbook(file);
				publish("Loaded file: " + fileName);
				
			} catch (FileNotFoundException e) {				
				String msg = "loadFile() - error = FileNotFoundException - msg = " + e.getMessage();
				publish(msg);
//				e.printStackTrace();
			} catch (IOException e) {
				String msg = "loadFile() - error = IOException - msg = " + e.getMessage();
				publish(msg);
//				e.printStackTrace();
			}
	}
	
	@Override
	public void createFile() {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet(getSheetName());

		int counter = 0;
		for(E entity : getList()) {
			entityToRow(entity, sheet.createRow(counter++));
		}		
		// write file
        FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(new File(getFileName() + ".xls"));			
	        workbook.write(fileOut);
	        fileOut.close();
	        workbook.close();	        
		
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	// crea una lista de Entity objects a partir de un fichero
	@Override
	public void createList() {
		loadFile();
		List<E> listaTemporal = new ArrayList<E>();
		sheet = workbook.getSheet(sheetName);
		Iterator<Row> it = sheet.iterator();
		E newentity = null;
		while(it.hasNext()) {			
			try {
				newentity = rowToEntity(it.next(), getServiceLocator());
			} catch (Throwable e) {
				String msg = "createList() - ERROR - row con problemas :   " + e.getMessage();
				publish(msg);
			}	
			if(newentity != null)
			listaTemporal.add(newentity);
		}
		setList(listaTemporal); 
	}



	// Graba la lista de Entity objects en BD
	@Override
	public void persistList() {
		publish("listSize =  " + getList().size());
		EntityManager em = getEntityManager();
		for(E e : getList()) {
			try {
				em.persist(e);
			}catch(Throwable t) {
				String msg = "persistList() - ERROR - message= " + t.getMessage() + "\n" +
							"ExceptionClass= " + t.getClass().getName() + "\n" + 
								"entity = " + e;
				publish(msg);
			}
		}	
	}
	@Override
	public Workbook getWorkbook() {
		if(workbook == null) {
			loadFile();
		}
		return workbook;
	}
	@Override
	public Sheet getSheet() {

		return sheet;
	}
	@Override
	public void setSheetName(String sheet_name) {
		sheetName = sheet_name;		
	}
	
	@Override
	public List<E> getList() {
		if(list == null) {
			list = new ArrayList<E>();
//			createList();
		}
		return list;
	}
	
	@Override
	public void setList(List<E> list) {
		this.list = list;
	}
	
	@Override
	public String getFileName() {
		return fileName;
	}
	
	@Override
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String getSheetName() {
		return sheetName;
	}
	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}
	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}


	@Override
	public EntityManager getEntityManager() {
		EntityManager em = null;
		try{
			em = getServiceLocator().getEntityManager();
		}catch(Throwable t){
			throw new DBException("EntityManager error", t);
		}
		return em;
	}

	@Override
	public IServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	@Override
	public void setServiceLocator(IServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

	@Override
	public IXlsToEntityConversor<E> getConversor() {
		return conversor;
	}

	public void setConversor(IXlsToEntityConversor<E> conversor) {
		this.conversor = conversor;
	}


	@Override
	public E rowToEntity(Row row, IServiceLocator serviceLocator) {
		return getConversor().rowToEntity(row, serviceLocator);
	}

	@Override
	public Row entityToRow(E entity, Row row) {
		return getConversor().entityToRow(entity, row);
	}






	
	
	
	

}
