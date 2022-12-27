package Controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import CS.Request;
import Client.ClientConnection;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@SuppressWarnings({ "deprecation", "unused" })
public class AngajatController implements Initializable {

	@FXML
	private TextField domeniu;

	@FXML
	private TextField disponibilitate;

	@FXML
	private TextField editura;

	@FXML
	private TextField autor;

	@FXML
	private TextField pret;

	@FXML
	private TextField titlu;

	@FXML
	private Label domeniu1;

	@FXML
	private Label filtrare2;
	
	@FXML
	private Label disponibilitate1;

	@FXML
	private Label editura1;

	@FXML
	private Label autor1;

	@FXML
	private Label pret1;

	@FXML
	private Label titlu1;

	@FXML
	ComboBox<String> comb;

	@FXML
	ComboBox<String> comb1;

	@FXML
	private TextArea textArea;

	@FXML
	ComboBox<String> comb2;
	@FXML
	private Label librarie;

	@FXML
	private Button adaugare;

	@FXML
	private Button sterge;

	@FXML
	private Button vizualizareC;

	@FXML
	private Button actualizeaza;

	@FXML
	private Button filtrare;

	@FXML
	private Button vizualizareR;

	@FXML
	private Button vizualizareS;

	@FXML
	private Button vanzare;

	@FXML
	private Button deconectare;

	@FXML
	private Button cauta;

	@FXML
	private Button afisare;
    @FXML
    private TextField filtrare1;


	public void initialize(URL arg0, ResourceBundle arg1) {

		ObservableList<String> combo_list = FXCollections.observableArrayList("Domeniu", "Disponibilitate", "Editura",
				"Autor", "Pret");
		ObservableList<String> combo_list1 = FXCollections.observableArrayList("JSON", "CSV");
		ObservableList<String> combo_list2 = FXCollections.observableArrayList("Lucaciu","Moldovan","Pop");


		comb2.setItems(combo_list2);

		comb.setItems(combo_list);
		comb1.setItems(combo_list1);

	}

	@FXML
	void afisareLibrarie(ActionEvent event) {
		
		String combo1= comb2.getSelectionModel().getSelectedItem().toString();
		 Request r= new Request("AfisareLibrarie",combo1);
			r.setSenderType("user");
			try {
				ClientConnection.Connection.sendMessageToServer(r);
			} catch (IOException e) {
				
				e.printStackTrace();
			}

	}

	@FXML
	void rapoarte(ActionEvent event) throws FileNotFoundException {
		//this.model.setOperatie("rapoarte");
		 String combo1= comb1.getSelectionModel().getSelectedItem().toString();
		 Request r= new Request("Rapoarte",combo1);
			r.setSenderType("user");
			try {
				ClientConnection.Connection.sendMessageToServer(r);
			} catch (IOException e) {
				
				e.printStackTrace();
			}

	}

	@FXML
	void cautare(ActionEvent event) throws FileNotFoundException {
		//this.model.setOperatie("cautare");
		try {
		    String titlu1= titlu.getText();
			Request r= new Request("CautaCarte",titlu1);
			r.setSenderType("user");
			ClientConnection.Connection.sendMessageToServer(r);
			}
			catch(Exception ex)
			{
				System.out.println("Failed");
			}
	}

	@FXML
	void vizualizareCarti(ActionEvent event) throws FileNotFoundException {
	
		Request r= new Request("VizualizareCarti","");
		r.setSenderType("user");
		try {
			ClientConnection.Connection.sendMessageToServer(r);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		}
	

	@FXML
	void actualizare(ActionEvent event) throws Exception {
		

		try {
			String domeniu1 = domeniu.getText();
			String disponibilitate1 = disponibilitate.getText();
			String editura1 = editura.getText();
			String autor1 = autor.getText();
			String pret1 = pret.getText();
			String titlu1 = titlu.getText();
			Request r= new Request("ActualizareCarti",domeniu1 + " "+ disponibilitate1+" "+editura1+" "+autor1 + " "+pret1+" "+titlu1);
			r.setSenderType("user");
			ClientConnection.Connection.sendMessageToServer(r);
			}
			catch(Exception ex)
			{
				System.out.println("Failed");
			}

	}

	@FXML
	public void vanzare(ActionEvent event) {
		//this.model.setOperatie("vanzare");
		String titlu1=titlu.getText();
		Request r= new Request("VanzareCarte",titlu1);
		r.setSenderType("user");
		try {
			ClientConnection.Connection.sendMessageToServer(r);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	@FXML
	void sterge(ActionEvent event) {
		//this.model.setOperatie("stergere");
		 String titlu1=titlu.getText();
			Request r= new Request("StergereCarte",titlu1);
			r.setSenderType("user");
			try {
				ClientConnection.Connection.sendMessageToServer(r);
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			
	}

	@FXML
	void filtrare(ActionEvent event) throws Exception {

		//this.model.setOperatie("filtrare");
		try {
		    String combo1= comb.getSelectionModel().getSelectedItem().toString();
		    String filtrare= filtrare1.getText();
			
		
			Request r= new Request("FiltrareCarti",combo1+" "+filtrare);
			r.setSenderType("user");
			ClientConnection.Connection.sendMessageToServer(r);
			}
			catch(Exception ex)
			{
				System.out.println("Failed");
			}

	}

	@FXML
	void adauga(ActionEvent event) throws FileNotFoundException {
		//textArea.setText("");
		
		String domeniu1 = domeniu.getText();
		String disponibilitate1 = disponibilitate.getText();
		String editura1 = editura.getText();
		String autor1 = autor.getText();
		String pret1 = pret.getText();
		String titlu1 = titlu.getText();
		
		try {
		 
			Request r= new Request("AdaugareCarte",domeniu1+ " "+ disponibilitate1+" "+editura1+" "+autor1 + " "+pret1+ " "+titlu1);
			r.setSenderType("user");
			ClientConnection.Connection.sendMessageToServer(r);
			}
			catch(Exception ex)
			{
				System.out.println("Failed");
			}

	
	}

	@FXML
	void statistica(ActionEvent event) {
		//this.model.setOperatie("statistici");
		Stage stage = new Stage();
		Scene scene = new Scene(new Group());
		stage.setTitle("Disponibilitate");
		stage.setWidth(1200);
		stage.setHeight(730);
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(new PieChart.Data("Medicina", 4),
				new PieChart.Data("Psihologie", 5), new PieChart.Data("Matematica", 4),
				new PieChart.Data("Informatica", 5), new PieChart.Data("Literatura", 5));
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Carti disponibile");

		((Group) scene.getRoot()).getChildren().add(chart);
		stage.setScene(scene);
		stage.show();
	
		
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
		domeniu1.setText("Domeniu");
		disponibilitate1.setText("Disponibilitate");
		editura1.setText("Editura");
		autor1.setText("Autor");
		pret1.setText("Pret");
		titlu1.setText("Titlu");
		adaugare.setText("Adauga carte");
		actualizeaza.setText("Actualizeaza carte");
		vizualizareC.setText("Vizualizeaza carti");
		sterge.setText("Sterge carte");
		deconectare.setText("Deconectare");
		vizualizareS.setText("Vizualizare statistici");
		vizualizareR.setText("Vizualizare rapoarte");
		vanzare.setText("Vanzare carte");
		cauta.setText("Cautare carte");
		filtrare.setText("Filtrare carti");
		afisare.setText("Afiseaza librarii");
		filtrare2.setText("Filtrare");
	}

	@FXML
	void Engleza() {
		domeniu1.setText("Field");
		disponibilitate1.setText("Availability");
		editura1.setText("Press");
		autor1.setText("Autor");
		pret1.setText("Price");
		titlu1.setText("Title");
		adaugare.setText("Add book");
		actualizeaza.setText("Update book");
		vizualizareC.setText("View books");
		sterge.setText("Delete book");
		deconectare.setText("Disconnection");
		vizualizareS.setText("View statistics");
		vizualizareR.setText("View raports");
		vanzare.setText("Sell book");
		cauta.setText("Search book");
		filtrare.setText("Filter books");
		afisare.setText("Display libraries");
		filtrare2.setText("Filter");
	}

	@FXML
	void Franceza() {
		domeniu1.setText("Domaine");
		disponibilitate1.setText("Disponibilite");
		editura1.setText("Maison d'edition");
		autor1.setText("Auteur");
		pret1.setText("Le prix");
		titlu1.setText("Titre");
		adaugare.setText("Ajouter un livre");
		actualizeaza.setText("Livre de mise a jour");
		vizualizareC.setText("Consultation de livre");
		sterge.setText("Essuyer la carte");
		deconectare.setText("Coupure");
		vizualizareS.setText("Voir les statistiques");
		vizualizareR.setText("Voir les rapports");
		vanzare.setText("Vente de livre");
		cauta.setText("Recherche de livre");
		filtrare.setText("Filtrer les livres");
		afisare.setText("Affiche les bibliotheques");
		filtrare2.setText("Filtrer");
	}

	/*public void Actualizeaza() {
		if (this.model.getOperatie().toLowerCase() == "filtrare") {
			String combo = comb.getSelectionModel().getSelectedItem().toString();
			String titlu1 = titlu.getText();
			String domeniu1 = domeniu.getText();
			String disponibilitate1 = disponibilitate.getText();
			String editura1 = editura.getText();
			String autor1 = autor.getText();
			String pret1 = pret.getText();

			textArea.setText("");

			ObservableList<Carte> date = FXCollections.observableArrayList();
			date = this.model.getPersistenta1().filtrareCarti(combo, domeniu1, disponibilitate1, editura1, autor1,
					pret1);
			for (int i = 0; i < date.size(); i++) {
				textArea.appendText("Domeniu: " + date.get(i).getDomeniu() + "\n" + "Disponibilitate: "
						+ date.get(i).getDisponibilitate() + "\n" + "Editura: " + date.get(i).getEditura() + "\n"
						+ "Autor: " + date.get(i).getAutor() + "\n" + "Titlu: " + date.get(i).getTitlu() + "\n");
				textArea.appendText("\n");
			}

		} else if (this.model.getOperatie().toLowerCase() == "vizualizare") {

			this.model.getPersistenta1().vizualizare();

		} else if (this.model.getOperatie().toLowerCase() == "adaugare") {

			this.model.getPersistenta1().adaugare(this.model.getCarte().getDomeniu(),
					String.valueOf(this.model.getCarte().getDisponibilitate()), this.model.getCarte().getEditura(),
					this.model.getCarte().getAutor(), String.valueOf(this.model.getCarte().getPret()),
					this.model.getCarte().getTitlu());

		} else if (this.model.getOperatie().toLowerCase() == "stergere") {
			textArea.setText("");
			String titlu1 = titlu.getText();
			this.model.getPersistenta1().StergeCarte(titlu1);

		} else if (this.model.getOperatie().toLowerCase() == "cautare") {
			String titlu1 = titlu.getText();
			textArea.setText("");

			ObservableList<Carte> date = FXCollections.observableArrayList();
			date = this.model.getPersistenta1().cautareCarte(titlu1);
			for (int j = 0; j < date.size(); j++) {

				textArea.appendText("Titlu cartii cautate: " + date.get(j).getTitlu() + "\n" + "Pretul cartii: "
						+ date.get(j).getPret() + "\n");
				textArea.appendText("\n");
			}

		} else if (this.model.getOperatie().toLowerCase() == "vanzare") {
			textArea.setText("");
			String titlu1 = titlu.getText();
			this.model.getPersistenta1().vanzareCarte(titlu1);
		} else if (this.model.getOperatie().toLowerCase() == "rapoarte") {

			String combo = comb1.getSelectionModel().getSelectedItem().toString();
			try {
				this.model.getPersistenta1().VizualizareRapoarte(combo);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} else if (this.model.getOperatie().toLowerCase() == "statistici") {
			this.model.getPersistenta1().statistici();

		}
	}*/

}
