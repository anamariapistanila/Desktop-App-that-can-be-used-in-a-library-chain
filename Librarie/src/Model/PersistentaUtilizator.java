package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controller.ConnectionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PersistentaUtilizator {
	private final static String selectStatement = "SELECT * FROM librarie.angajati";

	ArrayList<Utilizator> angajat = new ArrayList<Utilizator>();
	Connection db = ConnectionDB.getConnection();

	public ArrayList<Utilizator> extragere() {

		Statement statement = null;

		try {
			statement = db.createStatement();
			ResultSet r = statement.executeQuery(selectStatement);
			while (r.next()) {
				Utilizator u = new Utilizator();
				u.setIdPersoana(r.getInt(1));
				u.setCont(r.getString(2));
				u.setParola(r.getString(3));
				u.setNume(r.getString(4));
				u.setPrenume(r.getString(5));
				angajat.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return angajat;
	}

	public ObservableList<Utilizator> vizualizare() {

		ArrayList<Utilizator> listaUtilizatori;
		listaUtilizatori = extragere();

		ObservableList<Utilizator> date = FXCollections.observableArrayList();
		for (int j = 0; j < listaUtilizatori.size(); j++) {
			date.add(listaUtilizatori.get(j));

		}
		return date;

	}

	public void stergeAngajat(Utilizator u) {

		final String deleteStatement = "DELETE FROM librarie.angajati WHERE idangajati=?";
		PreparedStatement statement = null;
		ArrayList<Utilizator> listaUtilizatori;
		listaUtilizatori = extragere();
		Boolean gasit = false;

		for (Utilizator ut : listaUtilizatori) {
			if (ut.getIdPersoana() == u.getIdPersoana()) {
				gasit = true;
			}
		}
		if (gasit == true) {
			try {
				statement = db.prepareStatement(deleteStatement);
				statement.setInt(1, u.getIdPersoana());

				statement.executeUpdate();

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Stergerea s-a facut cu succes");
				alert.showAndWait();

			} catch (Exception e) {
			}

		} else {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setContentText("Intrare invalida");
			errorAlert.showAndWait();

		}

	}

	public void actualizareAngajat(String idPersoana, String nume, String prenume, String cont, String parola)
			 {

		Statement st;
		ArrayList<Utilizator> utilizatori = extragere();
		Boolean gasit = false;
		for (int i = 0; i < utilizatori.size(); i++) {
			if (utilizatori.get(i).getIdPersoana() == Integer.parseInt(idPersoana)) {
				gasit = true;
			}
		}
		try {
			if (gasit == true && !nume.isEmpty()) {
				st = db.createStatement();
				String query = "UPDATE `librarie`.`angajati`" + "SET" + "`nume` = '" + nume + "'"
						+ "WHERE `idangajati` = '" + idPersoana + "'";
				st.executeUpdate(query);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Actualizarea s-a realizat cu succes");
				alert.showAndWait();
			}
			if (gasit == true && !prenume.isEmpty()) {
				st = db.createStatement();
				String query = "UPDATE `librarie`.`angajati`" + "SET" + "`prenume` = '" + prenume + "'"
						+ "WHERE `idangajati` = '" + idPersoana + "'";
				st.executeUpdate(query);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Actualizarea s-a realizat cu succes");
				alert.showAndWait();
			}
			if (gasit == true && !cont.isEmpty()) {
				st = db.createStatement();
				String query = "UPDATE `librarie`.`angajati`" + "SET" + "`cont` = '" + cont + "'"
						+ "WHERE `idangajati` = '" + idPersoana + "'";
				st.executeUpdate(query);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Actualizarea s-a realizat cu succes");
				alert.showAndWait();
			}

			if (gasit == true && !parola.isEmpty()) {
				st = db.createStatement();
				String query = "UPDATE `librarie`.`angajati`" + "SET" + "`parola` = '" + parola + "'"
						+ "WHERE `idangajati` = '" + idPersoana + "'";
				st.executeUpdate(query);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Actualizarea s-a realizat cu succes");
				alert.showAndWait();
			}

			if (gasit == false) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setContentText("Intrare invalida");
				errorAlert.showAndWait();

			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	public void adaugaAngajat(String prenume, String cont, String parola, String idPersoana, String librarie,
			String nume) {
		String insertStatement = "INSERT INTO `librarie`.`angajati`"
				+ "(`idangajati`,`cont`,`parola`,`nume`,`prenume`,`librarie`) VALUES ('" + idPersoana + "','" + cont
				+ "','" + parola + "','" + nume + "','" + prenume + " ','" + librarie + "')";
		Statement st;
		try {

			st = db.createStatement();

			st.executeUpdate(insertStatement);

		} catch (Exception e) {
		}
	}

}
