package ejercicio.service;

import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ejercicio.dao.DepartamentoDao;
import ejercicio.entities.Departamento;
import ejercicio.utils.HibernateUtil;

public class InsertDepartamento {

	public static SessionFactory sessionFactory;

	private static Logger logger = LogManager.getLogger(InsertDepartamento.class);

	public static void insertarDepartamento(Departamento departamento) {

		if (validate(departamento)) {

			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			URL url = loader.getResource("log4j.properties");
			PropertyConfigurator.configure(url);

			Session session = HibernateUtil.getSessionFactory().openSession();

			Transaction tx = null;

			try {
				tx = session.beginTransaction();

				DepartamentoDao.insertDepartamento(session, departamento);

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

			logger.error("Error con los datos del empleado: " + departamento.toString());

		}

	}

	private static boolean validate(Departamento departamento)
	{ 
		if (departamento.getCodigo() == 0 || departamento.getCodResponsable() == 0 || departamento.getNombre() == null) {
			return false;
		}
		return true;
	}

}
