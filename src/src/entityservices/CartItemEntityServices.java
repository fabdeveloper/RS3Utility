package src.entityservices;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import src.entity.CartItem;

@Dependent
public class CartItemEntityServices extends AbstractEntityServices<CartItem> implements Serializable {

}
