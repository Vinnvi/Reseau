
public class PassagePieton extends JonctionSimple{
	
	public PassagePieton(){
		
	}
	
	@Override
	public void avancer(Voiture v,int distanceRestante){
		if(v.etat.sens){
			v.etat.setSegment(this.getsTrue());
			v.etat.setPositionSegement(distanceRestante-this.getLongueur());
		}
		else{
			v.etat.setSegment(this.getsFalse());
			v.etat.setPositionSegement(v.etat.getSegment().getLongueur()+this.getLongueur()-distanceRestante);
		}
		System.out.println("La voiture "+v.getId()+" traverse le passage pieton "+this.getId());
		System.out.println(this.getsFalse()+""+this.getsTrue());
	}
}	
