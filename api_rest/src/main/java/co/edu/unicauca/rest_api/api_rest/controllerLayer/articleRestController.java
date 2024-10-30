package co.edu.unicauca.rest_api.api_rest.controllerLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.rest_api.api_rest.facadeServices.DTO.CRUDConferencesDTO.ArticleDTO;
import co.edu.unicauca.rest_api.api_rest.facadeServices.DTO.ConferencesLinkArticles.*;
import co.edu.unicauca.rest_api.api_rest.facadeServices.services.IArticleService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200",  
 methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}) 
public class articleRestController {
    @Autowired
    private IArticleService articleService;
    
    @GetMapping("/Articulos")
	public List<ArticleDTO> listarArticulos() {
		return articleService.getAll();
	}

	@GetMapping("/Articulos/{id}")
	public ArticleDTO consultarArticulo(@PathVariable Integer id) {
		ArticleDTO objArticulo = null;
		objArticulo = articleService.getByID(id);
		return objArticulo;
	}

	@PostMapping("/Articulos")
	public ArticleDTO crearArticulo(@RequestBody ArticleDTO Articulo) {
		ArticleDTO objArticulo = null;
		objArticulo = articleService.add(Articulo);
		return objArticulo;
	}

	@PutMapping("/Articulos/{id}")
	public ArticleDTO actualizarArticulo(@RequestBody ArticleDTO Articulo, @PathVariable Integer id) {
		ArticleDTO objArticulo = null;
		ArticleDTO ArticuloActual = articleService.getByID(id);
		if (ArticuloActual != null) {
			objArticulo = articleService.update(id, Articulo);
		}
		return objArticulo;
	}

	@DeleteMapping("/Articulos/{id}")
	public Boolean eliminarArticulo(@PathVariable Integer id) {
		Boolean bandera = false;
		ArticleDTO ArticuloActual = articleService.getByID(id);
		if (ArticuloActual != null) {
			bandera = articleService.delete(id);
		}
		return bandera;
	}

	@GetMapping("/Articulos/existe/{id}")
	public Boolean existeArticulo(@PathVariable Integer id) {
		return articleService.exists(id);
	}
	
    @GetMapping("/Articulos/conferencias/{id}")
    public ArticlesLinkedConferences getConferencesOfArticles(@PathVariable Integer id) {
		return articleService.getConferencesOfArticles(id);
	}

}
