package org.example.samochodgui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import symulator.*;

import java.awt.*;
import java.io.IOException;

public class HelloController {
    @FXML
    public TextField modelPojazduTextField;
    public TextField nrRejestracyjnyTextField;
    public Button startButton;
    public ComboBox carComboBox;
    public Button newCarButton;

    private symulator.Samochod startSamochod = new symulator.Samochod(
            "TAG8912", "Ursus C330", 24, 2400, 6, 0, 0
    );
    private symulator.Samochod samochod = new symulator.Samochod(
            "TAG8912", "Ursus C330", 24, 2400, 6, 0, 0
    );

    @FXML
    public void initialize() {
        carComboBox.getItems().addAll(startSamochod);
        //samochod = carComboBox.getItems().get(0);
        refresh();
        // Load and set the car image
//        Image carImage = new Image(getClass().getResource("/images/car.png").toExternalForm());
//        System.out.println("Image width: " + carImage.getWidth() + ", height: " + carImage.getHeight());
//        carImageView.setImage(carImage);
//        carImageView.setFitWidth(30); // Set appropriate
//        dimensions for your image
//        carImageView.setFitHeight(20);
//        carImageView.setTranslateX(0);
//        carImageView.setTranslateY(0);
    }

    public void refresh() {
        modelPojazduTextField.setText(String.valueOf(samochod.getModel()));
        nrRejestracyjnyTextField.setText(String.valueOf(samochod.getNrRejestracyjny()));
    }

    public void addCarToList(String model, String registration, Double weight, Integer speed) {
        carComboBox.getItems().addAll(new symulator.Samochod(
                registration, model, 24, 2400, 6, 0, 0
        ));
    }

    @FXML
    private void onModelPojazduTextField() {
        System.out.println("Zmieniono model");
        refresh();
    }

    @FXML
    private void onNrRejestracyjnyTextField() {
        System.out.println("Zmieniono nr rejestracyjny");
        refresh();
    }

    @FXML
    private void onStartButton() {
        System.out.println("Samochód uruchomiony!");
        samochod.wlacz();
    }

    @FXML
    private void onCarComboBox() {
        System.out.println("combobox");
    }

    @FXML
    private void onNewCarButton() throws IOException {
        newCarWindow();
    }

    private void newCarWindow() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("new-car.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Nowy samochód!");
        stage.setScene(scene);
        stage.show();
    }

}
