package com.hw2;
// import java.io.IOException;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;




public class PrimaryController {


    @FXML
    private TextField textField;

    @FXML
    private ListView<String> listView;

    @FXML
    private void selectFolder(ActionEvent event) {
        DirectoryChooser FolderChooser = new DirectoryChooser();
        File rootFolder = FolderChooser.showDialog(new Stage());
        Directory rootDirectory = new Folder(rootFolder.getName());
    
        if (rootFolder != null) {
            traverseFolder(rootFolder, rootDirectory);
        }

        initialize(rootFolder.getName());
        ObservableList<String> items = folderStructure(0, rootDirectory, FXCollections.observableArrayList());
        listView.setItems(items);
    }

    public void initialize(String directoryName) {
        textField.setText(directoryName);
    }

    public void traverseFolder(File directory, Directory parentFolder) {
        File[] files = directory.listFiles();
        
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    int dotIndex = fileName.lastIndexOf(".");
                    
                    if (dotIndex > 0) {
                        String name = fileName.substring(0, dotIndex);
                        String extension = fileName.substring(dotIndex+1);
                        parentFolder.add(new com.hw2.File(name, file.length(), extension));
                      }
                    
                } else {
                    Directory innerFoler = new Folder(file.getName());
                    parentFolder.add(innerFoler);
                    traverseFolder(file, innerFoler);
                }
            }
        }
        
    }

    

    public ObservableList<String> folderStructure(int indent, Directory directory, ObservableList<String> items) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < indent; i++)
            sb.append("     |");
        if (indent != 0)
            sb.append("-- ");
        sb.append(directory.getName() + ": " + Math.round(directory.calculateSize() * 100.0) / 100.0 + "MB");
        items.add(sb.toString());

        if (directory instanceof Folder) {
            List<Directory> folders = directory.getChildren();
            for (int i = 0; i < folders.size(); i++)
                folderStructure(indent + 1, folders.get(i), items);
    }
    return items;
}

}
