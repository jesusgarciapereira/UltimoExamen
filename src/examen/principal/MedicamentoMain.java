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
					System.out.println("Introduzca códigos");
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

				case 4:
					String opcionModificar = "";

					System.out.println("Inserte el código del medicamento a modificar");
					codigo = sc.nextInt();
					sc.nextLine();

					med = new Medicamento(codigo);

					modPrecioOPos(sc, opcionModificar, med);
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

	private static void modPrecioOPos(Scanner sc, String opcionModificar, Medicamento med) {

		
		if (ClaseCRUD.listaMedicamentos.contains(med)) {
			System.out.println("¿Que quieres modificar?");
			System.out.println("\t [Precio]\t [Posologia]");
			opcionModificar = sc.nextLine();
		}
		
		if (opcionModificar.equalsIgnoreCase("precio")) {
			System.out.println("Inserte el nuevo precio");
			med.setPrecio(sc.nextDouble());
			sc.nextLine();
			if (ClaseCRUD.modificarMedicamento(med, med.getPrecio(), null)) {
				System.out.println("Se ha llevado a cabo la modificación del precio");
			}
		} else if (opcionModificar.equalsIgnoreCase("posologia")) {
			System.out.println("Inserte la nueva posología");
			med.setPosologia(sc.nextLine());
			if (ClaseCRUD.modificarMedicamento(med, 0, med.getPosologia())) {
				System.out.println("Se ha llevado a cabo la modificación de la posología");
			}
		} else {
			System.out.println("No se ha podido llevar a cabo la modificación");
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
