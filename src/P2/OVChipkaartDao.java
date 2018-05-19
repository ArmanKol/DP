package P2;

import java.util.List;

public interface OVChipkaartDao {
	public List<OVChipkaart> findAll();
	public List<OVChipkaart> findByReiziger(Reiziger reizigerid);
	public OVChipkaart save(OVChipkaart ovchipkaart);
	public OVChipkaart update(OVChipkaart ovchipkaart);
	public boolean delete(OVChipkaart ovchipkaart);
}
