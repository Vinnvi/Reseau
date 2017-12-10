import java.util.ArrayList;


public class Carrefour extends Jonction{
	ArrayList <SegmentRoute> listeRoutes = new ArrayList<>();
	
	
	public Carrefour(int id){
		this.setId(id);
	}
	
	public void addRoute(SegmentRoute s){
		listeRoutes.add(s);
	}
	
	@Override
	public void avancer(Voiture v,int distanceRestante){
		
		int nextStep = -1;
		do{
			nextStep = (int) (Math.random() * ( listeRoutes.size()));
		}while(listeRoutes.get(nextStep)==v.etat.getSegment());
		System.out.println(nextStep);
		v.etat.setSegment(listeRoutes.get(nextStep));
		if(v.etat.getSegment().getJonctionFalse()==this){ // si on arrive depuis la gauche
			v.etat.setSens(true);
			if(v.etat.getSegment().getLongueur()+this.getLongueur()>distanceRestante) { //Si on reste bien sur le meme segment à la fin
				v.etat.setPositionSegement(distanceRestante-this.getLongueur());
			}
			else {
				distanceRestante -= v.etat.getSegment().getLongueur()+this.getLongueur();
				v.etat.getSegment().getJonctionTrue().avancer(v,distanceRestante);
			}
		}
		else{//Si on arrive depuis la droite
			v.etat.setSens(false);
			if(v.etat.getSegment().getLongueur()+this.getLongueur()>distanceRestante) { //Si on reste bien sur le meme segment
				v.etat.setPositionSegement(v.etat.getSegment().getLongueur()+this.getLongueur()-distanceRestante);				
			}
			else {
				distanceRestante -= v.etat.getSegment().getLongueur()+this.getLongueur();
				v.etat.getSegment().getJonctionFalse().avancer(v, distanceRestante);
			}
		}
	}

	@Override
	public void addSegment(SegmentRoute s, boolean sens) {
		listeRoutes.add(s);
	}
}
