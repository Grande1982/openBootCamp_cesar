/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatosIdiomas_v2;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cesar
 */
@Entity
@Table(name = "tutorias", catalog = "idiomas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tutorias.findAll", query = "SELECT t FROM Tutorias t"),
    @NamedQuery(name = "Tutorias.findByIdTutoria", query = "SELECT t FROM Tutorias t WHERE t.idTutoria = :idTutoria"),
    @NamedQuery(name = "Tutorias.findByCurso", query = "SELECT t FROM Tutorias t WHERE t.curso = :curso"),
    @NamedQuery(name = "Tutorias.findByDiaSemana", query = "SELECT t FROM Tutorias t WHERE t.diaSemana = :diaSemana"),
    @NamedQuery(name = "Tutorias.findByHoraTutoria", query = "SELECT t FROM Tutorias t WHERE t.horaTutoria = :horaTutoria")})
public class Tutorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTutoria")
    private String idTutoria;
    @Column(name = "curso")
    private String curso;
    @Column(name = "diaSemana")
    private String diaSemana;
    @Column(name = "horaTutoria")
    @Temporal(TemporalType.TIME)

    private Date horaTutoria;

    @JoinColumn(name = "profesor", referencedColumnName = "codProfe")
    @ManyToOne(fetch = FetchType.LAZY)
    private Profesores profesor;
    
    public Tutorias() {
    }

    /**
     *
     * @param idTutoria codigo tutoria. clave primaria
     * @param curso nombre curso
     * @param diaSemana dia de la semana de la tutoria
     * @param horaTutoria hora de la tutoria
     * @param profesor objeto profesor
     */
    

    public Tutorias(String idTutoria, String curso, String diaSemana, Date horaTutoria, Profesores profesor) {
        this.idTutoria = idTutoria;
        this.curso = curso;
        this.diaSemana = diaSemana;
        this.horaTutoria = horaTutoria;
        this.profesor = profesor;
    }
    /**
     * 
     * @return 
     */
    public String getIdTutoria() {
        return idTutoria;
    }
    /**
     * 
     * @param idTutoria 
     */
    public void setIdTutoria(String idTutoria) {
        this.idTutoria = idTutoria;
    }
    /**
     * 
     * @return 
     */
    public String getCurso() {
        return curso;
    }
    /**
     * 
     * @param curso 
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }
    /**
     * 
     * @return 
     */
    public String getDiaSemana() {
        return diaSemana;
    }
    /**
     * 
     * @param diaSemana 
     */
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }
    /**
     * 
     * @return 
     */
    public Date getHoraTutoria() {
        return horaTutoria;
    }
    /**
     * 
     * @param horaTutoria 
     */
    public void setHoraTutoria(Date horaTutoria) {
        this.horaTutoria = horaTutoria;
    }
    /**
     * 
     * @return 
     */
    public Profesores getProfesor() {
        return profesor;
    }
    /**
     * 
     * @param profesor 
     */
    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }
    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTutoria != null ? idTutoria.hashCode() : 0);
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
        if (!(object instanceof Tutorias)) {
            return false;
        }
        Tutorias other = (Tutorias) object;
        if ((this.idTutoria == null && other.idTutoria != null) || (this.idTutoria != null && !this.idTutoria.equals(other.idTutoria))) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return toString tutorias
     */
    @Override
    public String toString() {
        return "BaseDatosIdiomas_v2.Tutorias[ codProf: "+ profesor.getCodProfe() +" idTutoria:" + idTutoria + " curso: " + curso + " diaSemana: " + diaSemana + " horaTutoria: " + horaTutoria + "]";
    }

}
