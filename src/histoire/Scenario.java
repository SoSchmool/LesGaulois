package histoire;
import histoire.personnages.*;


public class Scenario {

	public static void main(String[] args) {
		Gaulois g1 = new Gaulois("Asterix", 8);
		Gaulois g2 = new Gaulois("Obélix", 10);
		Romain r1 = new Romain("Minus", 6);
		Druide d1 = new Druide("Panoramix", 5, 10);
		d1.prendreParole();
		d1.preparerPotion();
		d1.booster(g2);
		g2.prendreParole();
		g2.parler("Par Bélénos, ce n'est pas juste ! ");
		g1.boirePotion(d1);
		g1.prendreParole();
		g1.parler("Bonjour à tous ");
		r1.prendreParole();
		r1.parler("UN GAU... UN GAUGAU...");
		for(int i=0; i<3; i++) {
			g1.frapper(r1);
		}
		
	}

}
