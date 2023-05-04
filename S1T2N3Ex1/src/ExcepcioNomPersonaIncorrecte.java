
public class ExcepcioNomPersonaIncorrecte extends Exception {

	private String msj_error;
	
	public ExcepcioNomPersonaIncorrecte() {
		super();
	}

	public ExcepcioNomPersonaIncorrecte(String msj_error) {
		super(msj_error);

	}
}
