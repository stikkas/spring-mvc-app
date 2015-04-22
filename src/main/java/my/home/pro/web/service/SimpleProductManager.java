package my.home.pro.web.service;

import java.util.List;
import my.home.pro.web.domain.Product;

/**
 *
 * @author Благодатских С.
 */
public class SimpleProductManager implements ProductManager {

	private List<Product> products;

	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public void increasePrice(int percentage) {
		if (products != null) {
			for (Product product : products) {
				product.setPrice(product.getPrice() * (100 + percentage) / 100);
			}
		}
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
