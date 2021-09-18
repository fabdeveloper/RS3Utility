package EShop.entityservices.dao.xls.excel;

import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.Row;

import EShop.entityservices.converter.xlstoentity.IXlsToEntityConversor;
import src.entity.Product;
import src.entity.UserProfile;
import src.inter.IServiceLocator;

@RequestScoped
public class UserProfileDaoExcel implements IXlsToEntityConversor<UserProfile> {



	@Override
	public UserProfile rowToEntity(Row row, IServiceLocator serviceLocator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Row entityToRow(UserProfile entity, Row row) {
		// TODO Auto-generated method stub
		return null;
	}

}
