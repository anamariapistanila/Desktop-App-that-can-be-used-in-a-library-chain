package Model;

import java.util.ArrayList;

public class ModelAngajat extends Dependente {

	private PersistentaCarte persistenta1;
	private LibrariePersistenta persistenta;
	private Carte carte;
	private Librarie librarie;
	private String operatie;

	public ModelAngajat() {
		this.listaObs = new ArrayList<Observer1>();
		this.carte = null;
		this.librarie = null;
		this.operatie = "";
		this.persistenta1 = PersistentaCarte.getInstance();
		this.persistenta = new LibrariePersistenta();
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public Librarie getLibrarie() {
		return librarie;
	}

	public void setLibrarie(Librarie librarie) {
		this.librarie = librarie;
	}

	public PersistentaCarte getPersistenta1() {
		return persistenta1;
	}

	public void setPersistenta1(PersistentaCarte persistenta1) {
		this.persistenta1 = persistenta1;
	}

	public LibrariePersistenta getPersistenta() {
		return persistenta;
	}

	public void setPersistenta(LibrariePersistenta persistenta) {
		this.persistenta = persistenta;
	}

	public String getOperatie() {
		return operatie;
	}

	public void setOperatie(String operatie) {
		this.operatie = operatie;
		this.Notificare();
		this.carte=null;
		
	}

}
