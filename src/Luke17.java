import easyIO.Out;

public class Luke17 {
	private static Out ut = new Out();
	// En liste over trekk som er mulige fra hver enkelt posisjon
	// Merk at 0 er �verst.
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
	
	// En rekursiv metode som pr�ver alle mulige stier.
	// Siden en sti kan bes�ke b�de tidligere noder og tidligere kanter,
	// trenger ikke metoden � vite hele stien, bare hvor lang den har blitt
	// og hva siste trekk var (dvs hvor springeren er).
	public static void trekk(int antallTrekk, int sisteTrekk) {
		// Hvis stien har n�dd 10 trekk, legg en til antall stier funnet
		if (antallTrekk >= 10) ++antall;
		// Ellers, pr�v alle stier som g�r videre fra denne
		else for (int nesteTrekk : trekk[sisteTrekk]) trekk(antallTrekk+1, nesteTrekk);
	}

	public static void main(String[] args) {
		// Start med det f�rste trekket, og gj�r alle mulige trekk.
		trekk(1, 1);
		// Skriv ut antall stier funnet.
		ut.outln("Antall trekk: "+antall);
	}

}
