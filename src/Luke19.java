import easyIO.Out;

public class Luke19 {
	// Kombiner alle linjene til en lang streng
	private static String lang_streng = "JegtroringenkanleveetheltlivutenkjærlighetMenkjærlighetenharmange"+
		"ansikterIhøstkomdetutenboksomheterErlikKjærlighetDenbeståravsamtaler"+
		"medselgereavgatemagasinetsomnåeretablertimangenorskebyerAlleharde"+
		"enhistorieåfortelleomkjærlighetsomnoeavgjørendeEntendetertilen"+
		"partneretfamiliemedlemenvennelleretkjæledyrMangeharopplevdåbli"+
		"sveketogselvåsvikteMenutrolignokblirikkekjærlighetsevnenødelagt"+
		"allikevelDenbyggesoppigjengangpågangKjærligheteneretstedåfeste"+
		"blikketDengirossretningognoeåstyreetterDengirossverdisommennesker"+
		"ognoeåleveforPåsammemåtesomkjærligheteneretfundamentimenneskelivet"+
		"erGrunnlovenetfundamentfornasjonenNorgeFor200årsidensamletengruppe"+
		"mennsegpåEidsvollforålagelovensomskullebligrunnlagettildetselvstendige"+
		"NorgeGrunnlovensomdengangblevedtattharutvikletsegipaktmedtidenog"+
		"sikreridagdetnorskefolkrettigheterviletttarforgittihverdagenRettighetersom"+
		"menneskerimangeandrelandbarekandrømmeomogsomdeslossformedlivet"+
		"sominnsatsJeghåperatvigjennomjubileumsfeiringeni2014vilbliminnetom"+
		"hvaGrunnlovenegentligbetyrforosssåvikanfortsetteåarbeideforverdiene"+
		"vårebådeherhjemmeoginternasjonaltJegharlysttilånevnenoeneksempler"+
		"påhvordanGrunnlovenvirkerinnpåenkeltmenneskerslivTenkdegatduskriver"+
		"etkritiskinnleggomlandetsstyrepåsosialemedier";
	
	private static Out ut = new Out();
	
	// Bruker erPalindrom() fra luke 1
	private static boolean erPalindrom(String tall) {
		// Sjekker om en streng er et palindrom
		// Metoden reverse() i StringBuilder blir brukt.
		StringBuilder sb = new StringBuilder(tall);
		return sb.reverse().toString().equals(tall);
	}
	
	public static void main(String[] args) {
		// Behold den lengste strengen så langt etter hver steg
		String lengste = "";
		// Gå gjennom alle mulige startposisjoner
		for (int i=0; i<lang_streng.length(); ++i) {
			// For hver startposisjon, gå gjennom alle mulige strenger som starter der
			// (dvs med slutt helt fra neste tegn til slutten av ordet)
			for (int j=i+1; j<=lang_streng.length(); ++j) {
				// Hvis strengen er et palindrom og lengre enn det forrige palindromet, behold den.
				String s = lang_streng.substring(i, j);
				if (erPalindrom(s) && s.length() > lengste.length()) {
					lengste = s;
				}
			}
		}
		ut.outln("Lengste palindrom: "+lengste);
	}
}
