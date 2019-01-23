package cl.accenture.proyecto.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "proyectos")
public class Proyecto {


    @Id
    @Column(name = "idProyecto")
    private Integer idProyecto;

    @Column
    private String nombreProyecto;
    @Column
    private Date fechaInicio;
    @Column
    private Date fechaTermino;
    @Column
    private boolean Status;

    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;

    public Proyecto(){
    }
    public Proyecto(Integer idProyecto, String nombreProyecto,Date fechaInicio,Date fechaTermino, boolean Status){

        this.idProyecto = idProyecto;
        this.nombreProyecto=nombreProyecto;
        this.fechaInicio=fechaInicio;
        this.fechaTermino=fechaTermino;
        this.Status=Status;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(java.sql.Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(java.sql.Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }



}
