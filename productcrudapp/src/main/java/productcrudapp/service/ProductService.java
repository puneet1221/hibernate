package productcrudapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao dao;

	public Product findProduct(int id) {
		return dao.get(id);
	}

	public List<Product> findAllProducts() {
		return dao.getAll();
	}

	public String deleteProduct(int id) {
		try {
			dao.delete(id);
			return "succerssfully deleted product with id" + id;
		} catch (Exception e) {
			return "failed to delete an exception Occurred" + e.getMessage();
		}

	}

	public String updateProduct(int id, Product p) {
		try {
			dao.update(id, p);
			return "succerssfully updated product with id" + id;
		} catch (Exception e) {
			return "failed to update an exception Occurred" + e.getMessage();
		}
	}

	public String addProduct(Product p) {
		try {
			dao.add(p);
			return "succerssfully added";
		} catch (Exception e) {
			return "fail to  add";
		}
	}
	
	public void deleteAll()
	{
		dao.deleteAll();
	}

}
