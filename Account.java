import javax.persistence.Entity;
import javax.persistence.Id;

@Entity  // This tells Spring that this is an entity (a table in the database)
public class Account {

    @Id  // The @Id annotation marks the field that will be the primary key in the database
    private String accountNo;
    private String policyName;
    private String policyDetails;

    // Getters and setters to allow other parts of the application to access and change the data
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getPolicyDetails() {
        return policyDetails;
    }

    public void setPolicyDetails(String policyDetails) {
        this.policyDetails = policyDetails;
    }
}
