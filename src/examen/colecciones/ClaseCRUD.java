package examen.colecciones;

import java.util.Set;
import java.util.TreeSet;

import examen.clases.Medicamento;
import examen.excepciones.CodigoNegativoExcepcion;
import examen.tratamientoficheros.TratamientoFicheros;

public class ClaseCRUD {

	public static Set<Medicamento> listaMedicamentos = new TreeSet<>();

	public static void inicializa() throws CodigoNegativoExcepcion {
		listaMedicamentos = TratamientoFicheros.leeFichero();
	}

	public static boolean agregaMedicamento(Medicamento med) {
		boolean resultado = false;

		if (listaMedicamentos.add(med))
			resultado = true;

		return resultado;

	}

	public static void listarMedicamentos() {
		for (Medicamento medicamento : listaMedicamentos) {
			System.out.println(medicamento);
			System.out.println("=================================");
		}

	}

	public static boolean borraMedicamento(Medicamento med) {
		boolean resultado = false;

		if (listaMedicamentos.remove(med))
			resultado = true;

		return resultado;

	}

	public static boolean modificarMedicamento(Medicamento med, double nuevoPrecio, String nuevaPosologia) {
		
		boolean resultado = false;

        if (listaMedicamentos.contains(med)) {
            for (Medicamento valor : listaMedicamentos) {
                if (valor.equals(med)) {
                    if (nuevoPrecio != 0) {
                        valor.setPrecio(nuevoPrecio);
                        resultado = true;
                    } else if (nuevaPosologia != null) {
                        valor.setPosologia(nuevaPosologia);
                        resultado = true;
                    }
                }
            }
        }
        
        return resultado;

    }
}
