import easyIO.Out;

public class Luke24 {
	private static Out ut = new Out();

	public static void main(String[] args) {
//		int i = 99;
//		ut.outln((int)Math.ceil(Math.log10(i+1)));
		// Start på 6, gå oppover 10 om gangen (gå gjennom alle tall som slutter på 6).
		for (int i=6; true; i+=10) {
			// Tallet delt på 10 (integerdivisjon) gir sifrene før 6-tallet.
			// 6 ganger 10^(antall siffer - 1) pluss det ovennevnte gir
			// det originale tallet med 6-tallet flyttet til starten.
			int snudd = i/10 + 6*(int)Math.pow(10, Math.ceil(Math.log10(i+1)-1));
			// Sjekk om tallet oppfyller kravene, og isåfall skriv det ut og stopp.
			if (i*4 == snudd) {
				ut.outln("Minste tall som oppfyller alle kravene: "+i);
				return;
			}
		}
	}

}
