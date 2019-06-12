package com.example.examen;

public class Matricula {
    private Integer id;
    private String correo;
    private String solicitud;
    private String tipo_solicitud;
    private String imagen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(String solicitud) {
        this.solicitud = solicitud;
    }

    public String getTipo_solicitud() {
        return tipo_solicitud;
    }

    public void setTipo_solicitud(String tipo_solicitud) {
        this.tipo_solicitud = tipo_solicitud;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", solicitud='" + solicitud + '\'' +
                ", tipo_solicitud='" + tipo_solicitud + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }

    public Matricula(Integer id, String correo, String solicitud, String tipo_solicitud, String imagen) {
        this.id = id;
        this.correo = correo;
        this.solicitud = solicitud;
        this.tipo_solicitud = tipo_solicitud;
        this.imagen = imagen;
    }

    public Matricula() {
    }
}
