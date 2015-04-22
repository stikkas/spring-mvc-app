package my.home.pro.web.service;

import java.io.Serializable;
import java.util.List;
import my.home.pro.web.domain.Product;

/**
 *
 * @author Благодатских С.
 */
public interface ProductManager extends Serializable {

	public void increasePrice(int percentage);

	public List<Product> getProducts();

}
