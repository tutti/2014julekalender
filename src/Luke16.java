import java.math.BigInteger;
import easyIO.Out;

public class Luke16 {
	// Verken int eller long kan holde i nærheten av så store verdier som kreves her.
	// Javas BigInteger kan det derimot; denne kan holde vilkårlig store verdier.
	private static Out ut = new Out();
	private static final BigInteger TO = new BigInteger("2");

	public static void main(String[] args) {
		// Gå gjennom alle verdier for n mellom 0 og 10000
		for (int n=0; n<=10000; ++n) {
			// Lag et tall 2^n og gjør det til en streng
			BigInteger tall = TO.pow(n);
			String streng = tall.toString();
			// Hvis strengen for 2^n inneholder "472047", er det den vi ser etter.
			// I så fall, skriv det ut som svar.
			if (streng.indexOf("472047") >= 0) {
				ut.outln("n="+n+", 2^n="+streng);
				return;
			}
		}
	}

}
