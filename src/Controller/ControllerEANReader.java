package Controller;

import Model.ModelEANReader;
import View.ViewPrincipal;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.JSONObject;

/**
 *
 * @author Gnomo
 */
public class ControllerEANReader {
    public ControllerEANReader(){}

    
    public void eanReader(ViewPrincipal view) throws IOException{
        ModelEANReader reader = new ModelEANReader();
        String codigo = view.getFieldCodigoCadastro().getText();
        JSONObject json = reader.readJsonFromUrl("https://api.cosmos.bluesoft.com.br/gtins/"+codigo+".json", view.getApiToken());
        if(json == null){
            JOptionPane.showMessageDialog(null, "SEM RESULTADOS");
        }
        else{
            view.getFieldTituloCadastro().setText(json.getString("description"));
        }
    }
}
