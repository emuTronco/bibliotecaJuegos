package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Arrays;

@Entity
@Table(name = "juego", schema = "bibliotecajuegos", catalog = "")
public class JuegoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_juego")
    private int idJuego;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "id_desarrollador")
    private Integer idDesarrollador;
    @Basic
    @Column(name = "id_genero")
    private Integer idGenero;
    @Basic
    @Column(name = "precio")
    private Integer precio;
    @Basic
    @Column(name = "fecha_lanzamiento")
    private Date fechaLanzamiento;
    @Basic
    @Column(name = "caratula")
    private byte[] caratula;
    @Basic
    @Column(name = "creation_date")
    private Date creationDate;

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdDesarrollador() {
        return idDesarrollador;
    }

    public void setIdDesarrollador(Integer idDesarrollador) {
        this.idDesarrollador = idDesarrollador;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public byte[] getCaratula() {
        return caratula;
    }

    public void setCaratula(byte[] caratula) {
        this.caratula = caratula;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JuegoEntity juego = (JuegoEntity) o;

        if (idJuego != juego.idJuego) return false;
        if (nombre != null ? !nombre.equals(juego.nombre) : juego.nombre != null) return false;
        if (idDesarrollador != null ? !idDesarrollador.equals(juego.idDesarrollador) : juego.idDesarrollador != null)
            return false;
        if (idGenero != null ? !idGenero.equals(juego.idGenero) : juego.idGenero != null) return false;
        if (precio != null ? !precio.equals(juego.precio) : juego.precio != null) return false;
        if (fechaLanzamiento != null ? !fechaLanzamiento.equals(juego.fechaLanzamiento) : juego.fechaLanzamiento != null)
            return false;
        if (!Arrays.equals(caratula, juego.caratula)) return false;
        if (creationDate != null ? !creationDate.equals(juego.creationDate) : juego.creationDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idJuego;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (idDesarrollador != null ? idDesarrollador.hashCode() : 0);
        result = 31 * result + (idGenero != null ? idGenero.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        result = 31 * result + (fechaLanzamiento != null ? fechaLanzamiento.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(caratula);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }
}
