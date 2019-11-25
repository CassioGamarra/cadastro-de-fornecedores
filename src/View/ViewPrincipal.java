/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerCadastro;
import Controller.ControllerConexao;
import Controller.ControllerJson;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author cassio
 */
public class ViewPrincipal extends javax.swing.JFrame{
    //Formatando a hora no sistema
    private static final DateFormat FORMATO = new SimpleDateFormat("HH:mm:ss");
    /**
     * Creates new form ViewPrincipal
     */
    public ViewPrincipal() throws SQLException {
        initComponents();
        conexao.verificaDadosConexao(this);
        conexao.conectar(this);
        cadastro.consultarTodos(this);
        // Iniciamos a thread do relógio. Tornei uma deamon thread para que seja
        // automaticamente finalizada caso a aplicação feche.
        Thread clockThread = new Thread(new ViewPrincipal.ClockRunnable(), "Clock thread");
        clockThread.setDaemon(true);
        clockThread.start();
    }
    
    //Hora do sistema
    
    /**
     * Método para atualizar a hora no formulário. Não é thread-safe, portanto,
     * @param date
     */
    public void setHora(Date date) {
        lblHora.setText(FORMATO.format(date));
    }

    /**
     * Runnable que contém o código que atuará na thread. Chamando o método setHora
     */
    private class ClockRunnable implements Runnable {
        public void run() {
            try {
                while (true) {
                    // Aqui chamamos o setHora através da EventQueue da AWT.
                    // Conforme dito, isso garante Thread safety para o Swing.
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            // Só podemos chamar setHora diretamente dessa
                            // forma, pois esse Runnable é uma InnerClass não
                            // estática.
                            setHora(new Date());
                        }
                    });
                    // Fazemos nossa thread dormir por um segundo, liberando o
                    // processador para outras threads processarem.
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e) {
            }
        }
    }

    //Controller da Conexão
    public ControllerConexao conexao = new ControllerConexao();
    //Controler para buscar a lista de jogos
    public ControllerCadastro cadastro = new ControllerCadastro();
    
    //Getters da conexão
    public JDialog getDialogConexao() {
        return dialogConexao;
    }
    
    public JTextField getFieldUser() {    
        return fieldUser;
    }

    public JTextField getFieldIP() {
        return fieldIP;
    }

    public JTextField getFieldNomeDB() {
        return fieldNomeDB;
    }

    public JPasswordField getFieldPassword() {
        return fieldPassword;
    }

    public JTextField getFieldPorta() {
        return fieldPorta;
    }
    
    //Getters gerais da view
    
    public JTextField getFieldBuscaInativos() {
        return fieldBuscaInativos;
    }

    public JTextField getFieldBusca() {
        return fieldBusca;
    }

    public JDialog getDialogAlterar() {
        return dialogAlterar;
    }
    
    public JDialog getDialogCadastrar() {
        return dialogCadastrar;
    }

    public JDialog getDialogInformacoes() {
        return dialogInformacoes;
    }

    public JDialog getDialogRestaurar() {
        return dialogRestaurar;
    }

    public JTextField getFieldBairroAlt() {
        return fieldBairroAlt;
    }

    public JTextField getFieldBairroCad() {
        return fieldBairroCad;
    }

    public JTextField getFieldBairroInfo() {
        return fieldBairroInfo;
    }

    public JTextField getFieldCEPAlt() {
        return fieldCEPAlt;
    }

    public JTextField getFieldCEPCad() {
        return fieldCEPCad;
    }

    public JTextField getFieldCEPInfo() {
        return fieldCEPInfo;
    }

    public JTextField getFieldCNPJAlt() {
        return fieldCNPJAlt;
    }

    public JTextField getFieldCNPJCad() {
        return fieldCNPJCad;
    }

    public JTextField getFieldCNPJInfo() {
        return fieldCNPJInfo;
    }

    public JTextField getFieldEnderecoAlt() {
        return fieldEnderecoAlt;
    }

    public JTextField getFieldEnderecoCad() {
        return fieldEnderecoCad;
    }

    public JTextField getFieldEnderecoInfo() {
        return fieldEnderecoInfo;
    }

    public JTextField getFieldMunicipioAlt() {
        return fieldMunicipioAlt;
    }

    public JTextField getFieldMunicipioCad() {
        return fieldMunicipioCad;
    }

    public JTextField getFieldMunicipioInfo() {
        return fieldMunicipioInfo;
    }

    public JTextField getFieldNomeAlt() {
        return fieldNomeAlt;
    }

    public JTextField getFieldNomeCad() {
        return fieldNomeCad;
    }

    public JTextField getFieldNomeInfo() {
        return fieldNomeInfo;
    }

    public JTextField getFieldTelefoneAlt() {
        return fieldTelefoneAlt;
    }

    public JTextField getFieldTelefoneCad() {
        return fieldTelefoneCad;
    }

    public JTextField getFieldTelefoneInfo() {
        return fieldTelefoneInfo;
    }

    public JTextField getFieldUFAlt() {
        return fieldUFAlt;
    }

    public JTextField getFieldUFCad() {
        return fieldUFCad;
    }

    public JTextField getFieldUFInfo() {
        return fieldUFInfo;
    }

    public JTable getTabelaFornecedores() {
        return tabelaFornecedores;
    }
    
    public JTable getTabelaFornecedoresInativos() {    
        return tabelaFornecedoresInativos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    @SuppressWarnings(value = "unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogRestaurar = new javax.swing.JDialog();
        panelRestaurar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnRestaurarFornecedor = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaFornecedoresInativos = new javax.swing.JTable();
        fieldBuscaInativos = new javax.swing.JTextField();
        dialogConexao = new javax.swing.JDialog();
        panelConexao = new javax.swing.JPanel();
        fieldIP = new javax.swing.JTextField();
        fieldPorta = new javax.swing.JTextField();
        fieldNomeDB = new javax.swing.JTextField();
        fieldUser = new javax.swing.JTextField();
        fieldPassword = new javax.swing.JPasswordField();
        btnConectar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dialogCadastrar = new javax.swing.JDialog();
        panelCadastro = new javax.swing.JPanel();
        btnCadastrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fieldCNPJCad = new javax.swing.JTextField();
        fieldNomeCad = new javax.swing.JTextField();
        fieldTelefoneCad = new javax.swing.JTextField();
        fieldCEPCad = new javax.swing.JTextField();
        fieldEnderecoCad = new javax.swing.JTextField();
        fieldBairroCad = new javax.swing.JTextField();
        fieldMunicipioCad = new javax.swing.JTextField();
        fieldUFCad = new javax.swing.JTextField();
        dialogAlterar = new javax.swing.JDialog();
        panelCadastro3 = new javax.swing.JPanel();
        btnAlterar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fieldCNPJAlt = new javax.swing.JTextField();
        fieldNomeAlt = new javax.swing.JTextField();
        fieldTelefoneAlt = new javax.swing.JTextField();
        fieldCEPAlt = new javax.swing.JTextField();
        fieldEnderecoAlt = new javax.swing.JTextField();
        fieldBairroAlt = new javax.swing.JTextField();
        fieldMunicipioAlt = new javax.swing.JTextField();
        fieldUFAlt = new javax.swing.JTextField();
        dialogInformacoes = new javax.swing.JDialog();
        panelCadastro2 = new javax.swing.JPanel();
        btnOkInfo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldCNPJInfo = new javax.swing.JTextField();
        fieldNomeInfo = new javax.swing.JTextField();
        fieldTelefoneInfo = new javax.swing.JTextField();
        fieldCEPInfo = new javax.swing.JTextField();
        fieldEnderecoInfo = new javax.swing.JTextField();
        fieldBairroInfo = new javax.swing.JTextField();
        fieldMunicipioInfo = new javax.swing.JTextField();
        fieldUFInfo = new javax.swing.JTextField();
        panelPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFornecedores = new javax.swing.JTable();
        btnRestaurar = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        btnConexao = new javax.swing.JButton();
        btnInformacoes = new javax.swing.JButton();
        btnCadastro = new javax.swing.JButton();
        btnAltera = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        fieldBusca = new javax.swing.JTextField();

        dialogRestaurar.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogRestaurar.setTitle("RESTAURAR FORNECEDOR");
        dialogRestaurar.setBackground(new java.awt.Color(255, 255, 255));
        dialogRestaurar.setFocusable(false);
        dialogRestaurar.setMinimumSize(new java.awt.Dimension(640, 620));
        dialogRestaurar.setResizable(false);

        panelRestaurar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 59, 69));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("FORNECEDORES INATIVOS");

        jButton1.setBackground(new java.awt.Color(51, 59, 69));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("VOLTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnRestaurarFornecedor.setBackground(new java.awt.Color(51, 59, 69));
        btnRestaurarFornecedor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRestaurarFornecedor.setForeground(new java.awt.Color(255, 255, 255));
        btnRestaurarFornecedor.setText("RESTAURAR");
        btnRestaurarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarFornecedorActionPerformed(evt);
            }
        });

        tabelaFornecedoresInativos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabelaFornecedoresInativos.setForeground(new java.awt.Color(51, 59, 69));
        tabelaFornecedoresInativos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNPJ", "NOME", "TELEFONE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFornecedoresInativos.setColumnSelectionAllowed(true);
        tabelaFornecedoresInativos.setGridColor(new java.awt.Color(51, 59, 69));
        tabelaFornecedoresInativos.setRowHeight(20);
        tabelaFornecedoresInativos.setSelectionBackground(new java.awt.Color(51, 59, 69));
        tabelaFornecedoresInativos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaFornecedoresInativos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabelaFornecedoresInativos);
        tabelaFornecedoresInativos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabelaFornecedoresInativos.getColumnModel().getColumnCount() > 0) {
            tabelaFornecedoresInativos.getColumnModel().getColumn(0).setResizable(false);
            tabelaFornecedoresInativos.getColumnModel().getColumn(0).setPreferredWidth(1);
            tabelaFornecedoresInativos.getColumnModel().getColumn(1).setResizable(false);
            tabelaFornecedoresInativos.getColumnModel().getColumn(2).setResizable(false);
        }
        tabelaFornecedoresInativos.setSelectionForeground(new java.awt.Color(255,255,255));

        fieldBuscaInativos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldBuscaInativos.setForeground(new java.awt.Color(51, 59, 69));
        fieldBuscaInativos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 1, true), "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 59, 69))); // NOI18N
        fieldBuscaInativos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldBuscaInativosKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelRestaurarLayout = new javax.swing.GroupLayout(panelRestaurar);
        panelRestaurar.setLayout(panelRestaurarLayout);
        panelRestaurarLayout.setHorizontalGroup(
            panelRestaurarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRestaurarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRestaurarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRestaurarLayout.createSequentialGroup()
                        .addGap(0, 125, Short.MAX_VALUE)
                        .addComponent(btnRestaurarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fieldBuscaInativos))
                .addContainerGap())
        );

        panelRestaurarLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnRestaurarFornecedor, jButton1});

        panelRestaurarLayout.setVerticalGroup(
            panelRestaurarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRestaurarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(fieldBuscaInativos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(panelRestaurarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRestaurarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dialogRestaurarLayout = new javax.swing.GroupLayout(dialogRestaurar.getContentPane());
        dialogRestaurar.getContentPane().setLayout(dialogRestaurarLayout);
        dialogRestaurarLayout.setHorizontalGroup(
            dialogRestaurarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRestaurar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogRestaurarLayout.setVerticalGroup(
            dialogRestaurarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRestaurar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dialogRestaurar.setLocationRelativeTo(null);

        dialogConexao.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogConexao.setTitle("CONFIGURAR CONEXÃO");
        dialogConexao.setAlwaysOnTop(true);
        dialogConexao.setBackground(new java.awt.Color(255, 255, 255));
        dialogConexao.setFocusable(false);
        dialogConexao.setMinimumSize(new java.awt.Dimension(480, 570));
        dialogConexao.setResizable(false);
        dialogConexao.setLocationRelativeTo(null);

        panelConexao.setBackground(new java.awt.Color(255, 255, 255));

        fieldIP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldIP.setForeground(new java.awt.Color(51, 59, 69));
        fieldIP.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "IP *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldPorta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldPorta.setForeground(new java.awt.Color(51, 59, 69));
        fieldPorta.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "PORTA *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N
        fieldPorta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPortaActionPerformed(evt);
            }
        });

        fieldNomeDB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldNomeDB.setForeground(new java.awt.Color(51, 59, 69));
        fieldNomeDB.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "NOME DA BASE DE DADOS *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldUser.setForeground(new java.awt.Color(51, 59, 69));
        fieldUser.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "USUÁRIO *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldPassword.setForeground(new java.awt.Color(51, 59, 69));
        fieldPassword.setText("jPasswordField1");
        fieldPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "SENHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N
        fieldPassword.setCaretColor(new java.awt.Color(255, 255, 255));
        fieldPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldPasswordMouseClicked(evt);
            }
        });

        btnConectar.setBackground(new java.awt.Color(51, 59, 69));
        btnConectar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnConectar.setForeground(new java.awt.Color(255, 255, 255));
        btnConectar.setText("OK");
        btnConectar.setToolTipText("Botão para Conectar com o banco");
        btnConectar.setBorderPainted(false);
        btnConectar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LOGO_1.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 59, 69));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CONFIGURAR CONEXÃO COM A BASE DE DADOS");

        javax.swing.GroupLayout panelConexaoLayout = new javax.swing.GroupLayout(panelConexao);
        panelConexao.setLayout(panelConexaoLayout);
        panelConexaoLayout.setHorizontalGroup(
            panelConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConexaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldPassword)
                    .addComponent(fieldUser)
                    .addComponent(fieldNomeDB))
                .addContainerGap())
            .addGroup(panelConexaoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(fieldIP)
                .addGap(187, 187, 187))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConexaoLayout.createSequentialGroup()
                .addContainerGap(299, Short.MAX_VALUE)
                .addComponent(fieldPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(panelConexaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelConexaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelConexaoLayout.setVerticalGroup(
            panelConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConexaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(panelConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldIP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldPorta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldNomeDB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnConectar.getAccessibleContext().setAccessibleName("botão conectar");

        javax.swing.GroupLayout dialogConexaoLayout = new javax.swing.GroupLayout(dialogConexao.getContentPane());
        dialogConexao.getContentPane().setLayout(dialogConexaoLayout);
        dialogConexaoLayout.setHorizontalGroup(
            dialogConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConexao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogConexaoLayout.setVerticalGroup(
            dialogConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConexao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dialogCadastrar.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogCadastrar.setTitle("CADASTRAR FORNECEDOR");
        dialogCadastrar.setBackground(new java.awt.Color(255, 255, 255));
        dialogCadastrar.setFocusable(false);
        dialogCadastrar.setMinimumSize(new java.awt.Dimension(480, 780));
        dialogCadastrar.setResizable(false);
        dialogCadastrar.setLocationRelativeTo(null);
        dialogCadastrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dialogCadastrarKeyPressed(evt);
            }
        });

        panelCadastro.setBackground(new java.awt.Color(255, 255, 255));

        btnCadastrar.setBackground(new java.awt.Color(51, 59, 69));
        btnCadastrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.setToolTipText("");
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 59, 69));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CADASTRAR FORNECEDOR");

        fieldCNPJCad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldCNPJCad.setForeground(new java.awt.Color(51, 59, 69));
        fieldCNPJCad.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "CNPJ - PRESSIONE ENTER P/ BUSCAR OS DADOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N
        fieldCNPJCad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCNPJCadKeyPressed(evt);
            }
        });

        fieldNomeCad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldNomeCad.setForeground(new java.awt.Color(51, 59, 69));
        fieldNomeCad.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "NOME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldTelefoneCad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldTelefoneCad.setForeground(new java.awt.Color(51, 59, 69));
        fieldTelefoneCad.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "TELEFONE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldCEPCad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldCEPCad.setForeground(new java.awt.Color(51, 59, 69));
        fieldCEPCad.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "CEP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldEnderecoCad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldEnderecoCad.setForeground(new java.awt.Color(51, 59, 69));
        fieldEnderecoCad.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "ENDEREÇO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldBairroCad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldBairroCad.setForeground(new java.awt.Color(51, 59, 69));
        fieldBairroCad.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "BAIRRO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldMunicipioCad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldMunicipioCad.setForeground(new java.awt.Color(51, 59, 69));
        fieldMunicipioCad.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "MUNICÍPIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldUFCad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldUFCad.setForeground(new java.awt.Color(51, 59, 69));
        fieldUFCad.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "ESTADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        javax.swing.GroupLayout panelCadastroLayout = new javax.swing.GroupLayout(panelCadastro);
        panelCadastro.setLayout(panelCadastroLayout);
        panelCadastroLayout.setHorizontalGroup(
            panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastroLayout.createSequentialGroup()
                .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(fieldCNPJCad)
                            .addComponent(fieldCEPCad)
                            .addComponent(fieldEnderecoCad)
                            .addComponent(fieldBairroCad)
                            .addGroup(panelCadastroLayout.createSequentialGroup()
                                .addComponent(fieldMunicipioCad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldUFCad, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fieldNomeCad)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldTelefoneCad)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCadastroLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelCadastroLayout.setVerticalGroup(
            panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCNPJCad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldNomeCad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldTelefoneCad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCEPCad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldEnderecoCad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldBairroCad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldMunicipioCad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldUFCad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(390, 390, 390))
        );

        javax.swing.GroupLayout dialogCadastrarLayout = new javax.swing.GroupLayout(dialogCadastrar.getContentPane());
        dialogCadastrar.getContentPane().setLayout(dialogCadastrarLayout);
        dialogCadastrarLayout.setHorizontalGroup(
            dialogCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCadastro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogCadastrarLayout.setVerticalGroup(
            dialogCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        dialogAlterar.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogAlterar.setTitle("ALTERAR FORNECEDOR");
        dialogAlterar.setBackground(new java.awt.Color(255, 255, 255));
        dialogAlterar.setFocusable(false);
        dialogAlterar.setMinimumSize(new java.awt.Dimension(480, 780));
        dialogAlterar.setResizable(false);
        dialogAlterar.setLocationRelativeTo(null);

        panelCadastro3.setBackground(new java.awt.Color(255, 255, 255));

        btnAlterar.setBackground(new java.awt.Color(51, 59, 69));
        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar.setText("ALTERAR");
        btnAlterar.setToolTipText("");
        btnAlterar.setBorderPainted(false);
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(83, 65, 43));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CADASTRAR FORNECEDOR");

        fieldCNPJAlt.setEditable(false);
        fieldCNPJAlt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldCNPJAlt.setForeground(new java.awt.Color(51, 59, 69));
        fieldCNPJAlt.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "CNPJ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldNomeAlt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldNomeAlt.setForeground(new java.awt.Color(51, 59, 69));
        fieldNomeAlt.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "NOME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldTelefoneAlt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldTelefoneAlt.setForeground(new java.awt.Color(51, 59, 69));
        fieldTelefoneAlt.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "TELEFONE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldCEPAlt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldCEPAlt.setForeground(new java.awt.Color(51, 59, 69));
        fieldCEPAlt.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "CEP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldEnderecoAlt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldEnderecoAlt.setForeground(new java.awt.Color(51, 59, 69));
        fieldEnderecoAlt.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "ENDEREÇO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldBairroAlt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldBairroAlt.setForeground(new java.awt.Color(51, 59, 69));
        fieldBairroAlt.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "BAIRRO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldMunicipioAlt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldMunicipioAlt.setForeground(new java.awt.Color(51, 59, 69));
        fieldMunicipioAlt.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "MUNICÍPIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldUFAlt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldUFAlt.setForeground(new java.awt.Color(51, 59, 69));
        fieldUFAlt.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "ESTADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        javax.swing.GroupLayout panelCadastro3Layout = new javax.swing.GroupLayout(panelCadastro3);
        panelCadastro3.setLayout(panelCadastro3Layout);
        panelCadastro3Layout.setHorizontalGroup(
            panelCadastro3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastro3Layout.createSequentialGroup()
                .addGroup(panelCadastro3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastro3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCadastro3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(fieldCNPJAlt)
                            .addComponent(fieldCEPAlt)
                            .addComponent(fieldEnderecoAlt)
                            .addComponent(fieldBairroAlt)
                            .addGroup(panelCadastro3Layout.createSequentialGroup()
                                .addComponent(fieldMunicipioAlt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldUFAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fieldNomeAlt)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldTelefoneAlt)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCadastro3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelCadastro3Layout.setVerticalGroup(
            panelCadastro3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastro3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCNPJAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldNomeAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldTelefoneAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCEPAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldEnderecoAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldBairroAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCadastro3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldMunicipioAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldUFAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(390, 390, 390))
        );

        javax.swing.GroupLayout dialogAlterarLayout = new javax.swing.GroupLayout(dialogAlterar.getContentPane());
        dialogAlterar.getContentPane().setLayout(dialogAlterarLayout);
        dialogAlterarLayout.setHorizontalGroup(
            dialogAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCadastro3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogAlterarLayout.setVerticalGroup(
            dialogAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCadastro3, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        dialogInformacoes.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogInformacoes.setTitle("INFORMAÇÕES");
        dialogInformacoes.setBackground(new java.awt.Color(255, 255, 255));
        dialogInformacoes.setMinimumSize(new java.awt.Dimension(480, 780));
        dialogInformacoes.setResizable(false);
        dialogInformacoes.setLocationRelativeTo(null);

        panelCadastro2.setBackground(new java.awt.Color(255, 255, 255));

        btnOkInfo.setBackground(new java.awt.Color(51, 59, 69));
        btnOkInfo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnOkInfo.setForeground(new java.awt.Color(255, 255, 255));
        btnOkInfo.setText("OK");
        btnOkInfo.setToolTipText("");
        btnOkInfo.setBorderPainted(false);
        btnOkInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnOkInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkInfoActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(83, 65, 43));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CADASTRAR FORNECEDOR");

        fieldCNPJInfo.setEditable(false);
        fieldCNPJInfo.setBackground(new java.awt.Color(255, 255, 255));
        fieldCNPJInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldCNPJInfo.setForeground(new java.awt.Color(51, 59, 69));
        fieldCNPJInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "CNPJ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldNomeInfo.setEditable(false);
        fieldNomeInfo.setBackground(new java.awt.Color(255, 255, 255));
        fieldNomeInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldNomeInfo.setForeground(new java.awt.Color(51, 59, 69));
        fieldNomeInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "NOME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldTelefoneInfo.setEditable(false);
        fieldTelefoneInfo.setBackground(new java.awt.Color(255, 255, 255));
        fieldTelefoneInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldTelefoneInfo.setForeground(new java.awt.Color(51, 59, 69));
        fieldTelefoneInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "TELEFONE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldCEPInfo.setEditable(false);
        fieldCEPInfo.setBackground(new java.awt.Color(255, 255, 255));
        fieldCEPInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldCEPInfo.setForeground(new java.awt.Color(51, 59, 69));
        fieldCEPInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "CEP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldEnderecoInfo.setEditable(false);
        fieldEnderecoInfo.setBackground(new java.awt.Color(255, 255, 255));
        fieldEnderecoInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldEnderecoInfo.setForeground(new java.awt.Color(51, 59, 69));
        fieldEnderecoInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "ENDEREÇO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldBairroInfo.setEditable(false);
        fieldBairroInfo.setBackground(new java.awt.Color(255, 255, 255));
        fieldBairroInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldBairroInfo.setForeground(new java.awt.Color(51, 59, 69));
        fieldBairroInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "BAIRRO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldMunicipioInfo.setEditable(false);
        fieldMunicipioInfo.setBackground(new java.awt.Color(255, 255, 255));
        fieldMunicipioInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldMunicipioInfo.setForeground(new java.awt.Color(51, 59, 69));
        fieldMunicipioInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "MUNICÍPIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        fieldUFInfo.setEditable(false);
        fieldUFInfo.setBackground(new java.awt.Color(255, 255, 255));
        fieldUFInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldUFInfo.setForeground(new java.awt.Color(51, 59, 69));
        fieldUFInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 2, true), "ESTADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 59, 69))); // NOI18N

        javax.swing.GroupLayout panelCadastro2Layout = new javax.swing.GroupLayout(panelCadastro2);
        panelCadastro2.setLayout(panelCadastro2Layout);
        panelCadastro2Layout.setHorizontalGroup(
            panelCadastro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastro2Layout.createSequentialGroup()
                .addGroup(panelCadastro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastro2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCadastro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(fieldCNPJInfo)
                            .addComponent(fieldCEPInfo)
                            .addComponent(fieldEnderecoInfo)
                            .addComponent(fieldBairroInfo)
                            .addGroup(panelCadastro2Layout.createSequentialGroup()
                                .addComponent(fieldMunicipioInfo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldUFInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fieldNomeInfo)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldTelefoneInfo)
                            .addComponent(btnOkInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCadastro2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelCadastro2Layout.setVerticalGroup(
            panelCadastro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastro2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCNPJInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldNomeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldTelefoneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCEPInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldEnderecoInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldBairroInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCadastro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldMunicipioInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldUFInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOkInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(390, 390, 390))
        );

        javax.swing.GroupLayout dialogInformacoesLayout = new javax.swing.GroupLayout(dialogInformacoes.getContentPane());
        dialogInformacoes.getContentPane().setLayout(dialogInformacoesLayout);
        dialogInformacoesLayout.setHorizontalGroup(
            dialogInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCadastro2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogInformacoesLayout.setVerticalGroup(
            dialogInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCadastro2, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CADASTRO DE FORNECEDORES");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(960, 540));

        tabelaFornecedores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabelaFornecedores.setForeground(new java.awt.Color(51, 59, 69));
        tabelaFornecedores.setBackground(new java.awt.Color(255, 255, 255));
        tabelaFornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNPJ", "NOME", "TELEFONE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFornecedores.setColumnSelectionAllowed(true);
        tabelaFornecedores.setGridColor(new java.awt.Color(51, 59, 69));
        tabelaFornecedores.setRowHeight(20);
        tabelaFornecedores.setSelectionBackground(new java.awt.Color(51, 59, 69));
        tabelaFornecedores.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabelaFornecedores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaFornecedores.getTableHeader().setReorderingAllowed(false);
        tabelaFornecedores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaFornecedoresKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFornecedores);
        tabelaFornecedores.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabelaFornecedores.getColumnModel().getColumnCount() > 0) {
            tabelaFornecedores.getColumnModel().getColumn(0).setResizable(false);
            tabelaFornecedores.getColumnModel().getColumn(0).setPreferredWidth(1);
            tabelaFornecedores.getColumnModel().getColumn(1).setResizable(false);
            tabelaFornecedores.getColumnModel().getColumn(2).setResizable(false);
        }

        btnRestaurar.setBackground(new java.awt.Color(51, 59, 69));
        btnRestaurar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRestaurar.setForeground(new java.awt.Color(255, 255, 255));
        btnRestaurar.setText("F5 - RESTAURAR");
        btnRestaurar.setFocusable(false);
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        lblHora.setBackground(new java.awt.Color(255, 255, 255));
        lblHora.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblHora.setForeground(new java.awt.Color(51, 59, 69));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        btnConexao.setBackground(new java.awt.Color(51, 59, 69));
        btnConexao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConexao.setForeground(new java.awt.Color(255, 255, 255));
        btnConexao.setText("F10 - CONFIGURAR CONEXÃO");
        btnConexao.setFocusable(false);
        btnConexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConexaoActionPerformed(evt);
            }
        });

        btnInformacoes.setBackground(new java.awt.Color(51, 59, 69));
        btnInformacoes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInformacoes.setForeground(new java.awt.Color(255, 255, 255));
        btnInformacoes.setText("F1 - INFORMAÇÕES");
        btnInformacoes.setFocusable(false);
        btnInformacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformacoesActionPerformed(evt);
            }
        });

        btnCadastro.setBackground(new java.awt.Color(51, 59, 69));
        btnCadastro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCadastro.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastro.setText("F2 - CADASTRAR");
        btnCadastro.setFocusable(false);
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        btnAltera.setBackground(new java.awt.Color(51, 59, 69));
        btnAltera.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAltera.setForeground(new java.awt.Color(255, 255, 255));
        btnAltera.setText("F3 - ALTERAR");
        btnAltera.setFocusable(false);
        btnAltera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlteraActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(51, 59, 69));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("F4 - EXCLUIR");
        btnExcluir.setFocusable(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        fieldBusca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldBusca.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 59, 69), 1, true), "Buscar:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 59, 69))); // NOI18N
        fieldBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldBuscaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(logo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnConexao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(btnInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        panelPrincipalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAltera, btnCadastro, btnExcluir, btnInformacoes, btnRestaurar});

        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logo)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConexao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelPrincipalLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAltera, btnCadastro, btnExcluir, btnInformacoes, btnRestaurar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldPasswordMouseClicked
        // TODO add your handling code here:
        fieldPassword.setText("");
    }//GEN-LAST:event_fieldPasswordMouseClicked

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        dialogConexao.setAlwaysOnTop(false);
        try {
            // TODO add your handling code here:
            conexao.salvarDadosConexao(this);
        } catch (SQLException ex) {
            Logger.getLogger(ViewPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConectarActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        // TODO add your handling code here:
        dialogRestaurar.setVisible(true);
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void fieldPortaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPortaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPortaActionPerformed

    private void btnConexaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConexaoActionPerformed
        // TODO add your handling code here:
        dialogConexao.setVisible(true);
    }//GEN-LAST:event_btnConexaoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dialogRestaurar.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnInformacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformacoesActionPerformed
        // TODO add your handling code here:
        cadastro.consultar(this, "informacoes");
    }//GEN-LAST:event_btnInformacoesActionPerformed

    private void btnRestaurarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarFornecedorActionPerformed
        // TODO add your handling code here:
        cadastro.restaurar(this);
    }//GEN-LAST:event_btnRestaurarFornecedorActionPerformed

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        // TODO add your handling code here:
        dialogCadastrar.setVisible(true);
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void btnAlteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlteraActionPerformed
        // TODO add your handling code here:
        cadastro.consultar(this, "alterar");
    }//GEN-LAST:event_btnAlteraActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        cadastro.excluir(this);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        cadastro.cadastrar(this);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void fieldCNPJCadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCNPJCadKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            ControllerJson reader = new ControllerJson();
            try {
                reader.eanReader(this);
            }
            catch (IOException ex) {
                Logger.getLogger(ViewPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_fieldCNPJCadKeyPressed

    private void btnOkInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkInfoActionPerformed
        // TODO add your handling code here:
        dialogInformacoes.dispose();
    }//GEN-LAST:event_btnOkInfoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        cadastro.alterar(this);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_F1){
            JOptionPane.showMessageDialog(null, "Nenhum fornecedor selecionado!");
        }
        if(evt.getKeyCode() == KeyEvent.VK_F2){
            btnCadastro.doClick();
        }
        if(evt.getKeyCode() == KeyEvent.VK_F3){
            JOptionPane.showMessageDialog(null, "Nenhum fornecedor selecionado!");
        }
        if(evt.getKeyCode() == KeyEvent.VK_F4){
            JOptionPane.showMessageDialog(null, "Nenhum fornecedor selecionado!");
        }
        if(evt.getKeyCode() == KeyEvent.VK_F5){
            btnRestaurar.doClick();
        }
        if(evt.getKeyCode() == KeyEvent.VK_F10){
            btnConexao.doClick();
        }
    }//GEN-LAST:event_formKeyPressed

    private void fieldBuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBuscaKeyTyped
        // TODO add your handling code here:
        cadastro.filtrarDados(this, "ativos");
    }//GEN-LAST:event_fieldBuscaKeyTyped

    private void tabelaFornecedoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaFornecedoresKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_F1){
            btnInformacoes.doClick();
        }
        if(evt.getKeyCode() == KeyEvent.VK_F2){
            btnCadastro.doClick();
        }
        if(evt.getKeyCode() == KeyEvent.VK_F3){
            btnAltera.doClick();
        }
        if(evt.getKeyCode() == KeyEvent.VK_F4){
            btnExcluir.doClick();
        }
        if(evt.getKeyCode() == KeyEvent.VK_F5){
            btnRestaurar.doClick();
        }
        if(evt.getKeyCode() == KeyEvent.VK_F10){
            btnConexao.doClick();
        }
    }//GEN-LAST:event_tabelaFornecedoresKeyPressed

    private void fieldBuscaInativosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBuscaInativosKeyTyped
        // TODO add your handling code here:
        cadastro.filtrarDados(this, "inativos");
    }//GEN-LAST:event_fieldBuscaInativosKeyTyped

    private void dialogCadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dialogCadastrarKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnCadastrar.doClick();
        }
    }//GEN-LAST:event_dialogCadastrarKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewPrincipal view = new ViewPrincipal();
                    view.setLocationRelativeTo(null);
                    view.setFocusable(true);
                    view.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltera;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnConexao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInformacoes;
    private javax.swing.JButton btnOkInfo;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JButton btnRestaurarFornecedor;
    private javax.swing.JDialog dialogAlterar;
    private javax.swing.JDialog dialogCadastrar;
    private javax.swing.JDialog dialogConexao;
    private javax.swing.JDialog dialogInformacoes;
    private javax.swing.JDialog dialogRestaurar;
    private javax.swing.JTextField fieldBairroAlt;
    private javax.swing.JTextField fieldBairroCad;
    private javax.swing.JTextField fieldBairroInfo;
    private javax.swing.JTextField fieldBusca;
    private javax.swing.JTextField fieldBuscaInativos;
    private javax.swing.JTextField fieldCEPAlt;
    private javax.swing.JTextField fieldCEPCad;
    private javax.swing.JTextField fieldCEPInfo;
    private javax.swing.JTextField fieldCNPJAlt;
    private javax.swing.JTextField fieldCNPJCad;
    private javax.swing.JTextField fieldCNPJInfo;
    private javax.swing.JTextField fieldEnderecoAlt;
    private javax.swing.JTextField fieldEnderecoCad;
    private javax.swing.JTextField fieldEnderecoInfo;
    private javax.swing.JTextField fieldIP;
    private javax.swing.JTextField fieldMunicipioAlt;
    private javax.swing.JTextField fieldMunicipioCad;
    private javax.swing.JTextField fieldMunicipioInfo;
    private javax.swing.JTextField fieldNomeAlt;
    private javax.swing.JTextField fieldNomeCad;
    private javax.swing.JTextField fieldNomeDB;
    private javax.swing.JTextField fieldNomeInfo;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JTextField fieldPorta;
    private javax.swing.JTextField fieldTelefoneAlt;
    private javax.swing.JTextField fieldTelefoneCad;
    private javax.swing.JTextField fieldTelefoneInfo;
    private javax.swing.JTextField fieldUFAlt;
    private javax.swing.JTextField fieldUFCad;
    private javax.swing.JTextField fieldUFInfo;
    private javax.swing.JTextField fieldUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelCadastro;
    private javax.swing.JPanel panelCadastro2;
    private javax.swing.JPanel panelCadastro3;
    private javax.swing.JPanel panelConexao;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelRestaurar;
    private javax.swing.JTable tabelaFornecedores;
    private javax.swing.JTable tabelaFornecedoresInativos;
    // End of variables declaration//GEN-END:variables
}
