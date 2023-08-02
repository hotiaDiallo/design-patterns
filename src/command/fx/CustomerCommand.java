package command.fx;

public class CustomerCommand implements Command<Void>{
    private final CustomerService service;

    public CustomerCommand(CustomerService service) {
        this.service = service;
    }

    @Override
    public Void execute() {
        service.addCustomer();
        return null;
    }
}
