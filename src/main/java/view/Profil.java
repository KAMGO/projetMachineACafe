package view;

public class Profil {
	String nomProfil="aucunNom";
	int proportionLait=-1;
	int typeBoisson=-1;
	String qteBoisson=null;
	String intensiteCafe=null;

	public Profil(String nomProfil) {
		this.nomProfil = nomProfil;
	}
	public String getNomFavori() {
		return nomProfil;
	}
	public void setNomFavori(String nomFavori) {
		this.nomProfil = nomFavori;
	}
	public int getProportionLait() {
		return proportionLait;
	}
	public void setProportionLait(int proportionLait) {
		this.proportionLait = proportionLait;
	}
	public int getTypeBoisson() {
		return typeBoisson;
	}
	public void setTypeBoisson(int typeBoisson) {
		this.typeBoisson = typeBoisson;
	}
	public String getQteBoisson() {
		return qteBoisson;
	}
	public void setQteBoisson(String idQteBoisson) {
		this.qteBoisson = idQteBoisson;
	}
	public String getIntensiteCafe() {
		return intensiteCafe;
	}
	public void setIntensiteCafe(String idIntensiteCafe) {
		this.intensiteCafe = idIntensiteCafe;
	}
}
