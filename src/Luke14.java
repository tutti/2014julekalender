import easyIO.Out;

public class Luke14 {
	private static Out ut = new Out();
	
	private static int oppNed(int tall) {
		// Denne metoden snur et tall opp ned
		// Først, lag en streng av tallet
		String streng = Integer.toString(tall);
		
		// Hvis strengen inneholder et tegn som ikke kan snus opp ned,
		// returner -1.
		if (streng.contains("2")
				|| streng.contains("3")
				|| streng.contains("4")
				|| streng.contains("5")
				|| streng.contains("7")
		) {
			return -1;
		}
		
		// - Lag en ny StringBuilder (for å bruke reverse()).
		// - Snu strengen baklengs
		// - Gjør om til vanlig streng igjen (for å bruke replace()).
		// - Bytt ut alle 6'ere med ":".
		// - Bytt ut alle 9'ere med 6'ere
		// - Bytt ut alle ":" (tidligere 6'ere) med 9'ere
		// - Returner tallet som en int
		return Integer.parseInt(
				new StringBuilder(streng)
				.reverse()
				.toString()
				.replace('6', ':')
				.replace('9', '6')
				.replace(':', '9')
		);
	}

	public static void main(String[] args) {
		// Gå gjennom tallene fra 0 til 100000, og sjekk om de er samme tall opp ned
		int antall = 0;
		for (int i=0; i<100000; ++i) {
			if (i == oppNed(i)) ++antall;
		}
		ut.outln("Antall tall som kan leses opp ned: "+antall);
	}

}
