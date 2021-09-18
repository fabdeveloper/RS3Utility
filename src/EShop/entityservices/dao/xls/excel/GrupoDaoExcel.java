package EShop.entityservices.dao.xls.excel;

import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import EShop.entityservices.converter.xlstoentity.IXlsToEntityConversor;
import src.entity.Grupo;
import src.inter.IServiceLocator;

@RequestScoped
public class GrupoDaoExcel implements IXlsToEntityConversor<Grupo> {



	@Override
	public Grupo rowToEntity(Row row, IServiceLocator serviceLocator) {
		DataFormatter formatter = new DataFormatter();
		Grupo nuevo = serviceLocator.getGrupoServices().getTransferObject();
				
//		nuevo.setId(Integer.valueOf(formatter.formatCellValue(row.getCell(0)))); 
		nuevo.setName(formatter.formatCellValue(row.getCell(1))); 
		nuevo.setDescription(formatter.formatCellValue(row.getCell(2))); 
		
		return nuevo;
	}

	@Override
	public Row entityToRow(Grupo entity, Row row) {
		// TODO Auto-generated method stub
		return null;
	}

}
