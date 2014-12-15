import java.util.ArrayList;
import easyIO.Out;

public class Luke15 {
	private static Out ut = new Out();
	// Gjør antall funnet, n og hvilke tall som er funnet tilgjengelige for hele klassen
	private static int antall = 0;
	private static int n = 0;
	private static ArrayList<Integer> funnet = new ArrayList<Integer>();
	
	// Rekursiv metode som går gjennom alle mulige permutasjoner av sifre i et tall.
	// Kopiert fra oppgave 5
	private static void regnUt(int tall) {
		regnUt("", Integer.toString(tall));
	}
	
	// Kjøttet i metoden over.
	private static void regnUt(String pre, String rest) {
		if (rest.equals("")) {
			// Her skjer utregningen; det er denne delen som er ulik oppgave 5
			// Del opp tallet i to tosifrede tall.
			// Dersom begge er delelige på 10, er de ikke gyldige.
			// Dersom produktet av dem allerede har blitt funnet, skal det ikke telles en gang til.
			// Ellers har vi funnet en ny gyldig n.
			int a = Integer.valueOf(pre.substring(0, 2));
			int b = Integer.valueOf(pre.substring(2, 4));
			if (a%10 == 0 && b%10 == 0) return;
			if (funnet.contains(n)) return;
			if (a*b == n) {
				funnet.add(n);
				++antall;
			}
			return;
		}
		
		// Gå gjennom alle mulige permutasjoner av strengen
		for (int i=0; i<rest.length(); ++i) {
			regnUt(pre + rest.charAt(i), rest.substring(0, i) + rest.substring(i+1, rest.length()));
		}
	}

	public static void main(String[] args) {
		antall = 0;
		for (n=1000; n<10000; ++n) {
			// Løp gjennom alle mulige permutasjoner av tallet n
			// Dette gjør at alle mulige kombinasjoner av sifre i tallet n prøves.
			regnUt(n);
		}
		ut.outln("Antall n som svarer til alle kravene: "+antall);
	}

}
