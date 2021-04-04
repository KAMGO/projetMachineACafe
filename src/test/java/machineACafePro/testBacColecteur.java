package machineACafePro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.BacCollecteur;
import stateChart_gen.CafePro;

public class testBacColecteur {
	CafePro cafePro;
	BacCollecteur bacCollecteur;
	@BeforeEach
	public void Avant() {
	 cafePro = new CafePro();
	 bacCollecteur=new BacCollecteur(cafePro);
	}
	
	
	@Test
	public void testVideBacCollect() {
		bacCollecteur.viderBacCollecteur(); //je verifie si en mettant le bac a 0 il le fait effectivement
		assertEquals(0, (int)cafePro.getNivoCollecteur());
	}
}
