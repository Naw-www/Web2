package murach.business;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private String howHeard;
    private boolean cdAnnouncements;
    private boolean emailAnnouncements;
    private String contactMethod;

    // Default constructor
    public User() {
        this("", "", "", null, "", false, false, "");
    }

    // Constructor with basic fields
    public User(String firstName, String lastName, String email) {
        this(firstName, lastName, email, null, "", false, false, "emailOrPostal");
    }

    // Full constructor
    public User(String firstName, String lastName, String email, 
                LocalDate dateOfBirth, String howHeard, 
                boolean cdAnnouncements, boolean emailAnnouncements, 
                String contactMethod) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.howHeard = howHeard;
        this.cdAnnouncements = cdAnnouncements;
        this.emailAnnouncements = emailAnnouncements;
        this.contactMethod = contactMethod;
    }

    // Getters and Setters
    public String getFirstName() { 
        return firstName; 
    }
    
    public void setFirstName(String firstName) { 
        this.firstName = firstName; 
    }

    public String getLastName() { 
        return lastName; 
    }
    
    public void setLastName(String lastName) { 
        this.lastName = lastName; 
    }

    public String getEmail() { 
        return email; 
    }
    
    public void setEmail(String email) { 
        this.email = email; 
    }

    public LocalDate getDateOfBirth() { 
        return dateOfBirth; 
    }
    
    public void setDateOfBirth(LocalDate dateOfBirth) { 
        this.dateOfBirth = dateOfBirth; 
    }

    public String getHowHeard() { 
        return howHeard; 
    }
    
    public void setHowHeard(String howHeard) { 
        this.howHeard = howHeard; 
    }

    public boolean isCdAnnouncements() { 
        return cdAnnouncements; 
    }
    
    public void setCdAnnouncements(boolean cdAnnouncements) { 
        this.cdAnnouncements = cdAnnouncements; 
    }

    public boolean isEmailAnnouncements() { 
        return emailAnnouncements; 
    }
    
    public void setEmailAnnouncements(boolean emailAnnouncements) { 
        this.emailAnnouncements = emailAnnouncements; 
    }

    public String getContactMethod() { 
        return contactMethod; 
    }
    
    public void setContactMethod(String contactMethod) { 
        this.contactMethod = contactMethod; 
    }
    
    // Helper method to get formatted how heard text
    public String getHowHeardText() {
        switch(howHeard) {
            case "searchEngine": return "Search Engine";
            case "wordOfMouth": return "Word of Mouth";
            case "socialMedia": return "Social Media";
            case "other": return "Other";
            default: return howHeard;
        }
    }
    
    // Helper method to get formatted contact method text
    public String getContactMethodText() {
        switch(contactMethod) {
            case "emailOrPostal": return "Email or Postal Mail";
            case "emailOnly": return "Email Only";
            case "postalOnly": return "Postal Mail Only";
            default: return contactMethod;
        }
    }
}