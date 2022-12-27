package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class LibrariePersistenta {

	private final static String selectStatement = "SELECT * FROM librarie.librarii";

	Connection db = ConnectionDB.getConnection();
	Carti carti = new Carti();
	ArrayList<Carte> lista = carti.getListaCarti();

	public ArrayList<Librarie> extragere() {
		ArrayList<Librarie> librarii = new ArrayList<Librarie>();

		Statement statement = null;

		try {
			statement = db.createStatement();
			ResultSet r = statement.executeQuery(selectStatement);
			while (r.next()) {
				Librarie c = new Librarie();
				c.setId(r.getInt(1));
				c.setNume(r.getString(2));

				librarii.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return librarii;

	}

}
