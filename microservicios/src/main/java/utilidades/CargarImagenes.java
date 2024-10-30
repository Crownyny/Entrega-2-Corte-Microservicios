package utilidades;

import javax.swing.ImageIcon;

/**
 *
 * @author LENOVO
 */
public class CargarImagenes {
    public ImageIcon CargarImagen(String ruta)
    {
        ImageIcon imagen= new javax.swing.ImageIcon(getClass().getResource(ruta));  
        return imagen;
    }
}
