package Model;

import java.util.ArrayList;

public class Librarii {
	ArrayList<Librarie> listaLibrarii = new ArrayList<Librarie>();

	public Librarii() {
	}

	public Librarii(ArrayList<Librarie> listaLibrarii) {
		super();
		this.listaLibrarii = listaLibrarii;
	}

	public ArrayList<Librarie> getListaLibrarii() {
		return listaLibrarii;
	}

	public void setListaLibrarii(ArrayList<Librarie> listaLibrarii) {
		this.listaLibrarii = listaLibrarii;
	}

}
