import easyIO.Out;

public class Luke10 {
	private static Out ut = new Out();
	
	// Denne funksjonen finner neste våkne person
	private static int nesteVåken(boolean[] personer, int personIndeks) {
		int i;
		// Start på personen etter den som har flasken, sjekk om personen er våken. Hvis ikke gå til neste.
		for (i=(personIndeks+1)%personer.length; personer[i]; i=(i+1)%personer.length) {}
		return i;
	}
	
	public static void main(String[] args) {
		// Sett opp bordet med 1500 personer.
		boolean[] personer = new boolean[1500];
		
		// Start på første person
		int harFlasken = 0;
		
		// Fortsett til 1499 personer har sovnet
		for (int i=0; i<1499; ++i) {
			// Neste våkne person sovner
			personer[nesteVåken(personer, harFlasken)] = true;
			
			// Neste våkne person etter det igjen får flasken
			harFlasken = nesteVåken(personer, harFlasken);
		}
		
		// Skriv ut hvem som har flasken til slutt.
		ut.out("Person "+(harFlasken+1)+" har flasken.");
	}
}
