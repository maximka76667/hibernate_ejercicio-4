package ejercicio;
// Generated 10 oct. 2022 13:09:46 by Hibernate Tools 6.0.2.Final

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Empleados generated by hbm2java
 */
public class Empleados implements java.io.Serializable {

	private int numEmpleado;
	private Departamentos departamentos;
	private String nombreEmpleado;
	private String puesto;
	private Integer numJefe;
	private Date fechaAlta;
	private BigDecimal salario;
	private BigDecimal comision;

	public Empleados() {
	}

	public Empleados(int numEmpleado, String nombreEmpleado, String puesto, Date fechaAlta, BigDecimal salario) {
		this.numEmpleado = numEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.puesto = puesto;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
	}

	public Empleados(int numEmpleado, Departamentos departamentos, String nombreEmpleado, String puesto,
			Integer numJefe, Date fechaAlta, BigDecimal salario, BigDecimal comision) {
		this.numEmpleado = numEmpleado;
		this.departamentos = departamentos;
		this.nombreEmpleado = nombreEmpleado;
		this.puesto = puesto;
		this.numJefe = numJefe;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
		this.comision = comision;
	}

	public int getNumEmpleado() {
		return this.numEmpleado;
	}

	public void setNumEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}

	public Departamentos getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(Departamentos departamentos) {
		this.departamentos = departamentos;
	}

	public String getNombreEmpleado() {
		return this.nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getPuesto() {
		return this.puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Integer getNumJefe() {
		return this.numJefe;
	}

	public void setNumJefe(Integer numJefe) {
		this.numJefe = numJefe;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public BigDecimal getSalario() {
		return this.salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getComision() {
		return this.comision;
	}

	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}

}
