package Model;

import java.util.ArrayList;

public class Utilizatori {

	ArrayList<Utilizator> listaUtilizatori = new ArrayList<Utilizator>();

	public Utilizatori() {
	}

	public Utilizatori(ArrayList<Utilizator> listaUtilizatori) {
		super();
		this.listaUtilizatori = listaUtilizatori;
	}

	public ArrayList<Utilizator> getListaUtilizatori() {
		return listaUtilizatori;
	}

	public void setListaUtilizatori(ArrayList<Utilizator> listaUtilizatori) {
		this.listaUtilizatori = listaUtilizatori;
	}

}
