package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



@SuppressWarnings("deprecation")
public class PersistentaCarte {

	Connection db = ConnectionDB.getConnection();
	private final static String selectStatement = "SELECT * FROM librarie.carti";

	private static PersistentaCarte instance = new PersistentaCarte();

	public PersistentaCarte() {
	}

	public static PersistentaCarte getInstance() {
		return instance;
	}

	public ArrayList<Carte> extragere() {
		ArrayList<Carte> carti = new ArrayList<Carte>();
		Statement statement = null;

		try {
			statement = db.createStatement();
			ResultSet r = statement.executeQuery(selectStatement);
			while (r.next()) {
				Carte c = new Carte();
				c.setDomeniu(r.getString(1));
				c.setDisponibilitate(r.getInt(2));
				c.setEditura(r.getString(3));
				c.setAutor(r.getString(4));
				c.setPret(r.getDouble(5));
				c.setTitlu(r.getString(6));

				carti.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return carti;
	}

	public ObservableList<Carte> vizualizare()  {

		ArrayList<Carte> listaCarti;
		listaCarti = extragere();

		ObservableList<Carte> date = FXCollections.observableArrayList();
		for (int j = 0; j < listaCarti.size(); j++) {
			date.add(listaCarti.get(j));

		}
		return date;

	}

	public ObservableList<Carte> filtrareCarti(String combo, String textF) {
		ArrayList<Carte> carti;
		carti = extragere();

		ObservableList<Carte> date = FXCollections.observableArrayList();
		String aux = combo;
		boolean gasit = false;
		int i = 0;
		while (i < carti.size()) {
			System.out.println(carti.size());
			if (aux.equals("Domeniu") && (carti.get(i).getDomeniu().equals(textF))) {
				date.add(carti.get(i));
				gasit = true;

			}

			if (aux.equals("Disponibilitate")
					&& (carti.get(i).getDisponibilitate() == Integer.parseInt(textF))) {
				date.add(carti.get(i));
				gasit = true;

			}
			if (aux.equals("Editura") && (carti.get(i).getEditura().equals(textF))) {
				date.add(carti.get(i));
				gasit = true;

			}

			if (aux.equals("Autor") && (carti.get(i).getAutor().equals(textF))) {
				date.add(carti.get(i));
				gasit = true;

			}
			if (aux.equals("Pret") && (carti.get(i).getPret() == Double.parseDouble(textF))) {
				date.add(carti.get(i));
				gasit = true;

			}
		
			i++;
		}

		if (gasit == false) {
			System.out.println("EROARE");
		}

		return date;

	}

	public void adaugare(String domeniu, String disponibilitate, String editura, String autor, String pret,
			String titlu)  {

		Statement st;
		try {

			String insertStatement = "INSERT INTO `librarie`.`carti`"
					+ "(`domeniu`,`disponibilitate`,`editura`,`autor`,`pret`,`titlu`) VALUES ('" + domeniu + "','"
					+ disponibilitate + "','" + editura + "','" + autor + "','" + pret + "','" + titlu + "')";
			st = db.createStatement();
		
			st.executeUpdate(insertStatement);
			System.out.println("Am ajuns in persistenta");
			
			System.out.println("Adaugarea s-a realizat cu succes");

		} catch (Exception e) {
		}
	}

	public void StergeCarte(String titlu) {

		ArrayList<Carte> carti;
		carti = extragere();
		boolean gasit = false;

		for (int i = 0; i < carti.size(); i++) {
			if (carti.get(i).getTitlu().equals(titlu)) {
				gasit = true;
			}
		}
		if (gasit == true) {
			String deleteStatement = "DELETE FROM `librarie`.`carti`" + "WHERE `titlu`='" + titlu + "'";
			Statement st;
			try {
				System.out.println("ana");
				st = db.createStatement();

				st.executeUpdate(deleteStatement);

				System.out.println("Stergerea s-a realizat cu succes");

			} catch (Exception e) {
			}
		} else {
			System.out.println("EROARE");

		}

	}

	public void vanzareCarte(String titlu) {

		ArrayList<Carte> carti;
		carti = extragere();
		int disponibilitate = 0;
		boolean gasit = false;

		for (int i = 0; i < carti.size(); i++) {
			if (carti.get(i).getTitlu().equals(titlu)) {
				gasit = true;
				System.out.println("Am gasit cartea");
				disponibilitate = carti.get(i).getDisponibilitate();
				disponibilitate--;
			}
		}
		if (gasit == true) {
			String deleteStatement = "UPDATE `librarie`.`carti`" + "SET `disponibilitate`='" + disponibilitate + "'"
					+ "WHERE `titlu`='" + titlu + "'";
			Statement st;

			try {

				st = db.createStatement();

				st.executeUpdate(deleteStatement);
				System.out.println("Vanzarea s-a realizat cu succes");

			} catch (Exception e) {
			}
		} else {
			System.out.println("EROARE");

		}

	}

	public void Actualizare(String domeniu, String disponibilitate, String editura, String autor, String pret,
			String titlu)  {
		Statement st;
		ArrayList<Carte> carti = extragere();
		Boolean gasit = false;
		for (int i = 0; i < carti.size(); i++) {
			if (carti.get(i).getTitlu().equals(titlu)) {
				gasit = true;
			}
		}
		try {
			if (gasit == true && !domeniu.isEmpty()) {
				st = db.createStatement();
				String query = "UPDATE `librarie`.`carti`" + "SET" + "`domeniu` = '" + domeniu + "'"
						+ "WHERE `titlu` = '" + titlu + "'";
				st.executeUpdate(query);
				System.out.println("Actualizarea s-a realizat cu succes");
			}
			if (gasit == true && !disponibilitate.isEmpty()) {
				st = db.createStatement();
				String query = "UPDATE `librarie`.`carti`" + "SET" + "`disponibilitate` = '" + disponibilitate + "'"
						+ "WHERE `titlu` = '" + titlu + "'";
				st.executeUpdate(query);
				System.out.println("Actualizarea s-a realizat cu succes");
			}
			if (gasit == true && !editura.isEmpty()) {
				st = db.createStatement();
				String query = "UPDATE `librarie`.`carti`" + "SET" + "`editura` = '" + editura + "'"
						+ "WHERE `titlu` = '" + titlu + "'";
				st.executeUpdate(query);
				System.out.println("Actualizarea s-a realizat cu succes");
			}

			if (gasit == true && !autor.isEmpty()) {
				st = db.createStatement();
				String query = "UPDATE `librarie`.`carti`" + "SET" + "`autor` = '" + autor + "'" + "WHERE `titlu` = '"
						+ titlu + "'";
				st.executeUpdate(query);
				System.out.println("Actualizarea s-a realizat cu succes");
			}

			if (gasit == false) {
				System.out.println("EROARE");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	public ObservableList<Carte> cautareCarte(String titlu) {

		ObservableList<Carte> date = FXCollections.observableArrayList();
		ArrayList<Carte> carti;
		carti = extragere();
		boolean gasit = false;

		for (int i = 0; i < carti.size(); i++) {
			System.out.println(carti.get(i).getTitlu());
			if (carti.get(i).getTitlu().equals(titlu)) {
				gasit = true;
				date.add(carti.get(i));

			}
		}
		if (gasit == true) {
			String cautareStatement = "SELECT * FROM `librarie`.`carti`" + "WHERE `titlu`='" + titlu + "'";
			Statement st;
			try {
				st = db.createStatement();

				st.executeUpdate(cautareStatement);
				System.out.println("Gasit cu succes");
			} catch (Exception e) {
			}
		} else {
			System.out.println("EROARE");
		}

		return date;

	}

	@SuppressWarnings({ "unchecked" })
	public void VizualizareRapoarte(String comb1) throws IOException {

		ArrayList<Carte> listaCarti;
		listaCarti = extragere();

		String aux = comb1;
		if (aux.equals("CSV")) {
			Writer writer = null;
			try {
				File file = new File("./Carti.csv.");
				writer = new BufferedWriter(new FileWriter(file));

				for (int j = 0; j < listaCarti.size(); j++) {

					String text = listaCarti.get(j).getDomeniu() + "," + listaCarti.get(j).getDisponibilitate() + ","
							+ listaCarti.get(j).getEditura() + "," + "," + listaCarti.get(j).getAutor() + ","
							+ listaCarti.get(j).getPret() + "," + listaCarti.get(j).getTitlu() + "\n";

					writer.write(text);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {

				writer.flush();
				writer.close();
			}
		} else if (aux.equals("JSON")) {
			JSONArray lista = new JSONArray();
			for (int i = 0; i < listaCarti.size(); i++) {
				JSONObject carti = new JSONObject();
				carti.put("domeniu", listaCarti.get(i).getDomeniu());
				carti.put("disponibilitate", listaCarti.get(i).getDisponibilitate());
				carti.put("editura", listaCarti.get(i).getEditura());
				carti.put("autor", listaCarti.get(i).getAutor());
				carti.put("pret", listaCarti.get(i).getPret());
				carti.put("titlu", listaCarti.get(i).getTitlu());

				lista.add(carti);

				// Write JSON file

			}
			try (FileWriter file = new FileWriter("./Carti.json")) {

				file.write(lista.toJSONString());
				file.flush();

			}
		}
	}

	

}