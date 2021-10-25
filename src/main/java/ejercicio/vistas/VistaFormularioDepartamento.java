package ejercicio.vistas;

import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ejercicio.entities.Departamento;
import ejercicio.entities.Empleado;
import ejercicio.principal.App;

public class VistaFormularioDepartamento {

	private static Logger logger = LogManager.getLogger(VistaFormularioDepartamento.class);

	public static Departamento formularioDepartamento(){

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("log4j.properties");
		PropertyConfigurator.configure(url);

		Departamento departamento = new Departamento();

		Scanner sc = new Scanner(System.in);

		int codDept = 0;
		try {
		System.out.println("Inserta Codigo para el Departamento");
		codDept = sc.nextInt();
			// remaining logic
		} catch (InputMismatchException e) {
			logger.error("Dato para el codigo no valido" + sc);
			System.out.println("Dato introducido no valido");
			VistaErrorFormulario.mostrarError();
		} 

		departamento.setCodigo(codDept);
		
		int codResp = 0;
		
		try {
			System.out.println("Inserta el Codigo del Responsable");
			codResp = sc.nextInt();
			// remaining logic
		} catch (InputMismatchException e) {
			logger.error("Dato para el codigo no valido" + sc);
			System.out.println("Dato introducido no valido");
			VistaErrorFormulario.mostrarError();
		} 
					
		departamento.setCodResponsable(codResp);
		
		System.out.println("Inserta el nombre del Departamento");
		departamento.setNombre(sc.nextLine());

		sc.close();

		return departamento;
	} 

}
