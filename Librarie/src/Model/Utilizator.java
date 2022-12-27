package Model;


public class Utilizator {

	private String nume;

	private String prenume;

	private String cont;

	private String parola;

	private int idPersoana;

	public Utilizator() {
	}
	
	public Utilizator(int idPersoana,String nume, String prenume, String cont, String parola) {
		super();
		this.idPersoana = idPersoana;
		this.nume = nume;
		this.prenume = prenume;
		this.cont = cont;
		this.parola = parola;
	
		

	}
	public Utilizator(int idPersoana,String cont) {
		super();
		this.idPersoana = idPersoana;
		this.cont=cont;
	
	
	
		

	}

	public String getNume() {
		return nume;
	}

	public int getIdPersoana() {
		return idPersoana;
	}

	public void setIdPersoana(int idPersoana) {
		this.idPersoana = idPersoana;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	
}
