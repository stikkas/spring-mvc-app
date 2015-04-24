package my.home.pro.web.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import my.home.pro.web.domain.Product;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Благодатских С.
 */
@Repository
public class SimpleProductManager implements ProductManager {

	private List<Product> products;

	@PostConstruct
	private void init() {
		products = new ArrayList<>();
		Product p = new Product();
		p.setDescription("Lamp");
		p.setPrice(5.75);
		products.add(p);
		p = new Product();
		p.setDescription("Table");
		p.setPrice(75.25);
		products.add(p);
		p = new Product();
		p.setDescription("Chair");
		p.setPrice(22.79);
		products.add(p);
	}

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
