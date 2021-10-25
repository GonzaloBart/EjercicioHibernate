package menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static int crearMenu() {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		do {
			ArrayList<String> opciones = imprimirMenu();
			System.out.print("Introduce una opcion: ");
			opcion = sc.nextInt();

			boolean esCorrecto = comprobarOpciones(opciones.size(), opcion);
			if(esCorrecto) {
				return opcion;
			}
			else {
				System.out.println("La opcion introducida no es valida");
			}
		} while(opcion!=0);
		
		return opcion;
	}
	
	public static boolean comprobarOpciones(int numOpciones, int opcion) {
		boolean esCorrecto = true;
		
		if(opcion > numOpciones || opcion < 0) {
			esCorrecto = false;
		}
		return esCorrecto;
	}
	
	public static ArrayList<String> imprimirMenu() {
		ArrayList<String> opciones = leerOpciones();
		
		for(int i=0; i < opciones.size(); i++) {
			System.out.println((i+1) + ". " + opciones.get(i));
		}
		System.out.println("0. Salir");
		return opciones;
	}

	public static ArrayList<String> leerOpciones() {
		String fichero = "src/main/java/menu/menu.txt";

		ArrayList<String> opciones = new ArrayList<String>();

		BufferedReader br = null;
		try { 					
			br = new BufferedReader(new FileReader(new File(fichero))); 
			String linea = br.readLine(); 
			
			while (linea != null) { 
				String opcion = linea;
				opciones.add(opcion);
				linea = br.readLine();
			} 
		} catch (IOException errorDeFichero) { 
			System.out.println("Hay un error: " + errorDeFichero.getMessage()); 
		} 
		catch (Exception e) { 
			System.out.println("Hay un error: " + e.getMessage()); 
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		return opciones;
	}
}
