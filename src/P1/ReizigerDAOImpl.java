package P1;

import java.util.ArrayList;
import java.util.List;

public class ReizigerDAOImpl implements ReizigerDao{

	private ArrayList<Reiziger> lReiziger = new ArrayList<>();
	
	@Override
	public Reiziger save(Reiziger reiziger) {
		lReiziger.add(reiziger);
		return reiziger;
	}

	@Override
	public List<Reiziger> findAll() {
		return lReiziger;
	}

	@Override
	public List<Reiziger> findByGBdatum(String GBdatum) {
		ArrayList<Reiziger> findList = new ArrayList<>();
		for(Reiziger r : lReiziger) {
			if(r.getGBdatum().toString().equals(GBdatum)) {
				findList.add(r);
			}
		}
		return findList;
	}

	@Override
	public Reiziger update(Reiziger reiziger) {
		
		int index = lReiziger.indexOf(reiziger);
		
		if(index == -1) {
			return null;
		}
		lReiziger.set(index, reiziger);

		return reiziger;
	}

	@Override
	public boolean delete(Reiziger reiziger) {
		return lReiziger.remove(reiziger);
	}

}
