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
    @Column(name = "genero")
    private String genero;
    @Basic
    @Column(name = "precio")
    private Integer precio;
    @Basic
    @Column(name = "fecha_lanzamiento")
    private Date fechaLanzamiento;
    @Basic
    @Column(name = "caratula")
    private byte[] caratula;

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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JuegoEntity that = (JuegoEntity) o;

        if (idJuego != that.idJuego) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (genero != null ? !genero.equals(that.genero) : that.genero != null) return false;
        if (precio != null ? !precio.equals(that.precio) : that.precio != null) return false;
        if (fechaLanzamiento != null ? !fechaLanzamiento.equals(that.fechaLanzamiento) : that.fechaLanzamiento != null)
            return false;
        if (!Arrays.equals(caratula, that.caratula)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idJuego;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (genero != null ? genero.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        result = 31 * result + (fechaLanzamiento != null ? fechaLanzamiento.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(caratula);
        return result;
    }
}
