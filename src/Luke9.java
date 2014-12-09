import easyIO.Out;

public class Luke9 {
	private static Out ut = new Out();
	private static int minste = 999;
	
	// Rekursiv metode som går gjennom alle mulige permutasjoner av sifre i et tall.
	// Kopiert fra oppgave 5
	private static void regnUt(int tall) {
		regnUt("", Integer.toString(tall));
	}
	
	// Kjøttet i metoden over.
	private static void regnUt(String pre, String rest) {
		if (rest.equals("")) {
			// Her skjer utregningen; det er denne delen som er ulik oppgave 5
			// Del strengen opp i tre biter
			int tall1 = Integer.parseInt(pre.substring(0,  3));
			int tall2 = Integer.parseInt(pre.substring(3,  6));
			int tall3 = Integer.parseInt(pre.substring(6));
			if (tall1 + tall2 == tall3 // Sørg for at regnestykket stemmer
					&& tall1 > 99 && tall2 > 99 && tall3 > 999 // Sørg for at alle tallene er store nok
					&& Math.min(tall1,  tall2) < minste) {
				// Hvis det nye leddet er det minste så langt, overskriv det forrige tallet vi fant
				minste = Math.min(tall1,  tall2);
			}
		}
		
		// Gå gjennom alle mulige permutasjoner av strengen
		for (int i=0; i<rest.length(); ++i) {
			regnUt(pre + rest.charAt(i), rest.substring(0, i) + rest.substring(i+1, rest.length()));
		}
	}

	public static void main(String[] args) {
		// Kall regnUt() på et tall med de nødvendige sifrene
		regnUt(1234567890);
		
		// Skriv ut det minste leddet
		ut.outln("Minste ledd: "+minste);
	}
}
