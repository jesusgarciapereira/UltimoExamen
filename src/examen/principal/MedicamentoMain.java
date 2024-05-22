package examen.principal;

import java.util.Scanner;

import examen.clases.Medicamento;
import examen.colecciones.ClaseCRUD;
import examen.excepciones.CodigoNegativoExcepcion;
import examen.tratamientoficheros.TratamientoFicheros;

public class MedicamentoMain {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion;

		int codigo;
		String nombre = "";
		String descripcion = "";
		double precio = 0;
		String posologia = "";

		Medicamento med;

		System.out.println("Bienvenido al sistema gestor de medicamentos");
		try {
			ClaseCRUD.inicializa();

			do {
				mostrarMenu();
				opcion = sc.nextInt();
				sc.nextLine();

				switch (opcion) {
				case 1:
					System.out.println("Introduzca código");
					codigo = sc.nextInt();
					sc.nextLine();
					System.out.println("Introduzca nombre");
					nombre = sc.nextLine();
					System.out.println("Introduzca descripción");
					descripcion = sc.nextLine();
					System.out.println("Introduzca precio");
					precio = sc.nextDouble();
					sc.nextLine();
					System.out.println("Introduzca posologia");
					posologia = sc.nextLine();

					med = new Medicamento(codigo, nombre, descripcion, precio, posologia);

					if (ClaseCRUD.agregaMedicamento(med))
						System.out.println("Medicamento añadido con éxito");
					else
						System.out.println("No se ha podido añadido el medicamento");
					;
					break;
				case 2:
					ClaseCRUD.listarMedicamentos();

					break;
				case 3:
					System.out.println("Introduzca código");
					codigo = sc.nextInt();
					sc.nextLine();

					med = new Medicamento(codigo);

					if (ClaseCRUD.borraMedicamento(med))
						System.out.println("Medicamento borrado con éxito");
					else
						System.out.println("No se ha podido borrar el medicamento");

					break;
					// Desierto
				case 4:
					System.out.println("Introduzca código");
					codigo = sc.nextInt();
					sc.nextLine();
					System.out.println("Introduzca nuevo precio");
					precio = sc.nextDouble();
					sc.nextLine();
					System.out.println("Introduzca nueva posologia");
					posologia = sc.nextLine();

					med = new Medicamento(codigo);

					if (ClaseCRUD.modificarMedicamento(med, precio, posologia))
						System.out.println("Medicamento modificado con éxito");
					else
						System.out.println("No se ha podido modificar el medicamento");


					break;
				case 5:
					TratamientoFicheros.escribeFichero(ClaseCRUD.listaMedicamentos);

					break;
				case 0:
					break;

				default:
					System.out.println("Opción incorrecta");
					break;
				}

			} while (opcion != 0);

			System.out.println("Saliendo del sistema...");

		} catch (

		CodigoNegativoExcepcion e) {
			System.err.println(e);
		}
	}

	private static void mostrarMenu() {
		System.out.println("1. Añadir medicamento");
		System.out.println("2. Listar medicamentos");
		System.out.println("3. Eliminar medicamento");
		System.out.println("4. Modificar medicamento");
		System.out.println("5. Guardar medicamentos");
		System.out.println("0. Salir");
		System.out.println("Seleccione una opcion");

	}

}
