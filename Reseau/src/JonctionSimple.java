
public abstract class JonctionSimple extends Jonction{
	private SegmentRoute sFalse;
	private SegmentRoute sTrue;
	
	public void addSegment(SegmentRoute s,boolean sens) {
		if(sens == false) {
			sFalse = s;
		}
		else {
			sTrue = s;
		}
	}
}
