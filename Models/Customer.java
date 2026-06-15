package Models;

public class Customer {
    private int Id;
    private String Title;
    private String Email;
    private String Phone;

    public Customer(int id, String title, String email, String phone) {
        this.Id = id;
        this.Title = title;
        this.Email = email;
        this.Phone = phone;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPhone() {
        return this.Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    @Override
    public String toString() {
        return "Customer [Id = " + this.Id + ", Title  = " + this.Title + ", Email  = " + this.Email + ", Phone  ="
                + this.Phone + "]";
    }

}
