import easyIO.In;
import easyIO.Out;

public class Luke4 {
	private static In fil = new In("kilma_data_blindern.txt");
	private static Out out = new Out();
	
	public static void main(String[] args) {
		fil.inLine();
		double minste = 0.0;
		String dato = "";
		while (!fil.endOfFile()) {
			String linje = fil.inLine();
			String[] data = linje.split("\\s+");
			int måned = Integer.parseInt(data[2].split("\\.")[1]);
			if (måned != 12) continue;
			double dagensTemperatur = Double.parseDouble(data[4].replace(",", "."));
			if (dagensTemperatur < minste) {
				minste = dagensTemperatur;
				dato = data[2];
			}
		}
		out.outln("Laveste temperatur: " + minste);
		out.outln("Dato: " + dato);
	}
}
