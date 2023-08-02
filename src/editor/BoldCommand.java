package editor;

public class BoldCommand implements UndoableCommand{
    private final HTMLDocument document;
    private final History history;
    private  String previousContent;

    public BoldCommand(HTMLDocument document, History history) {
        this.document = document;
        this.history = history;
    }

    @Override
    public void execute() {
        previousContent = document.getContent();
        document.makeBold();
        history.push(this);
    }

    @Override
    public void unexecute() {
        document.setContent(previousContent);
    }
}
