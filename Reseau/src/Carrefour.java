import java.util.ArrayList;


public class Carrefour extends Jonction{
	ArrayList <SegmentRoute> listeRoutes = new ArrayList<>();
	
	
	public Carrefour(){
		
	}
	
	public void addRoute(SegmentRoute s){
		listeRoutes.add(s);
	}
	
	@Override
	public void avancer(Voiture v,int distanceRestante){
		int nextStep = 0;
		do{
			nextStep = (int) (Math.random() * ( listeRoutes.size()-1 ));
		}while(listeRoutes.get(nextStep)==v.etat.getSegment());
		
		v.etat.setSegment(listeRoutes.get(nextStep));
		if(v.etat.getSegment().getJonctionFalse()==this){ // si on arrive depuis la gauche
			if(v.etat.getSegment().getLongueur()+this.getLongueur()>distanceRestante) { //Si on reste bien sur le meme segment à la fin
				v.etat.setPositionSegement(distanceRestante-this.getLongueur());
			}
			else {
				distanceRestante -= v.etat.getSegment().getLongueur()+this.getLongueur();
				v.etat.getSegment().getJonctionTrue().avancer(v,distanceRestante);
			}
		}
		else{//Si on arrive depuis la droite
			if(v.etat.getSegment().getLongueur()+this.getLongueur()>distanceRestante) { //Si on reste bien sur le meme segment
				v.etat.setPositionSegement(v.etat.getSegment().getLongueur()+this.getLongueur()-distanceRestante);				
			}
			else {
				distanceRestante -= v.etat.getSegment().getLongueur()+this.getLongueur();
				v.etat.getSegment().getJonctionFalse().avancer(v, distanceRestante);
			}
		}
	}
}
