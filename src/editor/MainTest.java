package editor;

public class MainTest {
    public static void main(String[] args) {
        var history = new History();
        var document = new HTMLDocument();
        document.setContent("Hello Word");
        var command = new BoldCommand(document, history);
        command.execute();
        System.out.println(document.getContent());
        var undo = new UndoCommand(history);
        undo.execute();
        System.out.println(document.getContent());
    }
}
