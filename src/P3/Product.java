package P3;

public class Product {
	private int productNummer;
	private String productNaam;
	private String beschrijving;
	private double prijs;
	
	public Product(int pNummer, String pNaam, String beschrijving, double prijs) {
		this.productNummer = pNummer;
		this.productNaam = pNaam;
		this.beschrijving = beschrijving;
		this.prijs = prijs;
	}
	
	public int getpNummer() {
		return productNummer;
	}
	
	public String getpNaam() {
		return productNaam;
	}
	
	public String getBeschrijving() {
		return beschrijving;
	}
	
	public double getPrijs() {
		return prijs;
	}
	
	public String toString() {
		String tekst = "[ Productnummer: " + productNummer + "] [Productnaam: " + productNaam + "] [Beschrijving: " + beschrijving + "] [Prijs: " + prijs + "]" ;
		return tekst;
	}
}
