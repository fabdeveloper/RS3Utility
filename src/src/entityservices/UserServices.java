package src.entityservices;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import src.entity.User;

@Dependent
public class UserServices extends AbstractEntityServices<User>  implements Serializable{
	

}
