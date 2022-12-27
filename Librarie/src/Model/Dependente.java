package Model;

import java.util.ArrayList;

public class Dependente {

	public ArrayList<Observer1> listaObs;

	public void Adaugare(Observer1 obs) {
		this.listaObs.add(obs);
	}

	public void Stergere(Observer1 obs) {
		this.listaObs.remove(obs);
	}

	public void Notificare() {
		for (Observer1 obs : this.listaObs) {
			System.out.println("am ajuns in notify");
			obs.Actualizeaza();
		}
	}

}
