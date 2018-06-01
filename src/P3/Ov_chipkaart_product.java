package P3;


public class Ov_chipkaart_product {
	private int kaartnummer;
	private int productnummer;
	
	public Ov_chipkaart_product(int kn, int pn) {
		kaartnummer = kn;
		productnummer = pn;
	}
	
	public int getKaartnummer() {
		return kaartnummer;
	}
	
	public int getProductnummer() {
		return productnummer;
	}
	
	public String toString() {
		return "[Kaartnummer: " + kaartnummer + "] [Productnummer: " + productnummer + "]";
	}
}
