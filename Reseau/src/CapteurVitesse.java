import java.util.Observable;

public class CapteurVitesse extends Capteur{

	public CapteurVitesse(boolean sens,SegmentRoute s,int position) {
		// TODO Auto-generated constructor stub
		this.position = position;
		this.sens = sens;
		this.s = s;
		s.ajouterObservateur(this);
	}
	
	@Override
	public void update(Voiture v,int positionDepart,int positionArrivee) {
		if(v.etat.isSens() == this.isSens()){
			if(v.etat.isSens()){
				if(position>positionDepart && position<positionArrivee){
					System.out.println("Hello voiture "+v.getId());
				}
			}
			else{
				if(position<positionDepart && position>positionArrivee){
					System.out.println("Hello voiture "+v.getId());
				}
			}
		}
	}
}
