package entity;

import jakarta.persistence.*;

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
    @Column(name = "beneficios")
    private Integer beneficios;

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

    public Integer getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(Integer beneficios) {
        this.beneficios = beneficios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DesarrolladorEntity that = (DesarrolladorEntity) o;

        if (idDesarrollador != that.idDesarrollador) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (numJuegos != null ? !numJuegos.equals(that.numJuegos) : that.numJuegos != null) return false;
        if (beneficios != null ? !beneficios.equals(that.beneficios) : that.beneficios != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDesarrollador;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (numJuegos != null ? numJuegos.hashCode() : 0);
        result = 31 * result + (beneficios != null ? beneficios.hashCode() : 0);
        return result;
    }
}
