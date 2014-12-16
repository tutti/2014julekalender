import java.math.BigInteger;
import easyIO.Out;

public class Luke16 {
	// Verken int eller long kan holde i n�rheten av s� store verdier som kreves her.
	// Javas BigInteger kan det derimot; denne kan holde vilk�rlig store verdier.
	private static Out ut = new Out();
	private static final BigInteger TO = new BigInteger("2");

	public static void main(String[] args) {
		// G� gjennom alle verdier for n mellom 0 og 10000
		for (int n=0; n<=10000; ++n) {
			// Lag et tall 2^n og gj�r det til en streng
			BigInteger tall = TO.pow(n);
			String streng = tall.toString();
			// Hvis strengen for 2^n inneholder "472047", er det den vi ser etter.
			// I s� fall, skriv det ut som svar.
			if (streng.indexOf("472047") >= 0) {
				ut.outln("n="+n+", 2^n="+streng);
				return;
			}
		}
	}

}
