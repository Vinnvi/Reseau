
public class EtatCourant {
	SegmentRoute segment;
	int positionSegement;
	boolean sens;
	int vitesseActuelle;
	
	public EtatCourant(SegmentRoute s,int p,boolean sens,int v){
		segment = s;
		positionSegement = p;
		this.sens = sens;
		vitesseActuelle = v;
	}

	public SegmentRoute getSegment() {
		return segment;
	}

	public void setSegment(SegmentRoute segment) {
		this.segment = segment;
	}

	public int getPositionSegement() {
		return positionSegement;
	}

	public void setPositionSegement(int positionSegement) {
		this.positionSegement = positionSegement;
	}

	public boolean isSens() {
		return sens;
	}

	public void setSens(boolean sens) {
		this.sens = sens;
	}

	public int getVitesseActuelle() {
		return vitesseActuelle;
	}

	public void setVitesseActuelle(int vitesseActuelle) {
		this.vitesseActuelle = vitesseActuelle;
	}
	
	
}
