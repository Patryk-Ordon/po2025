package org.example.samochodgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewCarController {
    public TextField modelPojazduTextField;
    public TextField nrRejestracyjnyTextField;
    public TextField wagaPojazduTextField;
    public TextField predkoscPojazduTextField;
    public Button confirmButton;
    public Button cancelButton;

    public void onModelPojazduTextField(ActionEvent actionEvent) {
        System.out.println("Zmieniono model nowego samochodu");
    }

    public void onNrRejestracyjnyTextField(ActionEvent actionEvent) {
        System.out.println("Zmieniono nr rej samochodu");
    }

    @FXML
    private void onConfirmButton() {
        String model = modelPojazduTextField.getText();
        String registration = nrRejestracyjnyTextField.getText();
        double weight;
        int speed;
        try {
            weight = Double.parseDouble(wagaPojazduTextField.getText());
            speed = Integer.parseInt(predkoscPojazduTextField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawne dane. Spróbuj ponownie.");
            return;
        }
        //HelloController.addCarToList(model, registration, weight, speed);
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }

    public void onCancelButton(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
