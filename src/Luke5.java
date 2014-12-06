import java.util.ArrayList;
import easyIO.Out;

public class Luke5 {
	private static Out ut = new Out();
	// Oppgaven trenger en liste over primtall. Sett av en objektvariabel til dette.
	private static ArrayList<Integer> primtall;
	
	// Velg en "minste" primfaktor som er garantert større enn faktisk minste primfaktor.
	private static int minste = 999999999;
	// Lagre også hvilket tall som hadde denne primfaktoren.
	private static int minsteFunnet = 0;
	
	private static int største_primfaktor(int tall) {
		// Denne funksjonen er ikke helt som navnet skulle tilsi. Istedenfor å finne største primfaktor,
		// slutter den å lete etter større primfaktorer hvis et tidligere tall har hatt en mindre
		// største primfaktor. For å bruke funksjonen som navnet tilsier, bytt ut "for"-linjen med
		// linjen under, som har blitt kommentert ut. Grunnen til at dette gjøres er å korte ned
		// kjøretiden til programmet betraktelig.
		// Det er også grunnen til at faktoren blir satt til 999999999; dersom funksjonen stopper
		// uten å ha funnet noen primfaktorer, er det dette som returneres.
		
		// Mange løsninger som kan finnes på Internett finner laveste primfaktor til et tall
		// ved å løpe gjennom alle tall fra 2 og oppover og kontinuerlig dele tallet på
		// alt det er delelig på til løkken overgår tallet. Denne løsningen blir for treg for
		// tall i denne størrelsesordenen. Det er egentlig bare primtallene som må forsøkes.
		// Det er derfor programmet starter med å finne primtall.
		int faktor = 999999999;
		for (int i=0; i<primtall.size() && primtall.get(i) <= tall && primtall.get(i) < minste; ++i) {
		// for (int i=0; i<primtall.size() && primtall.get(i) <= tall; ++i) {
			// Del tallet på primtallet så lenge det fortsatt er delelig. Hvis det er delelig minst
			// en gang, er primtallet en primfaktor.
			while (tall % primtall.get(i) == 0) {
				tall /= primtall.get(i);
				if (tall == 1) faktor = primtall.get(i);
			}
		}
		return faktor;
	}
	
	// Rekursiv metode som går gjennom alle mulige permutasjoner av sifre i et tall.
	private static void regnUt(int tall) {
		regnUt("", Integer.toString(tall));
	}
	
	// Kjøttet i metoden over.
	private static void regnUt(String pre, String rest) {
		if (rest.equals("")) {
			// Hvis en hel permutasjon har blitt funnet, sjekk om største primfaktor er mindre
			// enn en som har blitt funnet før.
			int faktor = største_primfaktor(Integer.parseInt(pre));
			if (faktor < minste) {
				minste = faktor;
				minsteFunnet = Integer.parseInt(pre);
			}
			return;
		}
		
		// Hvis ikke, gå gjennom alle permutasjoner av resten av strengen.
		for (int i=0; i<rest.length(); ++i) {
			regnUt(pre + rest.charAt(i), rest.substring(0, i) + rest.substring(i+1, rest.length()));
		}
	}

	public static void main(String[] args) {
		// Dette programmet løser oppgaven og måler hvor lang tid det tok.
		// Kjøring på min egen maskin tar i underkant av 1 minutt, mesteparten av
		// dette går med til å finne alle primtallene som trengs.
		long tid1 = System.nanoTime();
		ut.outln("Beregner primtall...");
		primtall = Primtall.beregnPrimtall(987654321/2);
		ut.outln("Primtall beregnet.");
		ut.outln("Finner minste mulige største primfaktor...");
		long tid2 = System.nanoTime();
		regnUt(123456789);
		ut.outln(minsteFunnet+" har en største primfaktor på "+minste+", den minste funnet.");
		long tid3 = System.nanoTime();
		long ldiff1 = tid2-tid1;
		long ldiff2 = tid3-tid2;
		long ldiff3 = tid3-tid1;
		double ddiff1 = (ldiff1/1000000)/1000.0;
		double ddiff2 = (ldiff2/1000000)/1000.0;
		double ddiff3 = (ldiff3/1000000)/1000.0;
		ut.outln("Beregning av primtall tok "+ddiff1+" sekunder.");
		ut.outln("Beregning av minste mulige største primfaktor tok "+ddiff2+" sekunder.");
		ut.outln("Total kjøringstid var "+ddiff3+" sekunder");
	}
}
