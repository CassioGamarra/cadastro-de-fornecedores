package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe com os métodos de busca e exclusão da base de dados
 * @author Cássio Gamarra
 */
public class ModelCadastro {
    public ModelCadastro(){}
    
    ConnectionFactory conexao = ConnectionFactory.getInstance();
    //Consultar
    public ResultSet consultarTodos(){
        String sql = "SELECT * FROM fornecedor ORDER BY nome";
        
        try {
            PreparedStatement stmt = conexao.conectarBanco().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            conexao.conectarBanco().close();
            return consulta;
        } 
        catch (SQLException e) {
            System.out.println("Erro");
        }
        return null;
    }
    
    //Cadastrar
    public boolean cadastrar(Fornecedor fornecedor){
        String cnpj, nome, telefone, cep, endereco, bairro, municipio, uf;
        
        cnpj = fornecedor.getCNPJ();
        nome = fornecedor.getNome().toUpperCase();
        telefone = fornecedor.getTelefone();
        cep = fornecedor.getCEP();
        endereco = fornecedor.getEndereco().toUpperCase();
        bairro = fornecedor.getBairro().toUpperCase();
        municipio = fornecedor.getMunicipio().toUpperCase();
        uf = fornecedor.getUF().toUpperCase();

        String sql = "INSERT INTO fornecedor (cnpj, nome, telefone, cep, endereco, bairro, municipio, uf, status) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt;
            stmt = conexao.conectarBanco().prepareStatement(sql);
            stmt.setString(1, cnpj);
            stmt.setString(2, nome);
            stmt.setString(3, telefone);
            stmt.setString(4, cep);
            stmt.setString(5, endereco);
            stmt.setString(6, bairro);
            stmt.setString(7, municipio);
            stmt.setString(8, uf);
            stmt.setInt(9, 1);
            stmt.execute();
            conexao.conectarBanco().close();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(ModelCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //Consulta unica
    public Fornecedor consultar(String cnpj){
        Fornecedor fornecedor = new Fornecedor();
        
        String sql = "SELECT * FROM fornecedor WHERE cnpj = '"+cnpj+"'";
        PreparedStatement stmt;
        try{
            stmt = conexao.conectarBanco().prepareStatement(sql);
            ResultSet result = stmt.executeQuery(sql);
            if(result.next()){
                fornecedor.setCNPJ(cnpj);
                fornecedor.setNome(result.getString("nome"));
                fornecedor.setTelefone(result.getString("telefone"));
                fornecedor.setCEP(result.getString("cep"));
                fornecedor.setEndereco(result.getString("endereco"));
                fornecedor.setBairro(result.getString("bairro"));
                fornecedor.setMunicipio(result.getString("municipio"));
                fornecedor.setUF(result.getString("uf"));
            }
            return fornecedor;
        }
        catch (SQLException ex) {
            Logger.getLogger(ModelCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fornecedor;
    }
    
    //Alterar
    public boolean alterar(Fornecedor fornecedor){
        String nome, endereco, bairro, municipio, uf;
        
        nome = fornecedor.getNome().toUpperCase();
        endereco = fornecedor.getEndereco().toUpperCase();
        bairro = fornecedor.getBairro().toUpperCase();
        municipio = fornecedor.getMunicipio().toUpperCase();
        uf = fornecedor.getUF().toUpperCase();
        
        String sql = "UPDATE fornecedor SET nome = '"+nome+"',"
                + "telefone = '"+fornecedor.getTelefone()+"', cep = '"+fornecedor.getCEP()+"',"
                + "endereco = '"+endereco+"', bairro = '"+bairro+"',"
                + "municipio = '"+municipio+"', uf = '"+uf+"'WHERE cnpj = '"+fornecedor.getCNPJ()+"'";
        PreparedStatement stmt;
        try {
            stmt = conexao.conectarBanco().prepareStatement(sql);
            stmt.executeUpdate();
            conexao.conectarBanco().close();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(ModelCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //Excluir
    public boolean excluir(Fornecedor fornecedor){
        String sql = "UPDATE fornecedor SET status = 0 WHERE cnpj = '"+fornecedor.getCNPJ()+"'";
        PreparedStatement stmt;
        try {
            stmt = conexao.conectarBanco().prepareStatement(sql);
            stmt.executeUpdate();
            conexao.conectarBanco().close();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(ModelCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    //Restaurar
    public boolean restaurar(Fornecedor fornecedor){
        String sql = "UPDATE fornecedor SET status = 1 WHERE cnpj = '"+fornecedor.getCNPJ()+"'";
        PreparedStatement stmt;
        try {
            stmt = conexao.conectarBanco().prepareStatement(sql);
            stmt.executeUpdate();
            conexao.conectarBanco().close();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(ModelCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
