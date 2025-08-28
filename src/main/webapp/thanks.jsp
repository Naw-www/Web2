<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="murach.business.User" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Thanks for Joining</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css" />
    <style>
        .thank-you-container {
            text-align: center;
            padding: 40px;
        }
        
        .success-icon {
            font-size: 48px;
            color: #4caf50;
            margin-bottom: 20px;
        }
        
        .user-info {
            background-color: #f5f5f7;
            border-radius: 8px;
            padding: 20px;
            margin: 20px 0;
            text-align: left;
        }
        
        .info-row {
            display: flex;
            justify-content: space-between;
            padding: 10px 0;
            border-bottom: 1px solid #e0e0e0;
        }
        
        .info-row:last-child {
            border-bottom: none;
        }
        
        .info-label {
            font-weight: 600;
            color: #3d3d3d;
        }
        
        .info-value {
            color: #1d1d1f;
        }
        
        .back-link {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 24px;
            background-color: #0071e3;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            transition: background-color 0.3s;
        }
        
        .back-link:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="thank-you-container">
            <div class="success-icon">✓</div>
            <h1>Thank You for Joining!</h1>
            <p>You have been successfully added to our email list.</p>
            
            <%
                User user = (User) request.getAttribute("user");
                if (user != null) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            %>
            
            <div class="user-info">
                <h2>Your Information:</h2>
                
                <div class="info-row">
                    <span class="info-label">Name:</span>
                    <span class="info-value"><%= user.getFirstName() %> <%= user.getLastName() %></span>
                </div>
                
                <div class="info-row">
                    <span class="info-label">Email:</span>
                    <span class="info-value"><%= user.getEmail() %></span>
                </div>
                
                <% if (user.getDateOfBirth() != null) { %>
                <div class="info-row">
                    <span class="info-label">Date of Birth:</span>
                    <span class="info-value"><%= user.getDateOfBirth().format(formatter) %></span>
                </div>
                <% } %>
                
                <div class="info-row">
                    <span class="info-label">How you heard about us:</span>
                    <span class="info-value"><%= user.getHowHeardText() %></span>
                </div>
                
                <div class="info-row">
                    <span class="info-label">CD Announcements:</span>
                    <span class="info-value"><%= user.isCdAnnouncements() ? "Yes" : "No" %></span>
                </div>
                
                <div class="info-row">
                    <span class="info-label">Email Announcements:</span>
                    <span class="info-value"><%= user.isEmailAnnouncements() ? "Yes" : "No" %></span>
                </div>
                
                <div class="info-row">
                    <span class="info-label">Contact Method:</span>
                    <span class="info-value"><%= user.getContactMethodText() %></span>
                </div>
            </div>
            
            <% } %>
            
            <a href="emailList" class="back-link">Return to Sign Up</a>
        </div>
    </div>
</body>
</html>