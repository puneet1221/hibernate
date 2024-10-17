package productcrudapp.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import productcrudapp.model.Product;

@Repository
public class ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	ProductRowMappper productRowMappper;

	public List<Product> getAll() {

		String sql = "select * from products";
		return jdbcTemplate.query(sql, productRowMappper);
	}

	public Product get(int id)  {
		String sql = "select * from products where id=?";

		return jdbcTemplate.queryForObject(sql, productRowMappper, id);

	}

	public void add(Product p) throws SQLException {
		String sql = "insert into products(ID,NAME,DESCRIPTION,PRICE) values(?,?,?,?)";
		jdbcTemplate.update(sql, p.getId(), p.getName(), p.getDescription(), p.getPrice());
	}

	public void delete(int id) throws SQLException {
		String sql = "delete from products where id=?";

		jdbcTemplate.update(sql, id);

	}

	public void update(int id, Product p) throws SQLException {
		String sql = "update products set id=?,name=?,description=?,price=? where id=?";
		jdbcTemplate.update(sql, p.getId(), p.getName(), p.getDescription(), p.getPrice(), id);

	}
	
	public void deleteAll()
	{
		String sql="delete  from products";
		jdbcTemplate.update(sql);
	}

}
