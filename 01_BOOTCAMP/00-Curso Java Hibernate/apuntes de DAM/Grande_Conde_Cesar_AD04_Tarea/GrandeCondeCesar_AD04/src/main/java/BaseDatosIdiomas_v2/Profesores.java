/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatosIdiomas_v2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cesar
 */
@Entity
@Table(name = "profesores", catalog = "idiomas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesores.findAll", query = "SELECT p FROM Profesores p"),
    @NamedQuery(name = "Profesores.findByCodProfe", query = "SELECT p FROM Profesores p WHERE p.codProfe = :codProfe"),
    @NamedQuery(name = "Profesores.findByNombre", query = "SELECT p FROM Profesores p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Profesores.findByApellido", query = "SELECT p FROM Profesores p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Profesores.findByDepartamento", query = "SELECT p FROM Profesores p WHERE p.departamento = :departamento"),
    @NamedQuery(name = "Profesores.findBySueldomes", query = "SELECT p FROM Profesores p WHERE p.sueldomes = :sueldomes"),
    @NamedQuery(name = "Profesores.findByCargo", query = "SELECT p FROM Profesores p WHERE p.cargo = :cargo")})
public class Profesores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codProfe")
    private String codProfe;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "departamento")
    private String departamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sueldomes")
    private BigDecimal sueldomes;
    @Column(name = "cargo")
    private String cargo;
    
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Tutorias> tutoriasList;

    /**
     *
     * constructor vacio
     * */
            
    public Profesores() {
    }

    /**
     * 
     * 
     * @param codProfe codigo profesor. clave primaria 
     * @param nombre nombre del profesor
     * @param apellido apellido del profesor
     * @param departamento departamento profesor
     * @param sueldomes sueldo del profesor
     * @param cargo  cargo del profesor
     */
    public Profesores(String codProfe, String nombre, String apellido, String departamento, BigDecimal sueldomes, String cargo) {
        this.codProfe = codProfe;
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
        this.sueldomes = sueldomes;
        this.cargo = cargo;
    }


    /**
     * 
     * 
     * @return 
     */
    public String getCodProfe() {
        return codProfe;
    }
    
    /**
     * 
     * 
     * @param codProfe 
     */
    public void setCodProfe(String codProfe) {
        this.codProfe = codProfe;
    }
    /**
     * 
     * 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * @return 
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * 
     * @param apellido 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * 
     * @return 
     */
    public String getDepartamento() {
        return departamento;
    }
    /**
     * 
     * @param departamento 
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    /**
     * 
     * @return 
     */
    public BigDecimal getSueldomes() {
        return sueldomes;
    }
    /**
     * 
     * @param sueldomes 
     */
    public void setSueldomes(BigDecimal sueldomes) {
        this.sueldomes = sueldomes;
    }
    /**
     * 
     * @return 
     */
    public String getCargo() {
        return cargo;
    }
    /**
     * 
     * @param cargo 
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    /**
     * 
     * @return 
     */
    @XmlTransient
    public List<Tutorias> getTutoriasList() {
        return tutoriasList;
    }
    /**
     * 
     * @param tutoriasList 
     */
    public void setTutoriasList(List<Tutorias> tutoriasList) {
        this.tutoriasList = tutoriasList;
    }
    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProfe != null ? codProfe.hashCode() : 0);
        return hash;
    }
    /**
     * 
     * @param object
     * @return 
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesores)) {
            return false;
        }
        Profesores other = (Profesores) object;
        if ((this.codProfe == null && other.codProfe != null) || (this.codProfe != null && !this.codProfe.equals(other.codProfe))) {
            return false;
        }
        return true;
    }
    /**
     * 
     * @return toString profesores
     */
    @Override
    public String toString() {
        return "BaseDatosIdiomas_v2.Profesores[ codProfe: " + codProfe + " nombre: " + nombre + " apellido: " + apellido + " departamento: " + departamento + " sueldo: " + sueldomes + " cargo: "+ cargo + "]";
    }

}
