package machineACafePro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import model.ReservoirCafe;
import stateChart_gen.CafePro;

public class testRecervoirCafe {
	CafePro cafePro;
	ReservoirCafe reservoirCafe;
	@BeforeEach
	public void Avant() {
	 cafePro = new CafePro();
	 reservoirCafe=new ReservoirCafe(cafePro);
	 reservoirCafe.ajouterCafe(-50); //vide le bac
	}
	
	
	@Test
	public void testAjoutCafe() {
		reservoirCafe.ajouterCafe(10); //ajout 10
		assertEquals(10, (int)cafePro.getQteCafe());
		reservoirCafe.ajouterCafe(100); //ajout 100
		assertEquals(50, (int)cafePro.getQteCafe());//j ai considere que si on ajouter plus que le recervoir, il prend uniquement le max du recervoir
		reservoirCafe.ajouterCafe(-60); //ajout -60 // il yavait 50 -60=-10 donc il ne fait rien et concerve 50
		assertEquals(50, (int)cafePro.getQteCafe());
	}
}
