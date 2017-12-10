
public class PassagePieton extends JonctionSimple{
	
	public PassagePieton(int id){
		this.setId(id);
	}
	
	@Override
	public void avancer(Voiture v,int distanceRestante){
		if(v.etat.getSegment() == this.getsFalse()){
			v.etat.setSegment(this.getsTrue());
			v.etat.setPositionSegement(distanceRestante-this.getLongueur());
		}
		else{
			
			v.etat.setSegment(this.getsFalse());
			v.etat.setPositionSegement(v.etat.getSegment().getLongueur()+1-distanceRestante);
		}
		System.out.println("La voiture "+v.getId()+" traverse le passage pieton "+this.getId());
	}
}	
