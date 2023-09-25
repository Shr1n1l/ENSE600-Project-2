import java.time.LocalDateTime;

public class Showtime {
    private int id;
    private LocalDateTime startTime;
    private int movieId;
    private int theaterNumber;
    private double ticketPrice;

    public Showtime(int id, LocalDateTime startTime, int movieId, int theaterNumber, double ticketPrice) {
        this.id = id;
        this.startTime = startTime;
        this.movieId = movieId;
        this.theaterNumber = theaterNumber;
        this.ticketPrice = ticketPrice;
    }

    // Getters and setters for all properties

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTheaterNumber() {
        return theaterNumber;
    }

    public void setTheaterNumber(int theaterNumber) {
        this.theaterNumber = theaterNumber;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Showtime{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", movieId=" + movieId +
                ", theaterNumber=" + theaterNumber +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
