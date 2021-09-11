package EShop.entityservices.dao.xls.excel;

import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.Row;

import src.entity.Atributo;
import src.inter.IServiceLocator;


@RequestScoped
public class AtributoDaoExcel implements IXlsToEntityConversor<Atributo> {

	@Override
	public Atributo rowToEntity(Row row, IServiceLocator serviceLocator) {
		// TODO Auto-generated method stub
		return null;
	}
	



}
