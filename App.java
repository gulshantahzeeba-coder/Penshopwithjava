import Interfaces.ICustomer;
import Menus.CustomerMenu;
import Services.CustomerService;

public class App {
    private static ICustomer _iCustomer;

    public App(ICustomer iCustomer) {
        _iCustomer = _iCustomer == null ? new CustomerService() : _iCustomer;
    }

    public static void main(String[] args) {
        CustomerMenu menu = new CustomerMenu(new CustomerService());
        menu.seedCustomers();
        menu.Start();
    }

}
