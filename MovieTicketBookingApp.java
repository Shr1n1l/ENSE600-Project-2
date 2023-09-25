import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MovieTicketBookingApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private DatabaseAccess databaseAccess;

    public MovieTicketBookingApp() {
        setTitle("Movie Ticket Booking App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        add(cardPanel);

        databaseAccess = new DatabaseAccess(); // Initialize database access

        // Create the main menu screen
        MainMenuPanel mainMenuPanel = new MainMenuPanel();
        cardPanel.add(mainMenuPanel, "MainMenu");

        // Create the movie selection screen
        MovieSelectionPanel movieSelectionPanel = new MovieSelectionPanel();
        cardPanel.add(movieSelectionPanel, "MovieSelection");

        // Set up action listeners to navigate between screens
        mainMenuPanel.setMovieSelectionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "MovieSelection");
                movieSelectionPanel.loadMovies(); // Load movies from the database
            }
        });

        movieSelectionPanel.setBackToMenuListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "MainMenu");
            }
        });

        // Center the window on the screen
        setLocationRelativeTo(null);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MovieTicketBookingApp app = new MovieTicketBookingApp();
                app.setVisible(true);
            }
        });
    }

    // Main menu screen
    private class MainMenuPanel extends JPanel {
        private JButton movieSelectionButton;

        public MainMenuPanel() {
            setLayout(new BorderLayout());

            JLabel titleLabel = new JLabel("Welcome to Movie Ticket Booking");
            titleLabel.setHorizontalAlignment(JLabel.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
            add(titleLabel, BorderLayout.NORTH);

            movieSelectionButton = new JButton("Book Tickets");
            movieSelectionButton.setFont(new Font("Arial", Font.PLAIN, 16));
            add(movieSelectionButton, BorderLayout.CENTER);
        }

        public void setMovieSelectionListener(ActionListener listener) {
            movieSelectionButton.addActionListener(listener);
        }
    }

    // Movie selection screen
   private class MovieSelectionPanel extends JPanel {
    private JButton backButton;
    private JComboBox<Movie> movieComboBox;

    public MovieSelectionPanel() {
        setLayout(new BorderLayout());

        // Header panel with column names
        JPanel headerPanel = new JPanel(new GridLayout(1, 6)); // 6 columns
        JLabel idLabel = new JLabel("ID");
        JLabel titleLabel = new JLabel("Title");
        JLabel directorLabel = new JLabel("Director");
        JLabel yearLabel = new JLabel("Year");
        JLabel genreLabel = new JLabel("Genre");
        JLabel descriptionLabel = new JLabel("Description");

        headerPanel.add(idLabel);
        headerPanel.add(titleLabel);
        headerPanel.add(directorLabel);
        headerPanel.add(yearLabel);
        headerPanel.add(genreLabel);
        headerPanel.add(descriptionLabel);
        add(headerPanel, BorderLayout.NORTH);

        movieComboBox = new JComboBox<>();
        movieComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        add(movieComboBox, BorderLayout.CENTER);

        backButton = new JButton("Back to Menu");
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        add(backButton, BorderLayout.SOUTH);
    }

    public void setBackToMenuListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void loadMovies() {
        // Load movies from the database and populate the combo box
        List<Movie> movies = databaseAccess.getAllMovies();
        DefaultComboBoxModel<Movie> model = new DefaultComboBoxModel<>(movies.toArray(new Movie[0]));
        movieComboBox.setModel(model);
    }
}
}
