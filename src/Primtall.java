import java.util.ArrayList;
import easyIO.Out;

public class Primtall {
	private static Out ut = new Out();
	public static ArrayList<Integer> beregnPrimtall(int maks) {
		return beregnPrimtall(maks, false);
	}
	
	public static ArrayList<Integer> beregnPrimtall(int maks, boolean debug) {
		ArrayList<Integer> primtall = new ArrayList<Integer>();
		boolean[] sieve = new boolean[maks+1];
		primtall.add(2);
		sieve[1] = true;
		sieve[2] = true;
		for (int i=3; i<=maks; i+=2) {
			if (i % 1000000 == 1 && debug) ut.outln((i-1)/1000000);
			if (sieve[i]) continue;
			for (int j=i; j<=maks; j+=i) {
				sieve[j] = true;
			}
			primtall.add(i);
		}
		return primtall;
	}
}
