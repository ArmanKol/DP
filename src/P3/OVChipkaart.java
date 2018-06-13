package P3;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaart {
	private int kaartnummer, klasse;
	private Reiziger reiziger;
	private Product product;
	private double saldo;
	private Date geldigtot;
	private List<Product> listOVCProduct = new ArrayList<>();
	
	
	public OVChipkaart(int krtnmmr, Date geldig, int ksse, double sldo, Reiziger reiziger) {
		this.kaartnummer = krtnmmr;
		this.geldigtot = geldig;
		this.klasse = ksse;
		this.saldo = sldo;
		this.reiziger = reiziger;
	}
	
	public OVChipkaart(int krtnmmr) {
		this.kaartnummer = krtnmmr;
	}
	
	public List<Product> getOVChipkaartProducten() {
		return listOVCProduct;
	}
	
	public void setOVChipkaartProducten(List<Product> a) {
		this.listOVCProduct = a;
	}
	
	public int getKaartnummer() {
		return this.kaartnummer;
	}
	
	public int getKlasse() {
		return this.klasse;
	}
	
	public Reiziger getReiziger() {
		return this.reiziger;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public Date getDate() {
		return this.geldigtot;
	}
	
	
	
	public boolean equals(Object obj) {
		boolean returnValue = false;
		if(obj instanceof Reiziger) {
			Reiziger rr = (Reiziger) obj;
			if(rr.getId() == reiziger.getId()) {
				returnValue = true;
			}
		}
		
		return returnValue;
		
	}
	
	public String toString() {
		String x = "";		
		x += "[Kaartnummer: " + this.kaartnummer + "] - [Geldig tot: " + this.geldigtot + "] - [Klasse: " + this.klasse + "] - [Saldo: " + 
		this.saldo + "] - [" + reiziger + "]" + " - [" + getOVChipkaartProducten() + "]";

		return x;
	}
}
