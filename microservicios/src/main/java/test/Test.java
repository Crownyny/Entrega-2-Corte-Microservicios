package test;
import java.io.File;
import javax.swing.UIManager;
import servicios.ArticuloService;
import vista.VtnPrincipal;

/**
 *
 * @author Usuario
 */
public class Test {

    public static void main(String[] args) {
        seleccionarLookAndField();
        ArticuloService objArticuloService= new ArticuloService();       
        VtnPrincipal objVtnPrincipal= new VtnPrincipal();    
        objVtnPrincipal.asociarServicio(objArticuloService);
        objVtnPrincipal.setVisible(true);
        
    }
    
    private static void seleccionarLookAndField()
    {
        for(UIManager.LookAndFeelInfo laf:UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(laf.getName()))
                try {
                UIManager.setLookAndFeel(laf.getClassName());
                 } catch (Exception ex) {
            }
        }
    }
}  

