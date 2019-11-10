

	public interface Serialization{ // mainly used to convert to CSV

	    public String[] toCsv(); //
	    /*
	    An example of the return value should look like this
	   String[] csv = {convertToString(this.movieID), this.movieTitle, convertToString(this.movieRating),
	        convertToString(this.movieAgeRating), this.showingStatus};
	        return csv;
	     */
	}

