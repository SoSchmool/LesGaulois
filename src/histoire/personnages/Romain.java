package histoire.personnages;


public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement;
	private int nbEquipement;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.equipement = new Equipement[2];
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	public String prendreParole() {
		return "Le romain " + nom + " : ";
	}


	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if(force == 0) {
			parler("Aïe");
		}else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force à diminuer
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			parler("\nMais heureusement, grace à mon équipement sa force est diminué de ");
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipement[i] != null && equipement[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte = +resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipement[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipement[i];
				nbEquipementEjecte++;
				equipement[i] = null;
			}
		}
		return equipementEjecte;
	}

	

	public void sEquiper(Equipement equipements) {
		final String SOLDAT = "Le soldat";
		if (this.nbEquipement == 2) {
			System.out.println(SOLDAT + this.nom + " est déjà bien protégé !");
		} else {
			switch (equipements) {
			case BOUCLIER:
				if (this.equipement[1] == Equipement.BOUCLIER) {
					System.out.println(SOLDAT + this.nom + " possède déjà un bouclier");
					break;
				} else {
					this.equipement[1] = Equipement.BOUCLIER;
					this.nbEquipement += 1;
					System.out.println(SOLDAT + this.nom + " s'équipe avec un bouclier");
					break;
				}
			case CASQUE:
				if (this.equipement[0] == Equipement.CASQUE) {
					System.out.println(SOLDAT + this.nom + " possède déjà un casque");
					break;
				} else {
					this.equipement[0] = Equipement.CASQUE;
					this.nbEquipement += 1;
					System.out.println(SOLDAT + this.nom + " s'équipe avec un casque");
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Romain romain1 = new Romain("Minus", 6);
		romain1.prendreParole();
		romain1.parler("t'es qui même ? ");
		romain1.recevoirCoup(3);
		romain1.recevoirCoup(5);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		romain1.sEquiper(Equipement.CASQUE);
		romain1.sEquiper(Equipement.CASQUE);
		romain1.sEquiper(Equipement.BOUCLIER);
		romain1.sEquiper(Equipement.BOUCLIER);

	}
}
