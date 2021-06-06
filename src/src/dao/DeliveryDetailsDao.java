package src.dao;

import javax.enterprise.context.Dependent;
import src.entity.DeliveryDetails;

@Dependent
public class DeliveryDetailsDao extends AbstractDao<DeliveryDetails> {
	
	
	public DeliveryDetailsDao() {
		super(DeliveryDetails.class);
	}

}
