package model;

import javafx.application.Platform;
import javafx.scene.control.Label;
import stateChart_gen.CafePro;

public class ReservoirEau {
	
	CafePro cafePro= new CafePro();
	  int capaciteMaxReservoir = 80; 
	  
	public ReservoirEau(CafePro cafePro) {
		this.cafePro = cafePro;
		cafePro.setQteEau(capaciteMaxReservoir);
	}

	public void ajouterEau(int quantite) {
		if(cafePro.getQteEau()+quantite>=0)
			if(cafePro.getQteEau()+quantite<=capaciteMaxReservoir)
				cafePro.setQteEau(cafePro.getQteEau()+quantite);
			else
				cafePro.setQteEau(capaciteMaxReservoir);
	} 
	
	public void afficherNivoEau(Label lblEau) {
		Platform.runLater(() ->lblEau.setText(cafePro.getQteEau()+""));	
	} 
}
