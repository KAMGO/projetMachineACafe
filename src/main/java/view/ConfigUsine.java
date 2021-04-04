package view;

import java.util.ArrayList;

public class ConfigUsine {
	ArrayList<String> listBoissons = new ArrayList<String>(){{ add("Expresso");add("Expresso macch");add("Cappuccino");add("Cafe");add("Latte Macchiato");
	add("Cafe au lait");add("Mousse au lait");add("EauChaude");add("LaitChaud");add("Verseuse");add("Americano");add("FlatWhite");add("CafeCortado");}};
	ArrayList<String> listBoissonsLactee = new ArrayList<String>(){{add("Expresso macch");add("Cappuccino");add("Latte Macchiato");add("Café au lait");add("FlatWhite");add("CafeCortado");}};
	ArrayList<Integer> listProportionLaitCafe = new ArrayList<Integer>(){{ add(10);add(20);add(40);add(30);add(50);add(60);}};
	ArrayList<Profil> listProfilFavori = new ArrayList<Profil>(){{ add(new Profil("aucunNom1"));add(new Profil("aucunNom2"));add(new Profil("aucunNom3"));add(new Profil("aucunNom4"));}}; 
	ArrayList<String> listQteBoisson = new ArrayList<String>(){{ add("petit");add("moyen");add("grand");}};
	ArrayList<String> listIintensiteCafe = new ArrayList<String>(){{ add("tres doux");add("doux");add("normal");add("fort");add("tres fort");
	add("doubleshot fort");add("doubleshot fort+");add("comp. poudre");}};
	ArrayList<String> listCodeErreur = new ArrayList<String>(){{ add("OK");add("le mousseur de lait est sale veuillez le netoyer");add(" eau pas assez, veuillez completer");add("verifier le lait,verifier que le tuyau a lait est placé et \n est connecte au tube aspirateur sont connectes " );add("pas de cafe moulu.Veuillez remplir" );
	add("cafe grain pas assez.veuillez remplir");add("collecteur plein.Veuillez le vider");add("pas possible de faire arome double avec double tasse");add("preparation arome doudle impossible pour les petites tasses");add("fait le netoyage du systeme");add( "fait le detartrage du systeme");add("veuillez retirer le tuyau à lait");
	add("preparation des boissons au cafe grain impossible \n car probleme avec le moulin à grain");add("preparation des boissons au lait impossible. \n Probleme avec le mousseur de lait");}};
	
	ArrayList<String> listBoissons1 = new ArrayList<String>(){{ add("Expresso");add("Expresso macch");add("Cappuccino");add("Coffee");add("Latte Macchiato");
	add("Coffee with milk");add("Milk froth");add("Hot water");add("Hot milk");add("Jug");add("Americano");add("FlatWhite");add("CafeCortado");}};
	ArrayList<String> listBoissonsLactee1 = new ArrayList<String>(){{add("Expresso macch");add("Cappuccino");add("Latte Macchiato");add("Coffee with milk");add("FlatWhite");add("CafeCortado");}}; 
	ArrayList<String> listQteBoisson1 = new ArrayList<String>(){{ add("small");add("medium");add("big");}};
	ArrayList<String> listIintensiteCafe1 = new ArrayList<String>(){{ add("very soft");add("soft");add("normal");add("strong");add("very strong");
	add("doubleshot fort");add("doubleshot fort+");add("comp. powder");}};
	ArrayList<String> listCodeErreur1 = new ArrayList<String>(){{ add("OK");add("the milk frother is dirty please clean it");add("water not enough, please complete");add("check the milk, check that the milk hose is placed and \n is connected to the suction tube are connected" );add("no ground coffee, please fill in" );
	add("coffee bean not enough, please fill in");add("collector full, please empty it");add("not possible to make double aroma with double cup");add("preparation aroma doudle impossible for small cups");add("cleans the system");add( "descaling the system");add("please remove the milk pipe");
	add("preparation of coffee beans drinks impossible \n because problem with the bean mill");add("preparation of milk drinks not possible.\n Problem with the milk frother");}};
	
	public ArrayList<String> getListBoissons1() {
		return listBoissons1;
	}
	public void setListBoissons1(ArrayList<String> listBoissons1) {
		this.listBoissons1 = listBoissons1;
	}
	public ArrayList<String> getListBoissonsLactee1() {
		return listBoissonsLactee1;
	}
	public void setListBoissonsLactee1(ArrayList<String> listBoissonsLactee1) {
		this.listBoissonsLactee1 = listBoissonsLactee1;
	}
	public ArrayList<String> getListQteBoisson1() {
		return listQteBoisson1;
	}
	public void setListQteBoisson1(ArrayList<String> listQteBoisson1) {
		this.listQteBoisson1 = listQteBoisson1;
	}
	public ArrayList<String> getListIintensiteCafe1() {
		return listIintensiteCafe1;
	}
	public void setListIintensiteCafe1(ArrayList<String> listIintensiteCafe1) {
		this.listIintensiteCafe1 = listIintensiteCafe1;
	}
	public ArrayList<String> getListCodeErreur1() {
		return listCodeErreur1;
	}
	public void setListCodeErreur1(ArrayList<String> listCodeErreur1) {
		this.listCodeErreur1 = listCodeErreur1;
	}
	public ArrayList<String> getListCodeErreur() {
		return listCodeErreur;
	}
	public void setListCodeErreur(ArrayList<String> listCodeErreur) {
		this.listCodeErreur = listCodeErreur;
	}
	public ArrayList<String> getListIintensiteCafe() {
		return listIintensiteCafe;
	}
	public void setListIintensiteCafe(ArrayList<String> listIintensiteCafe) {
		this.listIintensiteCafe = listIintensiteCafe;
	}
	public ArrayList<Integer> getListProportionLaitCafe() {
		return listProportionLaitCafe;
	}
	public void setListProportionLaitCafe(ArrayList<Integer> listProportionLaitCafe) {
		this.listProportionLaitCafe = listProportionLaitCafe;
	}
	public ArrayList<Profil> getListProfilFavori() {
		return listProfilFavori;
	}
	public void setListProfilFavori(ArrayList<Profil> listProfilFavori) {
		this.listProfilFavori = listProfilFavori;
	}
	public ArrayList<String> getListQteBoisson() {
		return listQteBoisson;
	}
	public void setListQteBoisson(ArrayList<String> listQteBoisson) {
		this.listQteBoisson = listQteBoisson;
	}
	public ArrayList<String> getListBoissons() {
		return listBoissons;
	}
	public void setListBoissons(ArrayList<String> listBoissons) {
		this.listBoissons = listBoissons;
	}
	public ArrayList<String> getListBoissonsLactee() {
		return listBoissonsLactee;
	}
	public void setListBoissonsLactee(ArrayList<String> listBoissonsLactee) {
		this.listBoissonsLactee = listBoissonsLactee;
	}
	
	int qteExpresso      = 0;
	int qteExpressoMacch =1;
	int qteCafe          = 0;
	int qteCappuccino    = 1; 
	int qteLatteMacchiato= 1;
	int qteCafeLacte     = 1;
	int qteMousseLait    = 2;
	int qteEauChaude     = 1;
	int qteLaitChaud     = 2;
	int qteVerseuse      = 2;
	int qteAmericano 	 = 0;
	int qteFlatWhite 	 = 0;
	int qteCafeCortado 	 = 0;
	
	int intensiteExpresso      = 4;
	int intensiteExpressoMacch = 3;
	int intensiteCafe          = 4;
	int intensiteCappuccino    = 3; 
	int intensiteLatteMacchiato= 0;
	int intensiteCafeLacte     = 3;
	int intensiteMousseLait    = -1;
	int intensiteEauChaude     = -1;
	int intensiteLaitChaud     = -1;
	int intensiteVerseuse      = 4;
	int intensiteAmericano 	   = 5;
	int intensiteFlatWhite     = 3;
	int intensiteCafeCortado   = 3;


	int  proporLaitExpressoMacch = 10;
	int  proporLaitCappuccino    = 20; 
	int  proporLaitLatteMacchiato= 30;
	int  proporLaitCafeLacte     = 50;
	int  proporLaitFlatWhite     = 60;
	int  proporLaitCafeCortado   = 60;
	
	int dureteEau = 2;
	int bipSonnore      = 0;
	int temperatureCafe = 2;
	int Langue          = 0;
	
	
	public int getProporLaitExpressoMacch() {
		return proporLaitExpressoMacch;
	}
	public void setProporLaitExpressoMacch(int proporLaitExpressoMacch) {
		this.proporLaitExpressoMacch = proporLaitExpressoMacch;
	}
	public int getProporLaitCappuccino() {
		return proporLaitCappuccino;
	}
	public void setProporLaitCappuccino(int proporLaitCappuccino) {
		this.proporLaitCappuccino = proporLaitCappuccino;
	}
	public int getProporLaitLatteMacchiato() {
		return proporLaitLatteMacchiato;
	}
	public void setProporLaitLatteMacchiato(int proporLaitLatteMacchiato) {
		this.proporLaitLatteMacchiato = proporLaitLatteMacchiato;
	}
	public int getProporLaitCafeLacte() {
		return proporLaitCafeLacte;
	}
	public void setProporLaitCafeLacte(int proporLaitCafeLacte) {
		this.proporLaitCafeLacte = proporLaitCafeLacte;
	}
	public int getProporLaitFlatWhite() {
		return proporLaitFlatWhite;
	}
	public void setProporLaitFlatWhite(int proporLaitFlatWhite) {
		this.proporLaitFlatWhite = proporLaitFlatWhite;
	}
	public int getProporLaitCafeCortado() {
		return proporLaitCafeCortado;
	}
	public void setProporLaitCafeCortado(int proporLaitCafeCortado) {
		this.proporLaitCafeCortado = proporLaitCafeCortado;
	}
	public int getQteExpresso() {
		return qteExpresso;
	}
	public void setQteExpresso(int qteExpresso) {
		this.qteExpresso = qteExpresso;
	}
	public int getQteExpressoMacch() {
		return qteExpressoMacch;
	}
	public void setQteExpressoMacch(int qteExpressoMacch) {
		this.qteExpressoMacch = qteExpressoMacch;
	}
	public int getQteCafe() {
		return qteCafe;
	}
	public void setQteCafe(int qteCafe) {
		this.qteCafe = qteCafe;
	}
	public int getQteCappuccino() {
		return qteCappuccino;
	}
	public void setQteCappuccino(int qteCappuccino) {
		this.qteCappuccino = qteCappuccino;
	}
	public int getQteLatteMacchiato() {
		return qteLatteMacchiato;
	}
	public void setQteLatteMacchiato(int qteLatteMacchiato) {
		this.qteLatteMacchiato = qteLatteMacchiato;
	}
	public int getQteCafeLacte() {
		return qteCafeLacte;
	}
	public void setQteCafeLacte(int qteCafeLacte) {
		this.qteCafeLacte = qteCafeLacte;
	}
	public int getQteMousseLait() {
		return qteMousseLait;
	}
	public void setQteMousseLait(int qteMousseLait) {
		this.qteMousseLait = qteMousseLait;
	}
	public int getQteEauChaude() {
		return qteEauChaude;
	}
	public void setQteEauChaude(int qteEauChaude) {
		this.qteEauChaude = qteEauChaude;
	}
	public int getQteLaitChaud() {
		return qteLaitChaud;
	}
	public void setQteLaitChaud(int qteLaitChaud) {
		this.qteLaitChaud = qteLaitChaud;
	}
	public int getQteVerseuse() {
		return qteVerseuse;
	}
	public void setQteVerseuse(int qteVerseuse) {
		this.qteVerseuse = qteVerseuse;
	}
	public int getQteAmericano() {
		return qteAmericano;
	}
	public void setQteAmericano(int qteAmericano) {
		this.qteAmericano = qteAmericano;
	}
	public int getQteFlatWhite() {
		return qteFlatWhite;
	}
	public void setQteFlatWhite(int qteFlatWhite) {
		this.qteFlatWhite = qteFlatWhite;
	}
	public int getQteCafeCortado() {
		return qteCafeCortado;
	}
	public void setQteCafeCortado(int qteCafeCortado) {
		this.qteCafeCortado = qteCafeCortado;
	}
	public int getIntensiteExpresso() {
		return intensiteExpresso;
	}
	public void setIntensiteExpresso(int intensiteExpresso) {
		this.intensiteExpresso = intensiteExpresso;
	}
	public int getIntensiteExpressoMacch() {
		return intensiteExpressoMacch;
	}
	public void setIntensiteExpressoMacch(int intensiteExpressoMacch) {
		this.intensiteExpressoMacch = intensiteExpressoMacch;
	}
	public int getIntensiteCafe() {
		return intensiteCafe;
	}
	public void setIntensiteCafe(int intensiteCafe) {
		this.intensiteCafe = intensiteCafe;
	}
	public int getIntensiteCappuccino() {
		return intensiteCappuccino;
	}
	public void setIntensiteCappuccino(int intensiteCappuccino) {
		this.intensiteCappuccino = intensiteCappuccino;
	}
	public int getIntensiteLatteMacchiato() {
		return intensiteLatteMacchiato;
	}
	public void setIntensiteLatteMacchiato(int intensiteLatteMacchiato) {
		this.intensiteLatteMacchiato = intensiteLatteMacchiato;
	}
	public int getIntensiteCafeLacte() {
		return intensiteCafeLacte;
	}
	public void setIntensiteCafeLacte(int intensiteCafeLacte) {
		this.intensiteCafeLacte = intensiteCafeLacte;
	}
	public int getIntensiteMousseLait() {
		return intensiteMousseLait;
	}
	public void setIntensiteMousseLait(int intensiteMousseLait) {
		this.intensiteMousseLait = intensiteMousseLait;
	}
	public int getIntensiteEauChaude() {
		return intensiteEauChaude;
	}
	public void setIntensiteEauChaude(int intensiteEauChaude) {
		this.intensiteEauChaude = intensiteEauChaude;
	}
	public int getIntensiteLaitChaud() {
		return intensiteLaitChaud;
	}
	public void setIntensiteLaitChaud(int intensiteLaitChaud) {
		this.intensiteLaitChaud = intensiteLaitChaud;
	}
	public int getIntensiteVerseuse() {
		return intensiteVerseuse;
	}
	public void setIntensiteVerseuse(int intensiteVerseuse) {
		this.intensiteVerseuse = intensiteVerseuse;
	}
	public int getIntensiteAmericano() {
		return intensiteAmericano;
	}
	public void setIntensiteAmericano(int intensiteAmericano) {
		this.intensiteAmericano = intensiteAmericano;
	}
	public int getIntensiteFlatWhite() {
		return intensiteFlatWhite;
	}
	public void setIntensiteFlatWhite(int intensiteFlatWhite) {
		this.intensiteFlatWhite = intensiteFlatWhite;
	}
	public int getIntensiteCafeCortado() {
		return intensiteCafeCortado;
	}
	public void setIntensiteCafeCortado(int intensiteCafeCortado) {
		this.intensiteCafeCortado = intensiteCafeCortado;
	}
	public int getDureteEau() {
		return dureteEau;
	}
	public void setDureteEau(int dureteEau) {
		this.dureteEau = dureteEau;
	}
	public int getBipSonnore() {
		return bipSonnore;
	}
	public void setBipSonnore(int bipSonnore) {
		this.bipSonnore = bipSonnore;
	}
	public int getTemperatureCafe() {
		return temperatureCafe;
	}
	public void setTemperatureCafe(int temperatureCafe) {
		this.temperatureCafe = temperatureCafe;
	}
	public int getLangue() {
		return Langue;
	}
	public void setLangue(int langue) {
		Langue = langue;
	}
	
}
