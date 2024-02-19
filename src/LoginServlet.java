import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get parameters from the login form
        String email = request.getParameter("email"); // Changed from username to email
        String password = request.getParameter("password");

        // Check if credentials are valid
        boolean isValidUser = checkCredentials(email, password); // Changed from username to email

        if (isValidUser) {
            // If credentials are valid, redirect to student.jsp
        	HttpSession session = request.getSession();
        	session.setAttribute("email", email);
            response.sendRedirect("student.jsp");
        } else {
            // If credentials are not valid, redirect back to the login page
            response.sendRedirect("signup.jsp"); // You can change this to whatever your login page is
        }
    }

    private boolean checkCredentials(String email, String password) { // Changed from username to email
        // JDBC URL, username, and password of your PostgreSQL server
        String jdbcUrl = "jdbc:postgresql://localhost:5432/StudentPortal";
        String dbUsername = "postgres";
        String dbPassword = "paccy";

        // SQL query to check if email and password match in the database
        String sql = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ?"; // Changed from username to email

        try (
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
            
            // Create a prepared statement with the SQL query
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            // Set parameters for the prepared statement
            statement.setString(1, email); // Changed from username to email
            statement.setString(2, password);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if any rows are returned (indicating the credentials are valid)
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any SQL exceptions
        }

        // If no rows are returned or an exception occurs, return false
        return false;
    }
}
