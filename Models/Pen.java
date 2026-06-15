package Models;

public class Pen
{
    private int Id;
    private String PenTitle;
    private String PenCompany;
    private String PenColor;

    public Pen(int id, String PenTitle, String penCompany, String penColor) {
        this.Id = id;
        this.PenTitle = PenTitle;
        this.PenCompany = penCompany;
        this.PenColor = penColor;
    }

    // Let write getter and setter method about above field or propties
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getPenTitle() {
        return PenTitle;
    }

    public void setPenTitle(String pentitle) {
        this.PenTitle = pentitle;
    }

    public String getPenComapny() {
        return this.PenCompany;
    }

    public void setPenCompany(String penCompany) {
        this.PenCompany = penCompany;
    }

    public String getPenColor() {
        return this.PenColor;
    }

    public void setPencolor(String penColor) {
        this.PenColor = penColor;
    }

    @Override
    public String toString() {
        return "Pen [id = " + this.Id + ", Pen Title =" + this.PenTitle + ", Pen Company = " + this.PenCompany
                + ", Pen Color = " + this.PenColor + " ]";
    }

}
