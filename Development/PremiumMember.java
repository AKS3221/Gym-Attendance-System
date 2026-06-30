public class PremiumMember extends GymMember
{
    /** attributes of PremiumMember */
    private double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    /** constructor */
    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String personalTrainer)
    {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.premiumCharge = 50000;
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    /** accessor methods */
    public double getPremiumCharge()
    {
        return premiumCharge;
    }

    public String getPersonalTrainer()
    {
        return personalTrainer;
    }

    public boolean getIsFullPayment()
    {
        return isFullPayment;
    }

    public double getPaidAmount()
    {
        return paidAmount;
    }

    public double getDiscountAmount()
    {
        return discountAmount;
    }
    @Override
    public void markAttendance() 
    {
        System.out.println("Attendance marked for Premium Member: " + getName());
    }

    /** payDueAmount method */
    public String payDueAmount(double amount)
    {
        if (isFullPayment)
        {
            return "Full payment has already been made.";
        }

        if (paidAmount + amount > premiumCharge)
        {
            return "Payment exceeds total premium charge. Payment not accepted.";
        }

        paidAmount += amount;

        if (paidAmount == premiumCharge)
        {
            isFullPayment = true;
        }
        else
        {
            isFullPayment = false;
        }

        double remainingAmount = premiumCharge - paidAmount;
        return "Payment successful. Remaining amount: Rs. " + remainingAmount;
    }

    /** calculateDiscount method */
    public void calculateDiscount()
    {
        if (isFullPayment)
        {
            discountAmount = premiumCharge * 0.10;
            System.out.println("Discount of Rs. " + discountAmount + " applied.");
        }
        else
        {
            System.out.println("Discount not available. Full payment not completed.");
        }
    }

    /** revertPremiumMember method */
    public void revertPremiumMember()
    {
        resetMember();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    /** display method */
    public void display()
    {
        super.display();
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: Rs. " + paidAmount);
        System.out.println("Full Payment Done: " + isFullPayment);
        System.out.println("Remaining Amount: Rs. " + (premiumCharge - paidAmount));

        if (isFullPayment)
        {
            System.out.println("Discount Amount: Rs. " + discountAmount);
        }
    }
}