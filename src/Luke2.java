import java.util.Arrays;
import easyIO.Out;

public class Luke2 {
	private static Out ut = new Out();
	private static int[] toPrimtall = {11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
	
	public static int finn_m(int n) {
		for (int i = (int)(n*Math.pow(10, n-1)+1); i < (int)((n+1)*Math.pow(10, n-1)); i+=2) {
			String iStreng = Integer.toString(i);
			boolean gyldig = true;
			boolean[] funnet = new boolean[100];
			for (int j=0; j<n-1; ++j) {
				int tall = Integer.parseInt("" + iStreng.charAt(j) + iStreng.charAt(j+1));
				if (Arrays.binarySearch(toPrimtall, tall) >= 0) {
					if (funnet[tall]) {
						gyldig = false;
					} else {
						funnet[tall] = true;
					}
				} else {
					gyldig = false;
				}
			}
			if (gyldig) return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		ut.outln(finn_m(9));
	}

}
