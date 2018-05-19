package P1;

import java.util.Date;

import P2.OVChipkaart;

public class Reiziger {
	private String naam;
	private Date gbdatum;
	private int id;
	
	public Reiziger(int id, String nm, Date gbd) {
		this.id = id;
		this.naam = nm;
		this.gbdatum = gbd;
	}
	
	public String getNaam() {
		return this.naam;
	}
	
	public void setNaam(String nm) {
		this.naam = nm;
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Date getGBdatum() {
		return this.gbdatum;
	}
	
	public void setGBdatum(Date gbdm) {
		this.gbdatum = gbdm;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof OVChipkaart) {
			OVChipkaart ovc = (OVChipkaart)obj;
			if(ovc.getReiziger().getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return "[ id: " + id + "] [naam: " + naam + "] [geboortedatum: " + gbdatum + "]";
	}
}
