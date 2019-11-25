package Controller;

import Model.ModelJson;
import View.ViewPrincipal;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.JSONObject;

/**
 *
 * @author Gnomo
 */
public class ControllerJson {
    public ControllerJson(){}

    
    public void cnpjFromJson(ViewPrincipal view) throws IOException{
        ModelJson reader = new ModelJson();
        String cnpj = view.getFieldCNPJCad().getText();
        cnpj = cnpj.replaceAll("\\D", "");
        
        JSONObject json = reader.readJsonFromUrl("https://www.receitaws.com.br/v1/cnpj/"+cnpj);
        if((json == null)||(json.getString("status").equals("ERROR"))){
            JOptionPane.showMessageDialog(null, "SEM RESULTADOS");
        }
        else{
            view.getFieldNomeCad().setText(json.getString("nome"));
            view.getFieldTelefoneCad().setText(json.getString("telefone"));
            view.getFieldCEPCad().setText(json.getString("cep"));
            view.getFieldEnderecoCad().setText(json.getString("logradouro")+" | "+json.getString("numero"));
            view.getFieldBairroCad().setText(json.getString("bairro"));
            view.getFieldMunicipioCad().setText(json.getString("municipio"));
            view.getFieldUFCad().setText(json.getString("uf"));
        }
    }
}
