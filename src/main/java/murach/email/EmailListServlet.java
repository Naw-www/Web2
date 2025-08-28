package murach.email;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import murach.business.User;
import murach.data.UserDB;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.html";

        // Get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // Perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.html"; // the "join" page
        } else if (action.equals("add")) {
            // Get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            
            // Get date of birth and parse it
            String dobString = request.getParameter("dateOfBirth");
            LocalDate dateOfBirth = null;
            if (dobString != null && !dobString.isEmpty()) {
                dateOfBirth = LocalDate.parse(dobString);
            }
            
            // Get how user heard about us
            String howHeard = request.getParameter("howHeard");
            
            // Get announcement preferences (checkboxes)
            String cdAnnouncementsParam = request.getParameter("cdAnnouncements");
            boolean cdAnnouncements = "yes".equals(cdAnnouncementsParam);
            
            String emailAnnouncementsParam = request.getParameter("emailAnnouncements");
            boolean emailAnnouncements = "yes".equals(emailAnnouncementsParam);
            
            // Get contact method preference
            String contactMethod = request.getParameter("contactMethod");
            
            // Create User object with all data
            User user = new User(firstName, lastName, email, 
                               dateOfBirth, howHeard, 
                               cdAnnouncements, emailAnnouncements, 
                               contactMethod);
            
            // Save User object in database
            UserDB.insert(user);
            
            // Set User object in request object and set URL
            request.setAttribute("user", user);
            url = "/thanks.jsp"; // the "thanks" page
        }

        // Forward request and response objects to specified URL
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}