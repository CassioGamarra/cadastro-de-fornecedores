package Controller;

import Model.ConnectionFactory;
import Model.Fornecedor;
import Model.ModelCadastro;
import Util.Util;
import View.ViewPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 * Classe do controller de busca e exclusão da base de dados
 * @author Cássio Gamarra
 */
public class ControllerCadastro {
    public ControllerCadastro(){}
    
    ModelCadastro cadastro = new ModelCadastro();
    ConnectionFactory conexao = ConnectionFactory.getInstance();
    Util util = new Util();
    
    //Filtrar uma consulta na tabela
    public void filtrarDados(ViewPrincipal view, String nomeTabela){
        DefaultTableModel tabela;
        TableRowSorter<TableModel> sorter = new TableRowSorter<>();
        String busca = "";
        
        if(nomeTabela.equals("ativos")){
            tabela = (DefaultTableModel) view.getTabelaFornecedores().getModel();
            sorter = new TableRowSorter<>(tabela);
            view.getTabelaFornecedores().setRowSorter(sorter);
            busca = view.getFieldBusca().getText().toUpperCase();
        }
        else if(nomeTabela.equals("inativos")){
            tabela = (DefaultTableModel) view.getTabelaFornecedoresInativos().getModel();
            sorter = new TableRowSorter<>(tabela);
            view.getTabelaFornecedoresInativos().setRowSorter(sorter);
            busca = view.getFieldBuscaInativos().getText().toUpperCase();
        }
        
        if(busca.length() == 0){
            sorter.setRowFilter(null);
        }
        else{
            sorter.setRowFilter(RowFilter.regexFilter(busca, 1));
        }
        
    }
    
    //Consultar todos os cadastrados ativos e inativos
    public void consultarTodos(ViewPrincipal view){ 
        if(conexao.getStatus()){
            ResultSet consulta = cadastro.consultarTodos();
        
            DefaultTableModel tblFornecedores = (DefaultTableModel) view.getTabelaFornecedores().getModel();
            DefaultTableModel tblFornecedoresInativos = (DefaultTableModel) view.getTabelaFornecedoresInativos().getModel();

            String cnpj, nome, telefone;
            int status;
            
            try {
                while(consulta.next()){
                    cnpj = consulta.getString("cnpj");
                    nome = consulta.getString("nome");
                    telefone = consulta.getString("telefone");
                    status = consulta.getInt("status");
                    if(status == 0){
                        Object[] linha = {cnpj, nome, telefone};
                        tblFornecedoresInativos.addRow(linha);
                    }
                    else{
                        Object[] linha = {cnpj, nome, telefone};
                        tblFornecedores.addRow(linha);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerCadastro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    //Cadastrar um fornecedor
    public void cadastrar(ViewPrincipal view){
        Fornecedor fornecedor = new Fornecedor();
        
        String cnpj, nome, telefone, cep, endereco, bairro, municipio, uf;
        
        cnpj = view.getFieldCNPJCad().getText();
        nome = view.getFieldNomeCad().getText();
        telefone = view.getFieldTelefoneCad().getText();
        cep = view.getFieldCEPCad().getText();
        endereco = view.getFieldEnderecoCad().getText();
        bairro = view.getFieldBairroCad().getText();
        municipio = view.getFieldMunicipioCad().getText();
        uf = view.getFieldUFCad().getText();
        
        
        if((cnpj.equals(""))|| (telefone.equals("")) || (cep.equals("")) || 
                (endereco.equals("")) || (bairro.equals("")) || 
                (municipio.equals("")) || (uf.equals(""))){
            JOptionPane.showMessageDialog(null, 
                    "Por favor, preencha todos os campos!", "ERRO", 
                    JOptionPane.WARNING_MESSAGE);
        }
        else{
            fornecedor.setCNPJ(cnpj);
            fornecedor.setNome(nome);
            fornecedor.setTelefone(telefone);
            fornecedor.setCEP(cep);
            fornecedor.setEndereco(endereco);
            fornecedor.setBairro(bairro);
            fornecedor.setMunicipio(municipio);
            fornecedor.setUF(uf);
            
            int opcao = JOptionPane.showConfirmDialog(null, 
                    "Deseja cadastrar a empresa:\n\n"+
                            fornecedor.getNome().toUpperCase(), "CADASTRAR", 
                            JOptionPane.YES_NO_OPTION);

            if(opcao == 0){
                if(cadastro.cadastrar(fornecedor)){
                    JOptionPane.showMessageDialog(null, "O fornecedor\n\n"+
                            fornecedor.getNome().toUpperCase()+
                            "\n\nfoi cadastrado com sucesso!");
                    util.cleanJTable(view.getTabelaFornecedores());
                    util.cleanJTable(view.getTabelaFornecedoresInativos());
                    util.limparCampos(view.getDialogCadastrar());
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
    
    //Consultar um fornecedor
    public void consultar(ViewPrincipal view, String tipoConsulta){
        Fornecedor fornecedor  = new Fornecedor();
        
        String cnpj, nome, telefone, cep, endereco, bairro, municipio, uf;

        int i = view.getTabelaFornecedores().getSelectedRow();
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Nenhum fornecedor selecionado!");
            return;
        }
        cnpj = view.getTabelaFornecedores().getValueAt(i, 0).toString();
        
        fornecedor = cadastro.consultar(cnpj);
        if(fornecedor != null){
            nome = fornecedor.getNome();
            telefone = fornecedor.getTelefone();
            cep = fornecedor.getCEP();
            endereco = fornecedor.getEndereco();
            bairro = fornecedor.getBairro();
            municipio = fornecedor.getMunicipio();
            uf = fornecedor.getUF();
            
            if(tipoConsulta.equals("informacoes")){
                view.getFieldCNPJInfo().setText(cnpj);
                view.getFieldNomeInfo().setText(nome);
                view.getFieldTelefoneInfo().setText(telefone);
                view.getFieldCEPInfo().setText(cep);
                view.getFieldEnderecoInfo().setText(endereco);
                view.getFieldBairroInfo().setText(bairro);
                view.getFieldMunicipioInfo().setText(municipio);
                view.getFieldUFInfo().setText(uf);
                view.getDialogInformacoes().setVisible(true);
            }
            if(tipoConsulta.equals("alterar")){
                view.getFieldCNPJAlt().setText(cnpj);
                view.getFieldNomeAlt().setText(nome);
                view.getFieldTelefoneAlt().setText(telefone);
                view.getFieldCEPAlt().setText(cep);
                view.getFieldEnderecoAlt().setText(endereco);
                view.getFieldBairroAlt().setText(bairro);
                view.getFieldMunicipioAlt().setText(municipio);
                view.getFieldUFAlt().setText(uf);
                view.getDialogAlterar().setVisible(true);
            }
        }
        
        else{
            JOptionPane.showMessageDialog(null, "NENHUM RESULTADO!");
        }
    }
    
    //Alterar um fornecedor
    public void alterar(ViewPrincipal view){
        Fornecedor fornecedor = new Fornecedor();
        
        String cnpj, nome, telefone, cep, endereco, bairro, municipio, uf;
        
        cnpj = view.getFieldCNPJAlt().getText();
        nome = view.getFieldNomeAlt().getText();
        telefone = view.getFieldTelefoneAlt().getText();
        cep = view.getFieldCEPAlt().getText();
        endereco = view.getFieldEnderecoAlt().getText();
        bairro = view.getFieldBairroAlt().getText();
        municipio = view.getFieldMunicipioAlt().getText();
        uf = view.getFieldUFAlt().getText();

        if((telefone.equals("")) || (cep.equals("")) || 
                (endereco.equals("")) || (bairro.equals("")) || 
                (municipio.equals("")) || (uf.equals(""))){
            JOptionPane.showMessageDialog(null, 
                    "Por favor, preencha todos os campos!", "ERRO", 
                    JOptionPane.WARNING_MESSAGE);
        }
        else{
            int opcao = JOptionPane.showConfirmDialog(null, 
                    "Deseja alterar a empresa:\n\n"+
                            nome.toUpperCase(), "ALTERAR", 
                            JOptionPane.YES_NO_OPTION);
            fornecedor.setCNPJ(cnpj);
            fornecedor.setNome(nome);
            fornecedor.setTelefone(telefone);
            fornecedor.setCEP(cep);
            fornecedor.setEndereco(endereco);
            fornecedor.setBairro(bairro);
            fornecedor.setMunicipio(municipio);
            fornecedor.setUF(uf);
            
            if(opcao == 0){
                if(cadastro.alterar(fornecedor)){
                    JOptionPane.showMessageDialog(null, "O fornecedor\n\n"+
                            fornecedor.getNome().toUpperCase()+
                            "\n\nfoi alterado com sucesso!");
                    util.cleanJTable(view.getTabelaFornecedores());
                    util.cleanJTable(view.getTabelaFornecedoresInativos());
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
    
    //Excluir um fornecedor
    public void excluir(ViewPrincipal view){
        Fornecedor fornecedor = new Fornecedor();
        
        int i = view.getTabelaFornecedores().getSelectedRow();
        
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Nenhum fornecedor selecionado!");
            return;
        }
        
        fornecedor.setCNPJ(view.getTabelaFornecedores().getValueAt(i, 0).toString());
        fornecedor.setNome(view.getTabelaFornecedores().getValueAt(i, 1).toString());
               
        int opcao = JOptionPane.showConfirmDialog(null,
                "Deseja excluir o fornecedor:\n\n"+
                        fornecedor.getNome().toUpperCase(), "EXCLUIR", 
                        JOptionPane.YES_NO_OPTION);

        if(opcao == 0){
            if(cadastro.excluir(fornecedor)){
                JOptionPane.showMessageDialog(null, "O fornecedor\n\n"+
                            fornecedor.getNome().toUpperCase()+
                            "\n\nfoi excluido com sucesso!");
                    util.cleanJTable(view.getTabelaFornecedores());
                    util.cleanJTable(view.getTabelaFornecedoresInativos());
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
    
    //Restaurar um fornecedor
    public void restaurar(ViewPrincipal view){
        Fornecedor fornecedor = new Fornecedor();
        
        int i = view.getTabelaFornecedoresInativos().getSelectedRow();
        
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Nenhum fornecedor selecionado!");
            return;
        }

        fornecedor.setCNPJ(view.getTabelaFornecedoresInativos().getValueAt(i, 0).toString());
        fornecedor.setNome(view.getTabelaFornecedoresInativos().getValueAt(i, 1).toString());
        
        int opcao = JOptionPane.showConfirmDialog(null, 
                "Deseja restaurar o fornecedor:\n\n"+
                        fornecedor.getNome().toUpperCase(), "RESTAURAR", 
                        JOptionPane.YES_NO_OPTION);
        if(opcao == 0){
            if(cadastro.restaurar(fornecedor)){
                JOptionPane.showMessageDialog(null, "O fornecedor\n\n"+
                            fornecedor.getNome().toUpperCase()+
                            "\n\nfoi restaurado com sucesso!");
                    util.cleanJTable(view.getTabelaFornecedores());
                    util.cleanJTable(view.getTabelaFornecedoresInativos());
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
