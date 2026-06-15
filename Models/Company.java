package Models;

public class Company {
    private int Id;
    private String CompanyTitle;
    private String CompanyPhoneNumber;
    private String CompanyOwner;

    public Company(int Id, String Title, String PhoneNumber, String Owner) {
        this.Id = Id;
        this.CompanyTitle = Title;
        this.CompanyPhoneNumber = PhoneNumber;
        this.CompanyOwner = Owner;
    }

    // Let write getter and setter method about above field or propties
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getCompanyTitle() {
        return CompanyTitle;
    }

    public void setCompanyTitle(String companytitle) {
        this.CompanyTitle = companytitle;
    }

    public String getCompanyPhoneNumber() {
        return this.CompanyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String CompanyPhoneNumber) {
        this.CompanyPhoneNumber = CompanyPhoneNumber;
    }

    public String getCompanyOwner() {
        return this.CompanyOwner;
    }

    public void setCompanyOwner(String CompanyOwner) {
        this.CompanyOwner = CompanyOwner;
    }

    @Override
    public String toString() {
        return "Company [Id = " + this.Id + ", Company Title =" + this.CompanyTitle + ", CompanyPhoneNumber = "
                + this.CompanyPhoneNumber
                + ", CompanyOwner = " + this.CompanyOwner + " ]";
    }

}
