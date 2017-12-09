
public abstract class Jonction {
	private int longueur=1;
	private int id;
	public void avancer(Voiture v,int distanceRestante) {
		
	}
	public int getLongueur() {
		return longueur;
	}
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public abstract void addSegment(SegmentRoute s,boolean sens);
	
}
