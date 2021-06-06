package src.dao;

import javax.enterprise.context.Dependent;
import src.entity.User;

@Dependent
public class UserDao extends AbstractDao<User>{
	
	public UserDao() {
		super(User.class);
	}
}
