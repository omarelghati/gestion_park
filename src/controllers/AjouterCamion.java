package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.SqliteConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjouterCamion implements Initializable {
	@FXML private Button add;
	@FXML private TextField fieldImmatriculation ;
	@FXML private DatePicker fieldEntree ;
	@FXML private DatePicker fieldSortie ;
	@FXML private TextField fieldMarque ;
	@FXML private TextField fieldModele ;
	@FXML private TextField fieldCarburant ;
	@FXML private ComboBox<String> comboetat;
	@FXML private TextField pfiscal;
	@FXML private ComboBox<String> assurance;
	@FXML private TextField poidsmax;
	@FXML private TextField emission;
	@FXML private TextField kilometrage;
	@FXML private TextField consommation;
	@FXML private TextField age;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		comboetat.getItems().add("En panne");
		comboetat.getItems().add("Disponible");
		
		assurance.getItems().add("Oui");
		assurance.getItems().add("Non");


	}
	public void addCamion(ActionEvent e) throws SQLException{
		Stage s = (Stage) add.getScene().getWindow();
		Connection connection = SqliteConnection.connector();

		 String s1 = new String(fieldImmatriculation.getText());
		 System.out.println(pfiscal.getText());
		 String s2 = new String(fieldEntree.getValue().toString());
		 String s3 = new String(fieldSortie.getValue().toString());
		 String s4 = new String(fieldMarque.getText());
		 String s5 = new String(fieldModele.getText());
		 String s6 = new String(fieldCarburant.getText());
		 String s7 = new String(comboetat.getSelectionModel().getSelectedItem());
		 int s8 = Integer.parseInt(pfiscal.getText());
		 String s9 = assurance.getSelectionModel().getSelectedItem();
		 int s10 = Integer.parseInt(poidsmax.getText());
		 double s11 = Double.parseDouble(emission.getText());
		 long s12 = Long.parseLong(kilometrage.getText());
		 double s13 = Double.parseDouble(consommation.getText());
		 int s14 = Integer.parseInt(age.getText());
		String query = "INSERT INTO Vehicule VALUES('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"','"+s11+"','"+s12+"','"+s13+"','"+s14+"','Camion')";
		System.out.println(connection.createStatement().executeUpdate(query));
		s.close();



	}



}