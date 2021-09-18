package EShop.entityservices.dao.xls.excel;

import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.Row;

import EShop.entityservices.converter.xlstoentity.IXlsToEntityConversor;
import src.entity.Etiqueta;
import src.inter.IServiceLocator;

@RequestScoped
public class EtiquetasDaoExcel implements IXlsToEntityConversor<Etiqueta> {
	


	@Override
	public Etiqueta rowToEntity(Row row, IServiceLocator serviceLocator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Row entityToRow(Etiqueta entity, Row row) {
		// TODO Auto-generated method stub
		return null;
	}

}
