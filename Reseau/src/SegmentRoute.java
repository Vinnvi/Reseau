import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class SegmentRoute <S extends Semaphore,J extends Jonction> implements Observable{
	String name;
	private int longueur;
	private S semaphoreFalse;
	private S semaphoreTrue;
	private ArrayList <Observateur> capteurs;
	private J jonctionTrue;
	private J jonctionFalse;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public S getSemaphoreFalse() {
		return semaphoreFalse;
	}

	public void setSemaphoreFalse(S semaphoreFalse) {
		this.semaphoreFalse = semaphoreFalse;
	}

	public S getSemaphoreTrue() {
		return semaphoreTrue;
	}

	public void setSemaphoreTrue(S semaphoreTrue) {
		this.semaphoreTrue = semaphoreTrue;
	}

	public J getJonctionTrue() {
		return jonctionTrue;
	}

	public void setJonctionTrue(J jonctionTrue) {
		this.jonctionTrue = jonctionTrue;
	}

	public J getJonctionFalse() {
		return jonctionFalse;
	}

	public void setJonctionFalse(J jonctionFalse) {
		this.jonctionFalse = jonctionFalse;
	}
	
	
	
}
