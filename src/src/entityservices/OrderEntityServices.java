package src.entityservices;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import src.entity.Order;

@Dependent
public class OrderEntityServices extends AbstractEntityServices<Order> implements Serializable {

}
