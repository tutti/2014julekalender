import easyIO.Out;

public class Luke3 {
	private static Out ut = new Out();
	// Disse vektorene er de gyldige bevegelsene en springer kan gj�re.
	// De er gitt i rekkef�lge etter verdien til feltet de vil flytte springeren til.
	// For eksempel, siden "en venstre, to opp" alltid vil v�re feltet med lavest mulig
	// verdi springeren kan flytte til, er den f�rst.
	public static int[][] vektorer = {
		{-1, -2}, {1, -2}, {-2, -1}, {2, -1}, {-2, 1}, {2, 1}, {-1, 2}, {1, 2}
	};

	public static void main(String[] args) {
		// Start med et tomt brett med kun hvite felter (false=hvit her).
		boolean[][] brett = new boolean[10][10];
		// Plasser springeren p� 0,0.
		int x = 0;
		int y = 0;
		
		// Flytt 200 ganger
		for (int i=0; i<200; ++i) {
			// Velg et felt � flytte til.
			// Dette skal gj�res ved � velge feltet med den laveste verdien (10+y)
			// som har samme farge som springerens felt, ELLER feltet med den
			// h�yeste verdien hvis ingen felter med samme farge finnes.
			// Her er det gjort ved � se p� feltene etter tur, og sammenligne fargen.
			// I det et felt med samme farge blir funnet, stopper l�kken. Hvis ingen
			// blir funnet, g�r l�kken gjennom alle og lander da p� den siste.
			int[] funnetVektor = vektorer[0];
			for (int j=0; j<vektorer.length; ++j) {
				// Sjekk f�rst om feltet er p� brettet.
				if (x+vektorer[j][0]>=0 && x+vektorer[j][0]<10 && y+vektorer[j][1]>=0 && y+vektorer[j][1]<10) {
					// Oppdater vektoren som har blitt funnet.
					funnetVektor = vektorer[j];
					if (brett[x+vektorer[j][0]][y+vektorer[j][1]] == brett[x][y]) {
						// Hvis feltet har samme farge, er det denne vektoren vi vil ha.
						break;
					}
				}
			}
			// Skift farge p� feltet springeren forlater, og flytt til neste felt.
			brett[x][y] = !brett[x][y];
			x += funnetVektor[0];
			y += funnetVektor[1];
		}
		
		// Tell antall svarte felter.
		int antall = 0;
		for (boolean[] rekke : brett) {
			for (boolean rute : rekke) {
				if (rute) ++antall;
			}
		}
		
		// Skriv ut antallet.
		ut.outln("Antall svarte ruter: " + antall);
	}

}
