/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerCadastro;
import Controller.ControllerConexao;
import Controller.ControllerEANReader;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;;
import javax.swing.JTextArea;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author cassio
 */
public class ViewPrincipal extends javax.swing.JFrame {
    //Formatando a hora no sistema
    private static final DateFormat FORMATO = new SimpleDateFormat("HH:mm:ss");
    private String apiToken;
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
    
    //Getter do token da api de busca

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public String getApiToken() {
        return apiToken;
    }
    
    //Getters gerais da view
    
    public JTextField getFieldCodigoAlteracao() {
        return fieldCodigoAlteracao;
    }

    public JDialog getDialogAlterar() {
        return dialogAlterar;
    }

    public JDialog getDialogInformacoes() {
        return dialogInformacoes;
    }

    public JTextField getFieldCodigoCadastro() {
        return fieldCodigoCadastro;
    }

    public JTextField getFieldAnoAlteracao() {
        return fieldAnoAlteracao;
    }

    public JTextField getFieldAnoCadastro() {
        return fieldAnoCadastro;
    }

    public JTextField getFieldAnoInfo() {
        return fieldAnoInfo;
    }

    public JTextField getFieldAutorAlteracao() {
        return fieldAutorAlteracao;
    }

    public JTextField getFieldAutorCadastro() {
        return fieldAutorCadastro;
    }

    public JTextField getFieldAutorInfo() {
        return fieldAutorInfo;
    }

    public JTextField getFieldGeneroAlteracao() {
        return fieldGeneroAlteracao;
    }

    public JTextField getFieldGeneroCadastro() {
        return fieldGeneroCadastro;
    }

    public JTextField getFieldGeneroInfo() {
        return fieldGeneroInfo;
    }

    public JTextField getFieldTituloAlteracao() {
        return fieldTituloAlteracao;
    }

    public JTextField getFieldTituloCadastro() {
        return fieldTituloCadastro;
    }

    public JTextField getFieldTituloInfo() {
        return fieldTituloInfo;
    }

    public JTable getTabelaLivros() {
        return tabelaLivros;
    }

    public JTable getTabelaLivrosExcluidos() {
        return tabelaLivrosExcluidos;
    }

    public JTextArea getTextResumoAlteracao() {
        return textResumoAlteracao;
    }

    public JTextArea getTextResumoCadastro() {
        return textResumoCadastro;
    }

    public JTextArea getTextResumoInfo() {
        return textResumoInfo;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings(value = "unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogRestaurar = new javax.swing.JDialog();
        panelRestaurar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnRestaurarJogo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaLivrosExcluidos = new javax.swing.JTable();
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
        fieldGeneroCadastro = new javax.swing.JTextField();
        fieldAnoCadastro = new javax.swing.JTextField();
        fieldTituloCadastro = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fieldAutorCadastro = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        textResumoCadastro = new javax.swing.JTextArea();
        fieldCodigoCadastro = new javax.swing.JTextField();
        dialogAlterar = new javax.swing.JDialog();
        panelAlterar = new javax.swing.JPanel();
        fieldGeneroAlteracao = new javax.swing.JTextField();
        fieldAnoAlteracao = new javax.swing.JTextField();
        fieldTituloAlteracao = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldAutorAlteracao = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        textResumoAlteracao = new javax.swing.JTextArea();
        fieldCodigoAlteracao = new javax.swing.JTextField();
        dialogInformacoes = new javax.swing.JDialog();
        panelInformacoes = new javax.swing.JPanel();
        fieldGeneroInfo = new javax.swing.JTextField();
        fieldAnoInfo = new javax.swing.JTextField();
        fieldTituloInfo = new javax.swing.JTextField();
        btnOkInfo = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fieldAutorInfo = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        textResumoInfo = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLivros = new javax.swing.JTable();
        btnRestaurar = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        btnConexao = new javax.swing.JButton();
        btnInformacoes = new javax.swing.JButton();
        btnCadastro = new javax.swing.JButton();
        btnAltera = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnHide = new javax.swing.JButton();

        dialogRestaurar.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogRestaurar.setTitle("RESTAURAR LIVROS");
        dialogRestaurar.setBackground(new java.awt.Color(255, 255, 255));
        dialogRestaurar.setMinimumSize(new java.awt.Dimension(640, 640));
        dialogRestaurar.setResizable(false);

        panelRestaurar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_1.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(133, 108, 76));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RESTAURAR LIVROS");

        jButton1.setBackground(new java.awt.Color(133, 108, 76));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("VOLTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnRestaurarJogo.setBackground(new java.awt.Color(133, 108, 76));
        btnRestaurarJogo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRestaurarJogo.setForeground(new java.awt.Color(255, 255, 255));
        btnRestaurarJogo.setText("RESTAURAR");
        btnRestaurarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarJogoActionPerformed(evt);
            }
        });

        tabelaLivrosExcluidos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabelaLivrosExcluidos.setForeground(new java.awt.Color(133, 108, 76));
        tabelaLivrosExcluidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "TÍTULO", "GÊNERO", "AUTOR", "ANO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaLivrosExcluidos.setGridColor(new java.awt.Color(133, 108, 76));
        tabelaLivrosExcluidos.setRowHeight(20);
        tabelaLivrosExcluidos.setSelectionBackground(new java.awt.Color(133, 108, 76));
        tabelaLivrosExcluidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaLivrosExcluidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabelaLivrosExcluidos);
        if (tabelaLivrosExcluidos.getColumnModel().getColumnCount() > 0) {
            tabelaLivrosExcluidos.getColumnModel().getColumn(0).setResizable(false);
            tabelaLivrosExcluidos.getColumnModel().getColumn(0).setPreferredWidth(1);
            tabelaLivrosExcluidos.getColumnModel().getColumn(1).setResizable(false);
            tabelaLivrosExcluidos.getColumnModel().getColumn(2).setResizable(false);
            tabelaLivrosExcluidos.getColumnModel().getColumn(3).setResizable(false);
            tabelaLivrosExcluidos.getColumnModel().getColumn(4).setResizable(false);
        }
        tabelaLivrosExcluidos.setSelectionForeground(new java.awt.Color(255,255,255));

        javax.swing.GroupLayout panelRestaurarLayout = new javax.swing.GroupLayout(panelRestaurar);
        panelRestaurar.setLayout(panelRestaurarLayout);
        panelRestaurarLayout.setHorizontalGroup(
            panelRestaurarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRestaurarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRestaurarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRestaurarLayout.createSequentialGroup()
                        .addGap(0, 125, Short.MAX_VALUE)
                        .addComponent(btnRestaurarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        panelRestaurarLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnRestaurarJogo, jButton1});

        panelRestaurarLayout.setVerticalGroup(
            panelRestaurarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRestaurarLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRestaurarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRestaurarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
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
        dialogConexao.setMinimumSize(new java.awt.Dimension(480, 570));
        dialogConexao.setResizable(false);
        dialogConexao.setLocationRelativeTo(null);

        panelConexao.setBackground(new java.awt.Color(255, 255, 255));

        fieldIP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldIP.setForeground(new java.awt.Color(83, 65, 43));
        fieldIP.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "IP *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N
        fieldIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIPActionPerformed(evt);
            }
        });

        fieldPorta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldPorta.setForeground(new java.awt.Color(83, 65, 43));
        fieldPorta.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "PORTA *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N
        fieldPorta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPortaActionPerformed(evt);
            }
        });

        fieldNomeDB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldNomeDB.setForeground(new java.awt.Color(83, 65, 43));
        fieldNomeDB.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "NOME DA BASE DE DADOS *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N

        fieldUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldUser.setForeground(new java.awt.Color(83, 65, 43));
        fieldUser.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "USUÁRIO *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N

        fieldPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldPassword.setForeground(new java.awt.Color(83, 65, 43));
        fieldPassword.setText("jPasswordField1");
        fieldPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "SENHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N
        fieldPassword.setCaretColor(new java.awt.Color(255, 255, 255));
        fieldPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldPasswordMouseClicked(evt);
            }
        });

        btnConectar.setBackground(new java.awt.Color(133, 108, 76));
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
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_1.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(133, 108, 76));
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
        dialogCadastrar.setTitle("CADASTRAR LIVRO");
        dialogCadastrar.setBackground(new java.awt.Color(255, 255, 255));
        dialogCadastrar.setMaximumSize(new java.awt.Dimension(480, 700));
        dialogCadastrar.setMinimumSize(new java.awt.Dimension(480, 700));
        dialogCadastrar.setPreferredSize(new java.awt.Dimension(480, 700));
        dialogCadastrar.setResizable(false);
        dialogCadastrar.setLocationRelativeTo(null);

        panelCadastro.setBackground(new java.awt.Color(255, 255, 255));

        fieldGeneroCadastro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldGeneroCadastro.setForeground(new java.awt.Color(83, 65, 43));
        fieldGeneroCadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "GÊNERO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N
        fieldGeneroCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldGeneroCadastroActionPerformed(evt);
            }
        });

        fieldAnoCadastro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldAnoCadastro.setForeground(new java.awt.Color(83, 65, 43));
        fieldAnoCadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "ANO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N
        fieldAnoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAnoCadastroActionPerformed(evt);
            }
        });

        fieldTituloCadastro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldTituloCadastro.setForeground(new java.awt.Color(83, 65, 43));
        fieldTituloCadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "TÍTULO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N

        btnCadastrar.setBackground(new java.awt.Color(133, 108, 76));
        btnCadastrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.setToolTipText("Botão para Conectar com o banco");
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_1.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(83, 65, 43));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CADASTRAR LIVRO");

        fieldAutorCadastro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldAutorCadastro.setForeground(new java.awt.Color(83, 65, 43));
        fieldAutorCadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "AUTOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N

        textResumoCadastro.setColumns(20);
        textResumoCadastro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        textResumoCadastro.setForeground(new java.awt.Color(83, 65, 43));
        textResumoCadastro.setLineWrap(true);
        textResumoCadastro.setRows(5);
        textResumoCadastro.setWrapStyleWord(true);
        textResumoCadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "RESUMO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(83, 65, 43))); // NOI18N
        jScrollPane2.setViewportView(textResumoCadastro);

        fieldCodigoCadastro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldCodigoCadastro.setForeground(new java.awt.Color(83, 65, 43));
        fieldCodigoCadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "CÓDIGO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N
        fieldCodigoCadastro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCodigoCadastroKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelCadastroLayout = new javax.swing.GroupLayout(panelCadastro);
        panelCadastro.setLayout(panelCadastroLayout);
        panelCadastroLayout.setHorizontalGroup(
            panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastroLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(fieldGeneroCadastro)
                .addGap(187, 187, 187))
            .addGroup(panelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fieldTituloCadastro)
                .addContainerGap())
            .addGroup(panelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fieldAutorCadastro)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCadastroLayout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCadastroLayout.createSequentialGroup()
                        .addComponent(fieldAnoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCadastroLayout.createSequentialGroup()
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))))
            .addGroup(panelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(panelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fieldCodigoCadastro)
                .addContainerGap())
        );
        panelCadastroLayout.setVerticalGroup(
            panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fieldCodigoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldTituloCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldAutorCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldGeneroCadastro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldAnoCadastro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout dialogCadastrarLayout = new javax.swing.GroupLayout(dialogCadastrar.getContentPane());
        dialogCadastrar.getContentPane().setLayout(dialogCadastrarLayout);
        dialogCadastrarLayout.setHorizontalGroup(
            dialogCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCadastro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogCadastrarLayout.setVerticalGroup(
            dialogCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dialogAlterar.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogAlterar.setTitle("ALTERAR LIVRO");
        dialogAlterar.setBackground(new java.awt.Color(255, 255, 255));
        dialogAlterar.setMaximumSize(new java.awt.Dimension(480, 700));
        dialogAlterar.setMinimumSize(new java.awt.Dimension(480, 700));
        dialogAlterar.setPreferredSize(new java.awt.Dimension(480, 700));
        dialogAlterar.setResizable(false);
        dialogAlterar.setLocationRelativeTo(null);

        panelAlterar.setBackground(new java.awt.Color(255, 255, 255));

        fieldGeneroAlteracao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldGeneroAlteracao.setForeground(new java.awt.Color(83, 65, 43));
        fieldGeneroAlteracao.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "GÊNERO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N

        fieldAnoAlteracao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldAnoAlteracao.setForeground(new java.awt.Color(83, 65, 43));
        fieldAnoAlteracao.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "ANO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N

        fieldTituloAlteracao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldTituloAlteracao.setForeground(new java.awt.Color(83, 65, 43));
        fieldTituloAlteracao.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "TÍTULO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N

        btnAlterar.setBackground(new java.awt.Color(133, 108, 76));
        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar.setText("ALTERAR");
        btnAlterar.setToolTipText("Botão para Conectar com o banco");
        btnAlterar.setBorderPainted(false);
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_1.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(83, 65, 43));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ALTERAR LIVRO");

        fieldAutorAlteracao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldAutorAlteracao.setForeground(new java.awt.Color(83, 65, 43));
        fieldAutorAlteracao.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "AUTOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N

        textResumoAlteracao.setColumns(20);
        textResumoAlteracao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        textResumoAlteracao.setForeground(new java.awt.Color(83, 65, 43));
        textResumoAlteracao.setLineWrap(true);
        textResumoAlteracao.setRows(5);
        textResumoAlteracao.setWrapStyleWord(true);
        textResumoAlteracao.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "RESUMO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(83, 65, 43))); // NOI18N
        jScrollPane4.setViewportView(textResumoAlteracao);

        fieldCodigoAlteracao.setEditable(false);
        fieldCodigoAlteracao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldCodigoAlteracao.setForeground(new java.awt.Color(83, 65, 43));
        fieldCodigoAlteracao.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "CÓDIGO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N

        javax.swing.GroupLayout panelAlterarLayout = new javax.swing.GroupLayout(panelAlterar);
        panelAlterar.setLayout(panelAlterarLayout);
        panelAlterarLayout.setHorizontalGroup(
            panelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlterarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(fieldGeneroAlteracao)
                .addGap(187, 187, 187))
            .addGroup(panelAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fieldTituloAlteracao)
                .addContainerGap())
            .addGroup(panelAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fieldAutorAlteracao)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlterarLayout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addGroup(panelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlterarLayout.createSequentialGroup()
                        .addComponent(fieldAnoAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlterarLayout.createSequentialGroup()
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))))
            .addGroup(panelAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fieldCodigoAlteracao)
                .addContainerGap())
        );
        panelAlterarLayout.setVerticalGroup(
            panelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fieldCodigoAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldTituloAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldAutorAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(panelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldGeneroAlteracao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldAnoAlteracao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout dialogAlterarLayout = new javax.swing.GroupLayout(dialogAlterar.getContentPane());
        dialogAlterar.getContentPane().setLayout(dialogAlterarLayout);
        dialogAlterarLayout.setHorizontalGroup(
            dialogAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        dialogAlterarLayout.setVerticalGroup(
            dialogAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        dialogInformacoes.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogInformacoes.setTitle("INFORMAÇÕES");
        dialogInformacoes.setAlwaysOnTop(true);
        dialogInformacoes.setBackground(new java.awt.Color(255, 255, 255));
        dialogInformacoes.setMinimumSize(new java.awt.Dimension(480, 620));
        dialogInformacoes.setResizable(false);
        dialogInformacoes.setLocationRelativeTo(null);

        panelInformacoes.setBackground(new java.awt.Color(255, 255, 255));

        fieldGeneroInfo.setEditable(false);
        fieldGeneroInfo.setBackground(new java.awt.Color(255, 255, 255));
        fieldGeneroInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldGeneroInfo.setForeground(new java.awt.Color(83, 65, 43));
        fieldGeneroInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "GÊNERO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N
        fieldGeneroInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldGeneroInfoActionPerformed(evt);
            }
        });

        fieldAnoInfo.setEditable(false);
        fieldAnoInfo.setBackground(new java.awt.Color(255, 255, 255));
        fieldAnoInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldAnoInfo.setForeground(new java.awt.Color(83, 65, 43));
        fieldAnoInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "ANO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N
        fieldAnoInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAnoInfoActionPerformed(evt);
            }
        });

        fieldTituloInfo.setEditable(false);
        fieldTituloInfo.setBackground(new java.awt.Color(255, 255, 255));
        fieldTituloInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldTituloInfo.setForeground(new java.awt.Color(83, 65, 43));
        fieldTituloInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "TÍTULO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N

        btnOkInfo.setBackground(new java.awt.Color(133, 108, 76));
        btnOkInfo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnOkInfo.setForeground(new java.awt.Color(255, 255, 255));
        btnOkInfo.setText("OK");
        btnOkInfo.setToolTipText("Botão para Conectar com o banco");
        btnOkInfo.setBorderPainted(false);
        btnOkInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnOkInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkInfoActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_1.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("INFORMAÇÕES");

        fieldAutorInfo.setEditable(false);
        fieldAutorInfo.setBackground(new java.awt.Color(255, 255, 255));
        fieldAutorInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fieldAutorInfo.setForeground(new java.awt.Color(83, 65, 43));
        fieldAutorInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "AUTOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(83, 65, 43))); // NOI18N

        textResumoInfo.setEditable(false);
        textResumoInfo.setColumns(20);
        textResumoInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        textResumoInfo.setForeground(new java.awt.Color(83, 65, 43));
        textResumoInfo.setLineWrap(true);
        textResumoInfo.setRows(5);
        textResumoInfo.setToolTipText("");
        textResumoInfo.setWrapStyleWord(true);
        textResumoInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 65, 43), 2, true), "RESUMO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(83, 65, 43))); // NOI18N
        jScrollPane5.setViewportView(textResumoInfo);

        javax.swing.GroupLayout panelInformacoesLayout = new javax.swing.GroupLayout(panelInformacoes);
        panelInformacoes.setLayout(panelInformacoesLayout);
        panelInformacoesLayout.setHorizontalGroup(
            panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacoesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(fieldGeneroInfo)
                .addGap(187, 187, 187))
            .addGroup(panelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fieldTituloInfo)
                .addContainerGap())
            .addGroup(panelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fieldAutorInfo)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacoesLayout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacoesLayout.createSequentialGroup()
                        .addComponent(fieldAnoInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacoesLayout.createSequentialGroup()
                        .addComponent(btnOkInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))))
            .addGroup(panelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        panelInformacoesLayout.setVerticalGroup(
            panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fieldTituloInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldAutorInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldGeneroInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldAnoInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOkInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout dialogInformacoesLayout = new javax.swing.GroupLayout(dialogInformacoes.getContentPane());
        dialogInformacoes.getContentPane().setLayout(dialogInformacoesLayout);
        dialogInformacoesLayout.setHorizontalGroup(
            dialogInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInformacoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogInformacoesLayout.setVerticalGroup(
            dialogInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BIBLIOTECA PESSOAL");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setFocusTraversalPolicyProvider(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 540));

        tabelaLivros.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabelaLivros.setForeground(new java.awt.Color(133, 108, 76));
        tabelaLivros.setBackground(new java.awt.Color(255, 255, 255));
        tabelaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "TÍTULO", "GÊNERO", "AUTOR", "ANO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaLivros.setGridColor(new java.awt.Color(133, 108, 76));
        tabelaLivros.setRowHeight(20);
        tabelaLivros.setSelectionBackground(new java.awt.Color(133, 108, 76));
        tabelaLivros.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabelaLivros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaLivros.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaLivros);
        if (tabelaLivros.getColumnModel().getColumnCount() > 0) {
            tabelaLivros.getColumnModel().getColumn(0).setResizable(false);
            tabelaLivros.getColumnModel().getColumn(0).setPreferredWidth(1);
            tabelaLivros.getColumnModel().getColumn(1).setResizable(false);
            tabelaLivros.getColumnModel().getColumn(2).setResizable(false);
            tabelaLivros.getColumnModel().getColumn(3).setResizable(false);
            tabelaLivros.getColumnModel().getColumn(4).setResizable(false);
        }

        btnRestaurar.setBackground(new java.awt.Color(133, 108, 76));
        btnRestaurar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRestaurar.setForeground(new java.awt.Color(255, 255, 255));
        btnRestaurar.setText("RESTAURAR LIVROS");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        lblHora.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblHora.setForeground(new java.awt.Color(83, 65, 43));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        btnConexao.setBackground(new java.awt.Color(133, 108, 76));
        btnConexao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConexao.setForeground(new java.awt.Color(255, 255, 255));
        btnConexao.setText("CONFIGURAR CONEXÃO");
        btnConexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConexaoActionPerformed(evt);
            }
        });

        btnInformacoes.setBackground(new java.awt.Color(133, 108, 76));
        btnInformacoes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInformacoes.setForeground(new java.awt.Color(255, 255, 255));
        btnInformacoes.setText("VER INFORMAÇÕES");
        btnInformacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformacoesActionPerformed(evt);
            }
        });

        btnCadastro.setBackground(new java.awt.Color(133, 108, 76));
        btnCadastro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCadastro.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastro.setText("CADASTRAR LIVRO");
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        btnAltera.setBackground(new java.awt.Color(133, 108, 76));
        btnAltera.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAltera.setForeground(new java.awt.Color(255, 255, 255));
        btnAltera.setText("ALTERAR LIVRO");
        btnAltera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlteraActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(133, 108, 76));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("EXCLUIR LIVRO");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnHide.setMaximumSize(new java.awt.Dimension(0, 0));
        btnHide.setMinimumSize(new java.awt.Dimension(0, 0));
        btnHide.setPreferredSize(new java.awt.Dimension(0, 0));
        btnHide.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnHideKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(logo)
                        .addGap(129, 129, 129)
                        .addComponent(btnHide, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConexao))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAltera, btnCadastro, btnExcluir, btnInformacoes, btnRestaurar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnHide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)))
                        .addComponent(btnConexao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAltera, btnCadastro, btnExcluir, btnInformacoes, btnRestaurar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldIPActionPerformed

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

    private void btnRestaurarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarJogoActionPerformed
        // TODO add your handling code here:
        cadastro.restaurar(this);
    }//GEN-LAST:event_btnRestaurarJogoActionPerformed

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

    private void fieldGeneroCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldGeneroCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldGeneroCadastroActionPerformed

    private void fieldAnoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAnoCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAnoCadastroActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        cadastro.cadastrar(this);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        cadastro.alterar(this);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void fieldGeneroInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldGeneroInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldGeneroInfoActionPerformed

    private void fieldAnoInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAnoInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAnoInfoActionPerformed

    private void btnOkInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkInfoActionPerformed
        // TODO add your handling code here:
        dialogInformacoes.dispose();
    }//GEN-LAST:event_btnOkInfoActionPerformed

    private void fieldCodigoCadastroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCodigoCadastroKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja consultar o código online?", "CONSULTAR CÓDIGO", JOptionPane.YES_NO_OPTION);
            
            if(opcao == 0){
                ControllerEANReader reader = new ControllerEANReader();
                try {
                    reader.eanReader(this);
                }
                catch (IOException ex) {
                    Logger.getLogger(ViewPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_fieldCodigoCadastroKeyPressed

    private void btnHideKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnHideKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_F2){
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja inserir o token da API de consulta?", "TOKEN", JOptionPane.YES_NO_OPTION);
            if(opcao == 0){
                setApiToken(JOptionPane.showInputDialog("Digite o token: "));
            }
        }
    }//GEN-LAST:event_btnHideKeyPressed

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
    private javax.swing.JButton btnHide;
    private javax.swing.JButton btnInformacoes;
    private javax.swing.JButton btnOkInfo;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JButton btnRestaurarJogo;
    private javax.swing.JDialog dialogAlterar;
    private javax.swing.JDialog dialogCadastrar;
    private javax.swing.JDialog dialogConexao;
    private javax.swing.JDialog dialogInformacoes;
    private javax.swing.JDialog dialogRestaurar;
    private javax.swing.JTextField fieldAnoAlteracao;
    private javax.swing.JTextField fieldAnoCadastro;
    private javax.swing.JTextField fieldAnoInfo;
    private javax.swing.JTextField fieldAutorAlteracao;
    private javax.swing.JTextField fieldAutorCadastro;
    private javax.swing.JTextField fieldAutorInfo;
    private javax.swing.JTextField fieldCodigoAlteracao;
    private javax.swing.JTextField fieldCodigoCadastro;
    private javax.swing.JTextField fieldGeneroAlteracao;
    private javax.swing.JTextField fieldGeneroCadastro;
    private javax.swing.JTextField fieldGeneroInfo;
    private javax.swing.JTextField fieldIP;
    private javax.swing.JTextField fieldNomeDB;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JTextField fieldPorta;
    private javax.swing.JTextField fieldTituloAlteracao;
    private javax.swing.JTextField fieldTituloCadastro;
    private javax.swing.JTextField fieldTituloInfo;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelAlterar;
    private javax.swing.JPanel panelCadastro;
    private javax.swing.JPanel panelConexao;
    private javax.swing.JPanel panelInformacoes;
    private javax.swing.JPanel panelRestaurar;
    private javax.swing.JTable tabelaLivros;
    private javax.swing.JTable tabelaLivrosExcluidos;
    private javax.swing.JTextArea textResumoAlteracao;
    private javax.swing.JTextArea textResumoCadastro;
    private javax.swing.JTextArea textResumoInfo;
    // End of variables declaration//GEN-END:variables
}
