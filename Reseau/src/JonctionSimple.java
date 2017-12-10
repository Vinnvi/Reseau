
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

	public SegmentRoute getsFalse() {
		return sFalse;
	}

	public void setsFalse(SegmentRoute sFalse) {
		this.sFalse = sFalse;
	}

	public SegmentRoute getsTrue() {
		return sTrue;
	}

	public void setsTrue(SegmentRoute sTrue) {
		this.sTrue = sTrue;
	}
	
	
}
