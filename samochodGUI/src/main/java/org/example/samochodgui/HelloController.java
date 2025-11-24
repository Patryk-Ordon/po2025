package org.example.samochodgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import module symulator;

public class HelloController {
    @FXML
    public TextField modelPojazduTextField;
    public Button startButton;
    public TextField nrRejestracyjnyTextField;
    private Label welcomeText;
    private symulator.Samochod samochod;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void onModelPojazduTextField() {
        System.out.println("Zmieniono model");
    }

    @FXML
    private void onNrRejestracyjnyTextField() {
        System.out.println("Zmieniono nr rejestracyjny");
    }

    @FXML
    private void onStartButton() {
        System.out.println("Samochód uruchomiony!");

    }




}
