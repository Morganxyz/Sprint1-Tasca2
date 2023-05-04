
public class ExcepcioSeientIncorrect extends Exception{

	private String msj_error;
	
	public ExcepcioSeientIncorrect() {
		super();
	}

	public ExcepcioSeientIncorrect(String msj_error) {
		super(msj_error);

	}
}
