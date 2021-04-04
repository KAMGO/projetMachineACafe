
package model;

import javafx.application.Platform;
import javafx.scene.control.Label;
import stateChart_gen.CafePro;

public class BacCollecteur {
	CafePro cafePro;
	
	public BacCollecteur(CafePro cafePro) {
		this.cafePro = cafePro;
	}

	public void viderBacCollecteur() {
		cafePro.setNivoCollecteur(0);
	}
	
	public void affichNivoBacCollecteur(Label lblBacCollecteur) {
		Platform.runLater(() ->lblBacCollecteur.setText(cafePro.getNivoCollecteur()+""));
	}
}
