
/**
 * Write a description of class GYMmember here.
 *
 * @author (Aashutosh)
 * @version (a version number or a date)
 */
public abstract class GymMember
{
    // Private attributes
    private int id;
    private String DOB;
    private String name;
    private String membershipStartDate;
    private String location;
    private int attendance;
    private String phone;
    private double loyaltyPoints;
    private String email;
    private boolean activeStatus;
    private String gender;

    // Constructor
    public GymMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate) 
    {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0;
        this.loyaltyPoints = 0.0;
        this.activeStatus = false;
    }

    // Abstract method
    public abstract void markAttendance();

    // Getter methods (accessors)
    public int getId()
    {
        return id;
    }

    public String getDOB() 
    {
        return DOB;
    }

    public String getName() 
    {
        return name;
    }

    public String getMembershipStartDate() 
    {
        return membershipStartDate;
    }

    public String getLocation() 
    {
        return location;
    }

    public int getAttendance()
    {
        return attendance;
    }

    public String getPhone() 
    {
        return phone;
    }

    public double getLoyaltyPoints() 
    {
        return loyaltyPoints;
    }

    public String getEmail() 
    {
        return email;
    }

    public boolean isActiveStatus() 
    {
        return activeStatus;
    }

    public String getGender() 
    {
        return gender;
    }

    // Setter methods (if needed for subclass access)
    public void setAttendance(int attendance)
    {
        this.attendance = attendance;
    }

    public void setLoyaltyPoints(double loyaltyPoints) 
    {
        this.loyaltyPoints = loyaltyPoints;
    }

    public void setActiveStatus(boolean status) 
    {
        this.activeStatus = status;
    }

    // Activate membership
    public void activateMembership()
    {
        this.activeStatus = true;
    }

    // Deactivate membership
    public void deactivateMembership()
    {
        if (activeStatus) {
            this.activeStatus = false;
        } else {
            System.out.println("Membership is already deactivated.");
        }
    }

    // Reset member data
    public void resetMember() 
    {
        this.activeStatus = false;
        this.attendance = 0;
        this.loyaltyPoints = 0.0;
    }

    // Display member info
    public void display() 
    {
        System.out.println("=== Gym Member Info ===");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("DOB: " + DOB);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Active Status: " + (activeStatus ? "Active" : "Inactive"));
    }
}