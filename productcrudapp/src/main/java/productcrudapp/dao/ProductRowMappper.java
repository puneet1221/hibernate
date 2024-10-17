package productcrudapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import productcrudapp.model.Product;

@Component
public class ProductRowMappper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id=rs.getInt(1);
		String name=rs.getString(2);
		String description=rs.getString(3);
		long price=rs.getLong(4);
		Product p=new Product(id, name, description, price);
		return p;
		
	}

}
