package model;

import javafx.application.Platform;
import javafx.scene.control.Label;
import stateChart_gen.CafePro;
import stateChart_gen.CafePro.State;

public class FiltreAeau {
private int maxBoissonForChangeFiltre = 5;
private CafePro cafePro;

	public FiltreAeau(CafePro cafePro) {
		this.cafePro = cafePro;
		this.cafePro.setMaxBoissonForChangeFiltre(maxBoissonForChangeFiltre);
	}
	//cette methode permet de remplacer(retire et remettre ) le filtre.une fois le filtre place faut l'activer dans le menu
	public void FiltreRemplace(Label lblFiltreEau,Label lblPbfiltre){
    	if(cafePro.isStateActive(State.MAIN_STOP)){ // j ai consideré que pour placer ou retire un filtre il faut que la machine soit eteinte
    		if(cafePro.getFiltrePlace()==true) {
    			cafePro.setFiltrePlace(false);
    			cafePro.setEtatDuFiltre(0);
    			cafePro.setPbFiltreEau(false);// car si le filtre etait en panne en le retirant la panne doit disparaitre
    			lblFiltreEau.setText(0+"");
    			lblPbfiltre.setText(0+"");
    		}
    		else {
    			cafePro.setFiltrePlace(true);
    			lblFiltreEau.setText(1+"");
    			//cafePro.setEtatDuFiltre(true);
    		}
    	}	
	}
	public String controlEtatFiltre(Label lblFiltreEau) {
		String message=null;
		if(cafePro.getEtatDuFiltre()==1) //si le filtre est placé et est en bonne etat alors le detartrage est fait a 15 
			cafePro.setMaxBoissonForDetardrage(15);
		else
			cafePro.setMaxBoissonForDetardrage(10); //sinon le detardrage est fait a 10  car plus de depot de tardre quand l'eau n est pas filtre
		if(cafePro.getFiltrePlace()==true&&cafePro.getEtatDuFiltre()==1&&cafePro.getCounterForFiltre()>maxBoissonForChangeFiltre) {
			message="veuillez remplacer le filtre a eau";
		}
		if(cafePro.getFiltrePlace()==true&&cafePro.getEtatDuFiltre()==1&&cafePro.getCounterForFiltre()>2*maxBoissonForChangeFiltre) {//ici je considere le filtre en panne 
			cafePro.setEtatDuFiltre(2); // Etat du filtre renvoie true si le filtre est encore bon et false sinon. A l'activation d'un new filtre il est a true
		}
		if(cafePro.getEtatDuFiltre()==2) {
			Platform.runLater(() ->lblFiltreEau.setText(2+""));
			message="filtre defectueux veuillez le remplacer";
		}
		if(cafePro.getEtatDuFiltre()==0&&cafePro.getFiltrePlace()==false)
			message="veuillez placer un filtre a eau et l'activer ";
		if(cafePro.getEtatDuFiltre()==0&&cafePro.getFiltrePlace()==true)
			message="veuillez activer le filtre a eau ";
		
		return message;
	}
}
