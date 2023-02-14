package histoire.personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	public String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}


	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup((force / 3)*this.effetPotion);
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public void boirePotion(Druide druide) {
		if (druide.forcePotion == 3) {
			parler("Merci Druide, je sens que ma force est 3 fois décuplée");
		}
		this.effetPotion = this.effetPotion + druide.forcePotion;
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("asterix", 8);
		Romain romain1 = new Romain("soldat nul", 6);
		Druide d1 = new Druide("Panoramix", 2, 4);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		asterix.prendreParole();
		asterix.parler("C'est ciao ");
		asterix.frapper(romain1);
		asterix.boirePotion(d1);
		asterix.frapper(romain1);

	}

}