package Model;

import java.util.ArrayList;

public class Librarie {
	String nume;
	int id;
	ArrayList<Carte> carti;

	public Librarie() {
	}

	public Librarie(String nume, int id, ArrayList<Carte> carti) {
		super();
		this.nume = nume;
		this.id = id;
		this.carti = carti;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public ArrayList<Carte> getCarti() {
		return carti;
	}

	public void setCarti(ArrayList<Carte> carti) {
		this.carti = carti;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
