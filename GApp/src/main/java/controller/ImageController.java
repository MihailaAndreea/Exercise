package controller;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import module.Image;
import javafx.stage.Popup;
import module.Pixel;
import module.validator.ImageException;

import java.io.IOException;

public class ImageController {
    private Image image;
    @FXML
    private TextField rowEl;
    @FXML
    private TextField columnEl;
    @FXML
    private Stage stage;
    public ImageController(){}

    @FXML
    public void createImageHandler(ActionEvent actionEvent) throws IOException, ImageException
    {
        try {
            Group root = new Group();
            int row = Integer.parseInt(rowEl.getText());
            int column = Integer.parseInt(columnEl.getText());
            Image image = new Image(row, column);
            GridPane gridPane = new GridPane();
            root.getChildren().add(gridPane);
            Scene scene = new Scene(root, 500, 400);
            stage.setScene(scene);
            stage.setTitle("Image");
            stage.initModality(Modality.APPLICATION_MODAL);
            Pixel[][] matrix = image.getMatrix();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    String color = "-fx-background-color:white";
                    TextField text = new TextField();
                    text.setPrefWidth(40);
                    text.setPrefHeight(40);
                    text.setText(matrix[i][j].getColor());
                    text.setStyle(color);
                    text.setEditable(false);
                    gridPane.add(text, j, i);
                }
            }
            Line line1 = new Line(row * 46, column * 67, row * 46, 0);
            root.getChildren().add(line1);
            Button colorV = new Button("Color!");
            gridPane.add(colorV, column, 5);
            Label colorOnVertical = new Label("Color on Vertical");
            gridPane.add(colorOnVertical, column, 0);
            TextField verticalRow1 = new TextField();
            verticalRow1.setPrefWidth(40);
            verticalRow1.setPrefHeight(10);
            verticalRow1.setPromptText("X1");
            verticalRow1.setMaxWidth(40);
            gridPane.add(verticalRow1, column, 1);
            TextField verticalRow2 = new TextField();
            verticalRow2.setPrefWidth(40);
            verticalRow2.setPrefHeight(10);
            verticalRow2.setPromptText("X2");
            verticalRow2.setMaxWidth(40);
            gridPane.add(verticalRow2, column, 2);
            TextField verticalColumn = new TextField();
            verticalColumn.setPrefWidth(40);
            verticalColumn.setPrefHeight(10);
            verticalColumn.setPromptText("Y");
            verticalColumn.setMaxWidth(40);
            gridPane.add(verticalColumn, column, 3);
            TextField colorVertical = new TextField();
            colorVertical.setPrefWidth(50);
            colorVertical.setPrefHeight(10);
            colorVertical.setPromptText("Color");
            colorVertical.setMaxWidth(50);
            gridPane.add(colorVertical, column, 4);
            colorV.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    colorOnVertical(image, gridPane, colorVertical.getText(), Integer.parseInt(verticalRow1.getText()), Integer.parseInt(verticalRow2.getText()), Integer.parseInt(verticalColumn.getText()));
                }
            });
            stage.show();
//            showNotification("Image created successfully!", Alert.AlertType.CONFIRMATION);
        }
        catch (Exception e)
        {
            showNotification(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void colorOnVertical(Image image, GridPane gridPane, String color, int x1, int x2, int y)
    {
        Pixel[][] matrix = image.getMatrix();
        image.colorVertical(x1, x2, y, color);
        int row = image.getRow();
        int column = image.getColumn();
        String colorM;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                switch (matrix[i][j].getColor())
                {
                    default:
                        colorM = "-fx-background-color:white";
                        break;
                    case "P":
                        colorM = "-fx-background-color:pink";
                        break;
                    case "Or":
                        colorM = "-fx-background-color:orange";
                        break;
                    case "Pu":
                        colorM = "-fx-background-color:purple";
                        break;
                }
                TextField text = new TextField();
                text.setPrefWidth(40);
                text.setPrefHeight(40);
                text.setText(matrix[i][j].getColor());
                text.setStyle(colorM);
                text.setEditable(false);
                gridPane.add(text, j, i);
            }
        }
    }

    private void showNotification(String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle("Notification");
        alert.setContentText(message);
        alert.showAndWait();
    }

}
