package model;

import javafx.application.Platform;
import javafx.scene.control.Label;
import stateChart_gen.CafePro;

public class ReservoirCafe {

	CafePro cafePro;
	int capaciteMaxCafe = 50; 
	  
	public ReservoirCafe(CafePro cafePro) {
		this.cafePro = cafePro;
		cafePro.setQteCafe(capaciteMaxCafe);
		
	}
	public void ajouterCafe(int quantite) {
		if(cafePro.getQteCafe()+quantite>=0)
			if(cafePro.getQteCafe()+quantite<=capaciteMaxCafe)
				cafePro.setQteCafe(cafePro.getQteCafe()+quantite);
			else
				cafePro.setQteCafe(capaciteMaxCafe);
	} 
	public void afficherNivoCafe(Label lblCafe){
		Platform.runLater(() ->lblCafe.setText(cafePro.getQteCafe()+""));	
	} 
}
