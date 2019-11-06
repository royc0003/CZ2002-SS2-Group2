package SS2Assignment;

public class ShowTime implements Serialization{
	import java.util.Calendar;
	import java.text.SimpleDateFormat;
	import java.util.Date;

    private String showBegins;
    private String showEnds;
    private double duration;
    public ShowTime(String showBegins, String showEnds) {
        this.showBegins = showBegins;
        this.showEnds = showEnds;
        this.duration = Integer.parseInt(this.showBegins) - Integer.parseInt(this.showEnds);
    }
   
    public String getshowBegins() {
        return this.showBegins;
    }

    public void setshowBegins(String showBegins) {
        this.showBegins = showBegins;
    }

    public String getshowEnds() {
        return showEnds;
    }

    public void setshowEnds(String showEnds) {
        this.showEnds = showEnds;
    }
    public double getDuration(){
        return this.duration;
    }
    public String[] toCsv() {
        String[] csv = {this.showBegins, this.showEnds, Double.toString(this.duration)};
        return csv;
    }
}
