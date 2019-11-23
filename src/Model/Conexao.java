package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Singleton com as conexões do SGBD
 * @author cassio
 */
public class Conexao {
    private static Conexao instance;
    private String url;
    private String IP;
    private String porta;
    private String dbname;
    private String user;
    private String password;
    
    //Implementar um status da conexão
    private boolean status;
    
    private Conexao(){}
    
    public static Conexao getInstance(){
        if(instance == null){
            instance = new Conexao();
        }
        return instance;
    }
   
    public Connection conectarBanco() throws SQLException{
        url = "jdbc:mysql://"+getIP()+":"+getPorta()+"/"+getDbname()+"?useTimezone=true&serverTimezone=UTC";
        user = getUser();
        password = getPassword();     
        return conectar();
    }
    
    //Método para conectar com o banco
    private Connection conectar() throws SQLException{
        Connection conectar = null;
        try{
            conectar = DriverManager.getConnection(url, user, password);
            status = true;
            return conectar;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar!", "ERRO!", JOptionPane.WARNING_MESSAGE);
            status = false;
	}        
        return conectar;
    }
    
    //Getter e Setter
    public boolean getStatus() {
        return status;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
}
