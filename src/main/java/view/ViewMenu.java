package view;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import stateChart_gen.CafePro;
import stateChart_gen.CafePro.State;

public class ViewMenu {
	private int id=-1;
	ArrayList<String> listMaintenance = new ArrayList<String>(){{ add("Nettoyer le mousseur de lait");add("Nettoyer");add("Détartrer");add("Calc_nClean");}};
	
	ArrayList<String> listQteBoisson = new ArrayList<String>(){{ add("petit");add("moyen");add("grand");}}; //il faut selectionner boisson
	ArrayList<String> listDureteEau = new ArrayList<String>(){{ add("1");add("2");add("3");add("4");add("Adoucisseur");}};
	ArrayList<Integer>    listArretAuto = new ArrayList<Integer>(){{ add(60);add(120);add(150);add(180);add(200);add(300);add(600);}}; 
	ArrayList<String> listTemperatureCafe = new ArrayList<String>(){{ add("normale");add(" haute");add("maxi");}};
	ArrayList<String> listOptionFiltreEau = new ArrayList<String>(){{ add("Activer nouveau filtre");add(" Filtre non placé");}};
	ArrayList<String> listLangue = new ArrayList<String>(){{ add("Francais");add("Anglais");}};
	ArrayList<String> listOptBipSonore = new ArrayList<String>(){{ add("Active");add("Desactive");}};
	
	ArrayList<String> listQteBoisson1 = new ArrayList<String>(){{ add("small");add("Medium");add("big");}}; //il faut selectionner boisson
	ArrayList<String> listDureteEau1 = new ArrayList<String>(){{ add("1");add("2");add("3");add("4");add("Adoucisseur");}};
	ArrayList<Integer>    listArretAuto1 = new ArrayList<Integer>(){{ add(60);add(120);add(150);add(180);add(200);add(300);add(600);}}; 
	ArrayList<String> listTemperatureCafe1 = new ArrayList<String>(){{ add("normal");add(" high");add("maxi");}};
	ArrayList<String> listOptionFiltreEau1 = new ArrayList<String>(){{ add("Activate new filter");add(" Filter not placed");}};
	ArrayList<String> listLangue1 = new ArrayList<String>(){{ add("French");add("English");}};
	ArrayList<String> listOptBipSonore1 = new ArrayList<String>(){{ add("Active");add("Desactive");}};
	/* getters et setters */

	public ArrayList<String> getListQteBoisson() {
		return listQteBoisson;
	}
	public void setListQteBoisson(ArrayList<String> listQteBoisson) {
		this.listQteBoisson = listQteBoisson;
	}
	public ArrayList<String> getListDureteEau() {
		return listDureteEau;
	}
	public void setListDureteEau(ArrayList<String> listDureteEau) {
		this.listDureteEau = listDureteEau;
	}
	public ArrayList<Integer> getListArretAuto() {
		return listArretAuto;
	}
	public void setListArretAuto(ArrayList<Integer> listArretAuto) {
		this.listArretAuto = listArretAuto;
	}
	public ArrayList<String> getListTemperatureCafe() {
		return listTemperatureCafe;
	}
	public void setListTemperatureCafe(ArrayList<String> listTemperatureCafe) {
		this.listTemperatureCafe = listTemperatureCafe;
	}
	public ArrayList<String> getListOptionFiltreEau() {
		return listOptionFiltreEau;
	}
	public void setListOptionFiltreEau(ArrayList<String> listOptionFiltreEau) {
		this.listOptionFiltreEau = listOptionFiltreEau;
	}
	public ArrayList<String> getListLangue() {
		return listLangue;
	}
	public void setListLangue(ArrayList<String> listLangue) {
		this.listLangue = listLangue;
	}
	public ArrayList<String> getListOptBipSonore() {
		return listOptBipSonore;
	}
	public void setListOptBipSonore(ArrayList<String> listOptBipSonore) {
		this.listOptBipSonore = listOptBipSonore;
	}
	
	public void seDeplacer(CafePro cafePro, Label lblAffichInfo,Label lblAffichInfo1,ConfigUsine configUsine,TextField txtNomProfil) {
		cafePro.raiseBtnDeplacement();
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_AFFICHEBOISSONSINCEFIRSTTUSE))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_ARRÊTAUTOMATIQUE))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_BIPSONORE))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_DURETEEAU))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_MAINTENANCE))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_FAVORI))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_FILTREEAU_))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_LANGUE))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_NBREBOISSONSSINCEFIRSTUSE))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_NBRECAFEAVENTRETIEN))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_PROPORTIONLAIT))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
       	if(cafePro.isStateActive(State.MAIN_MENU_R1_QTEBOISSON))
       		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
       	if(cafePro.isStateActive(State.MAIN_MENU_R1_TEMPERATURECAFE))
       		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
       	
       	
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGLANGUE))
    		lblAffichInfo1.setText(listLangue.get((int)cafePro.getIndice()));
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGDURETEEAU))
    		lblAffichInfo1.setText(listDureteEau.get((int)cafePro.getIndice()));
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGARRETAUTOMATIQUE))
    		lblAffichInfo1.setText(listArretAuto.get((int)cafePro.getIndice())+" Secondes");
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGTEMPERATURECAFE))
    		lblAffichInfo1.setText(listTemperatureCafe.get((int)cafePro.getIndice()));
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGFILTREEAU))
    		lblAffichInfo1.setText(listOptionFiltreEau.get((int)cafePro.getIndice()));
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGBIPSONORE))
    		lblAffichInfo1.setText(listOptBipSonore.get((int)cafePro.getIndice()));
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_EFFECTUERMAINTENANCE))
    		if(cafePro.isStateActive(State.MAIN_MENU_R1_EFFECTUERMAINTENANCE_R1_ENTRETIEN))
    			lblAffichInfo1.setText(listMaintenance.get((int)cafePro.getChoixEntretien()));
    	
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGQTEBOISSON_R1_SELECTBOISSON)) {
    		//lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    		lblAffichInfo1.setText(configUsine.getListBoissons().get((int)cafePro.getIndice()));
    	}
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGQTEBOISSON_R1_QTEBOISSON)) {
    		//lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    		lblAffichInfo1.setText(configUsine.getListQteBoisson().get((int)cafePro.getQteBoisson()));	
    	}
    	
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGPROPORTIONLAIT_R1_CHOISIRBOISSON)) {
    		lblAffichInfo1.setText(configUsine.getListBoissonsLactee().get((int)cafePro.getIndice()));		
    	}
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGPROPORTIONLAIT_R1_CHOISIRPROPORTION)) {
    		 lblAffichInfo1.setText(configUsine.getListProportionLaitCafe().get((int)cafePro.getIndice())+" %"); 
    	}
    	
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGFAVORI_R1_SELECTPROFIL)){
    		if( txtNomProfil.getText().compareTo("")==0)
    			txtNomProfil.setText("changer le nom du profil ici");
    		if( txtNomProfil.getText().compareTo("changer le nom du profil ici")!=0) { //permet d'enregistre le changement de nom du profilFavori precedant
    			if(((int) cafePro.getIndice()-1)==-1)
    				configUsine.getListProfilFavori().get(3).setNomFavori( txtNomProfil.getText());
    			else
    				configUsine.getListProfilFavori().get((int) cafePro.getIndice()-1).setNomFavori( txtNomProfil.getText());
    			txtNomProfil.setText("changer le nom du profil ici");
    		}
    		lblAffichInfo1.setText(configUsine.getListProfilFavori().get((int) cafePro.getIndice()).nomProfil);
    	}
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGFAVORI_R1_SELECTBOISSON)){
    		lblAffichInfo1.setText(configUsine.getListBoissons().get((int) cafePro.getIndice()));
    	}
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGFAVORI_R1_QUANTITEBOISSON)){
    		lblAffichInfo1.setText(configUsine.getListQteBoisson().get((int) cafePro.getQteBoisson()));
    	}
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGFAVORI_R1_INTENSITECAFE)){
    		lblAffichInfo1.setText(configUsine.getListIintensiteCafe().get((int) cafePro.getIntensiteCafe()));
    	}
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGFAVORI_R1_PROPORTIONLAIT)){
    		lblAffichInfo1.setText(configUsine.getListProportionLaitCafe().get((int) cafePro.getIndice())+" %");
    	}
	}
	
	
	public void precedant(CafePro cafePro, Label lblAffichInfo,Label lblAffichInfo1) {
		cafePro.raiseBtnPrecedant();
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_AFFICHEBOISSONSINCEFIRSTTUSE))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_ARRÊTAUTOMATIQUE))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_BIPSONORE))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_DURETEEAU))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_MAINTENANCE))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_FAVORI))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_FILTREEAU_))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_LANGUE))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_NBREBOISSONSSINCEFIRSTUSE))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_NBRECAFEAVENTRETIEN))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_PROPORTIONLAIT))
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
       	if(cafePro.isStateActive(State.MAIN_MENU_R1_QTEBOISSON))
       		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
       	if(cafePro.isStateActive(State.MAIN_MENU_R1_TEMPERATURECAFE))
       		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
	}

	
	public String confirmer(CafePro cafePro,Label lblpbFiltre ,Label lblAffichInfo1,Label lblAffichInfo,ConfigUsine configUsine,TextField txtNomProfil) {
		String message=null;
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_MAINTENANCE)){
    		lblAffichInfo1.setVisible(true);
    		lblAffichInfo1.setText(listMaintenance.get(0));
    		cafePro.raiseBtnOk();
    	}
    	
    	/* ******************************** gestion de la modification ou de la creation des boisson favori dans le menu   ******************************************/
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_FAVORI)){
    		cafePro.raiseBtnOk();
    		txtNomProfil.setVisible(true);
      		lblAffichInfo1.setVisible(true);
      		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
      		lblAffichInfo1.setText(configUsine.getListProfilFavori().get(0).getNomFavori());
      		//lblAffichInfo1.setText(configUsine.getListProfilFavori().get((int) cafePro.getIndice()).nomProfil);
    	}
    	else if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGFAVORI_R1_SELECTPROFIL)){
    		id=(int) cafePro.getIndice();
    		if( txtNomProfil.getText().compareTo("")==0)
    			txtNomProfil.setText("changer le nom du profil ici");
    		if( txtNomProfil.getText().compareTo("changer le nom du profil ici")!=0) { //permet d'enregistre le changement de nom de profilFavori
    			configUsine.getListProfilFavori().get(id).setNomFavori( txtNomProfil.getText());
    			txtNomProfil.setText("changer le nom du profil ici");
    		}
    		cafePro.raiseBtnOk();
    		lblAffichInfo1.setText(configUsine.getListBoissons().get(0));
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	}
    	else if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGFAVORI_R1_SELECTBOISSON)) {
    		int i =(int) cafePro.getIndice();
    		cafePro.raiseBtnOk();
    		txtNomProfil.setVisible(false);
    		lblAffichInfo1.setText(configUsine.getListQteBoisson().get(0));
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    		if(i==0 || i==3 || i==9 || i==10) {
    			configUsine.getListProfilFavori().get(id).setTypeBoisson(1);
    			cafePro.setTypeBoisson(1);
    		}
    		else if(i== 1 || i==2 || i==4 || i==5  || i==11 || i==12) {
    			configUsine.getListProfilFavori().get(id).setTypeBoisson(3);
    			cafePro.setTypeBoisson(3);
    		}
    		else if(i== 6 || i==8) {
    			configUsine.getListProfilFavori().get(id).setTypeBoisson(2);
    			cafePro.setTypeBoisson(2);
    		}
    		else if(i==7) {
    			configUsine.getListProfilFavori().get(id).setTypeBoisson(4);
    			cafePro.setTypeBoisson(4);
    		}
    	}
     	else if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGFAVORI_R1_QUANTITEBOISSON)) {
    		//idNomBoisson=(int) cafePro.getIndice();
    		cafePro.raiseBtnOk();
    		configUsine.getListProfilFavori().get(id).setQteBoisson(configUsine.getListQteBoisson().get((int) cafePro.getQteBoisson()));
    		if(configUsine.getListProfilFavori().get(id).getTypeBoisson()==4 ||configUsine.getListProfilFavori().get(id).getTypeBoisson()==2)
    			if(cafePro.getLangue()==true)
    				message = "votre profil favori :" + configUsine.getListProfilFavori().get(id).getNomFavori()+"a ete enregistre ";
    			else
    				message = "your favorite profile :" + configUsine.getListProfilFavori().get(id).getNomFavori()+"was registered ";
    		else {
        		lblAffichInfo1.setText(configUsine.getListIintensiteCafe().get(0));
        		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
        		if(cafePro.getLangue()==true)
        			System.out.println("je suis dans favori "+cafePro.getTxtOptionMenu());
        		else
        			System.out.println("your favorite profile "+cafePro.getTxtOptionMenu());
    		}
    	}
     	else if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGFAVORI_R1_INTENSITECAFE)){
    		//idNomBoisson=(int) cafePro.getIndice();
    		cafePro.raiseBtnOk();
    	configUsine.getListProfilFavori().get(id).setIntensiteCafe(configUsine.getListIintensiteCafe().get((int) cafePro.getIntensiteCafe()));
    		if(configUsine.getListProfilFavori().get(id).getTypeBoisson()==1) {
    			if(cafePro.getLangue()==true)
    				message = "votre profil favori : " + configUsine.getListProfilFavori().get(id).getNomFavori()+" a ete enregistre ";
    			else
    				message = "your favorite profile : " + configUsine.getListProfilFavori().get(id).getNomFavori()+" was registered";
    		}
    		else {
        		lblAffichInfo1.setText(configUsine.getListProportionLaitCafe().get(0)+" %");
        		lblAffichInfo.setText(cafePro.getTxtOptionMenu());	
    		}
    	}
     	else if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGFAVORI_R1_PROPORTIONLAIT)){
    		cafePro.raiseBtnOk();	
    		configUsine.getListProfilFavori().get(id).setProportionLait(configUsine.getListProportionLaitCafe().get((int) cafePro.getIndice()));
    		if(cafePro.getLangue()==true)
    			message = "votre profil favori : " + configUsine.getListProfilFavori().get(id).getNomFavori()+ " ete enregistree ";
    		else
    			message = "your favorite profile : " + configUsine.getListProfilFavori().get(id).getNomFavori()+ " was registered ";
    	}
  
    	
    	/* *****************************gestion de la modification des proportions lait/cafe  d'une boisson Lactee dans le menu *********************/
    	
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_PROPORTIONLAIT)) {
    		cafePro.raiseBtnOk();
      		lblAffichInfo1.setVisible(true);
      		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
      		lblAffichInfo1.setText(configUsine.getListBoissonsLactee().get(0));
    	}
    	else if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGPROPORTIONLAIT_R1_CHOISIRBOISSON)){
        	id=(int) cafePro.getIndice();
        	cafePro.raiseBtnOk();
        	lblAffichInfo1.setText(configUsine.getListProportionLaitCafe().get(0)+" %");
        	lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	}
    	else if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGPROPORTIONLAIT_R1_CHOISIRPROPORTION)){
        		cafePro.raiseBtnOk();
        		int i=(int) cafePro.getIndice();
        		if(id==0)
        			configUsine.setProporLaitExpressoMacch(configUsine.getListProportionLaitCafe().get(i));
        		else if(id==1)
        			configUsine.setProporLaitCappuccino(configUsine.getListProportionLaitCafe().get(i));
        		else if(id==2)
        			configUsine.setProporLaitLatteMacchiato(configUsine.getListProportionLaitCafe().get(i));
        		else if(id==3)
        			configUsine.setProporLaitCafeLacte(configUsine.getListProportionLaitCafe().get(i));
        		else if(id==4)
        			configUsine.setProporLaitFlatWhite(configUsine.getListProportionLaitCafe().get(i));
        		else if(id==5)
        			configUsine.setProporLaitCafeCortado(configUsine.getListProportionLaitCafe().get(i));
        		message="la boisson "+ configUsine.getListBoissonsLactee().get(id)+" a pour new proportion : "+configUsine.getListQteBoisson().get(i)+" %";
    		}
    	
    	/* *****************************   gestion de la modification de la quantite d'une boisson  dans le menu  *********************/
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_QTEBOISSON)) {
    		cafePro.raiseBtnOk();
      		lblAffichInfo1.setVisible(true);
      		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
      		lblAffichInfo1.setText(configUsine.getListBoissons().get(0));
    	}
    	else if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGQTEBOISSON_R1_QTEBOISSON)) {
    		cafePro.raiseBtnOk();
    		int i=(int) cafePro.getQteBoisson();
    		if(id==0)
    			configUsine.setQteExpresso(i);
    		else if(id==1)
    			configUsine.setQteExpressoMacch(i);
    		else if(id==2)
    			configUsine.setQteCappuccino(i);
    		else if(id==3)
    			configUsine.setQteCafe(i);
    		else if(id==4)
    			configUsine.setQteLatteMacchiato(i);
    		else if(id==5)
    			configUsine.setQteCafeLacte(i);
    		else if(id==6)
    			configUsine.setQteMousseLait(i);
    		else if(id==7)
    			configUsine.setQteEauChaude(i);    		
    		else if(id==8)
        			configUsine.setQteLaitChaud(i);
    		else if(id==9)
    			configUsine.setQteVerseuse(i);
    		else if(id==10)
    			configUsine.setQteAmericano(i);
    		else if(id==11)
    			configUsine.setQteFlatWhite(i);
    		else if(id==12)
    			configUsine.setQteCafeCortado(i);
    		message="la boisson "+ configUsine.getListBoissons().get(id)+" a pour new qte : "+configUsine.getListQteBoisson().get(i);
    	}
    	else if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGQTEBOISSON_R1_SELECTBOISSON)) {
    		id=(int) cafePro.getIndice();
    		cafePro.raiseBtnOk();
    		lblAffichInfo1.setText(configUsine.getListQteBoisson().get(0));
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
    	}
       	
       	
       	
       	
    	/* *****************************gestion de la modification de la duretee de l'eau dans le menu *********************/
    	
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_DURETEEAU)){
      		cafePro.raiseBtnOk();
      		lblAffichInfo1.setVisible(true);
      		lblAffichInfo1.setText(listDureteEau.get(0));
    	}
    	else if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGDURETEEAU)){
    		cafePro.raiseBtnOk();
    		configUsine.setDureteEau((int) cafePro.getIndice());
    		if(cafePro.getLangue()==true)
    			message="la durete de l'eau est : "+listDureteEau.get(configUsine.getDureteEau());
    		else
    			message="the water hardness is : "+listDureteEau1.get(configUsine.getDureteEau());
    	} 	
    	/* *****************************gestion de l'activation ou de la desactivation du bip  sonnore dans le menu *********************/
       	if(cafePro.isStateActive(State.MAIN_MENU_R1_BIPSONORE)){
      		cafePro.raiseBtnOk();
      		lblAffichInfo1.setVisible(true);
      		lblAffichInfo1.setText(listOptBipSonore.get(0));
    	}
    	else if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGBIPSONORE)){
    		cafePro.raiseBtnOk();
    		configUsine.setBipSonnore((int) cafePro.getIndice());
    		if(cafePro.getIndice()==0)
    			cafePro.setBipSonnore(true);
    		else
    			cafePro.setBipSonnore(false);
    		if(cafePro.getLangue()==true)
    			message="le bip sonnore est : "+listOptBipSonore.get(configUsine.getBipSonnore());
    		else
    			message="the beep is ringing : "+listOptBipSonore.get(configUsine.getBipSonnore());
    	}
       	/* *****************************gestion de la modification de la langue dans le menu *********************/
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_LANGUE)) {
      		cafePro.raiseBtnOk();
      		lblAffichInfo1.setVisible(true);
      		lblAffichInfo1.setText(listLangue.get(0));
    	}
    	else if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGLANGUE)) {
    		cafePro.raiseBtnOk();
    		configUsine.setLangue((int) cafePro.getIndice());
    		if(cafePro.getLangue()==true)
    			message="langue enregistre : "+listLangue.get(configUsine.getLangue());
    		else
    			message="language recorded : "+listLangue1.get(configUsine.getLangue());
    	}
    	/* *****************************gestion de la modification de la temperature dans le menu *********************/
       	if(cafePro.isStateActive(State.MAIN_MENU_R1_TEMPERATURECAFE)){
       		cafePro.raiseBtnOk();
       		lblAffichInfo1.setVisible(true);
       		lblAffichInfo1.setText(listTemperatureCafe.get(0));
       	}
       	else if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGTEMPERATURECAFE)) {
       		cafePro.raiseBtnOk();
       		configUsine.setTemperatureCafe((int) cafePro.getIndice());
       		if(cafePro.getLangue()==true)
       			message="la tempeture du cafe a ete modifier avec succes : "+listTemperatureCafe.get(configUsine.getTemperatureCafe());
       		else
       			message="the coffee temperature has been successfully changed : "+listTemperatureCafe1.get(configUsine.getTemperatureCafe());
       		if(cafePro.getIndice()==0)
       			cafePro.setLangue(true);
       		else
       			cafePro.setLangue(false);
       	}
    	/* *****************************gestion de l'activation ou de la desactivation du filtre dans le menu *********************/
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_FILTREEAU_)){
    		cafePro.raiseBtnOk();
    		lblAffichInfo1.setVisible(true);
	    	lblAffichInfo1.setText(listOptionFiltreEau.get(0));//appel methode
    	}
    	else if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGFILTREEAU)){
    		cafePro.raiseBtnOk();
	    	if(cafePro.getFiltrePlace()==true&&cafePro.getEtatDuFiltre()==0){ 
		    	if(cafePro.getIndice()==0) {
		    		lblpbFiltre.setText(0+"");
		    		cafePro.setEtatDuFiltre(1);
		    		cafePro.setCounterForFiltre(0);
		    	}
		   		else {
		   			cafePro.setEtatDuFiltre(0);
		   		}
		    	if(cafePro.getLangue()==true)
		    		message="vos modifications ont ete enregistrées";
		    	else
		    		message="your changes have been saved";
	    	}
	    	else {
	    		if(cafePro.getLangue()==true)
	    			message="desolez vous devez d'abord place le filtre \n ou remplacer celui qui est placé";	
	    		else
	    			message="sorry you must first place the filter \n or replace the one that is placed";
	    	}
    	}
    	/* *****************************affichage du nombre de boisson depuis la premiere utilisation *********************/
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_NBREBOISSONSSINCEFIRSTUSE))
    		cafePro.raiseBtnOk();
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_AFFICHEBOISSONSINCEFIRSTTUSE)){
    		lblAffichInfo1.setVisible(true);
    		lblAffichInfo1.setText(cafePro.getNbreBoissonCook()+"");
    	}
    	/* *****************************affichage du nombre de boisson restante pour faire une maintenance  *********************/
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_NBRECAFEAVENTRETIEN))
    		cafePro.raiseBtnOk();
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_AFFICHEINFOENTRETIEN)) {
    		lblAffichInfo1.setVisible(true);
    		if(cafePro.getLangue()==true)
    			lblAffichInfo1.setText("Netoyage dans: "+(cafePro.getMaxBoissonForClean()- cafePro.getCounterForClean())+" cafes et Detartratage dans: "+(cafePro.getMaxBoissonForDetardrage()- cafePro.getCounterForDetardrage()+" cafes"));
    		else
    			lblAffichInfo1.setText("Cleanning in : "+(cafePro.getMaxBoissonForClean()- cafePro.getCounterForClean())+" coffees and Descale in: "+(cafePro.getMaxBoissonForDetardrage()- cafePro.getCounterForDetardrage()+" coffees"));
    	}
    	
    	/* *****************************           modification du temps apres lequel la machime doit s'eteindre           *********************/
    	if(cafePro.isStateActive(State.MAIN_MENU_R1_ARRÊTAUTOMATIQUE)) {
      		cafePro.raiseBtnOk();
      		lblAffichInfo1.setVisible(true);
      		lblAffichInfo1.setText(listArretAuto.get(0)+" Secondes");
    	}
    	else if(cafePro.isStateActive(State.MAIN_MENU_R1_SETTINGARRETAUTOMATIQUE)) {
    		cafePro.raiseBtnOk();
    		cafePro.setTempsArretAuto(listArretAuto.get((int) cafePro.getIndice()));
    		if(cafePro.getLangue()==true)
    			message="new temps arret automatique : "+cafePro.getTempsArretAuto();
    		else
    			message="new automatic shutdown time : "+cafePro.getTempsArretAuto();
    	}
       		//appel methode
       	return message;
	}
}
