import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private Connection connection;
    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/MovieTicketDB;create=true";
    private static final String USERNAME = "Shrinil";
    private static final String PASSWORD = "Mt123";

    public DatabaseAccess() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database connection error
        }
    }

    // Method to close the database connection
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to create a new movie record in the database
    public void createMovie(Movie movie) {
        String insertQuery = "INSERT INTO movies (title, director, year, genre, description) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getDirector());
            preparedStatement.setInt(3, movie.getYear());
            preparedStatement.setString(4, movie.getGenre());
            preparedStatement.setString(5, movie.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
        }
    }

    // Method to retrieve all movies from the database
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        String selectQuery = "SELECT * FROM movies";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String director = resultSet.getString("director");
                int year = resultSet.getInt("year");
                String genre = resultSet.getString("genre");
                String description = resultSet.getString("description");

                Movie movie = new Movie(id, title, director, year, genre, description);
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
        }
        return movies;
    }

    // Similar methods can be created for updating and deleting movies, users, and showtimes
}
