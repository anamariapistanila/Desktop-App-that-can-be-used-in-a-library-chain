package Model;

import java.util.ArrayList;

public class Carti {

	ArrayList<Carte> listaCarti = new ArrayList<Carte>();

	public Carti() {
	}

	public Carti(ArrayList<Carte> listaCarti) {
		super();
		this.listaCarti = listaCarti;
	}

	public ArrayList<Carte> getListaCarti() {
		return listaCarti;
	}

	public void setListaCarti(ArrayList<Carte> listaCarti) {
		this.listaCarti = listaCarti;
	}

}
