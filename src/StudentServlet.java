import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve email address from session
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        
        // Proceed with sending email to the retrieved email address
        sendRegistrationConfirmation(email);
        response.sendRedirect("registration-confirmation.jsp");
        // Redirect or forward as needed
    }
    
    private void sendRegistrationConfirmation(String email) {
        final String username = "irakozep9@gmail.com"; // your email
        final String password = "bafv afem qbwv rywv"; // your email password

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Registration Confirmation");
            message.setText("Dear User,\n\nYour registration was successful!");

            Transport.send(message);

            System.out.println("Registration confirmation email sent to: " + email);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
