import java.time.LocalDateTime;

public class Booking {
    private int id;
    private int userId;
    private int showtimeId;
    private LocalDateTime bookingTime;
    private int numberOfSeats;

    public Booking(int id, int userId, int showtimeId, LocalDateTime bookingTime, int numberOfSeats) {
        this.id = id;
        this.userId = userId;
        this.showtimeId = showtimeId;
        this.bookingTime = bookingTime;
        this.numberOfSeats = numberOfSeats;
    }

    // Getters and setters for all properties

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", userId=" + userId +
                ", showtimeId=" + showtimeId +
                ", bookingTime=" + bookingTime +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }
}
