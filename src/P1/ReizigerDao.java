package P1;

import java.util.List;

public interface ReizigerDao {
	public Reiziger save(Reiziger reiziger);
	public List<Reiziger> findAll();
	public List<Reiziger> findByGBdatum(String GBdatum);
	public Reiziger update(Reiziger reiziger);
	public boolean delete(Reiziger reiziger);
}
