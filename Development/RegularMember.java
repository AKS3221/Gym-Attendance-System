
/**
 * Write a description of class RegularMember here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RegularMember extends GymMember
{
    /** Attributes of RegularMember */
    private int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;

    /** Constructor */
    public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String referralSource,double fee)
    {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.attendanceLimit = 30;
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = "";
        this.referralSource = referralSource;
    }

    /** Accessor methods */
    public int getAttendanceLimit()
    {
        return attendanceLimit;
    }

    public boolean getIsEligibleForUpgrade()
    {
        return isEligibleForUpgrade;
    }

    public String getRemovalReason()
    {
        return removalReason;
    }

    public String getReferralSource()
    {
        return referralSource;
    }

    public String getPlan()
    {
        return plan;
    }

    public double getPrice()
    {
        return price;
    }

    /** Implement abstract method from GymMember */
    public void markAttendance()
    {
        int currentAttendance = getAttendance();
        currentAttendance++;
        setAttendance(currentAttendance);

        double currentPoints = getLoyaltyPoints();
        currentPoints += 5;
        setLoyaltyPoints(currentPoints);

        if (currentAttendance >= attendanceLimit)
        {
            isEligibleForUpgrade = true;
        }
    }

    /** Get plan price based on type */
    public double getPlanPrice(String plan)
    {
        switch(plan.toLowerCase())
        {
            case "basic": return 6500;
            case "standard": return 12500;
            case "deluxe": return 18500;
            default: return -1;
        }
    }

    /** Upgrade plan method */
    public String upgradePlan(String newPlan)
    {
        if (!isEligibleForUpgrade)
        {
            return "Member is not eligible for upgrade.";
        }

        if (newPlan.equalsIgnoreCase(plan))
        {
            return "This plan is already subscribed.";
        }

        double newPrice = getPlanPrice(newPlan);
        if (newPrice == -1)
        {
            return "Invalid plan selected.";
        }

        plan = newPlan;
        price = newPrice;
        return "Plan upgraded to " + newPlan + " at price Rs. " + price;
    }

    /** Revert Regular Member */
    public void revertRegularMember(String removalReason)
    {
        resetMember();
        isEligibleForUpgrade = false;
        plan = "basic";
        price = 6500;
        this.removalReason = removalReason;
    }

    /** Display method */
    public void display()
    {
        super.display();
        System.out.println("Plan: " + plan);
        System.out.println("Price: Rs. " + price);
        if (!removalReason.isEmpty())
        {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}