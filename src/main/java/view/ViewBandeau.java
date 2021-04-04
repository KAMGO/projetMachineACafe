package view;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stateChart_gen.CafePro;
import stateChart_gen.CafePro.State;

public class ViewBandeau {
	private ImageView btnExpresso,btnExpressoMacch,btnCafe,btnCappucino,btnMacchiato,btnCafeLait,btnMousseLait,btnBoissonSpecial;
	ArrayList<String> listBoissonSpecial = new ArrayList<String>(){{ add("EauChaude");add("LaitChaud");add("Verseuse");add("Americano");add("FlatWhite");
	add("CafeCortado");}};
	ArrayList<String> listBoissonSpecial1 = new ArrayList<String>(){{ add("Hot water");add("Hot milk");add("Jug");add("Americano");add("FlatWhite");
	add("CafeCortado");}};

	private ConfigUsine configUsine;
	
	public ArrayList<String> getListBoissonSpecial(){
		return listBoissonSpecial;
	}
	public void setListBoissonSpecial(ArrayList<String> listBoissonSpecial){
		this.listBoissonSpecial = listBoissonSpecial;
	}
	public ViewBandeau (ImageView btnExpresso,ImageView btnExpressoMacch,ImageView btnCafe,ImageView btnCappucino,ImageView btnMacchiato,
	ImageView btnCafeLait,ImageView btnMousseLait,ImageView btnBoissonSpecial,ConfigUsine configUsine){
		this.btnExpresso = btnExpresso;
		this.btnExpressoMacch= btnExpressoMacch;
		this.btnCafe =btnCafe;
		this.btnCappucino= btnCappucino;
		this.btnMacchiato= btnMacchiato;
		this.btnCafeLait= btnCafeLait;
		this.btnMousseLait= btnMousseLait;
		this.btnBoissonSpecial=btnBoissonSpecial;
		this.configUsine =configUsine;
	}
	// permet d'affecter aux boissons le type de boisson correspondant et d'affiche la boisson selectionnee. Rappel : nous avons 4 types de boissons (cafe=>1,cafe au lait =>2, lait =>3 et eau chaude =>4)
	public void selectBoisson(MouseEvent event,CafePro cafePro,Label qteBoisson,Label intensiteCafe,Label lblAffichInfo,Label lblLedExpreso,Label lblLedExpressoMacch,Label lblLedCappucino,Label lblLedCafe,Label lblLedMachiato,Label lblLedCafeLait,Label lblLedMousseLait,Label lblLedBoissonSpecial) { 
		//int typeBoisson=1;
		if(event.getTarget()==btnCafe){ //expresso,cafe,americano et fonction verseuse
			cafePro.setTypeBoisson(1);
			if(!cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS))
				cafePro.raiseSelectBoisson();
			if(cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS)){
				lblLedExpreso.setVisible(false);
				lblLedExpressoMacch.setVisible(false);
				lblLedCappucino.setVisible(false);
				lblLedCafe.setVisible(true);
				lblLedMachiato.setVisible(false);
				lblLedCafeLait.setVisible(false);
				lblLedMousseLait.setVisible(false);
				lblLedBoissonSpecial.setVisible(false);
				lblAffichInfo.setText("Cafe");
				intensiteCafe.setText(configUsine.getListIintensiteCafe().get(configUsine.getIntensiteCafe()));
				cafePro.setIntensiteCafe(configUsine.getIntensiteCafe());
				qteBoisson.setText(configUsine.getListQteBoisson().get(configUsine.getQteCafe()));
				cafePro.setQteBoisson(configUsine.getQteCafe());
			}
			if(cafePro.isStateActive(State.MAIN_IDLE)&&cafePro.getPbBandeau()==true) {
				lblAffichInfo.setText("Probleme avec le Bandeau");
				lblAffichInfo.setVisible(true);
			}
					
		}
		else if(event.getTarget()==btnExpresso){
			cafePro.setTypeBoisson(1);
			if(!cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS))
				cafePro.raiseSelectBoisson();
			if(cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS)) {
				lblLedExpreso.setVisible(true);
				lblLedExpressoMacch.setVisible(false);
				lblLedCappucino.setVisible(false);
				lblLedCafe.setVisible(false);
				lblLedMachiato.setVisible(false);
				lblLedCafeLait.setVisible(false);
				lblLedMousseLait.setVisible(false);
				lblLedBoissonSpecial.setVisible(false);
				lblAffichInfo.setText("Expresso");
				intensiteCafe.setText(configUsine.getListIintensiteCafe().get(configUsine.getIntensiteExpresso()));
				cafePro.setIntensiteCafe(configUsine.getIntensiteExpresso());
				qteBoisson.setText(configUsine.getListQteBoisson().get(configUsine.getQteExpresso()));
				cafePro.setQteBoisson(configUsine.getQteExpresso());
			}
		}
		else if(event.getTarget()==btnMousseLait) { //mousse lait ou le lait chaud
			cafePro.setTypeBoisson(2);
			if(!cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS))
				cafePro.raiseSelectBoisson();
			if(cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS)) {
				lblLedExpreso.setVisible(false);
				lblLedExpressoMacch.setVisible(false);
				lblLedCappucino.setVisible(false);
				lblLedCafe.setVisible(false);
				lblLedMachiato.setVisible(false);
				lblLedCafeLait.setVisible(false);
				lblLedMousseLait.setVisible(true);
				lblLedBoissonSpecial.setVisible(false);
				lblAffichInfo.setText("Mousse au lait");
				intensiteCafe.setText("");
				qteBoisson.setText(configUsine.getListQteBoisson().get(configUsine.getQteMousseLait()));
				cafePro.setQteBoisson(configUsine.getQteMousseLait());
			}
		}
		//cappuccino,flat white, CafeCortado, café au lait , Expresso macch et Latte Macchiato
		else if(event.getTarget()==btnExpressoMacch){
			cafePro.setTypeBoisson(3);
			if(!cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS))
				cafePro.raiseSelectBoisson();
			if(cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS)) {
				lblLedExpreso.setVisible(false);
				lblLedExpressoMacch.setVisible(true);
				lblLedCappucino.setVisible(false);
				lblLedCafe.setVisible(false);
				lblLedMachiato.setVisible(false);
				lblLedCafeLait.setVisible(false);
				lblLedMousseLait.setVisible(false);
				lblLedBoissonSpecial.setVisible(false);
				lblAffichInfo.setText("Expresso macch");
				intensiteCafe.setText(configUsine.getListIintensiteCafe().get(configUsine.getIntensiteExpressoMacch()));
				cafePro.setIntensiteCafe(configUsine.getIntensiteExpressoMacch());
				qteBoisson.setText(configUsine.getListQteBoisson().get(configUsine.getQteExpressoMacch()));
				cafePro.setQteBoisson(configUsine.getQteExpressoMacch());
				cafePro.setProportionLait(configUsine.getProporLaitExpressoMacch());
			}
		}
		else if(event.getTarget()==btnCafeLait){
			cafePro.setTypeBoisson(3);
			if(!cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS))
				cafePro.raiseSelectBoisson();
			if(cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS)) {
				lblLedExpreso.setVisible(false);
				lblLedExpressoMacch.setVisible(false);
				lblLedCappucino.setVisible(false);
				lblLedCafe.setVisible(false);
				lblLedMachiato.setVisible(false);
				lblLedCafeLait.setVisible(true);
				lblLedMousseLait.setVisible(false);
				lblLedBoissonSpecial.setVisible(false);
				lblAffichInfo.setText("Café au lait");
				intensiteCafe.setText(configUsine.getListIintensiteCafe().get(configUsine.getIntensiteCafeLacte()));
				cafePro.setIntensiteCafe(configUsine.getIntensiteCafeLacte());
				qteBoisson.setText(configUsine.getListQteBoisson().get(configUsine.getQteCafeLacte()));
				cafePro.setQteBoisson(configUsine.getQteCafeLacte());
				cafePro.setProportionLait(configUsine.getProporLaitCafeLacte());
			}
		}
		else if(event.getTarget()==btnMacchiato){
			cafePro.setTypeBoisson(3);
			if(!cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS))
				cafePro.raiseSelectBoisson();
			if(cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS)) {
				lblLedExpreso.setVisible(false);
				lblLedExpressoMacch.setVisible(false);
				lblLedCappucino.setVisible(false);
				lblLedCafe.setVisible(false);
				lblLedMachiato.setVisible(true);
				lblLedCafeLait.setVisible(false);
				lblLedMousseLait.setVisible(false);
				lblLedBoissonSpecial.setVisible(false);
				lblAffichInfo.setText("Latte Macchiato");
				intensiteCafe.setText(configUsine.getListIintensiteCafe().get(configUsine.getIntensiteLatteMacchiato()));
				cafePro.setIntensiteCafe(configUsine.getIntensiteLatteMacchiato());
				qteBoisson.setText(configUsine.getListQteBoisson().get(configUsine.getQteLatteMacchiato()));
				cafePro.setQteBoisson(configUsine.getQteLatteMacchiato());
				cafePro.setProportionLait(configUsine.getProporLaitLatteMacchiato());
			}
		}
		else if(event.getTarget()==btnCappucino) {
			cafePro.setTypeBoisson(3);
			if(!cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS))
				cafePro.raiseSelectBoisson();
			if(cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS)) {
				lblLedExpreso.setVisible(false);
				lblLedExpressoMacch.setVisible(false);
				lblLedCappucino.setVisible(true);
				lblLedCafe.setVisible(false);
				lblLedMachiato.setVisible(false);
				lblLedCafeLait.setVisible(false);
				lblLedMousseLait.setVisible(false);
				lblLedBoissonSpecial.setVisible(false);
				lblAffichInfo.setText("Cappuccino");
				intensiteCafe.setText(configUsine.getListIintensiteCafe().get(configUsine.getIntensiteCappuccino()));
				cafePro.setIntensiteCafe(configUsine.getIntensiteCappuccino());
				qteBoisson.setText(configUsine.getListQteBoisson().get(configUsine.getQteCappuccino()));
				cafePro.setQteBoisson(configUsine.getQteCappuccino());
				cafePro.setProportionLait(configUsine.getProporLaitCappuccino());
			}
		}
	}
	// permet d'affecter aux boissons speciales le type de boisson correspondant et de les afficher a l'ecran
	public void gestionBoissonSpecial(CafePro cafePro,Label lblAffichInfo,Label qteBoisson,Label intensiteCafe,Label lblLedExpreso,Label lblLedExpressoMacch,Label lblLedCappucino,Label lblLedCafe,Label lblLedMachiato,Label lblLedCafeLait,Label lblLedMousseLait,Label lblLedBoissonSpecial) {
		if(cafePro.isStateActive(State.MAIN_IDLE)) {
				cafePro.raiseSelectBoisson();
				cafePro.setIndice(0);
				lblAffichInfo.setText(listBoissonSpecial.get(0));
				lblLedExpreso.setVisible(false);
				lblLedExpressoMacch.setVisible(false);
				lblLedCappucino.setVisible(false);
				lblLedCafe.setVisible(false);
				lblLedMachiato.setVisible(false);
				lblLedCafeLait.setVisible(false);
				lblLedMousseLait.setVisible(false);
				lblLedBoissonSpecial.setVisible(true);
				cafePro.setTypeBoisson(4);
				intensiteCafe.setText("");
				qteBoisson.setText(configUsine.getListQteBoisson().get(configUsine.getQteEauChaude()));
				cafePro.setQteBoisson(configUsine.getQteEauChaude());
		}
		if(cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS)) {
			cafePro.raiseSelectBoissonSpecial();
			int next=(int)cafePro.getIndice();
			lblAffichInfo.setText(listBoissonSpecial.get(next));
			lblLedExpreso.setVisible(false);
			lblLedExpressoMacch.setVisible(false);
			lblLedCappucino.setVisible(false);
			lblLedCafe.setVisible(false);
			lblLedMachiato.setVisible(false);
			lblLedCafeLait.setVisible(false);
			lblLedMousseLait.setVisible(false);
			lblLedBoissonSpecial.setVisible(true);
			if(next==0) {
				cafePro.setTypeBoisson(4);
				lblAffichInfo.setText(listBoissonSpecial.get(0));
				intensiteCafe.setText("");
				qteBoisson.setText(configUsine.getListQteBoisson().get(configUsine.getQteEauChaude()));
				cafePro.setQteBoisson(configUsine.getQteEauChaude());
			}
			else if(next==1) {
				cafePro.setTypeBoisson(2);
				lblAffichInfo.setText(listBoissonSpecial.get(1));
				intensiteCafe.setText("");
				qteBoisson.setText(configUsine.getListQteBoisson().get(configUsine.getQteLaitChaud()));
				cafePro.setQteBoisson(configUsine.getQteLaitChaud());
			}
			else if(next==2) {
				cafePro.setTypeBoisson(1);
				lblAffichInfo.setText(listBoissonSpecial.get(2));
				intensiteCafe.setText(configUsine.getListIintensiteCafe().get(configUsine.getIntensiteVerseuse()));
				cafePro.setIntensiteCafe(configUsine.getIntensiteVerseuse());
				qteBoisson.setText(configUsine.getListQteBoisson().get(configUsine.getQteVerseuse()));
				cafePro.setQteBoisson(configUsine.getQteVerseuse());
			}
			else if(next==3) {
				cafePro.setTypeBoisson(1);
				lblAffichInfo.setText(listBoissonSpecial.get(3));
				intensiteCafe.setText(configUsine.getListIintensiteCafe().get(configUsine.getIntensiteAmericano()));
				cafePro.setIntensiteCafe(configUsine.getIntensiteAmericano());
				qteBoisson.setText(configUsine.getListQteBoisson().get(configUsine.getQteAmericano()));
				cafePro.setQteBoisson(configUsine.getQteAmericano());
			}
			else if(next==4) {
				cafePro.setTypeBoisson(3);
				lblAffichInfo.setText(listBoissonSpecial.get(4));
				intensiteCafe.setText(configUsine.getListIintensiteCafe().get(configUsine.getIntensiteFlatWhite()));
				cafePro.setIntensiteCafe(configUsine.getIntensiteFlatWhite());
				qteBoisson.setText(configUsine.getListQteBoisson().get(configUsine.getQteFlatWhite()));
				cafePro.setQteBoisson(configUsine.getQteFlatWhite());
				cafePro.setProportionLait(configUsine.getProporLaitFlatWhite());
			}
			else if(next==5) {
				cafePro.setTypeBoisson(3);
				if(cafePro.getLangue()==true) {
					lblAffichInfo.setText(listBoissonSpecial.get(5));
					intensiteCafe.setText(configUsine.getListIintensiteCafe().get(configUsine.getIntensiteCafeCortado()));
					cafePro.setIntensiteCafe(configUsine.getIntensiteCafeCortado());
					qteBoisson.setText(configUsine.getListQteBoisson().get(configUsine.getQteCafeCortado()));
					cafePro.setQteBoisson(configUsine.getQteCafeCortado());
					cafePro.setProportionLait(configUsine.getProporLaitCafeCortado());
				}
				else {
					lblAffichInfo.setText(listBoissonSpecial1.get(5));
					intensiteCafe.setText(configUsine.getListIintensiteCafe1().get(configUsine.getIntensiteCafeCortado()));
					cafePro.setIntensiteCafe(configUsine.getIntensiteCafeCortado());
					qteBoisson.setText(configUsine.getListQteBoisson().get(configUsine.getQteCafeCortado()));
					cafePro.setQteBoisson(configUsine.getQteCafeCortado());
					cafePro.setProportionLait(configUsine.getProporLaitCafeCortado());
				}
			}
		}
	}
	
	public void playStop(CafePro cafePro) {
		if(cafePro.isStateActive(State.MAIN_STOP)) {
			cafePro.raiseStart();
		}
		else  if(cafePro.isStateActive(State.MAIN_IDLE)) {
			cafePro.raiseStop();
		}
		else if(cafePro.isStateActive(State.MAIN_PREPARATION))
    		cafePro.raiseBtnStartStop();
		else if(cafePro.isStateActive(State.MAIN_MENU_R1_EFFECTUERMAINTENANCE))
    		cafePro.raiseStart();
	}
}
