package src.entityservices;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import src.entity.Product;

@Dependent
public class ProductServices extends AbstractEntityServices<Product> implements Serializable {

}
