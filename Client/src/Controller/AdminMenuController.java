package Controller;


import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import CS.Request;
import Client.ClientConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminMenuController implements Observer {

	@FXML
	private TextField nume;

	@FXML
	private TextField prenume;

	@FXML
	private TextField cont;
	@FXML
	private TextField idPersoana;

	@FXML
	private TextField parola;

	@FXML
	private TextArea text;

	@FXML
	private TextField librarie;

	@FXML
	private TextArea area;

	@FXML
	private Button adauga;

	@FXML
	private Button sterge;

	@FXML
	private Button actualizeaza;

	@FXML
	private Button vizualizeaza;

	@FXML
	private Button deconectare;

	@FXML
	private Label id;

	@FXML
	private Label nume1;

	@FXML
	private Label prenume1;

	@FXML
	private Label cont1;

	@FXML
	private Label parola1;
	
    @FXML
    private Label librarie1;



	@FXML
	void vizualizare(ActionEvent event) throws IOException {
		Request r= new Request("VizualizareAngajati","");
		r.setSenderType("user");
		ClientConnection.Connection.sendMessageToServer(r);
	
	}

	@FXML
	void stergere(ActionEvent event) {
		//this.admin.setOperatie("sterge");
		 String id= idPersoana.getText();
			Request r= new Request("StergereAngajat",id);
			r.setSenderType("user");
			try {
				ClientConnection.Connection.sendMessageToServer(r);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
			
	}

	@FXML
	void actualizare(ActionEvent event) {

		try {
		    String id= idPersoana.getText();
			String nume1= nume.getText();
			String prenume1= prenume.getText();
			String cont1= cont.getText();
			String parola1= parola.getText();
			Request r= new Request("ActualizareAngajat",id + " "+ nume1+" "+prenume1+" "+cont1+" "+ parola1);
			r.setSenderType("user");
			ClientConnection.Connection.sendMessageToServer(r);
			}
			catch(Exception ex)
			{
				System.out.println("Failed");
			}
	}

	@FXML
	void adaugare(ActionEvent event) {
		
		 String id= idPersoana.getText();
			String nume1= nume.getText();
			String prenume1= prenume.getText();
			String cont1= cont.getText();
			String parola1= parola.getText();
			String librarie1= librarie.getText();
			Request r= new Request("AdaugareAngajat",id + " "+ nume1+" "+prenume1+" "+ " "+cont1+" "+" "+librarie1+" " +parola1);
			r.setSenderType("user");
			try {
				ClientConnection.Connection.sendMessageToServer(r);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
	}

	@FXML
	void Deconectare(ActionEvent event) throws Exception {
		((javafx.scene.Node) event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/View/login.fxml"));
		Scene scene = new Scene(root, 900, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	void Romana() {
		nume1.setText("Nume");
		prenume1.setText("Prenume");
		cont1.setText("Cont");
		parola1.setText("Parola");
		librarie1.setText("Librarie");
		id.setText("Id Persoana");
		adauga.setText("Adauga angajat");
		actualizeaza.setText("Actualizeaza angajat");
		vizualizeaza.setText("Vizualizeaza angajati");
		sterge.setText("Sterge angajat");
		deconectare.setText("Deconectare");

	}

	@FXML
	void Engleza() {
		nume1.setText("Last Name");
		prenume1.setText("First Name");
		cont1.setText("Account");
		parola1.setText("Password");
		id.setText("Person id");
		librarie1.setText("BookShop");
		adauga.setText("Add employee");
		actualizeaza.setText("Update employee");
		vizualizeaza.setText("View employees");
		sterge.setText("Delete employee");
		deconectare.setText("Disconnection");

	}

	@FXML
	void Franceza() {
		nume1.setText("Nom");
		prenume1.setText("Surnom");
		cont1.setText("Compte");
		parola1.setText("Le mot de passe");
		id.setText("Personne d'identite");
		librarie1.setText("Librairie");
		adauga.setText("Ajouter l'employe");
		actualizeaza.setText("Mettre a jour l'employee");
		vizualizeaza.setText("Voir les employes");
		sterge.setText("Suprimer un employe");
		deconectare.setText("Coupre");

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void Actualizeaza() {
		if (this.admin.getOperatie().toLowerCase() == "vizualizare") {

			this.admin.getPersistenta().vizualizare();

		} else if (this.admin.getOperatie().toLowerCase() == "adauga") {
		
			String librarie1 = librarie.getText();
			this.admin.getPersistenta().adaugaAngajat(this.admin.getUtilizator().getPrenume(),
					this.admin.getUtilizator().getCont(), this.admin.getUtilizator().getParola(),
					String.valueOf(this.admin.getUtilizator().getIdPersoana()), librarie1,
					this.admin.getUtilizator().getNume());

		} else if (this.admin.getOperatie().toLowerCase() == "sterge") {
			int idPers = Integer.parseInt(idPersoana.getText());
			String cont1 = cont.getText();
			Utilizator ut = new Utilizator(idPers, cont1);
			this.admin.getPersistenta().stergeAngajat(ut);

		}
	}*/

}
