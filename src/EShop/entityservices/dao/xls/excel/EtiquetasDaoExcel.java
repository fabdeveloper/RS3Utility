package EShop.entityservices.dao.xls.excel;

import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.Row;

import src.entity.Etiqueta;
import src.inter.IServiceLocator;

@RequestScoped
public class EtiquetasDaoExcel implements IXlsToEntityConversor<Etiqueta> {
	


	@Override
	public Etiqueta rowToEntity(Row row, IServiceLocator serviceLocator) {
		// TODO Auto-generated method stub
		return null;
	}

}
