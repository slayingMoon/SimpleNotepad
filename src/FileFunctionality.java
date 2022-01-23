import java.awt.*;

public class FileFunctionality {

    GUI gui;

    public FileFunctionality(GUI gui) {
        this.gui = gui;
    }

    public void newFile() {
        gui.textArea.setText(""); //erase content of old file
        gui.window.setTitle("New"); //set title for the new file

    }

    public void open() {

        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);
    }
}
