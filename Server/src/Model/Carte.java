package Model;



public class Carte {
	private String domeniu;
	private int disponibilitate;
	private String editura;
	private String autor;
	private double pret;
	private String titlu;

	public Carte() {
	}

	public Carte(String domeniu, int disponibilitate, String editura, String autor, double pret, String titlu) {
		super();
		this.domeniu = domeniu;
		this.disponibilitate = disponibilitate;
		this.editura = editura;
		this.autor = autor;
		this.pret = pret;
		this.titlu = titlu;
	}

	public String getDomeniu() {
		return domeniu;
	}

	public void setDomeniu(String domeniu) {
		this.domeniu = domeniu;
	}

	public int getDisponibilitate() {
		return disponibilitate;
	}

	public void setDisponibilitate(int disponibilitate) {
		this.disponibilitate = disponibilitate;
	}

	public String getEditura() {
		return editura;
	}

	public void setEditura(String editura) {
		this.editura = editura;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getPret() {
		return pret;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}

	public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}


}
