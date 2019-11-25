package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONObject;

/**
 * 
 * @author Gnomo
 */
public class ModelJson {
    public ModelJson(){}
    
    public JSONObject readJsonFromUrl(String url) throws IOException{
        URL urlConexao = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlConexao.openConnection();
        connection.setRequestProperty("Content-Type","application/json");
        connection.setRequestMethod("GET");
        
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            connection.getInputStream().close();
            return json;
        }
        catch(Exception e){
            return null;
        }
    }
    
    //Método para ler o objeto
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
    }
}
