import java.util.Observable;
import java.util.Observer;

public abstract class Capteur implements Observateur{
	boolean sens; // Sens sur la jonction
	int position;
	SegmentRoute s;
	@Override
	public void update(Voiture v,int positionDepart,int positionArrivee) {

	}
	public boolean isSens() {
		return sens;
	}
	public void setSens(boolean sens) {
		this.sens = sens;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public SegmentRoute getS() {
		return s;
	}
	public void setS(SegmentRoute s) {
		this.s = s;
	}
	
}
