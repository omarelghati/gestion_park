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

public class AjouterVoiture implements Initializable {
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


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		comboetat.getItems().add("En panne");
		comboetat.getItems().add("Disponible");
		
		assurance.getItems().add("Oui");
		assurance.getItems().add("Non");


	}
	public void addVoiture(ActionEvent e) throws SQLException{
		Stage s = (Stage) add.getScene().getWindow();
		Connection connection = SqliteConnection.connector();

		 String s1 = new String(fieldImmatriculation.getText());
		 System.out.println(assurance.getSelectionModel().getSelectedItem());
		 System.out.println(pfiscal.getText());
		 String s2 = new String(fieldEntree.getValue().toString());
		 String s3 = new String(fieldSortie.getValue().toString());
		 String s4 = new String(fieldMarque.getText());System.out.println("1");
		 String s5 = new String(fieldModele.getText());System.out.println("2");
		 String s6 = new String(fieldCarburant.getText());System.out.println("3");
		 String s7 = new String(comboetat.getSelectionModel().getSelectedItem());
		String query = "INSERT INTO Vehicule VALUES('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')";
		System.out.println(connection.createStatement().executeUpdate(query));
		s.close();



	}



}