import java.util.ArrayList;
import easyIO.Out;

public class Luke5 {
	private static Out ut = new Out();
	private static ArrayList<Integer> primtall;
	
	private static int minste = 999999999;
	private static int minsteFunnet = 0;
	
	private static int største_primfaktor(int tall) {
		int faktor = 999999999;
		for (int i=0; i<primtall.size() && primtall.get(i) <= tall && primtall.get(i) < minste; ++i) {
		/* Merk: Linjen over er modifisert for å passe bedre til dette programmets behov.
		 * Primtallene som er over den minste faktoren funnet så langt sjekkes ikke,
		 * dette sparer mye tid, men returnerer feil faktor. For å bruke denne metoden for
		 * å finne den faktiske største primfaktoren, bruk linjen under istedenfor.
		 */
		// for (int i=0; i<primtall.size() && primtall.get(i) <= tall; ++i) {
			while (tall % primtall.get(i) == 0) {
				tall /= primtall.get(i);
				if (tall == 1) faktor = primtall.get(i);
			}
		}
		return faktor;
	}
	
	private static void regnUt(int tall) {
		regnUt("", Integer.toString(tall));
	}
	
	private static void regnUt(String pre, String rest) {
		if (rest.equals("")) {
			int faktor = største_primfaktor(Integer.parseInt(pre));
			if (faktor < minste) {
				minste = faktor;
				minsteFunnet = Integer.parseInt(pre);
			}
			return;
		}
		
		for (int i=0; i<rest.length(); ++i) {
			regnUt(pre + rest.charAt(i), rest.substring(0, i) + rest.substring(i+1, rest.length()));
		}
	}

	public static void main(String[] args) {
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
