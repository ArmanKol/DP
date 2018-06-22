package P3;

import java.util.List;

public interface ProductDao {
	public List<Product> findAll();
	public List<Product> findByOVChipkaart(OVChipkaart ovchipkaart);
	public Product save(Product product);
	public Product update(Product product);
	public boolean delete(Product product);
}
