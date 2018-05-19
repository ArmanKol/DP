package P2;

import java.util.ArrayList;
import java.util.Date;

public class Reiziger {
	private String voorletter, tussenvoegsel, achternaam;
	private Date gbdatum;
	private int id;
	private ArrayList<OVChipkaart> listOVC = new ArrayList<>();
		
	public Reiziger(int id, String voorl, String tussenv, String achternm ,Date gbd) {
		this.id = id;
		this.voorletter = voorl;
		this.tussenvoegsel = tussenv;
		this.achternaam = achternm;
		this.gbdatum = gbd;
	}
	
	public String getVoorletter() {
		return this.voorletter;
	}
	
	public String getTussenvoegsel() {
		String ltussenvoegsel = "";
		if(this.tussenvoegsel == null) {
			ltussenvoegsel += "";
		}else {
			ltussenvoegsel += this.tussenvoegsel;
		}
		return ltussenvoegsel;
	}
	
	public String getAchternaam() {
		return this.achternaam;
	}
	
	public String getNaam() {
		String volledigeNaam = "";
		if(tussenvoegsel == null || tussenvoegsel == "") {
			volledigeNaam += this.voorletter + " " + this.achternaam;
		}else{
			volledigeNaam += this.voorletter + " " + this.tussenvoegsel + " " + this.achternaam;
		}
		
		return volledigeNaam;
	}
	
	public void voegOVChipkaartToe(OVChipkaart ovc) {
		listOVC.add(ovc);
	}
	
	public ArrayList<OVChipkaart> getOVChipkaartList() {
		return listOVC;
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
		if(obj instanceof Reiziger) {
			Reiziger rr = (Reiziger)obj;
			if(rr.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return "[ id: " + getId() + "] [naam: " + getNaam() + "] [geboortedatum: " + gbdatum + "]";
	}
}
