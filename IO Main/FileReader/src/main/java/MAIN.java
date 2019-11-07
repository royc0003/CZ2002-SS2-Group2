
public class MAIN {

	public static void main(String[] args) {
		CineplexManager cin = new CineplexManager("GV", "JP", 3);
		for(int i=0; i< cin.getnumberofcinema() ; i++) {
		System.out.println("Cinema " + Integer.toString(i+1) + ": " );
		cin.getseatmapofcinema(i);
		
		System.out.println("\n");
		}
		
		cin.bookseatatcinema(1, "1.4", 5);
		cin.bookseatatcinema(1,"3.7", 5);
		cin.bookseatatcinema(1, "2.1", 5);
		
		cin.getseatmapofcinema(1);

		
	}

}
