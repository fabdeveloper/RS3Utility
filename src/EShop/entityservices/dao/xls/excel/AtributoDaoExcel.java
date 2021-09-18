package EShop.entityservices.dao.xls.excel;

import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.Row;

import EShop.entityservices.converter.xlstoentity.IXlsToEntityConversor;
import src.entity.Atributo;
import src.inter.IServiceLocator;


@RequestScoped
public class AtributoDaoExcel implements IXlsToEntityConversor<Atributo> {

	@Override
	public Atributo rowToEntity(Row row, IServiceLocator serviceLocator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Row entityToRow(Atributo entity, Row row) {
		// TODO Auto-generated method stub
		return null;
	}
	



}
