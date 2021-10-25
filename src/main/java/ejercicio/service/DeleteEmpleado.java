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

public class DeleteEmpleado {

	public static SessionFactory sessionFactory;

	private static Logger logger = LogManager.getLogger(DeleteEmpleado.class);



	public void borrarEmpleado(int codigo) {

		Empleado empleado = existe(codigo);

		if ( empleado != null) {

			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			URL url = loader.getResource("log4j.properties");
			PropertyConfigurator.configure(url);

			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();

				EmpleadoDao.deleteEmpleado(session, empleado);

				tx.commit();

			} catch (HibernateException e){
				if (tx != null) {
					tx.rollback();   

					logger.error("Error al acceder a la BD" + e);
				}
			}
		}else {
			logger.error("El codigo no existe en la base de datos " + codigo);
		}
	}

	public Empleado existe(int codigo) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Empleado empleado = null;
		try {		
			empleado = EmpleadoDao.readEmpleado(session, codigo);

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error al acceder a la BD" + e);

		}

		return empleado;
	} 

}
