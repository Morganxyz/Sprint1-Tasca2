
public class ExcepcioFilaIncorrecta extends Exception {
	
	private String msj_error;
	
	public ExcepcioFilaIncorrecta() {
		super();
	}

	public ExcepcioFilaIncorrecta(String msj_error) {
		super(msj_error);
	}

}
