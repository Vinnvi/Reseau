
public class Barriere extends Jonction{
	SegmentRoute s;
	
	public Barriere(int id){
		this.setId(id);
	}
	
	@Override
	public void avancer(Voiture v,int distanceRestante) {
		System.out.println("La voiture "+v.getId()+" est bloque a  une barriere");
	}

	@Override
	public void addSegment(SegmentRoute s, boolean sens) {
		this.setS(s);		
	}

	public SegmentRoute getS() {
		return s;
	}

	public void setS(SegmentRoute s) {
		this.s = s;
	}
	
}
