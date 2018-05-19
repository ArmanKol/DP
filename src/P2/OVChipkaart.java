package P2;

import java.sql.Date;

public class OVChipkaart {
	private int kaartnummer, klasse;
	private Reiziger reiziger;
	private double saldo;
	private Date geldigtot;
	
	
	public OVChipkaart(int krtnmmr, Date geldig, int ksse, double sldo, Reiziger reiziger) {
		this.kaartnummer = krtnmmr;
		this.geldigtot = geldig;
		this.klasse = ksse;
		this.saldo = sldo;
		this.reiziger = reiziger;
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
		this.saldo + "] - [ReizigersId: " + reiziger.getId() + "]";

		return x;
	}
}
