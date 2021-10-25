package ejercicio.vistas;

import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ejercicio.entities.Empleado;

public class VistaFormularioEmpleado {

	private static Logger logger = LogManager.getLogger(VistaFormularioEmpleado.class);

	public static Empleado formularioEmpleado(){

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("log4j.properties");
		PropertyConfigurator.configure(url);

		Empleado empleado = new Empleado();

		Scanner sc = new Scanner(System.in);

		int codigo = 0;
		try {
		System.out.println("Inserta Codigo para el Empleado");
			codigo = sc.nextInt();
			// remaining logic
		} catch (InputMismatchException e) {
			logger.error("Dato para el codigo no valido" + sc);
			System.out.println("Dato introducido no valido");
			VistaErrorFormulario.mostrarError();
		}
		empleado.setCodigo(codigo);
		
		System.out.println("Inserta Nombre para el Empleado");			
		empleado.setNombre(sc.next());

		System.out.println("Inserta Apellido1 para el Empleado");
		empleado.setApellido1(sc.next());

		System.out.println("Inserta Apellido2 para el Empleado");
		empleado.setApellido2(sc.next());

		System.out.println("Inserta Codigo de Departamento para el Empleado");
		empleado.setCodDepartamento(sc.nextInt());

		String buffer = sc.nextLine();

		System.out.println("Inserta Direccion del Empleado");			
		empleado.setDireccion(sc.nextLine());

		System.out.println("Inserta Codigo de Lugar de Nacimiento del Empleado");
		empleado.setLugarNacimiento(sc.nextLine());

		System.out.println("Inserta Fecha de Nacimiento del Empleado");
		empleado.setFechaNacimiento(sc.nextLine());

		System.out.println("Inserta Puesto del Empleado");
		empleado.setPuesto(sc.nextLine());

		System.out.println("Inserta Telefono del Empleado");
		empleado.setTelefono(sc.nextLine());

		sc.close();

		return empleado;
	} 

}
