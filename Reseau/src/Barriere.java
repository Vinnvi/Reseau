
public class Barriere extends Jonction{
	@Override
	public void avancer(Voiture v,int distanceRestante) {
		System.out.println("La voiture "+v.getId()+" est bloqué à une barriere");
	}
}
