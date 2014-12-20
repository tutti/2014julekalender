
public class Luke20 {
	
	static final int TVERRSUM = 19;
	static final int STØRRELSE = 1000;
	
	private static byte[][] brett = new byte[STØRRELSE][STØRRELSE];
	
	// Denne funksjonen regner ut tverrsummen av to tall, som definert i oppgaven
	public static int tverrsum(int x, int y) {
		// Beegynn med absolutt verdi av tallene
		x = Math.abs(x);
		y = Math.abs(y);
		int sum = 0;
		while (x>0 || y>0) {
			// Ved å ta tallet modulo 10, får en siste siffer i tallet.
			// Ved å dele på 10, kutter en bort dette sifferet.
			sum += x%10 + y%10;
			x /= 10;
			y /= 10;
		}
		return sum;
	}
	
	public static boolean steg() {
		// Denne funksjonen tar et "steg" i utregningen,
		// ved å gå over brettet (uttrykt ved bytes, altså små heltall),
		// og hver gang et felt som ikke har blitt besøkt enda blir besøkt,
		// markerer funksjonen alle feltene rundt til å få besøk (men kun
		// andre felter som ikke har blitt besøkt markeres).
		// Verdien 0 betyr ikke besøkt,
		// 1 betyr besøkt og tverrsum <= 19,
		// 2 betyr besøk neste runde,
		// 3 betyr besøkt og tverrsum > 19.
		// Merk at denne metoden ikke egner seg til å finne avstander, selv
		// om den er ganske lik slike metoder; dette er fordi felter som blir
		// markert for besøk som undersøkes senere i samme "steg" blir besøkt
		// i samme steg. Dette er helt i orden her, da rekkefølgen feltene blir
		// besøkt i ikke har noe å si.
		boolean ferdig = true;
		for (int i=0; i<brett.length; ++i) {
			for (int j=0; j<brett[i].length; ++j) {
				// Hvis dette er et felt vi skal besøke...
				if (brett[i][j] == 2) {
					// Trekk fra halve størrelsen for å regne tverrsummen.
					// Dette er fordi arrayet i utgangspunktet har (0,0) øverst
					// til venstre, men vi vil ha det i midten.
					if (tverrsum(i-STØRRELSE/2, j-STØRRELSE/2) > TVERRSUM) {
						// Tverrsummen er for stor. Marker feltet med en 3er.
						brett[i][j] = 3;
					} else {
						// Tverrsummen er ikke for stor. Marker feltene rundt for
						// besøk, bemerk at vi ikke er ferdig enda, og marker
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
		// Marker feltet i midten for besøk
		brett[STØRRELSE/2][STØRRELSE/2] = 2;
		int antall = 0;
		// Fortsett å regne frem til det ikke er noen felter igjen å besøke
		while (!steg()) {}
		
		// Tell hvor mange felter ble markert med 1ere.
		for (int i=0; i<brett.length; ++i) {
			for (int j=0; j<brett[i].length; ++j) {
				if (brett[i][j] == 1) ++antall;
			}
		}
		System.out.println("Rudolf kan nå "+antall+" felter.");
	}

}
