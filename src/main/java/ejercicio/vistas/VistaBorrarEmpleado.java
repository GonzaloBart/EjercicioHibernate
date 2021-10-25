package ejercicio.vistas;

import java.util.Scanner;

public class VistaBorrarEmpleado {

	public static int borrarEmpleado() {

		int codigo = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Indica el codigo del empleado que quiere borrar: ");
		codigo = sc.nextInt();

		if (sc.hasNextInt()) {
			codigo = sc.nextInt();
		} else {
			VistaErrorBorrar.mostrarError();
		}
		return codigo;		
	}

}
