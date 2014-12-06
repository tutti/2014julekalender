import easyIO.Out;

public class Luke6 {
	private static Out ut = new Out();
	// Størrelsen på gangetabellen
	private static final int STØRRELSE = 8000;

	public static void main(String[] args) {
		// Lag en liste over hvilke unike tall som har blitt funnet.
		boolean[] produkter = new boolean[STØRRELSE*STØRRELSE+1];
		
		// Lag en teller for antall unike tall
		int antall = 0;
		
		// Gå gjennom alle kombinasjoner av 2 tall mellom 1 og 8000
		for (int i=1; i<=STØRRELSE; ++i) {
			for (int j=1; j<=STØRRELSE; ++j) {
				// Hvis tallet ikke har blitt funnet før, øk telleren med 1.
				if (!produkter[i*j]) ++antall;
				// Marker tallet som funnet.
				produkter[i*j] = true;
			}
		}
		
		// Skriv ut antall unike produkter.
		ut.outln("Antall unike produkter: "+antall);
	}
}
