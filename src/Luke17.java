import easyIO.Out;

public class Luke17 {
	private static Out ut = new Out();
	// En liste over trekk som er mulige fra hver enkelt posisjon
	// Merk at 0 er øverst.
	private static int[][] trekk = {
		{4, 6},
		{6, 8},
		{7, 9},
		{4, 8},
		{3, 9, 0},
		{},
		{1, 7, 0},
		{2, 6},
		{1, 3},
		{2, 4}
	};
	
	// Antall trekk som har blitt gjort.
	private static int antall = 0;
	
	// En rekursiv metode som prøver alle mulige stier.
	// Siden en sti kan besøke både tidligere noder og tidligere kanter,
	// trenger ikke metoden å vite hele stien, bare hvor lang den har blitt
	// og hva siste trekk var (dvs hvor springeren er).
	public static void trekk(int antallTrekk, int sisteTrekk) {
		// Hvis stien har nådd 10 trekk, legg en til antall stier funnet
		if (antallTrekk >= 10) ++antall;
		// Ellers, prøv alle stier som går videre fra denne
		else for (int nesteTrekk : trekk[sisteTrekk]) trekk(antallTrekk+1, nesteTrekk);
	}

	public static void main(String[] args) {
		// Start med det første trekket, og gjør alle mulige trekk.
		trekk(1, 1);
		// Skriv ut antall stier funnet.
		ut.outln("Antall trekk: "+antall);
	}

}
