package org.example.samochodgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import symulator.Silnik;
import symulator.SkrzyniaBiegow;
import symulator.Sprzeglo;

import java.util.ArrayList;

public class NewCarController {
    public TextField modelPojazduTextField;
    public TextField nrRejestracyjnyTextField;
    public TextField wagaPojazduTextField;
    public TextField predkoscPojazduTextField;
    public Button confirmButton;
    public Button cancelButton;
    public ComboBox silnikComboBox;
    public ComboBox skrzyniaComboBox;
    private HelloController helloController;
    private ArrayList<Silnik> silniki;
    private ArrayList<SkrzyniaBiegow> skrzynie;

    @FXML
    public void initialize() {
        silniki = new ArrayList<>();
        silniki.add(new Silnik("Seat 1.6 MPI", 500.0, 5000.0, "WV", "1.6 MPI", 7000));
        silniki.add(new Silnik("Seat 1.9 TDI", 600.0, 5500.0, "WV", "1.9 TDI", 4000));

        silnikComboBox.getItems().addAll("Seat 1.6 MPI", "Seat 1.9 TDI");
        silnikComboBox.getSelectionModel().select(0);

        Sprzeglo sprzeglo1 = new Sprzeglo("Seat Sprzęgło", 200.0, 1000.0, "WV", "Typ 1");
        Sprzeglo sprzeglo2 = new Sprzeglo("WV Sprzęgło", 250.0, 1500.0, "Seat", "Typ 2");

        skrzynie = new ArrayList<>();
        skrzynie.add(new SkrzyniaBiegow("Skrzynia Seat 5", 550.0, 2000.0, "Seat", "S5", 5, sprzeglo1));
        skrzynie.add(new SkrzyniaBiegow("Skrzynia Seat 6", 650.0, 2500.0, "Seat", "S6", 6, sprzeglo2));

        skrzyniaComboBox.getItems().addAll("Skrzynia Seat 5", "Skrzynia Seat 6");
        skrzyniaComboBox.getSelectionModel().select(0);
    }

    public void onModelPojazduTextField(ActionEvent actionEvent) {
        System.out.println("Zmieniono model nowego samochodu");
    }

    public void onNrRejestracyjnyTextField(ActionEvent actionEvent) {
        System.out.println("Zmieniono nr rej samochodu");
    }

    public void setHelloController(HelloController helloController) {this.helloController = helloController;}

    @FXML
    private void onConfirmButton() {
        String model;
        String registration;
        double weight;
        int speed;
        Silnik silnik = silniki.get(silnikComboBox.getSelectionModel().getSelectedIndex());
        SkrzyniaBiegow skrzynia = skrzynie.get(skrzyniaComboBox.getSelectionModel().getSelectedIndex());
        if (silnik == null || skrzynia == null) {
            pokazBlad("Musisz wybrać silnik i skrzynię!");
            return;
        }
        try {
            model = modelPojazduTextField.getText();
            registration = nrRejestracyjnyTextField.getText();
            weight = Double.parseDouble(wagaPojazduTextField.getText());
            speed = Integer.parseInt(predkoscPojazduTextField.getText());


        } catch (NumberFormatException e) {
            pokazBlad("Niepoprawne dane. Spróbuj ponownie.");
            return;
        }
        helloController.addCarToList(model, registration, weight, speed, silnik, skrzynia);
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }

    public void onCancelButton(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void pokazBlad(String wiadomosc) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText(null);
        alert.setContentText(wiadomosc);
        alert.showAndWait();
    }
}
