package view;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import stateChart_gen.CafePro;

public class ViewPanne {
	Button btnPanneMoulin;
	Button btnPanneMousseur;
	Button btnDefaillance;
	Button btnPanneFiltre;
	Button btnPanneBandeau;
	Button btnPanneEcran;
	public ViewPanne(Button btnPanneMoulin, Button btnPanneMousseur, Button btnDefaillance, Button btnPanneFiltre,
			Button btnPanneBandeau, Button btnPanneEcran) {
		this.btnPanneMoulin = btnPanneMoulin;
		this.btnPanneMousseur = btnPanneMousseur;
		this.btnDefaillance = btnDefaillance;
		this.btnPanneFiltre = btnPanneFiltre;
		this.btnPanneBandeau = btnPanneBandeau;
		this.btnPanneEcran = btnPanneEcran;
	}
	public void panne(MouseEvent event,CafePro cafePro,Pane paneEcran, Label lblPanneMoulin,Label lblPanneMousseur,Label lblDefaillance, Label lblPanneFiltre ,Label lblPanneBandeau ,Label lblPanneEcran) {
		if(event.getSource()==btnPanneMoulin){
			if(cafePro.getPbMoulin()==true) {
				lblPanneMoulin.setText(0+"");
				cafePro.setPbMoulin(false);
			}
			else {
				cafePro.setPbMoulin(true);
				lblPanneMoulin.setText(1+"");
			}
		}
		else if(event.getSource()==btnPanneMousseur){
			if(cafePro.getPbMousseurLait()==true) {
				lblPanneMousseur.setText(0+"");
				cafePro.setPbMousseurLait(false);
			}
			else {
				cafePro.setPbMousseurLait(true);
				lblPanneMousseur.setText(1+"");
			}
		}
		else if(event.getSource()==btnDefaillance){
			if(cafePro.getPbDefailanceSys()==true){
				lblDefaillance.setText(0+"");
				cafePro.setPbDefailanceSys(false);
			}
			else {
				cafePro.setPbDefailanceSys(true);
				lblDefaillance.setText(1+"");
			}	
		}
		else if(event.getSource()==btnPanneFiltre){
			if(cafePro.getFiltrePlace()==true&&cafePro.getEtatDuFiltre()==1){//car le filtre doit etre au prealable placé
				lblPanneFiltre.setText(1+"");
				cafePro.setPbFiltreEau(false);
				cafePro.setEtatDuFiltre(2);
			}
		}
		else if(event.getSource()==btnPanneEcran){
			if(cafePro.getPbEcran()==true){
				lblPanneEcran.setText(0+"");
				cafePro.setPbEcran(false);
			}
			else{
				cafePro.setPbEcran(true);
				lblPanneEcran.setText(1+"");
			}	
		}
		else if(event.getSource()==btnPanneBandeau){
			if(cafePro.getPbBandeau()==true){
				lblPanneBandeau.setText(0+"");
				cafePro.setPbBandeau(false);
			}
			else{
				cafePro.setPbBandeau(true);
				lblPanneBandeau.setText(1+"");
			}	
		}
	}
}

