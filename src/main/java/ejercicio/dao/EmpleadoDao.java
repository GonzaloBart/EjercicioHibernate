package ejercicio.dao;


import org.hibernate.Session;

import ejercicio.entities.Empleado;


public class EmpleadoDao {
	
	
	public static void insertEmpleado(Session s, Empleado empleado) {
		s.save(empleado);
	}

	public static Empleado readEmpleado(Session s, int codigo) {
		String hQuery = " from Empleado e " +
				" where e.codigo = :codigo";
		Empleado empleado = s.createQuery(hQuery, Empleado.class)
				.setParameter("codigo", codigo)
				.setMaxResults(1)
				.uniqueResult();
		
		return empleado;
	}

	public static void updateEmpleado(Session s, Empleado empleado) {
		s.update(empleado);
	}

	public static void deleteEmpleado(Session s, Empleado empleado) {
		s.delete(empleado);
	}

}
