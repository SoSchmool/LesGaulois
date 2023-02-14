package histoire.lieu;
import histoire.personnages.*;


public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMax) {
		this.nom = nom;
		this.villageois=new Gaulois[nbVillageoisMax];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois, int place) {
		this.villageois[place] = gaulois;
		this.nbVillageois+=1;
	}
	
	public Gaulois trouverHabitant(int place) {
		return this.villageois[place];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans village du chef " + this.chef.getNom() + " vivent les légendaires gaulois :");
		for(int i=0; i<nbVillageois; i++){
			System.out.println(this.villageois[i].getNom());
		}
	}
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		//Gaulois gaulois = village.trouverHabitant(30);
		//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 30 out of bounds for length 30
		//at histoire.lieu.Village.trouverHabitant(Village.java:30)
		//at histoire.lieu.Village.main(Village.java:35)

		Chef chef = new Chef("Abraracourcix", 6, village);
		Gaulois g1 = new Gaulois("Astérix", 8);
		village.setChef(chef);
		village.ajouterHabitant(g1, 0);
		//Gaulois gaulois = village.trouverHabitant(1);
		//System.out.println(gaulois);
		//null
		Gaulois g2 = new Gaulois("Obélix", 25);
		village.ajouterHabitant(g2, 1);
		village.afficherVillageois();
	}
	
	
}