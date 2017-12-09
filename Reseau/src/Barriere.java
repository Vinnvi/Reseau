
public class Barriere extends Jonction{
	SegmentRoute s;
	
	public Barriere(){
		
	}
	
	@Override
	public void avancer(Voiture v,int distanceRestante) {
		System.out.println("La voiture "+v.getId()+" est bloqué à une barriere");
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
