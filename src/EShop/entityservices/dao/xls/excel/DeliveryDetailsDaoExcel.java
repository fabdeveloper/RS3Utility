package EShop.entityservices.dao.xls.excel;

import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.Row;

import EShop.entityservices.converter.xlstoentity.IXlsToEntityConversor;
import src.entity.DeliveryDetails;
import src.inter.IServiceLocator;

@RequestScoped
public class DeliveryDetailsDaoExcel implements IXlsToEntityConversor<DeliveryDetails> {
	


	@Override
	public DeliveryDetails rowToEntity(Row row, IServiceLocator serviceLocator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Row entityToRow(DeliveryDetails entity, Row row) {
		// TODO Auto-generated method stub
		return null;
	}

}
