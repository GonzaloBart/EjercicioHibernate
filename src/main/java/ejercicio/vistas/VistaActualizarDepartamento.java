package ejercicio.vistas;

import java.util.Scanner;

public class VistaActualizarDepartamento {

	public static int actualizarDepartamento() {

		int codigo = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Indica el codigo del departamento que quiere actualizar: ");
		codigo = sc.nextInt();

		if (sc.hasNextInt()) {
			codigo = sc.nextInt();
		} else {
			VistaErrorBorrar.mostrarError();
		}
		
		System.out.println("El departamento a actualizar es el siguiente: ");

		return codigo;		
	}

}
