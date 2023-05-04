import java.util.ArrayList;

public class Venda {
	
	static ArrayList<Producte>llistaProductes = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Producte p0 = new Producte("Patatas0",1);
		//llistaProductes.add(p0);
		
		int [] llista = {5,4,3,2,1};
		
		try {
		System.out.println(llista[7]);
		
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("El nombre buscat está fora de rang!");
		}
	
		try {
			float preuTotalVenda = calcularTotal();
			System.out.println("El preu total de la venda de tots els produtes es de " + 
			preuTotalVenda + " Euros");
		}catch (Venda_Buida_Exception e){
			System.out.println("No hi ha productes per vendre");
		}
		
	}
	
		public static float calcularTotal() throws Venda_Buida_Exception {
		
		float sumatori = 0f;
		float preuTotalVenda = 0f;
		
		if(llistaProductes.size() == 0) {
			
			throw new Venda_Buida_Exception("No es pot vendre si no hi ha productes");
			
		}else if(llistaProductes.size() != 0) {
			for(Producte p : llistaProductes) {
				sumatori = p.getPreu();
				preuTotalVenda += sumatori;
			}
		}
		return preuTotalVenda;
	}
}
