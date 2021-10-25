package ejercicio.vistas;

import java.util.Scanner;

public class VistaLeerDepartamento {
	
	public static int actualizarDepartamento() {

		int codigo = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Indica el codigo del departamento que quiere ver: ");
		codigo = sc.nextInt();

		if (sc.hasNextInt()) {
			codigo = sc.nextInt();
		} else {
			VistaErrorBorrar.mostrarError();
		}

		return codigo;		
	}

}
