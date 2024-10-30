package servicios;

import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jackson.JacksonFeature;

import modelos.Articulo;

public class ArticuloService {
	private String endPoint;
	private Client client; 
	public ArticuloService()
	{
            this.endPoint="http://localhost:8050/api/Articulos";
            client = ClientBuilder.newClient().register(new JacksonFeature());
	}
	
	
	public Articulo consultarArticulo(Integer id)
	{
		Articulo  objArticulo = null;
		
		WebTarget target = client.target(this.endPoint+"/"+id);
		objArticulo = target.request(MediaType.APPLICATION_JSON_TYPE).get(Articulo.class);
		return objArticulo;
	}
	
	public List<Articulo> listarArticulos()
	{
		List<Articulo> listaArticulos=null;		
		WebTarget target = client.target(this.endPoint);
		listaArticulos = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Articulo>>() {});		
		return listaArticulos;
	}
	
	public boolean registrarArticulo(Articulo objArticuloRegistar)
        {
        Articulo objArticulo = null;
        WebTarget target = client.target(this.endPoint);	    
        Entity<Articulo> data = Entity.entity(objArticuloRegistar, MediaType.APPLICATION_JSON_TYPE);
        objArticulo = target.request(MediaType.APPLICATION_JSON_TYPE).post(data, Articulo.class);
    
            return objArticulo != null;
        }
	
	public Articulo actualizarArticulo(Articulo objArticuloActualizar,Integer id)
	{
		Articulo  objArticulo=null;		
		WebTarget target = client.target(this.endPoint+"/"+id);	    
	    Entity<Articulo> data = Entity.entity(objArticuloActualizar, MediaType.APPLICATION_JSON_TYPE);
	    objArticulo = target.request(MediaType.APPLICATION_JSON_TYPE).put(data, Articulo.class);		
		
		return objArticulo;
	}
	
	public Boolean eliminarArticulo(Integer id)
	{
		Boolean bandera=false;
		WebTarget target = client.target(this.endPoint+"/"+id);	    
		bandera = target.request(MediaType.APPLICATION_JSON_TYPE).delete(Boolean.class);
		return bandera;
	}
        
       public Boolean consultarSiExisteArticulo(Integer id) {
                Boolean bandera;
                WebTarget target = client.target(this.endPoint + "/Articulos/existe/" + id);
                bandera = target.request(MediaType.APPLICATION_JSON_TYPE).get(Boolean.class);
                return bandera;
    }    
}