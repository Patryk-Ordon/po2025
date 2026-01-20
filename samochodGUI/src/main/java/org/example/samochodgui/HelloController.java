package org.example.samochodgui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import symulator.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class HelloController implements Listener {
    public TextField modelPojazduTextField;
    public TextField nrRejestracyjnyTextField;
    public TextField wagaPojazduTextField;
    public TextField predkoscPojazduTextField;
    public Button startButton;
    public Button offButton;
    public TextField nazwaSkrzyniTextField;
    public TextField cenaSkrzyniTextField;
    public TextField wagaSkrzyniTextField;
    public TextField biegTextField;
    public Button zwiekszBiegButton;
    public Button zmniejszBiegButton;
    public TextField nazwaSilnikaTextField;
    public TextField cenaSilnikaTextField;
    public TextField wagaSilnikaTextField;
    public TextField obrotySilnikaTextField;
    public Button zwiekszObrotyButton;
    public Button zmniejszObrotyButton;
    public TextField nazwaSprzeglaTextBox;
    public TextField cenaSprzeglaTextBox;
    public TextField wagaSprzeglaTextBox;
    public TextField stanSprzeglaTextBox;
    public Button sprzegloOnButton;
    public Button sprzegloOffButton;
    public ComboBox carComboBox;
    public ImageView carImageView;
    public AnchorPane mapa;
    public VBox carIcon;
    public Label carImageLabel;
    private ArrayList<Samochod> carList;
    private symulator.Samochod samochod;

    @FXML
    public void initialize() {
        carList = new ArrayList<Samochod>();
        addCarToList("Ursus C330", "TAG8912", 1500.0, 24,new Silnik("Perkins", 500.0, 5000.0, "URSUS", "S330", 2800), new SkrzyniaBiegow("Skrzynia URSUS 6", 550.0, 2000.0, "URSUS", "S6", 6, new Sprzeglo("URSUS Sprzęgło", 200.0, 1000.0, "Warszawa", "Typ 1")));
        refresh();
        // Load and set the car image
        Image carImage = new Image(getClass().getResource("/images/seat.png").toExternalForm());
        System.out.println("Image width: " + carImage.getWidth() + ", height: " + carImage.getHeight());
        carImageView.setImage(carImage);
        carImageView.setFitWidth(60); // Set appropriate dimensions for your image
        carImageView.setFitHeight(30);
        carImageView.setTranslateX(0);
        carImageView.setTranslateY(0);

        samochod.addListener(this);
        mapa.setOnMouseClicked(event -> {
            double halfWidth = carImageView.getFitWidth() / 2.0;
            double halfHeight = carImageView.getFitHeight() / 2.0;
            double x = event.getX() - halfWidth;
            double y = event.getY() - halfHeight;
            Pozycja nowaPozycja = new Pozycja(x, y);
            if(samochod.getStanWlaczenia() && !samochod.getSkrzynia().getSprzeglo().getStanSprzegla())
                samochod.jedzDo(nowaPozycja);
        });
    }

    @Override
    public void update()
    {
        Platform.runLater(()-> {
            carIcon.setTranslateX(samochod.getAktualnaPozycja().getX());
            carIcon.setTranslateY(samochod.getAktualnaPozycja().getY());
        });
    }

    public void refresh() {
        Platform.runLater(() ->{
            modelPojazduTextField.setText(String.valueOf(samochod.getModel()));
            nrRejestracyjnyTextField.setText(String.valueOf(samochod.getNrRejestracyjny()));
            wagaPojazduTextField.setText(String.valueOf(samochod.getWaga()));
            predkoscPojazduTextField.setText(String.valueOf(samochod.getPredkosc()));
            nazwaSkrzyniTextField.setText(String.valueOf(samochod.getSkrzynia().getNazwa()));
            cenaSkrzyniTextField.setText(String.valueOf(samochod.getSkrzynia().getCena()));
            wagaSkrzyniTextField.setText(String.valueOf(samochod.getSkrzynia().getWaga()));
            biegTextField.setText(String.valueOf(samochod.getSkrzynia().getAktualnyBieg()));

            if (samochod.getStanWlaczenia()) {
                startButton.setDisable(true);
                offButton.setDisable(false);
                zwiekszObrotyButton.setDisable(false);
                zmniejszObrotyButton.setDisable(false);
            } else {
                startButton.setDisable(false);
                offButton.setDisable(true);
                zwiekszObrotyButton.setDisable(true);
                zmniejszObrotyButton.setDisable(true);
            }

            if (samochod.getSkrzynia().getSprzeglo().getStanSprzegla()) {
                sprzegloOnButton.setDisable(true);
                sprzegloOffButton.setDisable(false);
                zwiekszBiegButton.setDisable(false);
                zmniejszBiegButton.setDisable(false);
            } else {
                sprzegloOnButton.setDisable(false);
                sprzegloOffButton.setDisable(true);
                zwiekszBiegButton.setDisable(true);
                zmniejszBiegButton.setDisable(true);
            }

            nazwaSilnikaTextField.setText(String.valueOf(samochod.getSilnik().getNazwa()));
            cenaSilnikaTextField.setText(String.valueOf(samochod.getSilnik().getCena()));
            wagaSilnikaTextField.setText(String.valueOf(samochod.getSilnik().getWaga()));
            obrotySilnikaTextField.setText(String.valueOf(samochod.getSilnik().getObroty()));

            nazwaSprzeglaTextBox.setText(String.valueOf(samochod.getSkrzynia().getSprzeglo().getNazwa()));
            wagaSprzeglaTextBox.setText(String.valueOf(samochod.getSkrzynia().getSprzeglo().getWaga()));
            cenaSprzeglaTextBox.setText(String.valueOf(samochod.getSkrzynia().getSprzeglo().getCena()));

            carImageLabel.setText(String.valueOf(samochod.getModel()));
            if (samochod.getSkrzynia().getSprzeglo().getStanSprzegla()) {
                stanSprzeglaTextBox.setText("Załączone");
            } else {
                stanSprzeglaTextBox.setText("Rozłączone");
            }
            carIcon.setTranslateX(samochod.getAktualnaPozycja().getX());
            carIcon.setTranslateY(samochod.getAktualnaPozycja().getY());
        });
    }

    public void addCarToList(String model, String registration, Double weight, Integer speed, Silnik silnik, SkrzyniaBiegow skrzyniaBiegow) {
        Samochod newCar = new Samochod(registration, model, weight, speed, silnik, skrzyniaBiegow);
        carList.add(newCar);
        samochod = newCar;
        samochod.addListener(this);
        carComboBox.getItems().add(newCar.getModel() + " " + newCar.getNrRejestracyjny());
        carComboBox.getSelectionModel().selectLast();
        refresh();
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
    private void onNewCarButton() throws IOException {
        newCarWindow();
    }

    private void newCarWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("new-car.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        NewCarController controller = fxmlLoader.getController();
        controller.setHelloController(this);
        Stage stage = new Stage();
        stage.setTitle("Nowy samochód!");
        stage.setScene(scene);
        stage.show();
    }

    public void onDeleteCarButton(ActionEvent actionEvent) {
        if (carList.size() > 1) {
            carList.remove(carComboBox.getSelectionModel().getSelectedIndex());
            carComboBox.getItems().remove(carComboBox.getSelectionModel().getSelectedIndex());
            carComboBox.getSelectionModel().selectFirst();
            refresh();
        } else
            System.out.println("W programie musi istnieć przynajmniej jeden samochód");
    }

    @FXML
    private void onCarComboBox() {
        samochod = carList.get(carComboBox.getSelectionModel().getSelectedIndex());
        refresh();
    }

    @FXML
    private void onStartButton() {
        if(samochod.wlacz())
            System.out.println("Samochód uruchomiony!");
        refresh();
    }

    public void onOffButton(ActionEvent actionEvent) {
        if(samochod.wylacz())
            System.out.println("Samochód wyłączony!");
        refresh();
    }

    public void onZwiekszBiegButton(ActionEvent actionEvent) {
        if(samochod.getSkrzynia().zwiekszBieg())
            System.out.println("Zwiększono bieg!");
        refresh();
    }

    public void onZmiejszBiegButton(ActionEvent actionEvent) {
        if(samochod.getSkrzynia().zmniejszBieg())
            System.out.println("Zmiejszono bieg!");
        refresh();
    }

    public void onSprzegloOnButton(ActionEvent actionEvent) {
        samochod.getSkrzynia().getSprzeglo().wcisnij();
        System.out.println("Sprzęgło wciśnięte!");
        refresh();
    }

    public void onSprzegloOffButton(ActionEvent actionEvent) {
        samochod.getSkrzynia().getSprzeglo().zwolnij();
        System.out.println("Sprzęgło zwolnione");
        refresh();
    }

    public void onZwiekszObrotyButton(ActionEvent actionEvent) {
        if(samochod.dodajGazu())
            System.out.println("Zwiększono obroty!");
        refresh();
    }

    public void onZmiejszObrotyButton(ActionEvent actionEvent) {
        if(samochod.ujmijGazu())
            System.out.println("Zmniejszono obroty!");
        refresh();
    }
}
