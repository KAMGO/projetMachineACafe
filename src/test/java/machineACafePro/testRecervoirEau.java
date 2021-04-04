package machineACafePro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.ReservoirEau;
import stateChart_gen.CafePro;

public class testRecervoirEau {
	CafePro cafePro;
	ReservoirEau reservoirEau;
	@BeforeEach
	public void Avant() {
	 cafePro = new CafePro();
	 reservoirEau=new ReservoirEau(cafePro);
	 reservoirEau.ajouterEau(-80); //vide le recervoir
	}
	
	
	@Test
	public void testAjoutCafe() {
		reservoirEau.ajouterEau(10); //ajout 10
		assertEquals(10, (int)cafePro.getQteEau());
		reservoirEau.ajouterEau(100); //ajout 100
		assertEquals(80, (int)cafePro.getQteEau());//j ai considere que si on ajouter plus que le recervoir, il prend uniquement le max du recervoir
		reservoirEau.ajouterEau(-90); //ajout -60 // il yavait 80 -60=-20 donc il ne fait rien et concerve 50
		assertEquals(80, (int)cafePro.getQteEau());
	}
}
