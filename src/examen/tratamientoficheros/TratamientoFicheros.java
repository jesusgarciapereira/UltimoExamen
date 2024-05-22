package examen.tratamientoficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import examen.clases.Medicamento;
import examen.excepciones.CodigoNegativoExcepcion;

public class TratamientoFicheros {
	public static final String RUTA_FICHERO = "src/examen/ficheros/medicamentos.txt";

	public static Set<Medicamento> leeFichero() throws CodigoNegativoExcepcion {
		Set<Medicamento> listaMedicamentos = new TreeSet<>();
		String lineaTexto = "";
		String[] medicamento;
		Medicamento m;

		int codigo;
		String nombre = "";
		String descripcion = "";
		double precio;
		String posologia;

		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(RUTA_FICHERO));
			lineaTexto = br.readLine();

			while (lineaTexto != null) {
				medicamento = lineaTexto.split(";");

				codigo = Integer.valueOf(medicamento[0]);
				nombre = medicamento[1];
				descripcion = medicamento[2];
				precio = Double.valueOf(medicamento[3]);
				posologia = medicamento[4];

				m = new Medicamento(codigo, nombre, descripcion, precio, posologia);

				listaMedicamentos.add(m);
				
				lineaTexto = br.readLine();
			}

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		} catch (IOException e) {
			System.err.println("Ha habido un error en la lectura del fichero");
		}

		return listaMedicamentos;
	}

	public static void escribeFichero(Set<Medicamento> listaMedicamentos) {
		BufferedWriter bw = null;
		
		
		try {
			bw = new BufferedWriter(new FileWriter(RUTA_FICHERO));
			
			for (Medicamento medicamento : listaMedicamentos) {
				String lineaEscrita = "";
				
				lineaEscrita += medicamento.getCodigo() + ";";
				lineaEscrita += medicamento.getNombre() + ";";
				lineaEscrita += medicamento.getDescripcion()+ ";";
				lineaEscrita += medicamento.getPrecio() + ";";
				lineaEscrita += medicamento.getPosologia();
				
				bw.write(lineaEscrita);
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			
		}
		
	}
}
