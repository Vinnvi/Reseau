import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class SegmentRoute <S extends Semaphore> implements Observable{
	String name;
	private int longueur;
	private S semaphoreFalse;
	private S semaphoreTrue;
	private ArrayList <Observateur> capteurs;
	
	public SegmentRoute(int longueur,String name){
		this.name = name;
		this.longueur = longueur;
		capteurs = new ArrayList<>();
	}
	
	public void addSemaphore(S semaphore,boolean sens){
		if(sens==true){
			semaphoreTrue = semaphore;
		}
		
	}
	
	public void ajouterObservateur(Observateur o){
		capteurs.add(o);
	}
	
	public void supprimerObservateur(Observateur o){
		capteurs.remove(o);
	}
	
	public void notifierObservateurs(Voiture v){
		for(int i=0;i<capteurs.size();i++){
			Observateur o = capteurs.get(i);
			o.update(v);
		}
	}
}
