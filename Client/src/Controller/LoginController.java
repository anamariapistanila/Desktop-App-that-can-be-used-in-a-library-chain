package Controller;

import java.io.IOException;


import CS.Request;
import Client.ClientConnection;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private TextField cont;

	@FXML
	private TextField parola;

	@FXML
	private Button autentificare;

	@FXML
	private Label cont1;

	@FXML
	private Label parola1;
	

	@FXML
	void loginButton(ActionEvent event) throws IOException {
	
		 String user = "Admin";
	     String parola1 = "1234";
	    


		if (user.equals(cont.getText()) && parola1.equals(parola.getText())) {
			 Request r= new Request("UserLogin",user + " "+ parola1);
		     r.setSenderType("user");
		     ClientConnection.Connection.sendMessageToServer(r);
		
			try {
				loadAdmin(event);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		else {
			 Request r= new Request("UserLogin",user + " "+ parola1);
		     r.setSenderType("user");
		     ClientConnection.Connection.sendMessageToServer(r);
			loadAngajat(event);
		}

	}

	private void loadAdmin(ActionEvent event) throws IOException {
		Parent viewParent = FXMLLoader.load(getClass().getResource("/View/admin.fxml"));
		Scene viewScene = new Scene(viewParent);

		// getting the stage information
		Stage windwow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		windwow.setScene(viewScene);
		windwow.show();
	}

	private void loadAngajat(ActionEvent event) throws IOException {
		Parent viewParent = FXMLLoader.load(getClass().getResource("/View/angajat.fxml"));
		Scene viewScene = new Scene(viewParent);

		// getting the stage information
		Stage windwow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		windwow.setScene(viewScene);
		windwow.show();
	}

	@FXML
	void Romana() {
		cont1.setText("Cont");
		parola1.setText("Parola");
		autentificare.setText("Autentificare");

	}

	@FXML
	void Engleza() {
		cont1.setText("Account");
		parola1.setText("Password");
		autentificare.setText("Login");

	}

	@FXML
	void Franceza() {
	    cont1.setText("Compte");
		parola1.setText("Mot");
		autentificare.setText("Connexion");
	}


}
