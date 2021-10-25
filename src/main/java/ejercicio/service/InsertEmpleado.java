package ejercicio.service;

import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ejercicio.dao.EmpleadoDao;
import ejercicio.entities.Empleado;
import ejercicio.utils.HibernateUtil;

public class InsertEmpleado {

	public static SessionFactory sessionFactory;

	private static Logger logger = LogManager.getLogger(InsertEmpleado.class);

	public static void insertarEmpleado(Empleado empleado) {

		if (validate(empleado)) {

			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			URL url = loader.getResource("log4j.properties");
			PropertyConfigurator.configure(url);

			Session session = HibernateUtil.getSessionFactory().openSession();

			Transaction tx = null;

			try {
				tx = session.beginTransaction();

				EmpleadoDao.insertEmpleado(session, empleado);

				tx.commit();

			} catch (HibernateException e){
				if (tx != null) {
					tx.rollback();   

					logger.error("Error al acceder a la BD" + e);
				}

			}finally {
				if (session != null) {
					session.close();
				}
			}

		}else {

			logger.error("Error con los datos del empleado: " + empleado.toString());

		}
		
		
		
	}

	private static boolean validate(Empleado empleado)
	{ 
		if (empleado.getApellido1() == null || empleado.getApellido2() == null || empleado.getCodDepartamento() == 0
			|| empleado.getCodigo() == 0 || empleado.getDireccion()	== null || empleado.getFechaNacimiento() == null 
			|| empleado.getLugarNacimiento() == null || empleado.getNombre() == null || empleado.getPuesto() == null 
			|| empleado.getTelefono() == null) {
			return false;
		}
		return true;
	}
}
