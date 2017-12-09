import java.util.ArrayList;

public class Carrefour {
	ArrayList <SegmentRoute> listeRoutes = new ArrayList<>();
	
	
	public Carrefour(){
		
	}
	
	public void addRoute(SegmentRoute s){
		listeRoutes.add(s);
	}
}
