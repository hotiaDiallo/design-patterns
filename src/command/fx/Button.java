package command.fx;

public class Button implements Command<Void>{
    private final Command command;

    public Button(Command command) {
        this.command = command;
    }

    @Override
    public Void execute() {
        command.execute();
        return null;
    }
}
