package EShop.entityservices.dao.xls.excel;

import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.Row;

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

}
