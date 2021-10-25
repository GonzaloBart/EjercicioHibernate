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

public class DeleteDepartamento {

	public static SessionFactory sessionFactory;

	private static Logger logger = LogManager.getLogger(DeleteDepartamento.class);
	


	public void borrarDepartamento(int codigo) {
		
		Departamento departamento = existe(codigo);
		
		if ( departamento != null) {

			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			URL url = loader.getResource("log4j.properties");
			PropertyConfigurator.configure(url);

			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				
				DepartamentoDao.deleteDepartamento(session, departamento);

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

	public Departamento existe(int codigo) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Departamento departamento = null;
		try {		
			departamento = DepartamentoDao.readDepartamento(session, codigo);

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error al acceder a la BD" + e);	
		}

		return departamento;
	} 

}
