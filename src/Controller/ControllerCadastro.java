package Controller;

import Model.Conexao;
import Model.Livro;
import Model.ModelCadastro;
import Util.Util;
import View.ViewPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 * Classe do controller de busca e exclusão da base de dados
 * @author Cássio Gamarra
 */
public class ControllerCadastro {
    public ControllerCadastro(){}
    
    ModelCadastro cadastro = new ModelCadastro();
    Conexao conexao = Conexao.getInstance();
    Util util = new Util();
    
    public void consultarTodos(ViewPrincipal view){ 
        if(conexao.getStatus()){
            ResultSet consulta = cadastro.consultarTodos();
        
            DefaultTableModel tabelaLivros = (DefaultTableModel) view.getTabelaLivros().getModel();
            DefaultTableModel tabelaLivrosExcluidos = (DefaultTableModel) view.getTabelaLivrosExcluidos().getModel();

            String titulo, autor, genero;
            long codigo;
            int ano, status;
            
            try {
                while(consulta.next()){
                    codigo = consulta.getLong("codigo");
                    titulo = consulta.getString("titulo");
                    autor = consulta.getString("autor");
                    genero = consulta.getString("genero");
                    ano = consulta.getInt("ano");
                    status = consulta.getInt("status");
                    if(status == 0){
                        Object[] linha = {codigo, titulo, autor, genero, ano};
                        tabelaLivrosExcluidos.addRow(linha);
                    }
                    else{
                        Object[] linha = {codigo, titulo, autor, genero, ano};
                        tabelaLivros.addRow(linha);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerCadastro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    //Cadastrar um livro
    public void cadastrar(ViewPrincipal view){
        Livro livro = new Livro();
        long codigo;
        int ano;
        String titulo, resumo, genero, autor;
        
        String codigoString = view.getFieldCodigoCadastro().getText();
        String anoString = view.getFieldAnoCadastro().getText();
        
        titulo = view.getFieldTituloCadastro().getText();
        resumo = view.getTextResumoCadastro().getText();
        genero = view.getFieldGeneroCadastro().getText();
        autor = view.getFieldAutorCadastro().getText();
        
        
        if((codigoString.equals(""))|| (titulo.equals("")) || (resumo.equals("")) || (genero.equals("")) || (autor.equals("")) || (anoString.equals(""))){
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!", "ERRO", JOptionPane.WARNING_MESSAGE);
        }
        else{
            codigo = Long.parseLong(codigoString);
            ano = Integer.parseInt(anoString);
            livro.setCodigo(codigo);
            livro.setTitulo(titulo);
            livro.setResumo(resumo);
            livro.setGenero(genero);
            livro.setAutor(autor);
            livro.setAno(ano);
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar o livro:\n\n"+livro.getTitulo().toUpperCase(), "CADASTRAR", JOptionPane.YES_NO_OPTION);

            if(opcao == 0){
                if(cadastro.cadastrar(livro)){
                    JOptionPane.showMessageDialog(null, "O livro\n\n"+livro.getTitulo().toUpperCase()+"\n\nfoi cadastrado com sucesso!");
                    util.cleanJTable(view.getTabelaLivros());
                    util.cleanJTable(view.getTabelaLivrosExcluidos());
                    consultarTodos(view);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
                }

            }
            else if(opcao == 1){
                JOptionPane.showMessageDialog(null, "Sem alterações!");
            }
            else{
                return;
            }
        }
    }
    //Consultar um livro
    public void consultar(ViewPrincipal view, String tipoConsulta){
        Livro livro = new Livro();
        int ano;
        String titulo, resumo, autor, genero;

        int i = view.getTabelaLivros().getSelectedRow();
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Nenhum livro selecionado!");
            return;
        }
        long codigo = Long.parseLong(view.getTabelaLivros().getValueAt(i, 0).toString());
        livro = cadastro.consultar(codigo);
        if(livro != null){
            titulo = livro.getTitulo();
            resumo = livro.getResumo();
            autor = livro.getAutor();
            genero = livro.getGenero();
            ano = livro.getAno();
            
            if(tipoConsulta.equals("informacoes")){
                view.getFieldTituloInfo().setText(titulo);
                view.getTextResumoInfo().setText(resumo);
                view.getFieldAutorInfo().setText(autor);
                view.getFieldGeneroInfo().setText(genero);
                view.getFieldAnoInfo().setText(String.valueOf(ano));
                view.getDialogInformacoes().setVisible(true);
            }
            if(tipoConsulta.equals("alterar")){
                view.getFieldCodigoAlteracao().setText(String.valueOf(codigo));
                view.getFieldTituloAlteracao().setText(titulo);
                view.getTextResumoAlteracao().setText(resumo);
                view.getFieldAutorAlteracao().setText(autor);
                view.getFieldGeneroAlteracao().setText(genero);
                view.getFieldAnoAlteracao().setText(String.valueOf(ano));
                view.getDialogAlterar().setVisible(true);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "NENHUM RESULTADO!");
        }
    }
    //Alterar um livro
    public void alterar(ViewPrincipal view){
        Livro livro = new Livro();
        
        String titulo, resumo, genero, autor;
        
        String anoString = view.getFieldAnoAlteracao().getText();
        
        titulo = view.getFieldTituloAlteracao().getText();
        resumo = view.getTextResumoAlteracao().getText();
        genero = view.getFieldGeneroAlteracao().getText();
        autor = view.getFieldAutorAlteracao().getText();
        
        if((titulo.equals("")) || (resumo.equals("")) || (genero.equals("")) || (autor.equals("")) || (anoString.equals(""))){
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!", "ERRO", JOptionPane.WARNING_MESSAGE);
        }
        else{
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja alterar o livro:\n\n"+titulo.toUpperCase(), "ALTERAR", JOptionPane.YES_NO_OPTION);
            
            livro.setCodigo(Long.parseLong(view.getFieldCodigoAlteracao().getText()));
            livro.setTitulo(titulo);
            livro.setResumo(resumo);
            livro.setAutor(autor);
            livro.setGenero(genero);
            livro.setAno(Integer.parseInt(anoString));
            
            if(opcao == 0){
                if(cadastro.alterar(livro)){
                    JOptionPane.showMessageDialog(null, "O livro\n\n"+livro.getTitulo().toUpperCase()+"\n\nfoi alterado com sucesso!");
                    util.cleanJTable(view.getTabelaLivros());
                    util.cleanJTable(view.getTabelaLivrosExcluidos());
                    view.getDialogAlterar().dispose();
                    consultarTodos(view);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro ao alterar!");
                }

            }
            else if(opcao == 1){
                JOptionPane.showMessageDialog(null, "Sem alterações!");
            }
            else{
                return;
            }
        }
    }
    //Excluir um livro
    public void excluir(ViewPrincipal view){
        Livro livro = new Livro();
        
        int i = view.getTabelaLivros().getSelectedRow();
        
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Nenhum livro selecionado!");
            return;
        }
        
        livro.setCodigo(Long.parseLong(view.getTabelaLivros().getValueAt(i, 0).toString()));
        livro.setTitulo(view.getTabelaLivros().getValueAt(i, 1).toString());
               
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o livro:\n\n"+livro.getTitulo().toUpperCase(), "EXCLUIR", JOptionPane.YES_NO_OPTION);

        if(opcao == 0){
            if(cadastro.excluir(livro)){
                JOptionPane.showMessageDialog(null, "O livro\n\n"+livro.getTitulo().toUpperCase()+"\n\nfoi excluido com sucesso!");
                util.cleanJTable(view.getTabelaLivros());
                util.cleanJTable(view.getTabelaLivrosExcluidos());
                consultarTodos(view);
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            }
                 
        }
        else if(opcao == 1){
            JOptionPane.showMessageDialog(null, "Sem alterações!");
        }
        else{
            return;
        }
    }
    //Restaurar um livro
    public void restaurar(ViewPrincipal view){
        Livro livro = new Livro();
        
        int i = view.getTabelaLivrosExcluidos().getSelectedRow();
        
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Nenhum livro selecionado!");
            return;
        }
        
        livro.setCodigo(Long.parseLong(view.getTabelaLivrosExcluidos().getValueAt(i, 0).toString()));
        livro.setTitulo(view.getTabelaLivrosExcluidos().getValueAt(i, 1).toString());
        
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja restaurar o livro:\n\n"+livro.getTitulo().toUpperCase(), "RESTAURAR", JOptionPane.YES_NO_OPTION);
        System.out.println(opcao);
        if(opcao == 0){
            if(cadastro.restaurar(livro)){
                JOptionPane.showMessageDialog(null, "O livro\n\n"+livro.getTitulo().toUpperCase()+"\n\nfoi restaurado com sucesso!");
                util.cleanJTable(view.getTabelaLivros());
                util.cleanJTable(view.getTabelaLivrosExcluidos());
                consultarTodos(view);
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro ao restaurar!");
            }    
        }
        else if(opcao == 1){
            JOptionPane.showMessageDialog(null, "Sem alterações!");
        }
        else{
            return;
        }
    }
}
