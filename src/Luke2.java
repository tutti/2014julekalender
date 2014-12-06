import java.util.Arrays;
import easyIO.Out;

public class Luke2 {
	private static Out ut = new Out();
	// En liste over alle tosifrede primtall. Jeg løste denne oppgaven før jeg skrev Primtall-klassen,
	// ellers ville jeg brukt den.
	private static int[] toPrimtall = {11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
	
	// Denne metoden finner m for en hvilken som helst n.
	public static int finn_m(int n) {
		// Mulige kandidattall er de der første siffer er n og som har n sifre.
		// Slike tall vil ligge mellom n(10^(n-1)) og (n+1)(10^(n-1)).
		// I tillegg må alle tosifrede tallsekvenser være primtall, noe som vil si at
		// de også må være oddetall. Da må også hele kandidattallet være et oddetall.
		// Derfor starter løkken på n(10^(n-1))+1, og øker med 2 istedenfor 1.
		for (int i = (int)(n*Math.pow(10, n-1)+1); i < (int)((n+1)*Math.pow(10, n-1)); i+=2) {
			// i konverteres til en streng for å kunne bruke String.charAt().
			String iStreng = Integer.toString(i);
			
			// Bruk en kontrollvariabel til å holde styr på om tallet er gyldig.
			boolean gyldig = true;
			
			// Hold også styr på hvilke primtall som har blitt funnet - de tosifrede tallene skal ikke
			// bare være primtall, men også *unike* primtall, altså bare finnes 1 gang.
			boolean[] funnet = new boolean[100];
			
			// Gå gjennom alle siffer i tallet som har et siffer etter seg,
			// altså alle utenom det siste sifferet.
			for (int j=0; j<n-1; ++j) {
				// Lag et tall av sifferet og sifferet etter
				int tall = Integer.parseInt("" + iStreng.charAt(j) + iStreng.charAt(j+1));
				
				// Se om deltallet er et primtall. Hvis ikke er også hovedtallet ugyldig.
				if (Arrays.binarySearch(toPrimtall, tall) >= 0) {
					if (funnet[tall]) {
						// Hvis deltallet er et primtall men allerede var funnet, er hovedtallet ugyldig.
						gyldig = false;
					} else {
						// Hvis deltallet er et primtall og enda ikke har blitt funnet,
						// er hovedtallet fortsatt gyldig. Noter at vi fant dette primtallet.
						funnet[tall] = true;
					}
				} else {
					// Hvis deltallet ikke er et primtall, er hovedtallet ugyldig.
					gyldig = false;
				}
			}
			// Hvis hovedtallet er gyldig, returner det. Det blir da den første, og dermed laveste,
			// verdien for m.
			if (gyldig) return i;
		}
		// Hvis ingen gyldige tall ble funnet, returner -1.
		return -1;
	}

	public static void main(String[] args) {
		ut.outln(finn_m(12));
	}

}
