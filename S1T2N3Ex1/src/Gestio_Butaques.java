import java.util.ArrayList;
import java.util.Scanner;

public class Gestio_Butaques {

	private static Scanner entrada = new Scanner(System.in);
	private ArrayList<Butaca>butaques;
	
	public Gestio_Butaques() {
		
	this.butaques = new ArrayList<>();
		
	}

	public ArrayList<Butaca> getButaques() {

		return this.butaques;
	}
	
	public int cercarButaques(int numFil,int numSe) {
		
		int posBut = -1;
		int i = 0;
		boolean esc = false;
		
		while(i < butaques.size() && !esc) {
			 Butaca butacaTrovada = butaques.get(i);
			
			if(butacaTrovada.getNomb_Fila() == numFil && butacaTrovada.getNomb_Seient() == numSe) {
				esc = true;
				System.out.println("Posició de la butaca: " + butaques.get(i));
				System.out.println("Aquesta butaca pertany a : " + butacaTrovada.getNomRes());
				System.out.println("");
			}else {
				System.out.println("Butaca no reservada");
				System.out.println("");
			}
			i++;			
		}
		return posBut;
		
	}
	
	public int cercarButaquesPP(String nom) {
		
		String nomP;
		int i = 0;
		boolean esc = false;
		int posBut = -1;
		
		System.out.println("Introdueix a nom de qui está feta la reserva: ");
		nomP = entrada.nextLine();
		
		while(i < butaques.size() && !esc) {
			 Butaca butacaTrovada = butaques.get(i);
			
			if(nomP.equalsIgnoreCase(butacaTrovada.getNomRes())) {
				posBut = i;
				esc = true;
			}
			i++;		
			
		}
		return posBut;	
	}
	
	public void setButaques(int numBut,int numSe,String nom) throws ExcepcioButacaOcupada {
		
		int resu = 0;
		
		resu = cercarButaques(numBut,numSe);
		entrada.next();
		
		if(resu == -1) {
			Butaca b0 = new Butaca(numBut,numSe,nom);
			butaques.add(b0);
			System.out.println("Reserva realitzada correctament!");
			System.out.println("");
		}else {
			throw new ExcepcioButacaOcupada("Butaca Ocupada!");
		}
	}
	
	public void eliminarButaques(int numBut,int numSe) throws ButacaLliure {
		
		
		String resp = "";
		int posBut = cercarButaques(numBut,numSe);
	
		if(posBut != -1 ) {
			System.out.println("Està segur d´eliminar la reserva? s/n : ");
			resp = entrada.next();
			
			if(resp.equalsIgnoreCase("s")){
				butaques.remove(posBut);	
				System.out.println("Butaca alliverada");
				System.out.println("");
			}else {
				System.out.println("Eliminació de reserva avortada!");
				System.out.println("");
			}
			
		}else {
			throw new ButacaLliure("Butaca lluire!");
		}
	}
	
	public void eliminarButaquesPP(String pers) throws ButacaLliure {
	
		String resp = "";
		int posBut = -1;
		int resu = 0;
		
		resu = cercarButaquesPP(pers);
			
		if(resu == -1) {
			System.out.println("Està segur d´eliminar totes les reserves? s/n : ");
			
			if(resp.equalsIgnoreCase("s")){
				for(int i = 0; i < butaques.size();i++) {
					butaques.remove(posBut);	
				}
				System.out.println("Butaques alliverades");
				System.out.println("");
			}else {
				System.out.println("Eliminació de reserva avortada!");
				System.out.println("");
			}
			
		}else {
			throw new ButacaLliure("Butaca lluire!");
		}
	}
}
