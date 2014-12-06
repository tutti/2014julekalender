import easyIO.Out;

public class Luke6 {
	private static Out ut = new Out();
	// St�rrelsen p� gangetabellen
	private static final int ST�RRELSE = 8000;

	public static void main(String[] args) {
		// Lag en liste over hvilke unike tall som har blitt funnet.
		boolean[] produkter = new boolean[ST�RRELSE*ST�RRELSE+1];
		
		// Lag en teller for antall unike tall
		int antall = 0;
		
		// G� gjennom alle kombinasjoner av 2 tall mellom 1 og 8000
		for (int i=1; i<=ST�RRELSE; ++i) {
			for (int j=1; j<=ST�RRELSE; ++j) {
				// Hvis tallet ikke har blitt funnet f�r, �k telleren med 1.
				if (!produkter[i*j]) ++antall;
				// Marker tallet som funnet.
				produkter[i*j] = true;
			}
		}
		
		// Skriv ut antall unike produkter.
		ut.outln("Antall unike produkter: "+antall);
	}
}
