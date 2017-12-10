
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
			//First case : car stays in the same segment
			if(etat.getPositionSegement()+etat.getVitesseActuelle()<etat.getSegment().getLongueur()){
				int positionBefore = etat.getPositionSegement();
				this.etat.setPositionSegement(etat.getPositionSegement()+etat.getVitesseActuelle());
				int positionAfter = etat.getPositionSegement();
				etat.getSegment().notifierObservateurs(this, positionBefore, positionAfter);
				
			}
			//Second case : car changes segment
			else {
				int positionBefore = etat.getPositionSegement();
				int distanceRestante = etat.getSegment().getLongueur()-etat.getPositionSegement();
				this.etat.setPositionSegement(this.etat.getSegment().getLongueur());
				etat.getSegment().notifierObservateurs(this, positionBefore, etat.getSegment().getLongueur()); // On notifie les observateurs sur la fin de la portion
				this.etat.getSegment().getJonctionTrue().avancer(this,distanceRestante);
			}
		}
		else{
			//First case : car stays in the same segment
			if(etat.getPositionSegement()>etat.getVitesseActuelle()) {
				int positionBefore = etat.getPositionSegement();
				etat.setPositionSegement(etat.getPositionSegement()-etat.getVitesseActuelle());
				int positionAfter = etat.getPositionSegement();
				etat.getSegment().notifierObservateurs(this, positionBefore, positionAfter);
				
			}
			// Second case : car changes segment
			else{
				int positionBefore = etat.getPositionSegement();
				int distanceRestante = etat.getVitesseActuelle()-etat.getPositionSegement();
				this.etat.setPositionSegement(0);
				etat.getSegment().notifierObservateurs(this, positionBefore, 0);
				this.etat.getSegment().getJonctionFalse().avancer(this, distanceRestante);
			}
		}
		System.out.println("La voiture "+this.getId()+" a avance jusqu'a la position "+this.etat.getPositionSegement()+" du segment"+ this.etat.getSegment().getName());

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
