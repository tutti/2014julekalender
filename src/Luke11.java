import java.util.ArrayList;

import easyIO.Out;

public class Luke11 {
	private static Out ut = new Out();
	
	private static int finnSum(ArrayList<Integer> primtall, int start, int lengde) {
		// Denne metoden finner summen av n (lengde) primtall fra det mte (start) primtallet.
		// Merk at start ikke er primtallet du starter fra, men nummeret til primtallet (0-basert),
		// for eksempel er 11 det femte primtallet, så for å starte der bruker du start=4.
		if (start+lengde >= primtall.size()) {
			// Hvis det ikke er nok primtall igjen i listen over primtall, returner 0.
			return 0;
		}
		int sum = 0;
		for (int i=start; i<start+lengde; ++i) {
			// Legg dette primtallet til summen
			sum += primtall.get(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		// Oppgaven begrenset tallet N vi skulle finne til under 10 millioner.
		// Derfor trenger vi ingen primtall over 10 milioner heller.
		ArrayList<Integer> primtall = Primtall.beregnPrimtall(10000000);
		int[] funnet = new int[10000000];
		
		for (int i=0; i<primtall.size(); ++i) {
			// For hvert av tallene 7, 17, 41 og 541, finn summen av primtallene
			// fra dette primtallet (i) og så mange primtall videre.
			// Hvis summen er innenfor grensen (10000000), øk tilsvarende tall med 1.
			// Grunnen til at koden sjekker om summen er >0, er på grunn av overflow.
			int sum7 = finnSum(primtall, i, 7);
			if (sum7 <10000000 && sum7 > 0) ++funnet[sum7];
			int sum17 = finnSum(primtall, i, 17);
			if (sum17 <10000000 && sum17 > 0) ++funnet[sum17];
			int sum41 = finnSum(primtall, i, 41);
			if (sum41 <10000000 && sum41 > 0) ++funnet[sum41];
			int sum541 = finnSum(primtall, i, 541);
			if (sum541 <10000000 && sum541 > 0) ++funnet[sum541];
		}
		
		// Finn første tall som har forekommet som sum 4 ganger, og skriv det ut.
		int i;
		for (i=1; funnet[i]<4; ++i) {}
		ut.outln("Tallet "+i+" oppfyller alle kravene.");
	}

}
