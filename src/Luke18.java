import java.util.Arrays;
import java.util.HashMap;

import easyIO.In;
import easyIO.Out;

public class Luke18 {
	private static Out ut = new Out();

	public static void main(String[] args) {
		// Lag et objekt for å hente ordene
		In fil = new In("words.txt");
		
		// Lagre hvor mange ganger hver tegnkombinasjon har blitt funnet
		HashMap<String, Integer> ord = new HashMap<String, Integer>();
		
		// Les hver linje (1 ord per linje)
		while (fil.hasNext()) {
			// Les inn
			String linje = fil.inLine().toLowerCase();
			
			// Converter til char-array
			char[] charlinje = linje.toCharArray();
			
			// Sorter char-array
			Arrays.sort(charlinje);
			
			// Gjør tilbake til en streng
			linje = new String(charlinje);
			
			// Nullstill antallet for denne tegnkombinasjonen hvis nødvendig
			if (ord.get(linje) == null) ord.put(linje, 0);
			
			// Øk tallet for denne tegnkombinasjonen
			ord.put(linje, ord.get(linje)+1);
		}
		
		int max = 0;
		String maxStreng="";
		
		// Se gjennom antall for hver tegnkombinasjon og finn ut hvilken det er flest av
		for (String etOrd : ord.keySet()) {
			if (ord.get(etOrd) > max) {
				max = ord.get(etOrd);
				maxStreng = etOrd;
			}
		}
		
		ut.outln(max+" forekomster av ord bestående av bokstavene "+maxStreng);
	}

}
