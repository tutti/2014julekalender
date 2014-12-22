import java.util.ArrayList;
import easyIO.Out;

public class Luke22 {
	private static Out ut = new Out();
	
	public static int kvadratsum(int n) {
		// Kvadratsummen av et tall er summen av kvadrattallene av sifrene.
		// For eksempel: kvadratsum(49) = 4^2 + 9^2
		int sum;
		for (sum=0; n>0; n/=10) {
			sum += (n%10)*(n%10);
		}
		return sum;
	}
	
	public static boolean har_egenskap(int n) {
		// En liste lagrer hvilke tall rekken har v�rt innom
		ArrayList<Integer> liste = new ArrayList<Integer>();
		// Fortsett til n=1 (det finnes en return inni i de tilfellene dette aldri skjer).
		while (n>1) {
			// Regn ut kvadratsummen av n
			n = kvadratsum(n);
			// Hvis denne summen allerede finnes i rekken, vil rekken aldri n� 1
			if (liste.contains(n)) return false;
			// Legg til nyeste sum i rekken
			liste.add(n);
		}
		// Rekken n�dde 1
		return true;
	}

	public static void main(String[] args) {
		ut.outln("Disse tallene g�r til 1:");
		// Skriv ut tallet 1 (vi vet at dette n�r 1, s� det skrives ut for � unng� kommaproblemer under).
		ut.out("1");
		for (int i=2; i<=50; ++i) {
			// For hvert tall fra 2 til 50 som har egenskapen, skriv ut tallet
			if (har_egenskap(i)) {
				ut.out(",");
				ut.out(i);
			}
		}
	}

}
