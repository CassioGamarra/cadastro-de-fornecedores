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
    
    Conexao conexao = Conexao.getInstance();
    //Consultar
    public ResultSet consultarTodos(){
        String sql = "SELECT * FROM livro";
        
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
    public boolean cadastrar(Livro livro){
        long codigo;
        int ano;
        String titulo, resumo, genero, autor;
        
        codigo = livro.getCodigo();
        titulo = livro.getTitulo();
        resumo = livro.getResumo();
        genero = livro.getGenero();
        autor = livro.getAutor();
        ano = livro.getAno();
        
        System.out.println(codigo);
        System.out.println(titulo);
        System.out.println(resumo);
        System.out.println(genero);
        System.out.println(autor);
        System.out.println(ano);
        
        String sql = "INSERT INTO livro (codigo, titulo, resumo, genero, autor, ano, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt;
            stmt = conexao.conectarBanco().prepareStatement(sql);
            stmt.setLong(1, codigo);
            stmt.setString(2, titulo);
            stmt.setString(3, resumo);
            stmt.setString(4, genero);
            stmt.setString(5, autor);
            stmt.setInt(6, ano);
            stmt.setInt(7, 1);
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
    public Livro consultar(Long codigo){
        Livro livro = new Livro();
        
        String sql = "SELECT * FROM livro WHERE CODIGO = '"+codigo+"'";
        PreparedStatement stmt;
        try{
            stmt = conexao.conectarBanco().prepareStatement(sql);
            ResultSet result = stmt.executeQuery(sql);
            if(result.next()){
                livro.setTitulo(result.getString("titulo"));
                livro.setResumo(result.getString("resumo"));
                livro.setAutor(result.getString("autor"));
                livro.setGenero(result.getString("genero"));
                livro.setAno(result.getInt("ano"));
            }
            return livro;
        }
        catch (SQLException ex) {
            Logger.getLogger(ModelCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livro;
    }
    //Alterar
    public boolean alterar(Livro livro){
        String sql = "UPDATE livro SET titulo = '"+livro.getTitulo()+"', resumo = '"+livro.getResumo()+"', genero = '"+livro.getGenero()+"', autor = '"+livro.getAutor()+"', ano = '"+livro.getAno()+"'  WHERE codigo = '"+livro.getCodigo()+"'";
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
    public boolean excluir(Livro livro){
        long codigo = 0;
        
        codigo = livro.getCodigo();
        
        String sql = "UPDATE livro SET status = 0 WHERE codigo = '"+codigo+"'";
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
    public boolean restaurar(Livro livro){
        long codigo = 0;
        
        codigo = livro.getCodigo();
        
        String sql = "UPDATE livro SET status = 1 WHERE codigo = '"+codigo+"'";
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
