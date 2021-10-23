package ejercicio.dao;


import org.hibernate.Session;

import ejercicio.entities.Departamento;


public class DepartamentoDao {

	public static void insertDepartamento(Session s, Departamento departamento) {
		s.save(departamento);
	}

	public static Departamento readDepartamento(Session s, int codigo) {
		String hQuery = " from Departamento d " +
				" where d.codigo = :codigo";
		Departamento departamento = s.createQuery(hQuery, Departamento.class)
				.setParameter("codigo", codigo)
				.setMaxResults(1)
				.uniqueResult();
		
		return departamento;
	}

	public static void updateDepartamento(Session s, Departamento departamento) {
		s.update(departamento);
	}

	public static void deleteDepartamento(Session s, Departamento departamento) {
		s.delete(departamento);
	}

}
