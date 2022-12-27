package Controller;

import java.io.FileNotFoundException;

import Model.ModelAdmin;
import Model.Observer1;
import Model.PersistentaUtilizator;
import Model.Utilizator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class AdminMenuController implements Observer1 {

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

	ModelAdmin admin = new ModelAdmin();
	
	public AdminMenuController() {
		this.admin.Adaugare(this);

	}

	@FXML
	void vizualizare(ActionEvent event) throws FileNotFoundException {
		area.setText("");
		ObservableList<Utilizator> date = FXCollections.observableArrayList();
		PersistentaUtilizator utilizatori = new PersistentaUtilizator();
		date = utilizatori.vizualizare();
		for (int j = 0; j < date.size(); j++) {
			area.appendText("Nume: " + date.get(j).getNume() + "\n" + "Prenume: " + date.get(j).getPrenume() + "\n"
					+ "Cont: " + date.get(j).getCont() + "\n" + "Parola: " + date.get(j).getParola() + "\n");
			area.appendText("\n");

		}
		this.admin.setOperatie("vizualizare");

	}

	@FXML
	void stergere(ActionEvent event) {
		this.admin.setOperatie("sterge");
	}

	@FXML
	void actualizare(ActionEvent event) {

		String prenume1 = prenume.getText();
		String parola1 = parola.getText();
		String nume1 = nume.getText();
		String idPersoana1 = idPersoana.getText();

		String cont1 = cont.getText();
		PersistentaUtilizator utilizatori = new PersistentaUtilizator();
		try {
			utilizatori.actualizareAngajat(idPersoana1, nume1, prenume1, cont1, parola1);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@FXML
	void adaugare(ActionEvent event) {
		String prenume1 = prenume.getText();
		String parola1 = parola.getText();
		String idPersoana1 = idPersoana.getText();

		String cont1 = cont.getText();
		String nume1 = nume.getText();

		Utilizator ut = new Utilizator(Integer.parseInt(idPersoana1), nume1, prenume1, cont1, parola1);
		this.admin.setUtilizator(ut);
		this.admin.setOperatie("adauga");
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
	}

}
