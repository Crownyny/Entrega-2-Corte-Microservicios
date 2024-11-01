package co.edu.unicauca.rest_api.api_rest.dataAccessLayer.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleEntity {
    private int id;
    private String nombre;
    private String autores;
    private int cantidadAutores;
    private String revista;

    public ArticleEntity() {}
}
