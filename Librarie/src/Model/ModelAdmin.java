package Model;

import java.util.ArrayList;

public class ModelAdmin extends Dependente {

	private PersistentaUtilizator persistenta;
	private Utilizator utilizator;
	private String operatie;

	public ModelAdmin() {
		this.listaObs = new ArrayList<Observer1>();

		this.operatie = "";

		this.persistenta = new PersistentaUtilizator();
	}

	public PersistentaUtilizator getPersistenta() {
		return persistenta;
	}

	public void setPersistenta(PersistentaUtilizator persistenta) {
		this.persistenta = persistenta;
	}

	public Utilizator getUtilizator() {
		return utilizator;
	}

	public void setUtilizator(Utilizator utilizator) {
		this.utilizator = utilizator;
	}

	public String getOperatie() {
		return operatie;
	}

	public void setOperatie(String operatie) {
		this.operatie = operatie;
		this.Notificare();
		this.utilizator=null;
	}

}
