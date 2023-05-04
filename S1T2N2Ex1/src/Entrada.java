import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

	static Scanner entrada = new Scanner(System.in);	
	
	public static byte llegirByte(String msj){
		
		byte edat = 0;
		String missatge_error = "Error de format";	
		boolean resp = false;
		
		do {			
			try {		
				
				System.out.println(msj);
				edat = entrada.nextByte();
				resp = true;
		
			}catch (InputMismatchException e){
				System.out.println(missatge_error);
				entrada.nextLine();
			}
			
		}while(!resp);
		
			return edat;	
	}

	public static int llegirInt(String msj) {
		
		int edat = 0;
		String missatge_error = "Error de format";	
		boolean resp = false;
		
		do {			
			try {		
				
				System.out.println(msj);
				edat = entrada.nextInt();
				resp = true;
		
			}catch (InputMismatchException e){
				System.out.println(missatge_error);
				entrada.nextLine();
			}
			
		}while(!resp);
		
			return edat;
	}

	public static float llegirFloat(String msj) {
	
		float edat = 0f;
		String missatge_error = "Error de format";	
		boolean resp = false;
		
		do {			
			try {		
				
				System.out.println(msj);
				edat = entrada.nextFloat();
				resp = true;
		
			}catch (InputMismatchException e){
				System.out.println(missatge_error);
				entrada.nextLine();
			}
			
		}while(!resp);
		
			return edat;
	}

	public static double llegirDouble(String msj) {
		
		double edat = 0d;
		String missatge_error = "Error de format";	
		boolean resp = false;
		
		do {			
			try {		
				
				System.out.println(msj);
				edat = entrada.nextDouble();
				resp = true;
		
			}catch (InputMismatchException e){
				System.out.println(missatge_error);
				entrada.nextLine();
			}
			
		}while(!resp);
		
			return edat;
	}
	
	public static char llegirChar(String msj) {
		
		char edat = ' ';
		String missatge_error = "Error de format";	
		boolean resp = false;
		
		do {			
			try {		
				
				System.out.println(msj);
				edat = entrada.next().charAt(0);
				resp = true;
				
				}catch (Exception e){
				System.out.println(missatge_error);
				entrada.nextLine();
			}
			
		}while(!resp);
		
			return edat;
	}

	public static String llegirString(String msj) {
		
		String edat = " ";
		String missatge_error = "Error de format";	
		boolean resp = false;
		
		do {			
			try {		
				
				System.out.println(msj);
				edat = entrada.next();
				resp = true;
		
			}catch (Exception e){
				System.out.println(missatge_error);
				entrada.nextLine();
			}
			
		}while(!resp);
		
			return edat;
	}

	public static boolean llegirSiNo(String msj) {
		
		String edat = "";
		boolean resp2 = false;
		String missatge_error = "Error de format";	
		boolean resp = false;
		
		do {			
			try {		
				
				System.out.println(msj);
				edat = entrada.next();
				if(edat.equalsIgnoreCase("s")) {
					resp2 = true;
					resp = true;
				}else if(edat.equalsIgnoreCase("n")) {
					resp2 = false;
					resp = true;
				}
				
				
			}catch (Exception e){
				System.out.println(missatge_error);
				entrada.nextLine();
			}
			
		}while(!resp);
				
			return resp2;
	}

}

