package lab5.editor;

public class TestEditor {
    public static void main(String[] args) {
        DocumentInvoker myDocument = new DocumentInvoker("callmemaybe");

        myDocument.Write("Hey I just met you");
        myDocument.Write("And this is crazy");
        myDocument.Write("But here’s my number");
        myDocument.Write("So call me maybe");
		myDocument.Redo(3);

        myDocument.Erase("And this is crazy");

        myDocument.Undo(0);

        myDocument.Bold(1);

        System.out.println(myDocument.Read());
        myDocument.printCommandBuffer();
    }
}
