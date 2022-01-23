import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

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
        fileName = null;
        fileAddress = null;
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

    public void save() {

        if(fileName == null) {

            saveAs(); //if file does not have a name, simply call the saveAs method

        }else {
            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();
            }catch (Exception e) {
                System.out.println("CANNOT OPEN FILE");
            }
        }
    }

    public void saveAs() {
        FileDialog fd = new FileDialog(gui.window, "Save As", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }

        try {

            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();
        }catch (Exception e) {

            System.out.println("COULD NOT SAVE FILE");

        }
    }

    public void exit() {

        System.exit(0);
    }
}
