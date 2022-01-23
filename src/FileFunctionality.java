import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileFunctionality {

    GUI gui;
    String fileName;
    String fileAddress;

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

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }


        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileAddress + fileName)); //full file path

            gui.textArea.setText(""); //clear text from previous opened document

            String line = null;

            while ((line = reader.readLine()) != null) {

                gui.textArea.append(line + "\n");
            }

            reader.close(); //close the reader

        }catch (Exception e) {

            System.out.println("FILE NOT OPENED!");
        }
    }
}
