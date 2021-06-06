package src.dao;

import javax.enterprise.context.Dependent;
import src.entity.CartItem;

@Dependent
public class CartItemDao extends AbstractDao<CartItem> {

	public CartItemDao() {
		super(CartItem.class);
	}

}
