import easyIO.Out;

public class Luke1 {
	private static Out ut = new Out();
	
	private static boolean erPalindrom(String tall) {
		// Sjekker om en streng er et palindrom
		// Metoden reverse() i StringBuilder blir brukt.
		StringBuilder sb = new StringBuilder(tall);
		return sb.reverse().toString().equals(tall);
	}

	public static void main(String[] args) {
		// Hold antall på hvor mange tall som er palindromer
		int antall = 0;
		
		for (int i=1; i<=1000000; ++i) {
			// For hvert tall mellom 1 og 1 million,
			// gjør om tallet til en streng i base 10 og base 8.
			// Integer.toString()-metoden i Java kan konvertere et tall
			// til en hvilken som helst base.
			String base10 = Integer.toString(i);
			String base8 = Integer.toString(i, 8);
			
			// Hvis tallet er et palindrom både i base 10-form og
			// base 8-form, øk telleren med 1.
			if (erPalindrom(base10) && erPalindrom(base8)) ++antall;
		}
		
		// Skriv ut antall palindromer.
		ut.outln("Antall palindromer: " + antall);
	}

}
