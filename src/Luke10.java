import easyIO.Out;

public class Luke10 {
	private static Out ut = new Out();
	
	// Denne funksjonen finner neste v�kne person
	private static int nesteV�ken(boolean[] personer, int personIndeks) {
		int i;
		// Start p� personen etter den som har flasken, sjekk om personen er v�ken. Hvis ikke g� til neste.
		for (i=(personIndeks+1)%personer.length; personer[i]; i=(i+1)%personer.length) {}
		return i;
	}
	
	public static void main(String[] args) {
		// Sett opp bordet med 1500 personer.
		boolean[] personer = new boolean[1500];
		
		// Start p� f�rste person
		int harFlasken = 0;
		
		// Fortsett til 1499 personer har sovnet
		for (int i=0; i<1499; ++i) {
			// Neste v�kne person sovner
			personer[nesteV�ken(personer, harFlasken)] = true;
			
			// Neste v�kne person etter det igjen f�r flasken
			harFlasken = nesteV�ken(personer, harFlasken);
		}
		
		// Skriv ut hvem som har flasken til slutt.
		ut.out("Person "+(harFlasken+1)+" har flasken.");
	}
}
