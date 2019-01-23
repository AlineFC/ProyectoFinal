package cl.accenture.proyecto.model;


import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @Column(name = "idEmpresa")
    private Integer idEmpresa;
    @Column(name = "nombreEmpresa")
    private String nombreEmpresa;



    public Empresa(){

    }

    public Empresa(Integer idEmpresa, String nombreEmpresa, Proyecto proyecto ){
        this.idEmpresa=idEmpresa;
        this.nombreEmpresa=nombreEmpresa;

    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}
