package src.dao;

import javax.enterprise.context.Dependent;

import src.entity.PurchaseStatus;

@Dependent
public class PurchaseSatusDao extends AbstractDao<PurchaseStatus> {
	

	public PurchaseSatusDao() {
		super(PurchaseStatus.class);
	}

}
