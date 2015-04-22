package my.home.pro.web.test;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertEquals;
import my.home.pro.web.domain.Product;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {

	private Product product;

	@Before
	public void setUp() {
		product = new Product();
	}

	@Test
	public void testSetAndGetDescription() {
		String testDescription = "aDescription";
		assertNull(product.getDescription());
		product.setDescription(testDescription);
		assertEquals(testDescription, product.getDescription());
	}

	@Test
	public void testSetAndGetPrice() {
		double testPrice = 100.00;
		assertEquals(0, 0, 0);
		product.setPrice(testPrice);
		assertEquals(testPrice, product.getPrice(), 0);
	}
}
