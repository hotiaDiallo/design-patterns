import command.fx.Button;
import command.fx.CustomerCommand;
import command.fx.CustomerService;

public class Main {
    public static void main(String[] args) {
        var service = new CustomerService();
        var command = new CustomerCommand(service);
        var button = new Button(command);
        button.execute();
    }
}