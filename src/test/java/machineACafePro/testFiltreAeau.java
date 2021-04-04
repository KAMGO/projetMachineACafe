package machineACafePro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.scene.control.Label;
import model.FiltreAeau;
import machineACafePro.CafeController.*;
import stateChart_gen.CafePro;

public class testFiltreAeau {
	CafePro cafePro;
	FiltreAeau filtre;
	Label lblFiltreEau;
	@BeforeEach
	public void Avant() {
	 cafePro = new CafePro();
	 filtre=new FiltreAeau(cafePro);
	}
	
	
	@Test
	public void testEtatFiltre() {
		cafePro.setEtatDuFiltre(1);
		filtre.controlEtatFiltre(lblFiltreEau); //si filtre place, pour dedartre il faut 15
		assertEquals(15, (int)cafePro.getMaxBoissonForDetardrage());
		cafePro.setEtatDuFiltre(0);
		filtre.controlEtatFiltre(lblFiltreEau); //si filtre place n'est pas place, pour dedartre il faut 10
		assertEquals(10, (int)cafePro.getMaxBoissonForDetardrage());
		
		//verification des message affiche apres un certain nombre de boisson preparee
		cafePro.setFiltrePlace(true);cafePro.setEtatDuFiltre(1);cafePro.setCounterForFiltre(9);
		filtre.controlEtatFiltre(lblFiltreEau);
		assertEquals(1, (int)cafePro.getEtatDuFiltre());
		assertEquals("veuillez remplacer le filtre a eau", filtre.controlEtatFiltre(lblFiltreEau)); //ce message car le nombre de boisson preparer est entre 5 et 2*5
		cafePro.setFiltrePlace(true);cafePro.setEtatDuFiltre(1);cafePro.setCounterForFiltre(5);
		assertEquals(null, filtre.controlEtatFiltre(lblFiltreEau));// aucun message car le filtre est encore en bonne etat
		
	}
}
