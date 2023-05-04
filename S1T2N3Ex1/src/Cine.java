import java.util.Scanner;

public class Cine {

	static Scanner entrada = new Scanner(System.in);
	private int nombreFiles;
	private int nombreSeientsPF;
	private String pers;
	private Gestio_Butaques gb0;
	public static int numFila;
	public static int numSeient;
	public static String numRes;

	
	public Cine() {
		
		gb0  = new Gestio_Butaques();
		demanarDadesInicials();
		
	}
	
	public int getNombreFiles() {
		return nombreFiles;
	}
	
	public int getNombreSeientsPF() {
		return nombreSeientsPF;
	}
	
	public String getPers() {
		return pers;
	}
	public void setNombreFiles(int nombreFiles) {
		 this.nombreFiles = nombreFiles;
	}
	public  void setNombreSeientsPF(int nombreSeientsPF) {
		this.nombreSeientsPF = nombreSeientsPF;
	}
	
	public void setPers(String pers) {
		this.pers = pers;
	}
	
	
	
	public void iniciar() {
		
		menu();
	}
	
	public void menu() {
		
		int  opcio;
		
		do {
		
		System.out.println("Introdueix l´opció desitjada: \n1. Mostrar Butaques\n2. Mostrar Butaques Persona"
				+ "\n3. Reservar Butaca\n4. Anular Reserva\n5. Anular Reserva Persona\n0. Sortir");
		opcio = entrada.nextInt();
		
			switch(opcio) {
			
				case 1: mostrarButaques();
					break;
				case 2: mostrarButaquesPersona();
					break;
				case 3: reservarButaca();				
					break;
				case 4: anularReserva();
					break;
				case 5: anularReservaPersona();
					break;
				case 0:
					System.out.println("Sortint!");
					System.out.println("");
					break;
				default:
					System.out.println("La opció escollida no és vàlida");
					System.out.println("");
			}
				
	}while(opcio != 0);

}
	public void mostrarButaques() {
		
		for(Butaca gp :  gb0.getButaques()) {
			System.out.println(gp);
		}
	}
	
	public void mostrarButaquesPersona(){
			
		int posBut;
			
		  posBut = gb0.cercarButaquesPP(pers);
		  
		  if(posBut != -1) {
			  
			  	System.out.println("Aquesta butaca pertany a : " + gb0.getButaques().get(posBut).getNomRes());
				System.out.println("Posició de la butaca: " + gb0.getButaques().get(posBut));
				System.out.println("");
				  			
			}else {
					System.out.println("Aquesta persona no té cap butaca reservada");
					System.out.println("");				
			}	
			
	  }		
	
	public void reservarButaca(){
		
		
		
		boolean esc = false;

		while(!esc) {
			
			try {
			numFila = introduirFila();
			esc = true;
		} catch (ExcepcioFilaIncorrecta e) {
			System.out.println(e.getMessage());	
			esc = false;
		} 
	}
	
		while(esc) {
			
			try {
			numSeient = introduirSeient();
			esc = false;
		} catch (ExcepcioSeientIncorrect e) {
			System.out.println(e.getMessage());
			esc = true;
		}
	}
		while(!esc) {
			
			try {
			numRes = introduirPersona();
			esc = true;
		} catch (ExcepcioNomPersonaIncorrecte e) {
			System.out.println(e.getMessage());
			esc = false;
		}
	}
		while(esc) {
			
			try {
				gb0.setButaques(numFila,numSeient,numRes);
				esc = false;
		} catch (ExcepcioButacaOcupada e) {
			System.out.println(e.getMessage());
				esc = true;
		}	
	}
		
}
	
	public void anularReserva() {
				
		try {
			numFila = introduirFila();
			numSeient = introduirSeient();
			gb0.eliminarButaques(numFila,numSeient);
		} catch (ExcepcioFilaIncorrecta e) {
			System.out.println(e.getMessage());	
		} catch (ExcepcioSeientIncorrect e) {
			System.out.println(e.getMessage());
		} catch (ButacaLliure e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void anularReservaPersona(){
		
	
		try {
			numRes = introduirPersona();
			gb0.eliminarButaquesPP(numRes);
		} catch (ExcepcioNomPersonaIncorrecte e) {
			System.out.println(e.getMessage());

		} catch (ButacaLliure e) {
			System.out.println(e.getMessage());
		}
		entrada.next();			
	}
	
	public void demanarDadesInicials(){
		
		int nombreFiles;
		int nombreSeients;
	
		
		System.out.println("Introdueix la quantitat de files que té el cinema: ");
		nombreFiles= entrada.nextInt();
		System.out.println("Introdueix la quantitat de seients per fila que té el cinema: ");
		nombreSeients = entrada.nextInt();
		
		setNombreFiles(nombreFiles);
		setNombreSeientsPF(nombreSeients);
		
	}
	public String introduirPersona() throws ExcepcioNomPersonaIncorrecte{
		
		boolean numTrovat = false;
		
		
		System.out.println("Introdueix el nom de la persona per fer la reserva: ");
		pers = entrada.nextLine();
		
		for(int i = 0; i < pers.length();i++) {
			if(pers.charAt(i) >= 0 || pers.charAt(i) <= 9) {
				numTrovat = true;	
			}	
		}
		if(numTrovat) {
			throw new ExcepcioNomPersonaIncorrecte("Format incorrecte");
		}
		return pers;
	}
		
	public int introduirFila() throws ExcepcioFilaIncorrecta{
		
		int numFila;
		
		System.out.println("Introdueix el numero de fila:");
		numFila = entrada.nextInt();
		
		if(numFila >= 1 && numFila <= getNombreFiles()) {
			System.out.println("La fila " + numFila + " és lliure");
			System.out.println("");
		}else {
			throw new ExcepcioFilaIncorrecta("Fila incorrecte");
		}
		return numFila;
	}
	
	public int introduirSeient() throws ExcepcioSeientIncorrect{
		
		int numSeient;
		
		System.out.println("Introdueix el numero de seient:");
		numSeient = entrada.nextInt();
		if(numSeient >= 1 && numSeient <= getNombreSeientsPF()) {
			System.out.println("El seient " + numSeient + " és lliure");
			System.out.println("");
		}else {
			throw new ExcepcioSeientIncorrect("Seient incorrecte");
		}
		return numSeient;
	}
}
