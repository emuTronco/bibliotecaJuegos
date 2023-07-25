package entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "desarrollador", schema = "bibliotecajuegos", catalog = "")
public class DesarrolladorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_desarrollador")
    private int idDesarrollador;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "num_juegos")
    private Integer numJuegos;
    @Basic
    @Column(name = "creation_date")
    private Timestamp creationDate;

    public DesarrolladorEntity(String nombre, Integer numJuegos) {
        this.nombre = nombre;
        this.numJuegos = numJuegos;
    }

    public DesarrolladorEntity() {

    }

    public int getIdDesarrollador() {
        return idDesarrollador;
    }

    public void setIdDesarrollador(int idDesarrollador) {
        this.idDesarrollador = idDesarrollador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumJuegos() {
        return numJuegos;
    }

    public void setNumJuegos(Integer numJuegos) {
        this.numJuegos = numJuegos;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DesarrolladorEntity that = (DesarrolladorEntity) o;

        if (idDesarrollador != that.idDesarrollador) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (numJuegos != null ? !numJuegos.equals(that.numJuegos) : that.numJuegos != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDesarrollador;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (numJuegos != null ? numJuegos.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }
}
