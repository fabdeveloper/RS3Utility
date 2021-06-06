package src.dao;

import javax.enterprise.context.Dependent;

import src.entity.Order;

@Dependent
public class OrderDao extends AbstractDao<Order> {
	
	public OrderDao() {
		super(Order.class);
	}
}
