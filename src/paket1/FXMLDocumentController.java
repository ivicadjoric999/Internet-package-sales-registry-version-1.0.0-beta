package paket1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import paket2.Internet_paket;

/**
 *
 * @author Ivica Djoric
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txtid;
    @FXML
    private TextField txtIme;
    @FXML
    private TextField txtPrezime;
    @FXML
    private TextField txtAdressa;
    @FXML
    private ComboBox<String> txtBrzina;
    @FXML
    private ComboBox<String> txtProtok;
    @FXML
    private RadioButton txtradion;
    @FXML
    private RadioButton txtradion2;
    @FXML
    TableView tblData = new TableView();
    @FXML
    ToggleGroup group;
    @FXML
    private TableColumn< Internet_paket, String> UserName;
    @FXML
    private TableColumn< Internet_paket, String> userprezime;
    @FXML
    private TableColumn< Internet_paket, String> useradresa;
    @FXML
    private TableColumn< Internet_paket, String> userbrzina;
    @FXML
    private TableColumn< Internet_paket, String> userprotok;
    @FXML
    private TableColumn< Internet_paket, String> userugovor;
    @FXML
    private TableColumn< Internet_paket, Integer> useridenbroj;

    Internet_paket internet_paketi;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.txtBrzina.getItems().addAll(new String[]{"2 MB", "5 MB", "10 MB", "20 MB", "50 MB", "100 MB"});
        this.txtBrzina.getSelectionModel().select("Brzina");
        this.txtProtok.getItems().addAll(new String[]{"1 GB", "5 GB", "10 GB", "100 GB", "Flat"});
        this.txtProtok.getSelectionModel().select("Protok");
        group = new ToggleGroup();
        txtradion.setToggleGroup(group);
        txtradion2.setToggleGroup(group);
        txtradion.setSelected(true);
        //-ubacivanje u tabelu
        useridenbroj.setCellValueFactory(new PropertyValueFactory<Internet_paket, Integer>("Idenfikacioni_broj"));
        useradresa.setCellValueFactory(new PropertyValueFactory<Internet_paket, String>("Adresa"));
        userprezime.setCellValueFactory(new PropertyValueFactory<Internet_paket, String>("Prezime"));
        userbrzina.setCellValueFactory(new PropertyValueFactory<Internet_paket, String>("Brzina"));
        userprotok.setCellValueFactory(new PropertyValueFactory<Internet_paket, String>("protok"));
        userugovor.setCellValueFactory(new PropertyValueFactory<Internet_paket, String>("Ugovor"));
        UserName.setCellValueFactory(new PropertyValueFactory<Internet_paket, String>("Ime"));

        tblData.setItems(geinteInternet_pakets());

    }

    public ObservableList<Internet_paket> geinteInternet_pakets() {
        ObservableList<Internet_paket> internet_pakets = FXCollections.observableArrayList();
        internet_pakets.add(new Internet_paket("ivica", "djoric", "Karadjordjeva 9 ", "100 MB", "100 GB", "2 GOD", 666));

        return internet_pakets;
    }

    @FXML
    private void HandleEvents(MouseEvent event) {

        if (txtBrzina.getValue() == "Brzina" || txtProtok.getValue() == "Protok") {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacioni Dialog");
            alert.setHeaderText("Brzina ili protok nisu izabrani!");
            alert.setContentText("Morate da unesete brzinu i protok!");
            alert.showAndWait();
        } else if (txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty() || txtAdressa.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacioni Dialog");
            alert.setHeaderText("GRESKA!");
            alert.setContentText("Sva polja za unos teksta moraju biti popunjena!");
            alert.showAndWait();
        } else {
            saveData();
        }
    }

    private void saveData() {
        String ime = txtIme.getText();
        String prezime = txtPrezime.getText();
        String addresa = txtAdressa.getText();
        String brzina = txtBrzina.getValue();
        String protok = txtProtok.getValue();
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        String godine = selectedRadioButton.getText();
        //  RANDOM BROJ ZA IDENTIFIKACIJU KORISNIKA!!!!!
        Random rand = new Random();
        int n = rand.nextInt(10000);
        n += 253;

        internet_paketi = new Internet_paket(ime, prezime, addresa, brzina, protok, godine, n);
        tblData.getItems().add(internet_paketi);
    }

    @FXML
    private void HandleEvents_for_ponisti(MouseEvent event) {
        txtIme.setText("");
        txtPrezime.setText("");
        txtAdressa.setText("");
        this.txtBrzina.getSelectionModel().select("Brzina");
        this.txtProtok.getSelectionModel().select("Protok");

    }

    @FXML
    private void HandleEvents_for_brisanje(MouseEvent event) {

        ObservableList<Internet_paket> allproduct, singleproducut;
        allproduct = tblData.getItems();
        singleproducut = tblData.getSelectionModel().getSelectedItems();
        singleproducut.forEach(allproduct::remove);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Korisnik je obrisan");
        alert.showAndWait();

    }

}
