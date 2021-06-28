package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import module.Image;
import javafx.stage.Popup;
import module.validator.ImageException;

import javax.swing.*;
import java.io.IOException;

public class ImageController {
    private Image image;
    @FXML
    private TextField rowEl;
    @FXML
    private TextField columnEl;
    public ImageController(){}

    @FXML
    public void createImageHandler(ActionEvent actionEvent) throws IOException, ImageException
    {
        try {
            int row = Integer.parseInt(rowEl.getText());
//        System.out.println(row);
            int column = Integer.parseInt(columnEl.getText());
            Image image = new Image(row, column);
            showNotification("Image created successfully!", Alert.AlertType.CONFIRMATION);
        }
        catch (Exception e)
        {
            showNotification(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void showNotification(String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle("Notification");
        alert.setContentText(message);
        alert.showAndWait();
    }

}
