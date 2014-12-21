import java.util.Arrays;

import easyIO.Out;
import easyIO.In;

public class Luke21 {
	public static Out ut = new Out();
	public static In fil = new In("words.txt");
	
	static final int ANTALL_ORD = 235886; // Det er 235886 ord i filen.
	
	public static int ascii_sum(String ord) {
		// Siden char+int konverterer char til integer-verdien av tegnet,
		// som er ASCII-verdien, er dette lett.
		int sum = 0;
		for (int i=0; i<ord.length(); ++i) {
			sum += ord.charAt(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		// Gå gjennom filen og noter ASCII-verdien for hvert ord
		int[] verdier = new int[ANTALL_ORD];
		for (int i=0; i<ANTALL_ORD; ++i) {
			String ord = fil.inLine();
			verdier[i] = ascii_sum(ord);
		}
		// Sorter arrayen
		Arrays.sort(verdier);
		
		// Legg sammen summen av de 42 siste (største) verdiene
		int sum = 0;
		for (int i=ANTALL_ORD-42; i<ANTALL_ORD; ++i) {
			sum += verdier[i];
		}
		System.out.println("Summen er "+sum);
	}
}
