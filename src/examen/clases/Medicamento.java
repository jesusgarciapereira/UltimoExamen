package examen.clases;

import examen.excepciones.CodigoNegativoExcepcion;

public class Medicamento implements Comparable<Medicamento> {

	private int codigo;
	private String nombre = "";
	private String descripcion = "";
	private double precio;
	private String posologia;

	public Medicamento(int codigo) throws CodigoNegativoExcepcion {
		compruebaCodigo(codigo);
	}

	public Medicamento(int codigo, String nombre, String descripcion, double precio, String posologia)
			throws CodigoNegativoExcepcion {
		this(codigo);
		if (nombre != null && !nombre.equals(""))
			this.nombre = nombre;
		if (descripcion != null && !descripcion.equals(""))
			this.descripcion = descripcion;
		if (precio > 0)
			this.precio = precio;
		if (posologia != null && !posologia.equals(""))
			this.posologia = posologia;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public String getPosologia() {
		return posologia;
	}

	public void setPrecio(double precio) {
		if (precio > 0)
			this.precio = precio;
	}

	public void setPosologia(String posologia) {
		if (posologia != null && !posologia.equals(""))
			this.posologia = posologia;
	}

	private void compruebaCodigo(int codigo) throws CodigoNegativoExcepcion {
		if (codigo > 0)
			this.codigo = codigo;
		else
			throw new CodigoNegativoExcepcion();
	}

	@Override
	public String toString() {
		String cadena = "";
		cadena += "Código: " + this.codigo + "\n";
		cadena += "Nombre: " + this.nombre + "\n";
		cadena += "Descripción: " + this.descripcion + "\n";
		cadena += "Precio: " + this.precio + "\n";
		cadena += "Posología: " + this.posologia;
		return cadena;
	}

	@Override
	public boolean equals(Object obj) {
		boolean resultado = false;
		Medicamento med = (Medicamento) obj;
		if (this.codigo == med.codigo)
			resultado = true;
		return resultado;
	}

	@Override
	public int compareTo(Medicamento o) {
		int resultado = 0;
		if(this.codigo > o.codigo)
			resultado = 1;
		else if(this.codigo < o.codigo)
			resultado = -1;
		
		return resultado;
	}

}
