package EShop.entityservices.dao.xls.excel;

import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.Row;

import EShop.entityservices.converter.xlstoentity.IXlsToEntityConversor;
import src.entity.PurchaseStatus;
import src.inter.IServiceLocator;

@RequestScoped
public class PurchaseStatusDaoExcel implements IXlsToEntityConversor<PurchaseStatus> {


	@Override
	public PurchaseStatus rowToEntity(Row row, IServiceLocator serviceLocator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Row entityToRow(PurchaseStatus entity, Row row) {
		// TODO Auto-generated method stub
		return null;
	}

}
