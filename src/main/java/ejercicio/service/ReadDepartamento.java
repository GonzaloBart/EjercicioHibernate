package ejercicio.service;

import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ejercicio.dao.DepartamentoDao;
import ejercicio.entities.Departamento;
import ejercicio.utils.HibernateUtil;

public class ReadDepartamento {

	public static SessionFactory sessionFactory;

	private static Logger logger = LogManager.getLogger(ReadDepartamento.class);

	public static Departamento leerDepartamento(int codigo) {

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("log4j.properties");
		PropertyConfigurator.configure(url);

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


