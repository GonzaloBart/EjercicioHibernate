package ejercicio.principal;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.FileHandler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

import ejercicio.vistas.VistaActualizarDepartamento;
import ejercicio.vistas.VistaBorrarDepartamento;
import ejercicio.vistas.VistaBorrarEmpleado;
import ejercicio.vistas.VistaFormularioDepartamento;
import ejercicio.vistas.VistaFormularioEmpleado;
import ejercicio.vistas.VistaLeerDepartamento;
import ejercicio.dao.EmpleadoDao;
import ejercicio.entities.Departamento;
import ejercicio.entities.Empleado;
import ejercicio.service.DeleteEmpleado;
import ejercicio.service.InsertDepartamento;
import ejercicio.service.InsertEmpleado;
import ejercicio.service.ReadDepartamento;
import ejercicio.utils.HibernateUtil;
import menu.Menu;



/**
 * Hello world!
 *
 */
public class App 
{

	//public static SessionFactory sessionFactory;

	public static Logger logger = LogManager.getLogger(App.class);


	public static void main( String[] args )
	{

		String methodName = App.class.getSimpleName() + ".main()";

		logger.info(String.format("%1$s: >>>>>> Main execution started.", methodName));

		// La SessionFactory se instancia 1 vez por ejecuci�n del programa.
		// Todas las sesiones de hibernate se obtienen de esa SessionFactory;	

		//Session session = HibernateUtil.getSessionFactory().openSession();


		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("log4j.properties");
		PropertyConfigurator.configure(url);

		//Empleado empleado2 = EmpleadoDao.readEmpleado(session, 23);
		
		//empleado2.toString();
		
		//EmpleadoDao.deleteEmpleado(session, 23);
		
		//EmpleadoDao.getAllEmpleados(session);
		
		int opcion = 0;

		opcion = Menu.crearMenu();

		switch (opcion) {

		case 1:
			Empleado empleado = VistaFormularioEmpleado.formularioEmpleado();
			InsertEmpleado.insertarEmpleado(empleado);
			break;
		case 2:
			Departamento departamento = VistaFormularioDepartamento.formularioDepartamento();
			InsertDepartamento.insertarDepartamento(departamento);
			break;
		case 3: 
			break;
		case 4:
			int codDep = VistaLeerDepartamento.actualizarDepartamento();	
			ReadDepartamento.leerDepartamento(codDep).toString();
			break;
		case 5:
			
			break;
		case 6:
			int codDep2 = VistaActualizarDepartamento.actualizarDepartamento();		
			ReadDepartamento.leerDepartamento(codDep2).toString();
			System.out.println("Introduce los datos del departamento a actualizar");
			Departamento departamento2 = VistaFormularioDepartamento.formularioDepartamento();
			InsertDepartamento.insertarDepartamento(departamento2);
			break;
		case 7:
			int codigo = VistaBorrarEmpleado.borrarEmpleado();
			DeleteEmpleado borrar = new DeleteEmpleado();
			borrar.borrarEmpleado(codigo);
			break;
		case 8:
			int codigoDep = VistaBorrarDepartamento.borrarDepartamento();		
			DeleteEmpleado borrar2 = new DeleteEmpleado();
			borrar2.borrarEmpleado(codigoDep);
			break;
		default:
		}

	}

}
