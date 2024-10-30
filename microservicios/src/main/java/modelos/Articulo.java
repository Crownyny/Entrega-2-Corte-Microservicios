package modelos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Mary
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Articulo {
    private int id;
    private String nombre;
    private String autores;
    private int cantidadAutores;
    private String revista;
    
    public Articulo(){
    }
    
    public Articulo(int id, String nombre, String autores, int cantidadAutores, String revista) {
        this.id = id;
        this.nombre = nombre;
        this.autores = autores;
        this.cantidadAutores = cantidadAutores;
        this.revista = revista;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }
    
    public Integer getCantidadAutores(){
        return cantidadAutores;
    }
    public void setCantidadAutores(Integer cantidadAutores) {
        this.cantidadAutores = cantidadAutores;
    }  
    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }
}
