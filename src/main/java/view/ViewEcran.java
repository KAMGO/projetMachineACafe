package view;

import java.util.ArrayList;

import javafx.scene.control.Label;
import stateChart_gen.CafePro;
import stateChart_gen.CafePro.State;

public class ViewEcran {
	ArrayList<String> listIintensiteCafe = new ArrayList<String>(){{ add("tres doux");add("doux");add("normal");add("fort");add("tres fort");
	add("doubleshot fort");add("doubleshot fort+");add("comp. poudre");}};
	ArrayList<String> listQteBoisson = new ArrayList<String>(){{ add("petit");add("moyen");add("grand");}};
	ArrayList<String> listQteBoisson1 = new ArrayList<String>(){{ add("small");add("medium");add("big");}};
	ArrayList<String> listIintensiteCafe1 = new ArrayList<String>(){{ add("very soft");add("soft");add("normal");add("strong");add("very strong");
	add("doubleshot fort");add("doubleshot fort+");add("comp. powder");}};
	public void choisirIntensiteCafe(CafePro cafePro,Label lblIntesiteCafe) {
		if(cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS)) {
			if(cafePro.getTypeBoisson()!=4 &&cafePro.getTypeBoisson()!=2) {
				cafePro.raiseBtnIntensiteCafe();
				lblIntesiteCafe.setText(listIintensiteCafe.get((int)cafePro.getIntensiteCafe()));
			}
		}
	}
	public void choisirQteBoisson(CafePro cafePro,Label lblQteBoisson) {
		if(cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS)) {
			cafePro.raiseBtnQteBoisson();
			lblQteBoisson.setText(listQteBoisson.get((int)cafePro.getQteBoisson()));
		}
	}
	public void appelBoissonFavori(CafePro cafePro,Label lblAfficheInfo,ConfigUsine configUsine) {
		if(cafePro.isStateActive(State.MAIN_IDLE)) {
			cafePro.raiseBtnAppelFavori();
			lblAfficheInfo.setVisible(true);
			lblAfficheInfo.setText(configUsine.getListProfilFavori().get((int) cafePro.getIndice()).getNomFavori());
		}
		else if(cafePro.isStateActive(State.MAIN_APPELFAVORI)) {
			cafePro.raiseBtnAppelFavori();
			lblAfficheInfo.setText(configUsine.getListProfilFavori().get((int) cafePro.getIndice()).getNomFavori());
		}
	}
	public String preparerBoissonFavori(CafePro cafePro,ConfigUsine configUsine){
		String message=null;
		if(cafePro.isStateActive(State.MAIN_APPELFAVORI)){
			Profil profil = configUsine.getListProfilFavori().get((int) cafePro.getIndice());
			if(profil.getTypeBoisson()==1) {//preparation boissson au cafe 
				if(profil.getIntensiteCafe()==null || profil.getQteBoisson()==null) {
					if(cafePro.getLangue()==true)
						message="parramettrage profil inacheve veuillez le terminer";
					else
						message="parametrisation unfinished profile please complete it";
					cafePro.setProfilEstConfig(false);
				}
				else {
					cafePro.setProfilEstConfig(true);
					//cafePro.raiseBtnStartStop();
				}
			}
			else if(profil.getTypeBoisson()==2) { //prepararion Lait
				if(profil.getIntensiteCafe()==null || profil.getQteBoisson()==null) {
					if(cafePro.getLangue()==true)
						message="parramettrage profil inacheve veuillez le terminer";
					else
						message="parametrisation unfinished profile please complete it";
					cafePro.setProfilEstConfig(false);
				}
				else {
					cafePro.setProfilEstConfig(true);
					//cafePro.raiseBtnStartStop();
				}
			}
			else if(profil.getTypeBoisson()==3) { //preparation boisson Lactee
				if(profil.getIntensiteCafe()==null || profil.getQteBoisson()==null||profil.getProportionLait()==-1) {
					if(cafePro.getLangue()==true)
						message="parramettrage profil inacheve veuillez le terminer";
					else
						message="parametrisation unfinished profile please complete it";
					cafePro.setProfilEstConfig(false);
				}
				else {
					cafePro.setProfilEstConfig(true);
					//cafePro.raiseBtnStartStop();
				}
			}
			else if(profil.getTypeBoisson()==4){	//preparation eau chaude			
				if( profil.getQteBoisson()==null) {
					if(cafePro.getLangue()==true)
						message="parramettrage profil inacheve veuillez le terminer";
					else
						message="parametrisation unfinished profile please complete it";
					cafePro.setProfilEstConfig(false);
				}
				else {
					cafePro.setProfilEstConfig(true);
				}
			}
			else {
				if(cafePro.getLangue()==true)
					message ="profil favori non paramettre ";
				else
					message="favorite profile no parameter";
				cafePro.setProfilEstConfig(false);
			}
			cafePro.raiseBtnStartStop();
		}
		return message;
	}
	
}
