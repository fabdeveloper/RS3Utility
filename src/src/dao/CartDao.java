package src.dao;

import javax.enterprise.context.Dependent;
import src.entity.Cart;

@Dependent
public class CartDao extends AbstractDao<Cart> {
	
	public CartDao(){
		super(Cart.class);
	}

}
