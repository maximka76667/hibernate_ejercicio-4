package ejercicio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BBDD {

	static SessionFactory sesionfactoria;
	static Session sesion;

	public static void iniciarsesion() {
		@SuppressWarnings("unused")
		org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);

		Configuration config = new Configuration();
		config.configure("./hibernate.cfg.xml");
		sesionfactoria = config.buildSessionFactory();
		sesion = sesionfactoria.openSession();
	}

	public static void finalizarsesion() {
		sesion.close();
		sesionfactoria.close();
	}

	public static ArrayList<Integer> numdeptnos() {
		BBDD.iniciarsesion();
		String sql = "SELECT numDepartamento FROM Departamentos";
		TypedQuery<Integer> consulta = sesion.createQuery(sql, Integer.class);
		List<Integer> list = consulta.getResultList();
		BBDD.finalizarsesion();
		return (ArrayList<Integer>) list;
	}

	public static ArrayList<String> puestos() {
		BBDD.iniciarsesion();
		String sql = "SELECT DISTINCT puesto FROM Empleados";
		TypedQuery<String> consulta = sesion.createQuery(sql, String.class);
		List<String> list = consulta.getResultList();
		BBDD.finalizarsesion();
		return (ArrayList<String>) list;
	}

	public static ArrayList<Empleados> empleados(String orden, String puesto, String numdepartamento) {
		BBDD.iniciarsesion();
		String sql = "from Empleados";
		if (!puesto.equals("") || !numdepartamento.equals("")) {
			sql = sql + " WHERE";
			if (!puesto.equals("") && !numdepartamento.equals(""))
				sql = sql + " puesto like '" + puesto + "' AND num_Departamento=" + numdepartamento;
			else if (!puesto.equals(""))
				sql = sql + " puesto like '" + puesto + "'";
			else
				sql = sql + " num_Departamento=" + numdepartamento;
		}
		if (!orden.equals(""))
			sql = sql + " ORDER BY " + orden;

		TypedQuery<Empleados> consulta = sesion.createQuery(sql, Empleados.class);

		ArrayList<Empleados> lista = (ArrayList<Empleados>) consulta.getResultList();
		BBDD.finalizarsesion();
		return lista;
	}
}
