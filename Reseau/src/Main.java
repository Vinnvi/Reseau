import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;




public class Main {
	
	private Timer t;
	public void lancerSimulation(ArrayList<Voiture> list) 
	{
		t = new Timer();
		t.schedule(new Intervalle(list), 0, 10000);//action / delai / periode
    }
	class Intervalle extends TimerTask 
	{
		int nbRepetitions = 1;
		ArrayList<Voiture> listVoitures;
		public Intervalle(ArrayList<Voiture> list)
		{	
			listVoitures = list;
		}
        @Override
		public void run() 
		{
        	Scanner scan = new Scanner(System.in);
        	String reponse = "y";
			do
			{
				System.out.println("Intervalle numero "+nbRepetitions+" ------------");
				for(Voiture a : listVoitures)
				{
					a.avancer();
				}
				nbRepetitions++;
				System.out.println("Intervalle suivant? tapez 'y' pour oui ou autre pour non");
				reponse = scan.next();
						
				
		    }while (reponse.equals("y"));
			System.out.println("Termine!" + reponse);
			t.cancel();
		}
    }
	
	
	
	public static void Main(String args[]) {
		Barriere B1 = new Barriere();
		Barriere B2 = new Barriere();
		Barriere B3 = new Barriere();
		
		Carrefour C1 = new Carrefour();
		Carrefour C2 = new Carrefour();
		PassagePieton P1 = new PassagePieton();
		PassagePieton P2 = new PassagePieton();
		
		SegmentRoute R1 = new SegmentRoute(60,B1,C1,"R1");
		SegmentRoute R2 = new SegmentRoute(100,C1,P1,"R2");
		SegmentRoute R3 = new SegmentRoute(100,C2,P1,"R3");
		SegmentRoute R4 = new SegmentRoute(45,C2,B3,"R4");
		SegmentRoute R5 = new SegmentRoute(60,C2,B2,"R5");
		SegmentRoute R6 = new SegmentRoute(45,P2,C2,"R6");
		SegmentRoute R7 = new SegmentRoute(35,C1,P2,"R7");
		
		Voiture v1 = new Voiture(0,40,new EtatCourant(R1,10, true,10));
		ArrayList<Voiture> listVoitures = new ArrayList<Voiture>();
		listVoitures.add(v1);
		
		Main simulation = new Main();
		simulation.lancerSimulation(listVoitures);
	}
}
