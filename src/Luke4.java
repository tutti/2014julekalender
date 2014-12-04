import easyIO.In;
import easyIO.Out;

public class Luke4 {
	private static In fil = new In("kilma_data_blindern.txt");
	private static Out out = new Out();
	
	public static void main(String[] args) {
//		String line = fil.inLine();
//		String[] split = line.split("\\s+");
//		for (String s : split) {
//			out.outln(s);
//		}
		fil.inLine();
		double smallest = 0.0;
		String date = "";
		while (!fil.endOfFile()) {
			String line = fil.inLine();
			String[] data = line.split("\\s+");
			int month = Integer.parseInt(data[2].split("\\.")[1]);
			if (month != 12) continue;
			double thisTemperature = Double.parseDouble(data[4].replace(",", "."));
			if (thisTemperature < smallest) {
				smallest = thisTemperature;
				date = data[2];
			}
		}
		out.outln("Laveste temperatur: " + smallest);
		out.outln("Dato: " + date);
	}
}
