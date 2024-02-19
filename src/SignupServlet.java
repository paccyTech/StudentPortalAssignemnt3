import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignUpServlet")
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // JDBC URL, username, and password of PostgreSQL server
    private static final String jdbcURL = "jdbc:postgresql://localhost:5432/StudentPortal";
    private static final String jdbcUsername = "postgres";
    private static final String jdbcPassword = "paccy";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email"); // Changed from username to email
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        Connection connection = null;
        PrintWriter out = response.getWriter();

        try {
            // Load JDBC driver
            Class.forName("org.postgresql.Driver");
            
            // Connect to the database
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            
            // Create a SQL query
            String sql = "INSERT INTO users (email, password, phone) VALUES (?, ?, ?)"; // Changed from username to email
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email); // Changed from username to email
            statement.setString(2, password);
            statement.setString(3, phone);
            
            // Execute the query
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
            	response.sendRedirect("login.jsp");
            } else {
                out.println("Failed to register user.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("An error occurred while processing your request.");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect GET requests to the signup page or display an error message
        response.sendRedirect("signup.jsp");
    }
}
