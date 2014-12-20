
public class Luke20 {
	
	static final int TVERRSUM = 19;
	static final int ST�RRELSE = 1000;
	
	private static byte[][] brett = new byte[ST�RRELSE][ST�RRELSE];
	
	// Denne funksjonen regner ut tverrsummen av to tall, som definert i oppgaven
	public static int tverrsum(int x, int y) {
		// Beegynn med absolutt verdi av tallene
		x = Math.abs(x);
		y = Math.abs(y);
		int sum = 0;
		while (x>0 || y>0) {
			// Ved � ta tallet modulo 10, f�r en siste siffer i tallet.
			// Ved � dele p� 10, kutter en bort dette sifferet.
			sum += x%10 + y%10;
			x /= 10;
			y /= 10;
		}
		return sum;
	}
	
	public static boolean steg() {
		// Denne funksjonen tar et "steg" i utregningen,
		// ved � g� over brettet (uttrykt ved bytes, alts� sm� heltall),
		// og hver gang et felt som ikke har blitt bes�kt enda blir bes�kt,
		// markerer funksjonen alle feltene rundt til � f� bes�k (men kun
		// andre felter som ikke har blitt bes�kt markeres).
		// Verdien 0 betyr ikke bes�kt,
		// 1 betyr bes�kt og tverrsum <= 19,
		// 2 betyr bes�k neste runde,
		// 3 betyr bes�kt og tverrsum > 19.
		// Merk at denne metoden ikke egner seg til � finne avstander, selv
		// om den er ganske lik slike metoder; dette er fordi felter som blir
		// markert for bes�k som unders�kes senere i samme "steg" blir bes�kt
		// i samme steg. Dette er helt i orden her, da rekkef�lgen feltene blir
		// bes�kt i ikke har noe � si.
		boolean ferdig = true;
		for (int i=0; i<brett.length; ++i) {
			for (int j=0; j<brett[i].length; ++j) {
				// Hvis dette er et felt vi skal bes�ke...
				if (brett[i][j] == 2) {
					// Trekk fra halve st�rrelsen for � regne tverrsummen.
					// Dette er fordi arrayet i utgangspunktet har (0,0) �verst
					// til venstre, men vi vil ha det i midten.
					if (tverrsum(i-ST�RRELSE/2, j-ST�RRELSE/2) > TVERRSUM) {
						// Tverrsummen er for stor. Marker feltet med en 3er.
						brett[i][j] = 3;
					} else {
						// Tverrsummen er ikke for stor. Marker feltene rundt for
						// bes�k, bemerk at vi ikke er ferdig enda, og marker
						// feltet ed en 1er.
						if (brett[i+1][j] == 0) brett[i+1][j] = 2;
						if (brett[i-1][j] == 0) brett[i-1][j] = 2;
						if (brett[i][j+1] == 0) brett[i][j+1] = 2;
						if (brett[i][j-1] == 0) brett[i][j-1] = 2;
						ferdig = false;
						brett[i][j] = 1;
					}
				}
			}
		}
		return ferdig;
	}

	public static void main(String[] args) {
		// Marker feltet i midten for bes�k
		brett[ST�RRELSE/2][ST�RRELSE/2] = 2;
		int antall = 0;
		// Fortsett � regne frem til det ikke er noen felter igjen � bes�ke
		while (!steg()) {}
		
		// Tell hvor mange felter ble markert med 1ere.
		for (int i=0; i<brett.length; ++i) {
			for (int j=0; j<brett[i].length; ++j) {
				if (brett[i][j] == 1) ++antall;
			}
		}
		System.out.println("Rudolf kan n� "+antall+" felter.");
	}

}
