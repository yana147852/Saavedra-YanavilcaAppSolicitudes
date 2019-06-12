package com.yanavilca.LaboratorioServiceRest.model;

public class Matricula {
	
	private Long id;
	private String correo;
	private String tipo_solicitud;
	private String solicitud;
	private String imagen;

	public Matricula(Long id, String correo, String tipo_solicitud, String solicitud, String imagen) {
		this.id = id;
		this.correo = correo;
		this.tipo_solicitud = tipo_solicitud;
		this.solicitud = solicitud;
		this.imagen = imagen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTipo_solicitud() {
		return tipo_solicitud;
	}

	public void setTipo_solicitud(String tipo_solicitud) {
		this.tipo_solicitud = tipo_solicitud;
	}

	public String getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", correo=" + correo + ", tipo_solicitud=" + tipo_solicitud + ", solicitud="
				+ solicitud + ", imagen=" + imagen + "]";
	}

	public Matricula() {
	}
}
