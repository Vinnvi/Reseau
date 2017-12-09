
public class Voiture <S extends Semaphore>{
	private int id;
	private int vitesseMax;
	EtatCourant etat;
	
	public Voiture(int i,int vM,EtatCourant e){
		id = i;
		vitesseMax = vM;
		etat = e;
	}
	
	
	public void avancer(){
		if(etat.isSens()){
			//First case : car stay in the same segment
			if(etat.getPositionSegement()+etat.getVitesseActuelle()<etat.getSegment().getLongueur()){
				this.etat.setPositionSegement(etat.getPositionSegement()+etat.getVitesseActuelle());
				System.out.println("La voiture "+this.getId()+" a avance jusqu'a la position "+this.etat.getPositionSegement()+" du segment"+ this.etat.getSegment().getName());
				
			}
			//Second case : car change segment
			else {
				int distanceRestante = etat.getSegment().getLongueur()-etat.getPositionSegement();
				this.etat.setPositionSegement(this.etat.getSegment().getLongueur());
				this.etat.getSegment().getJonctionTrue().avancer(this,distanceRestante);
			}
		}
		else{
			
		}
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getVitesseMax() {
		return vitesseMax;
	}


	public void setVitesseMax(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}
	
}
