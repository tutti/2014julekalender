import java.util.ArrayList;
import easyIO.Out;

public class Luke13 {
	private static Out ut = new Out();
	
	private static boolean erPalindrom(int tall) {
		// Tatt fra oppgave 1, og endret til å bruke tall istedenfor String
		// Sjekker om en streng er et palindrom
		// Metoden reverse() i StringBuilder blir brukt.
		StringBuilder sb = new StringBuilder(Integer.toString(tall));
		return sb.reverse().toString().equals(Integer.toString(tall));
	}
	
	private static int baklengs(int tall) {
		// Snur tallet baklengs og returnerer det
		// Igjen blir reverse() i StringBuilder brukt.
		StringBuilder sb = new StringBuilder(Integer.toString(tall));
		return Integer.parseInt(sb.reverse().toString());
	}

	public static void main(String[] args) {
		// Hent alle primtall under 1000
		ArrayList<Integer> primtall = Primtall.beregnPrimtall(1000);
		
		// Tell antall primtall som også er primtall baklengs uten å være palindromer
		int antall = 0;
		for (int tall : primtall) {
			// Hvis tallet er et palindrom, ikke tell det med.
			if (erPalindrom(tall)) continue;
			
			// Hvis tallet baklengs fortsatt er et primtall, tell det med.
			if (primtall.contains(baklengs(tall))) ++antall;
		}
		ut.outln("Antall reversible primtall under 1000: "+antall);
	}

}
