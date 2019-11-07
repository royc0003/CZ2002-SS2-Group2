import java.util.ArrayList;
import java.util.Scanner;

public class CineplexManager 
{
	private ArrayList<Cineplex> cineplexList = new ArrayList<Cineplex>();
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
		c.displayAvailableMovies()
	}
		
	public void displayAllMovies(MovieManager m)
	{
		m.printDetails();
	}

//------------------------Main methods-----------------------------------------------------------------------------------------------
	
	public void createMovie(MovieManager m)
	{
		m.createMovie();
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
	
	public void assignMoviesToCineplex(Cineplex cineplex)
	{
		c.addMovieToCineplex(MovieManager m);
	}	
}
