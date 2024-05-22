package examen.excepciones;

public class CodigoNegativoExcepcion extends Exception{

	@Override
	public String toString() {

		return "El código debe ser un número mayor que 0";
	}
	
	@Override
	public String getMessage() {
		String res = super.getMessage();
		
		res+= this.getClass() +  "El código debe ser un número mayor que 0";
		return res;
	}
}
