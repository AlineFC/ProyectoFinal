package cl.accenture.proyecto.model;


import javax.persistence.*;

@Entity
@Table(name = "empleados")
public class Persona {

    @Id
    @Column(name = "idPersona")
    private Integer idPersona;
    @Column(name = "rut")
    private String rut;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "habilidad")
    private String habilidad;
    @Column(name = "correo")
    private String email;
    @ManyToOne
    @JoinColumn(name = "idProyecto")
    private Proyecto proyecto;

    public Persona() {

    }
//hola que tal
    public Persona(Integer idPersona,String email, String rut,String nombrePersona,String cargo,String habilidad, Proyecto proyecto) {
        this.idPersona = idPersona;
        this.rut = rut;
        this.nombre = nombrePersona;
        this.cargo=cargo;
        this.habilidad=habilidad;
        this.proyecto=proyecto;
        this.email=email;

             }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }


}