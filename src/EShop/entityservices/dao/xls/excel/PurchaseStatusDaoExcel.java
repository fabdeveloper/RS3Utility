package EShop.entityservices.dao.xls.excel;

import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.Row;

import src.entity.PurchaseStatus;
import src.inter.IServiceLocator;

@RequestScoped
public class PurchaseStatusDaoExcel implements IXlsToEntityConversor<PurchaseStatus> {


	@Override
	public PurchaseStatus rowToEntity(Row row, IServiceLocator serviceLocator) {
		// TODO Auto-generated method stub
		return null;
	}

}
