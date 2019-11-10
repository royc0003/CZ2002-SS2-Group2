import java.util.ArrayList;
import java.util.Scanner;

public class CineplexManager 
{
	protected ArrayList<Cineplex> cineplexList = new ArrayList<Cineplex>();
	private MovieManager movieManager;
	

//-------------------------Get methods--------------------------------------------------------------------------------------------	
	public Cineplex selectCineplex(int cineplexID)
	{
		for(int i = 0; i< cineplexList.size(); i++)
		{
			if(cineplexList.get(i).getCineplexID() == cineplexID)
			{
				return cineplexList.get(i);
			}
		}
		return null;
	}

//------------------------Display methods----------------------------------------------------------------------------------------------------------	
	
	public void displayMovieListOfCineplex(Cineplex c)
	{
		c.displayAvailableMovies();
	}
		
	public void displayAllMovies(MovieManager m)
	{
		m.printGlobalListOfMovieIDs();
	}
	
	
	public void printCineplexlist() {
		
		Cineplex[] SortCopy2= new Cineplex[cineplexList.size()];
		SortCopy2 = sortCineplexID();
		
		for(int i=0;i<SortCopy2.length; i++) {
			System.out.println("("+ (i+1) +")" + "Cineplex : " + SortCopy2[i].nameOfCineplex);
		}
		}

//------------------------Main methods-----------------------------------------------------------------------------------------------
	
	public void createMovie(MovieManager m)
	{
		m.createMovieCreator();
	}
	
	public void createCineplex()
	{
		System.out.println("Enter ID of Cineplex");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		
		System.out.println("Enter name of Cineplex");
		Scanner sc1 = new Scanner(System.in);
		String name = sc1.nextLine();
		
		System.out.println("Enter location of Cineplex");
		Scanner sc2 = new Scanner(System.in);
		String location = sc2.nextLine();
		
		System.out.println("Enter no of cinemas in Cineplex");
		Scanner sc3 = new Scanner(System.in);
		int number = sc3.nextInt();
		
		Cineplex cineplex = new Cineplex(id, name, location, number);
		cineplexList.add(cineplex);

		
		System.out.println("Created cineplex " + name + " at location " + location + " with " + number + " cinemas..");	
	}
	
	public void assignMoviesToCineplex(Cineplex c, int movieid)
	{	
		MovieAndShowtimes m = movieManager.getMovieAndShowtimes(movieid);
		c.addMovieToCineplex(m);
	}
	
		
	public Cineplex[] sortCineplexID(){
		
		Cineplex[] SortCopy= new Cineplex[cineplexList.size()];
		
		for(int i=0; i<cineplexList.size(); i++) {
			SortCopy[i]= cineplexList.get(i);
		}
		
		for(int i=0; i< SortCopy.length; i++) {
			if(SortCopy[i].cineplexID > SortCopy[i+1].cineplexID  ) {
				Cineplex temp = SortCopy[i+1];
				SortCopy[i] = SortCopy[i+1];
				SortCopy[i+1] = temp;
			}
		}
		return SortCopy;
	}
		
		
	
}