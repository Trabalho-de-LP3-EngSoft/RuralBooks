/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import DAO.MetodosLivros;
import DAO.AdicionarUsuario;
import DAO.Solicitacoes;
import DAO.Sugestoes;
import classes.Obra;
import classes.Solicitacao;
import classes.Sugestao;
import classes.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Menu extends javax.swing.JFrame {
        Usuario usuarioLogado = new Usuario();
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        preencheTabelaLivros("", (DefaultTableModel) TabelaLivros.getModel());
        InicializaAluno(false); //Deixa apenas o login visivel
        

    }
    private void InicializaAdmin(){
            TextoBarraCima.setVisible(true);
            TextoBarraCima.setText("Boas Vindas " + usuarioLogado.getNome()); 
            MenuBarAdmin.setVisible(true);
            PainelAddObra.setVisible(true);      
            MenuBarAluno.setVisible(false);        
            PainelLogin.setVisible(false);
            PainelRegistroBiblio.setVisible(false);
            PainelAddExemplares.setVisible(false);
            PainelSolicitacoesAdmin.setVisible(false);       
            PainelSugestoesAdmin.setVisible(false);
       
    }
    private void InicializaAluno(boolean t) {
            TextoBarraCima.setVisible(t);
            TextoBarraCima.setText("Boas Vindas " + usuarioLogado.getNome());
            BotaoAcervo.setVisible(t);
            BotaoSolicitacoes.setVisible(t);
            BotaoSugerir.setVisible(t);                  
            PainelBusca.setVisible(t);
             PainelLogin.setVisible(!t);                         //Deixa apenas o painel de login visivel ao iniciar o programa
            PainelRegistroBiblio.setVisible(false);
            PainelAddObra.setVisible(false);
            MenuBarAdmin.setVisible(false);
            PainelSugestoes.setVisible(false);
            PainelSolicitacoes.setVisible(false);
            PainelRegistro.setVisible(false);           
            PainelAddExemplares.setVisible(false);
            PainelSolicitacoesAdmin.setVisible(false);   
            PainelSugestoesAdmin.setVisible(false);
       
    }
    
    private void preencheTabelaLivros(String text, DefaultTableModel table) { //Método para popular a tabela livros com os dados
    
    MetodosLivros livroDAO = new MetodosLivros();
    List<Obra> listaLivros = livroDAO.buscaLivro(text);
    table.setNumRows(0);

    if (listaLivros != null && !listaLivros.isEmpty()) {
        for (Obra livro : listaLivros) {
            System.out.println("Listando Livros");
            Object[] obj = new Object[]{
                    livro.getId(),
                    livro.getTitulo(),
                    livro.getAutor(),
                    livro.getVolume(),
            };
            table.addRow(obj);
        }
    } else {
        System.out.println("Nenhum livro encontrado");
    }
}
    
    private void preencheTabelaSolicitacoes(Usuario user, DefaultTableModel table) { //Método para popular a tabela solicitacoes com os dados
    
    Solicitacoes soli = new Solicitacoes();
    int userID = AdicionarUsuario.getIdUsuario(user.getNome());
    List<Solicitacao> listaSoli =soli.BuscaSolicitacoes(userID);  
    table.setNumRows(0);

    if (listaSoli != null && !listaSoli.isEmpty()) {
        for (Solicitacao sol : listaSoli) {
            System.out.println("Listando Solicitaçoes: ");
            Object[] obj = new Object[]{
                sol.getNome(),
                sol.getISBN(),
                sol.getAluno_id(),
            };
            System.out.println("Adicionado: "+sol.getNome());
        table.addRow(obj);}
        }else {
        System.out.println("Nenhuma solicitação encontrada: ");
    }
}
    private void preencheTabelaSolicitacoes( DefaultTableModel table) { //Método para popular a tabela solicitacoes com as solicitaçoes de todos usuários    
    Solicitacoes soli = new Solicitacoes();
    List<Solicitacao> listaSoli =soli.BuscaSolicitacoes();  
    table.setNumRows(0);
    String nome = "";

    if (listaSoli != null && !listaSoli.isEmpty()) {
        for (Solicitacao sol : listaSoli) {
            System.out.println("Listando Solicitaçoes: ");
            Object[] obj = new Object[]{
                sol.getNome(),
                sol.getISBN(),
                sol.getAluno_id(),
                nome = AdicionarUsuario.getNomeByID(sol.getAluno_id())
            };
            System.out.println("Adicionado: "+sol.getNome());
        table.addRow(obj);}
        }else {
        System.out.println("Nenhuma solicitação encontrada: ");
    }
}
    
    private void preencheTabelaSugestoes(DefaultTableModel table) { //Método para popular a tabela sugestoes com os dados
    
    Sugestoes suges = new Sugestoes();
    List<Sugestao> listaSuges =suges.BuscaSugestao();  
    table.setNumRows(0);

    if (listaSuges != null && !listaSuges.isEmpty()) {
        for (Sugestao sug : listaSuges) {
            System.out.println("Listando Sugestoes: ");
            Object[] obj = new Object[]{
                sug.getNome_livro(),
                sug.getAutor()
            };
        table.addRow(obj);}
        }else {
        System.out.println("Nenhuma sugestao encontrada: ");
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        BarraCima = new javax.swing.JPanel();
        TextoBarraCima = new javax.swing.JLabel();
        MenuBarAdmin = new javax.swing.JPanel();
        AdicionarBibliotecario = new javax.swing.JButton();
        AdicionarObra = new javax.swing.JButton();
        Exemplares = new javax.swing.JButton();
        solicitacoes = new javax.swing.JButton();
        sugestoes = new javax.swing.JButton();
        MenuBarAluno = new javax.swing.JPanel();
        BotaoAcervo = new javax.swing.JButton();
        BotaoSolicitacoes = new javax.swing.JButton();
        BotaoSugerir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        PainelSugestoesAdmin = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaSugestoes = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        PainelSolicitacoesAdmin = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        SearchBar1 = new java.awt.TextField();
        Devolvido = new java.awt.Button();
        ScrollSoli1 = new javax.swing.JScrollPane();
        TabelaSoliAdmin = new javax.swing.JTable();
        PainelAddExemplares = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        IdLivroBox = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaLivros1 = new javax.swing.JTable();
        SearchBarExemplar = new java.awt.TextField();
        AdicionarExemplarBotao = new javax.swing.JButton();
        PainelRegistroBiblio = new javax.swing.JPanel();
        cadastrarAdmin = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        nomeBoxAdmin = new javax.swing.JTextField();
        emailBoxAdmin = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        senhaBoxAdmin = new javax.swing.JPasswordField();
        confSenhaAdmin = new javax.swing.JPasswordField();
        PainelAddObra = new javax.swing.JPanel();
        tituloBox = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        volumeBox = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        editoraBox = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        autorBox = new javax.swing.JTextField();
        AdicionarObraBotao = new javax.swing.JButton();
        PainelBusca = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaLivros = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        SearchBar = new java.awt.TextField();
        Solicitar = new java.awt.Button();
        PainelSugestoes = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        submeteSugestao = new javax.swing.JButton();
        sugestaoAutor = new javax.swing.JTextField();
        sugestaoNome = new javax.swing.JTextField();
        PainelSolicitacoes = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        ScrollSoli = new javax.swing.JScrollPane();
        TabelaSoli = new javax.swing.JTable();
        PainelLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomeLoginBox = new javax.swing.JTextField();
        Entrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Registrar = new javax.swing.JButton();
        senhaLoginBox = new javax.swing.JPasswordField();
        PainelRegistro = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        confSenhaBox = new javax.swing.JTextField();
        EnviarRegistro = new javax.swing.JButton();
        BotaoLogin = new javax.swing.JButton();
        nomeBox = new javax.swing.JTextField();
        emailBox = new javax.swing.JTextField();
        senhaBox = new javax.swing.JTextField();

        jTextField5.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(187, 187, 187));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BarraCima.setBackground(new java.awt.Color(188, 141, 97));

        TextoBarraCima.setBackground(new java.awt.Color(0, 0, 0));
        TextoBarraCima.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextoBarraCima.setForeground(new java.awt.Color(0, 0, 0));
        TextoBarraCima.setText("Boas Vindas " + usuarioLogado.getNome());

        javax.swing.GroupLayout BarraCimaLayout = new javax.swing.GroupLayout(BarraCima);
        BarraCima.setLayout(BarraCimaLayout);
        BarraCimaLayout.setHorizontalGroup(
            BarraCimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraCimaLayout.createSequentialGroup()
                .addContainerGap(507, Short.MAX_VALUE)
                .addComponent(TextoBarraCima, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(303, 303, 303))
        );
        BarraCimaLayout.setVerticalGroup(
            BarraCimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextoBarraCima, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        getContentPane().add(BarraCima, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 30));

        MenuBarAdmin.setBackground(new java.awt.Color(231, 220, 192));
        MenuBarAdmin.setForeground(new java.awt.Color(231, 220, 192));

        AdicionarBibliotecario.setText("Bibliotecários");
        AdicionarBibliotecario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarBibliotecarioActionPerformed(evt);
            }
        });

        AdicionarObra.setText("Adicionar Obra");
        AdicionarObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarObraActionPerformed(evt);
            }
        });

        Exemplares.setText("Exemplares");
        Exemplares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExemplaresActionPerformed(evt);
            }
        });

        solicitacoes.setText("Solicitações");
        solicitacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitacoesActionPerformed(evt);
            }
        });

        sugestoes.setText("Sugestões");
        sugestoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sugestoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuBarAdminLayout = new javax.swing.GroupLayout(MenuBarAdmin);
        MenuBarAdmin.setLayout(MenuBarAdminLayout);
        MenuBarAdminLayout.setHorizontalGroup(
            MenuBarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuBarAdminLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(MenuBarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sugestoes, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(solicitacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdicionarObra, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exemplares, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdicionarBibliotecario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        MenuBarAdminLayout.setVerticalGroup(
            MenuBarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuBarAdminLayout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(AdicionarObra, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AdicionarBibliotecario, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Exemplares, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(solicitacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sugestoes, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        getContentPane().add(MenuBarAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 550));

        MenuBarAluno.setBackground(new java.awt.Color(231, 220, 192));
        MenuBarAluno.setForeground(new java.awt.Color(231, 187, 187));
        MenuBarAluno.setToolTipText("");
        MenuBarAluno.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotaoAcervo.setText("Acervo");
        BotaoAcervo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAcervoActionPerformed(evt);
            }
        });
        MenuBarAluno.add(BotaoAcervo, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 123, 135, 61));

        BotaoSolicitacoes.setText("Solicitações");
        BotaoSolicitacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSolicitacoesActionPerformed(evt);
            }
        });
        MenuBarAluno.add(BotaoSolicitacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 196, 135, 61));

        BotaoSugerir.setText("Sugerir uma Obra");
        BotaoSugerir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSugerirActionPerformed(evt);
            }
        });
        MenuBarAluno.add(BotaoSugerir, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 269, 135, 61));

        getContentPane().add(MenuBarAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 210, 550));

        jPanel2.setBackground(new java.awt.Color(187, 187, 187));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PainelSugestoesAdmin.setBackground(new java.awt.Color(187, 187, 187));

        TabelaSugestoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Título", "Autor"
            }
        ));
        jScrollPane3.setViewportView(TabelaSugestoes);
        if (TabelaSugestoes.getColumnModel().getColumnCount() > 0) {
            TabelaSugestoes.getColumnModel().getColumn(0).setResizable(false);
            TabelaSugestoes.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Livros Sugeridos pelo público");

        javax.swing.GroupLayout PainelSugestoesAdminLayout = new javax.swing.GroupLayout(PainelSugestoesAdmin);
        PainelSugestoesAdmin.setLayout(PainelSugestoesAdminLayout);
        PainelSugestoesAdminLayout.setHorizontalGroup(
            PainelSugestoesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelSugestoesAdminLayout.createSequentialGroup()
                .addGroup(PainelSugestoesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelSugestoesAdminLayout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel27))
                    .addGroup(PainelSugestoesAdminLayout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        PainelSugestoesAdminLayout.setVerticalGroup(
            PainelSugestoesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelSugestoesAdminLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel2.add(PainelSugestoesAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 550));

        PainelSolicitacoesAdmin.setBackground(new java.awt.Color(187, 187, 187));

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Gerenciamento de Solicitações");

        SearchBar1.setBackground(new java.awt.Color(204, 204, 204));
        SearchBar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBar1ActionPerformed(evt);
            }
        });
        SearchBar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchBar1KeyReleased(evt);
            }
        });

        Devolvido.setBackground(new java.awt.Color(204, 204, 204));
        Devolvido.setLabel("Devolvido");
        Devolvido.setMaximumSize(new java.awt.Dimension(75, 25));
        Devolvido.setMinimumSize(new java.awt.Dimension(75, 25));
        Devolvido.setName(""); // NOI18N
        Devolvido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DevolvidoMouseClicked(evt);
            }
        });
        Devolvido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DevolvidoActionPerformed(evt);
            }
        });

        TabelaSoliAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Obra", "ISBN", "ID Aluno", "Nome Aluno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollSoli1.setViewportView(TabelaSoliAdmin);
        if (TabelaSoliAdmin.getColumnModel().getColumnCount() > 0) {
            TabelaSoliAdmin.getColumnModel().getColumn(0).setResizable(false);
            TabelaSoliAdmin.getColumnModel().getColumn(1).setResizable(false);
            TabelaSoliAdmin.getColumnModel().getColumn(2).setResizable(false);
            TabelaSoliAdmin.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout PainelSolicitacoesAdminLayout = new javax.swing.GroupLayout(PainelSolicitacoesAdmin);
        PainelSolicitacoesAdmin.setLayout(PainelSolicitacoesAdminLayout);
        PainelSolicitacoesAdminLayout.setHorizontalGroup(
            PainelSolicitacoesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelSolicitacoesAdminLayout.createSequentialGroup()
                .addGroup(PainelSolicitacoesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelSolicitacoesAdminLayout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel26))
                    .addGroup(PainelSolicitacoesAdminLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(PainelSolicitacoesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollSoli1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PainelSolicitacoesAdminLayout.createSequentialGroup()
                                .addComponent(SearchBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Devolvido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(920, Short.MAX_VALUE))
        );
        PainelSolicitacoesAdminLayout.setVerticalGroup(
            PainelSolicitacoesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelSolicitacoesAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(14, 14, 14)
                .addGroup(PainelSolicitacoesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Devolvido, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(SearchBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollSoli1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.add(PainelSolicitacoesAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 550));

        PainelAddExemplares.setBackground(new java.awt.Color(187, 187, 187));

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("ID do Livro:");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Adicione um exemplar!");

        TabelaLivros1.setBackground(new java.awt.Color(204, 204, 204));
        TabelaLivros1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Autor", "Volume"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaLivros1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TabelaLivros1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jScrollPane2.setViewportView(TabelaLivros1);
        if (TabelaLivros1.getColumnModel().getColumnCount() > 0) {
            TabelaLivros1.getColumnModel().getColumn(0).setResizable(false);
            TabelaLivros1.getColumnModel().getColumn(1).setResizable(false);
            TabelaLivros1.getColumnModel().getColumn(2).setResizable(false);
            TabelaLivros1.getColumnModel().getColumn(3).setResizable(false);
        }

        SearchBarExemplar.setBackground(new java.awt.Color(204, 204, 204));
        SearchBarExemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBarExemplarActionPerformed(evt);
            }
        });
        SearchBarExemplar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchBarExemplarKeyReleased(evt);
            }
        });

        AdicionarExemplarBotao.setText("Adicionar");
        AdicionarExemplarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarExemplarBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelAddExemplaresLayout = new javax.swing.GroupLayout(PainelAddExemplares);
        PainelAddExemplares.setLayout(PainelAddExemplaresLayout);
        PainelAddExemplaresLayout.setHorizontalGroup(
            PainelAddExemplaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelAddExemplaresLayout.createSequentialGroup()
                .addGroup(PainelAddExemplaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelAddExemplaresLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IdLivroBox, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelAddExemplaresLayout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel25))
                    .addGroup(PainelAddExemplaresLayout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelAddExemplaresLayout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(SearchBarExemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelAddExemplaresLayout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(AdicionarExemplarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        PainelAddExemplaresLayout.setVerticalGroup(
            PainelAddExemplaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelAddExemplaresLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel25)
                .addGap(66, 66, 66)
                .addGroup(PainelAddExemplaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(IdLivroBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(AdicionarExemplarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(SearchBarExemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel2.add(PainelAddExemplares, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 550));

        PainelRegistroBiblio.setBackground(new java.awt.Color(187, 187, 187));

        cadastrarAdmin.setText("Cadastrar");
        cadastrarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarAdminActionPerformed(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Cadastrar um novo Bibliotecário!");

        nomeBoxAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeBoxAdminActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Nome/Login:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("E-mail:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Senha:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Confirmar Senha:");

        senhaBoxAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaBoxAdminActionPerformed(evt);
            }
        });

        confSenhaAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confSenhaAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelRegistroBiblioLayout = new javax.swing.GroupLayout(PainelRegistroBiblio);
        PainelRegistroBiblio.setLayout(PainelRegistroBiblioLayout);
        PainelRegistroBiblioLayout.setHorizontalGroup(
            PainelRegistroBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelRegistroBiblioLayout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(PainelRegistroBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelRegistroBiblioLayout.createSequentialGroup()
                        .addGroup(PainelRegistroBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PainelRegistroBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nomeBoxAdmin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailBoxAdmin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(senhaBoxAdmin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confSenhaAdmin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel19))
                .addContainerGap(220, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelRegistroBiblioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cadastrarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(378, 378, 378))
        );
        PainelRegistroBiblioLayout.setVerticalGroup(
            PainelRegistroBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelRegistroBiblioLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel19)
                .addGap(56, 56, 56)
                .addGroup(PainelRegistroBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeBoxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelRegistroBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailBoxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelRegistroBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(senhaBoxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelRegistroBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(confSenhaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cadastrarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        jPanel2.add(PainelRegistroBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 550));

        PainelAddObra.setBackground(new java.awt.Color(187, 187, 187));

        tituloBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloBoxActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Título:");

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Editora:");

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Adicionar nova Obra!");

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Volume:");

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Autor:");

        AdicionarObraBotao.setText("Adicionar");
        AdicionarObraBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                AdicionarObraBotaoMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout PainelAddObraLayout = new javax.swing.GroupLayout(PainelAddObra);
        PainelAddObra.setLayout(PainelAddObraLayout);
        PainelAddObraLayout.setHorizontalGroup(
            PainelAddObraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelAddObraLayout.createSequentialGroup()
                .addGroup(PainelAddObraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelAddObraLayout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelAddObraLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel17)
                        .addGap(12, 12, 12)
                        .addComponent(tituloBox, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelAddObraLayout.createSequentialGroup()
                        .addGroup(PainelAddObraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelAddObraLayout.createSequentialGroup()
                                .addGap(188, 188, 188)
                                .addComponent(jLabel15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelAddObraLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PainelAddObraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PainelAddObraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editoraBox, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(volumeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(autorBox, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PainelAddObraLayout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(AdicionarObraBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(336, 336, 336))
        );
        PainelAddObraLayout.setVerticalGroup(
            PainelAddObraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelAddObraLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(PainelAddObraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(14, 14, 14)
                .addGroup(PainelAddObraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volumeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(15, 15, 15)
                .addGroup(PainelAddObraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editoraBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(PainelAddObraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(autorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(AdicionarObraBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(PainelAddObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 550));

        PainelBusca.setBackground(new java.awt.Color(187, 187, 187));
        PainelBusca.setAutoscrolls(true);
        PainelBusca.setPreferredSize(new java.awt.Dimension(534, 343));
        PainelBusca.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TabelaLivros.setBackground(new java.awt.Color(204, 204, 204));
        TabelaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Autor", "Volume"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaLivros.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TabelaLivros.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jScrollPane1.setViewportView(TabelaLivros);
        if (TabelaLivros.getColumnModel().getColumnCount() > 0) {
            TabelaLivros.getColumnModel().getColumn(0).setResizable(false);
            TabelaLivros.getColumnModel().getColumn(1).setResizable(false);
            TabelaLivros.getColumnModel().getColumn(2).setResizable(false);
            TabelaLivros.getColumnModel().getColumn(3).setResizable(false);
        }

        PainelBusca.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 710, 430));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Busque uma Obra!");
        PainelBusca.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 300, -1));

        SearchBar.setBackground(new java.awt.Color(204, 204, 204));
        SearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBarActionPerformed(evt);
            }
        });
        SearchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchBarKeyReleased(evt);
            }
        });
        PainelBusca.add(SearchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 630, -1));

        Solicitar.setBackground(new java.awt.Color(204, 204, 204));
        Solicitar.setLabel("Solicitar");
        Solicitar.setMaximumSize(new java.awt.Dimension(75, 25));
        Solicitar.setMinimumSize(new java.awt.Dimension(75, 25));
        Solicitar.setName(""); // NOI18N
        Solicitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SolicitarMouseClicked(evt);
            }
        });
        Solicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolicitarActionPerformed(evt);
            }
        });
        PainelBusca.add(Solicitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, -1, -1));

        jPanel2.add(PainelBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 550));

        PainelSugestoes.setBackground(new java.awt.Color(187, 187, 187));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Sugira uma aquisição!");
        jLabel10.setToolTipText("");

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Nome do Livro:");

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Autor:");

        submeteSugestao.setText("Submeter");
        submeteSugestao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submeteSugestaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelSugestoesLayout = new javax.swing.GroupLayout(PainelSugestoes);
        PainelSugestoes.setLayout(PainelSugestoesLayout);
        PainelSugestoesLayout.setHorizontalGroup(
            PainelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelSugestoesLayout.createSequentialGroup()
                .addGroup(PainelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelSugestoesLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(PainelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PainelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sugestaoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sugestaoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PainelSugestoesLayout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel10))
                    .addGroup(PainelSugestoesLayout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(submeteSugestao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(343, Short.MAX_VALUE))
        );
        PainelSugestoesLayout.setVerticalGroup(
            PainelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelSugestoesLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel10)
                .addGap(54, 54, 54)
                .addGroup(PainelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(sugestaoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(sugestaoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(submeteSugestao, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
        );

        jPanel2.add(PainelSugestoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 570));

        PainelSolicitacoes.setBackground(new java.awt.Color(187, 187, 187));
        PainelSolicitacoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel9.setText("Minhas Solicitações!");
        PainelSolicitacoes.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 353, -1));

        TabelaSoli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Obra", "ISBN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollSoli.setViewportView(TabelaSoli);
        if (TabelaSoli.getColumnModel().getColumnCount() > 0) {
            TabelaSoli.getColumnModel().getColumn(0).setResizable(false);
            TabelaSoli.getColumnModel().getColumn(1).setResizable(false);
        }

        PainelSolicitacoes.add(ScrollSoli, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 710, -1));

        jPanel2.add(PainelSolicitacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 550));

        PainelLogin.setBackground(new java.awt.Color(187, 187, 187));
        PainelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nome de Usuário:");
        PainelLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Senha:");
        PainelLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));
        PainelLogin.add(nomeLoginBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 200, -1));

        Entrar.setText("Entrar");
        Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntrarActionPerformed(evt);
            }
        });
        PainelLogin.add(Entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 90, 60));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Faça seu Login!");
        PainelLogin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, 50));

        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });
        PainelLogin.add(Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 90, 60));
        PainelLogin.add(senhaLoginBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 200, -1));

        jPanel2.add(PainelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 550));

        PainelRegistro.setBackground(new java.awt.Color(187, 187, 187));
        PainelRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("E-mail:");
        PainelRegistro.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 208, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nome:");
        PainelRegistro.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 180, -1, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Senha:");
        PainelRegistro.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 236, -1, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Confirmar senha:");
        PainelRegistro.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, -1, -1));
        PainelRegistro.add(confSenhaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 270, -1));

        EnviarRegistro.setText("Enviar");
        EnviarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarRegistroActionPerformed(evt);
            }
        });
        PainelRegistro.add(EnviarRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, -1, -1));

        BotaoLogin.setText("Login");
        BotaoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoLoginActionPerformed(evt);
            }
        });
        PainelRegistro.add(BotaoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, -1, -1));
        PainelRegistro.add(nomeBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 177, 270, -1));
        PainelRegistro.add(emailBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 205, 270, -1));
        PainelRegistro.add(senhaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 233, 270, -1));

        jPanel2.add(PainelRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -2, 930, 560));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 28, 923, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntrarActionPerformed
        String nomeEnviar = nomeLoginBox.getText();
        String senhaEnviar = senhaLoginBox.getText();
        System.out.println("Antes autenticação "+nomeEnviar);
        if (AdicionarUsuario.autenticar(nomeEnviar, senhaEnviar)){
            System.out.println("autenticou");
            usuarioLogado.setNome(nomeEnviar);
            usuarioLogado.setEmail(AdicionarUsuario.getEmailUsuario(nomeEnviar));
            usuarioLogado.setAdmin(AdicionarUsuario.getAdminUsuario(nomeEnviar));            
            System.out.println(usuarioLogado.getNome() + " "+ usuarioLogado.getEmail() + "" + usuarioLogado.getAdmin());
            if (usuarioLogado.getAdmin()){
                System.out.println("chegou admin");
                InicializaAdmin();
            }else{
                System.out.println("chegou aluno");
                InicializaAluno(true);             
            }
        }else{
            JOptionPane.showMessageDialog(this, "Usuário ou senha Incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_EntrarActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        // TODO add your handling code here:
       PainelRegistro.setVisible(true);
       PainelLogin.setVisible(false);
    }//GEN-LAST:event_RegistrarActionPerformed

    private void EnviarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarRegistroActionPerformed
        // TODO add your handling code here:
     
         String nomeEnviar = nomeBox.getText().trim();
         String emailEnviar = emailBox.getText().trim();
         String senhaEnviar = senhaBox.getText().trim();
         String senhaConf = confSenhaBox.getText().trim(); // pegar os dados dos campos
         System.out.println(nomeEnviar); // depuração

// Verifica se algum dos campos está vazio
        if (nomeEnviar.isEmpty() || emailEnviar.isEmpty() || senhaEnviar.isEmpty() || senhaConf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            if (!AdicionarUsuario.usuarioExiste(nomeEnviar, emailEnviar)) { // se não houver usuário correspondente, prossegue para a criação
            System.out.println("Pronto para adicionar usuário"); // depuração

            if (senhaEnviar.length() < 5) { // verifica se a senha tem no mínimo 5 dígitos
                
                JOptionPane.showMessageDialog(this, "A senha deve ter no mínimo 5 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
                
            } else if (senhaEnviar.equals(senhaConf)) { // checa se as senhas correspondem
                
                AdicionarUsuario.addUser(nomeEnviar, senhaEnviar, emailEnviar, false);
                JOptionPane.showMessageDialog(this, "Usuário adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                PainelRegistro.setVisible(false);
                PainelLogin.setVisible(true); // abre o painel de login após o registro concluído
                PainelBusca.setVisible(false);
                
            } else { // manda uma mensagem de erro se as senhas não corresponderem
                JOptionPane.showMessageDialog(this, "Falha: as senhas não correspondem", "Erro", JOptionPane.ERROR_MESSAGE);
                
                System.out.println("Falha: as senhas não correspondem");
                System.out.println("Senha enviada: " + senhaEnviar);
                System.out.println("Senha de confirmação: " + senhaConf);
            }
            }  else { // se houver um usuário já com o nome ou e-mail retorna um erro
                
                JOptionPane.showMessageDialog(this, "Nome de Usuário ou e-mail já em uso", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

    }//GEN-LAST:event_EnviarRegistroActionPerformed

    private void BotaoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoLoginActionPerformed
             PainelRegistro.setVisible(false);
             PainelLogin.setVisible(true);
             PainelRegistro.repaint();
             PainelRegistro.revalidate();             //deixa somente o panel login visível
             PainelLogin.repaint();
             PainelLogin.revalidate();
       
    }//GEN-LAST:event_BotaoLoginActionPerformed

    private void BotaoAcervoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAcervoActionPerformed
              PainelRegistro.setVisible(false);
              PainelLogin.setVisible(false);
              PainelSolicitacoes.setVisible(false);
              PainelSugestoes.setVisible(false);
              PainelBusca.setVisible(true);            // Ativa somente o Painel de busca
           
    }//GEN-LAST:event_BotaoAcervoActionPerformed

    private void SearchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBarKeyReleased
        String buscaText = SearchBar.getText();
        preencheTabelaLivros(buscaText, (DefaultTableModel) TabelaLivros.getModel());
    }//GEN-LAST:event_SearchBarKeyReleased

    private void SearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBarActionPerformed

    private void BotaoSolicitacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSolicitacoesActionPerformed
 
            PainelSolicitacoes.setVisible(true);
            preencheTabelaSolicitacoes(usuarioLogado, (DefaultTableModel) TabelaSoli.getModel());
            PainelBusca.setVisible(false);
            PainelRegistro.setVisible(false);
            PainelLogin.setVisible(false);                         //Deixa apenas o painel de solicitçoes visivel
            PainelSugestoes.setVisible(false);
          
    }//GEN-LAST:event_BotaoSolicitacoesActionPerformed

    private void SolicitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SolicitarMouseClicked
    
       DefaultTableModel tabelaLivros = (DefaultTableModel)TabelaLivros.getModel();
        int linhaSelec = TabelaLivros.getSelectedRow();
        System.out.println(tabelaLivros.getValueAt(linhaSelec, 0));
        int idSelec = Integer.parseInt(tabelaLivros.getValueAt(linhaSelec, 0).toString());
        String resul = Solicitacoes.addSolicitacao(AdicionarUsuario.getIdUsuario(usuarioLogado.getNome()), idSelec);     
        
        if ("".equals(resul)){
            JOptionPane.showMessageDialog(this, "Você já possui o número máximo de solicitações", "Falha na solicitação!", JOptionPane.INFORMATION_MESSAGE);
        } else switch (resul) {
                case "1":
                    JOptionPane.showMessageDialog(this, "Não há exemplares deste livro ou estão indisponíveis no momento.", "Exemplar Indisponível", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "2":
                    JOptionPane.showMessageDialog(this, "Erro, o banco de dados da biblioteca pode estar fora do ar.", "Errol", JOptionPane.ERROR_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Solicitação adicionada com sucesso, você pode retirar o livro em até 2 horas no balcão da biblioteca.", "Solicitação Realizada!", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
    }//GEN-LAST:event_SolicitarMouseClicked

    private void SolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolicitarActionPerformed
        
        
    }//GEN-LAST:event_SolicitarActionPerformed

    private void BotaoSugerirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSugerirActionPerformed
              PainelRegistro.setVisible(false);
              PainelLogin.setVisible(false);
              PainelSolicitacoes.setVisible(false);
              PainelBusca.setVisible(false);   
              PainelSugestoes.setVisible(true);
    }//GEN-LAST:event_BotaoSugerirActionPerformed

    private void submeteSugestaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submeteSugestaoActionPerformed
      String autor = sugestaoAutor.getText().trim();
      String nome = sugestaoNome.getText().trim();

    if (autor.isBlank() || nome.isBlank()) {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Campos Vazios", JOptionPane.INFORMATION_MESSAGE);
        return;
    }
    int resul = Sugestoes.adicionarSugestao(nome, autor);
    switch (resul) {
        case 3: 
            JOptionPane.showMessageDialog(this, "Nós já possuimos esse livro, procure no acervo", "Livro já existe", JOptionPane.INFORMATION_MESSAGE);
            break;
        case 2:
            JOptionPane.showMessageDialog(this, "Erro de conexão.", "Conexão falhou", JOptionPane.ERROR_MESSAGE);
            break;
        case 1:
            JOptionPane.showMessageDialog(this, "Já existe uma sugestão para esse livro, iremos adquirilo o mais rápido possivel!", "Sugestão já existe", JOptionPane.INFORMATION_MESSAGE);
            break;
        case 0:
            JOptionPane.showMessageDialog(this, "Sugestão adicionada com sucesso", "Sugestão Recebida!", JOptionPane.INFORMATION_MESSAGE);
            break;
    }   
    sugestaoAutor.setText("");
    sugestaoNome.setText("");
    }//GEN-LAST:event_submeteSugestaoActionPerformed

    private void AdicionarBibliotecarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarBibliotecarioActionPerformed

        PainelRegistroBiblio.setVisible(true);
        PainelAddObra.setVisible(false);       
        PainelAddExemplares.setVisible(false);
        PainelSolicitacoesAdmin.setVisible(false);
        PainelSugestoesAdmin.setVisible(false);
    }//GEN-LAST:event_AdicionarBibliotecarioActionPerformed

    private void AdicionarObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarObraActionPerformed
        PainelAddObra.setVisible(true);
        PainelAddExemplares.setVisible(false);
        PainelSolicitacoesAdmin.setVisible(false);
        PainelRegistroBiblio.setVisible(false);
        PainelSugestoesAdmin.setVisible(false);
    }//GEN-LAST:event_AdicionarObraActionPerformed

    private void ExemplaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExemplaresActionPerformed
        preencheTabelaLivros("", (DefaultTableModel) TabelaLivros1.getModel());        
        PainelAddExemplares.setVisible(true);
        PainelAddObra.setVisible(false);
        PainelSolicitacoesAdmin.setVisible(false);
        PainelRegistroBiblio.setVisible(false);
        PainelSugestoesAdmin.setVisible(false);
    }//GEN-LAST:event_ExemplaresActionPerformed

    private void tituloBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloBoxActionPerformed

    private void AdicionarObraBotaoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdicionarObraBotaoMouseReleased
        
        String titulo = tituloBox.getText().trim();
        String volume = volumeBox.getText().trim();
        String editora = editoraBox.getText().trim();
        String autor = autorBox.getText().trim();
        MetodosLivros met = new MetodosLivros();
        if (titulo.isBlank() || volume.isBlank() || editora.isBlank() || autor.isBlank()){
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Campos Vazios", JOptionPane.INFORMATION_MESSAGE);
        }else{
            String resul = met.addLivro(titulo, autor, volume, editora);     
            switch (resul) {
                
                case "0":
                    JOptionPane.showMessageDialog(this, "Livro Adicionado com sucesso.", "Livro Adicionado!", JOptionPane.INFORMATION_MESSAGE);
              
                    break;
                case "1":
                    JOptionPane.showMessageDialog(this, "Livro já existe!", "Livro existente.", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "2":
                    JOptionPane.showMessageDialog(this, "Verifique a conexão com o banco de dados", "Erro de conexão!", JOptionPane.ERROR_MESSAGE);
                    default:
                        throw new AssertionError();
        }
            tituloBox.setText("");
            volumeBox.setText("");
            editoraBox.setText("");
            autorBox.setText("");
        }
        
        
        
    }//GEN-LAST:event_AdicionarObraBotaoMouseReleased

    private void cadastrarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarAdminActionPerformed
         
        String nomeEnviar = nomeBoxAdmin.getText().trim();
         String emailEnviar = emailBoxAdmin.getText().trim();
         String senhaEnviar = senhaBoxAdmin.getText().trim();
         String senhaConf = confSenhaAdmin.getText().trim();
        if (nomeEnviar.isEmpty() || emailEnviar.isEmpty() || senhaEnviar.isEmpty() || senhaConf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            if (!AdicionarUsuario.usuarioExiste(nomeEnviar, emailEnviar)) { // se não houver usuário correspondente, prossegue para a criação
            System.out.println("Pronto para adicionar usuário"); // depuração

            if (senhaEnviar.length() < 5) { // verifica se a senha tem no mínimo 5 dígitos
                
                JOptionPane.showMessageDialog(this, "A senha deve ter no mínimo 5 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
                
            } else if (senhaEnviar.equals(senhaConf)) { // checa se as senhas correspondem
                
                AdicionarUsuario.addUser(nomeEnviar, senhaEnviar, emailEnviar, true);
                JOptionPane.showMessageDialog(this, "Bibliotecário adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);               
                nomeBoxAdmin.setText("");
                emailBoxAdmin.setText("");
                senhaBoxAdmin.setText("");
                confSenhaAdmin.setText("");
            } else { // manda uma mensagem de erro se as senhas não corresponderem
                JOptionPane.showMessageDialog(this, "Falha: as senhas não correspondem", "Erro", JOptionPane.ERROR_MESSAGE);
                
                System.out.println("Falha: as senhas não correspondem");
                System.out.println("Senha enviada: " + senhaEnviar);
                System.out.println("Senha de confirmação: " + senhaConf);
            }
            }  else { // se houver um usuário já com o nome ou e-mail retorna um erro
                
                JOptionPane.showMessageDialog(this, "Nome de Usuário ou e-mail já em uso", "Erro", JOptionPane.ERROR_MESSAGE);
                    }  
        }  
    }//GEN-LAST:event_cadastrarAdminActionPerformed

    private void nomeBoxAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeBoxAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeBoxAdminActionPerformed

    private void senhaBoxAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaBoxAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaBoxAdminActionPerformed

    private void confSenhaAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confSenhaAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confSenhaAdminActionPerformed

    private void SearchBarExemplarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBarExemplarKeyReleased
        String buscaText = SearchBarExemplar.getText();
        preencheTabelaLivros(buscaText, (DefaultTableModel) TabelaLivros1.getModel());
    }//GEN-LAST:event_SearchBarExemplarKeyReleased

    private void solicitacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solicitacoesActionPerformed
        preencheTabelaSolicitacoes((DefaultTableModel) TabelaSoliAdmin.getModel());
        PainelSolicitacoesAdmin.setVisible(true);
        PainelSugestoesAdmin.setVisible(false);
        PainelAddExemplares.setVisible(false);
        PainelAddObra.setVisible(false);       
        PainelRegistroBiblio.setVisible(false);
    }//GEN-LAST:event_solicitacoesActionPerformed

    private void SearchBar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBar1ActionPerformed

    private void SearchBar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBar1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBar1KeyReleased

    private void DevolvidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DevolvidoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DevolvidoMouseClicked

    private void DevolvidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DevolvidoActionPerformed
       
        DefaultTableModel tabelaSoliAdmin = (DefaultTableModel) TabelaSoliAdmin.getModel();
        int linhaSelec = TabelaSoliAdmin.getSelectedRow();
        System.out.println(tabelaSoliAdmin.getValueAt(linhaSelec, 1));
        String isbnSelec = tabelaSoliAdmin.getValueAt(linhaSelec, 1).toString();
        String resul = Solicitacoes.remSolicitacao( isbnSelec);     
        
        switch (resul) {
                case "0":
                    JOptionPane.showMessageDialog(this, "Solicitação terminada com sucesso!", "Solicitação terminada", JOptionPane.INFORMATION_MESSAGE);
                    preencheTabelaSolicitacoes((DefaultTableModel) TabelaSoliAdmin.getModel());
                    break;
                case "1":
                    JOptionPane.showMessageDialog(this, "Solicitação não encontrada!", "Não encontrada", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "2":
                    JOptionPane.showMessageDialog(this, "Erro, o banco de dados da biblioteca pode estar fora do ar.", "Errol", JOptionPane.ERROR_MESSAGE);
                    break;               
            }                                  
    }//GEN-LAST:event_DevolvidoActionPerformed

    private void AdicionarExemplarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarExemplarBotaoActionPerformed
                                                         
    String idLivro = IdLivroBox.getText().trim();
    MetodosLivros met = new MetodosLivros();
    try {
        int id = Integer.parseInt(idLivro);      
        String resul = met.addExemplar(id);
        switch (resul) {
            case "":
                JOptionPane.showMessageDialog(this, "Este id de livro não existe.", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
            case "0":
                JOptionPane.showMessageDialog(this, "Erro ao contar exemplares.", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
            case "1":
                JOptionPane.showMessageDialog(this, "Erro, o banco de dados da biblioteca pode estar fora do ar.", "Errol", JOptionPane.ERROR_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Exemplar Adicionado do livro: " + Solicitacoes.getTitleByID(id)+  "\n ISBN gerado: " + resul , "Exemplar Adicionado", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (NumberFormatException e) {
       
        JOptionPane.showMessageDialog(this, "O id do livro deve ser um número", "Errol", JOptionPane.ERROR_MESSAGE);
       
    }
     
        
    }//GEN-LAST:event_AdicionarExemplarBotaoActionPerformed

    private void SearchBarExemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBarExemplarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBarExemplarActionPerformed

    private void sugestoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sugestoesActionPerformed
        preencheTabelaSugestoes((DefaultTableModel) TabelaSugestoes.getModel());
        PainelSugestoesAdmin.setVisible(true);
        PainelSolicitacoesAdmin.setVisible(false);        
        PainelAddExemplares.setVisible(false);
        PainelAddObra.setVisible(false);       
        PainelRegistroBiblio.setVisible(false);
    }//GEN-LAST:event_sugestoesActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarBibliotecario;
    private javax.swing.JButton AdicionarExemplarBotao;
    private javax.swing.JButton AdicionarObra;
    private javax.swing.JButton AdicionarObraBotao;
    private javax.swing.JPanel BarraCima;
    private javax.swing.JButton BotaoAcervo;
    private javax.swing.JButton BotaoLogin;
    private javax.swing.JButton BotaoSolicitacoes;
    private javax.swing.JButton BotaoSugerir;
    private java.awt.Button Devolvido;
    private javax.swing.JButton Entrar;
    private javax.swing.JButton EnviarRegistro;
    private javax.swing.JButton Exemplares;
    private javax.swing.JTextField IdLivroBox;
    private javax.swing.JPanel MenuBarAdmin;
    private javax.swing.JPanel MenuBarAluno;
    private javax.swing.JPanel PainelAddExemplares;
    private javax.swing.JPanel PainelAddObra;
    private javax.swing.JPanel PainelBusca;
    private javax.swing.JPanel PainelLogin;
    private javax.swing.JPanel PainelRegistro;
    private javax.swing.JPanel PainelRegistroBiblio;
    private javax.swing.JPanel PainelSolicitacoes;
    private javax.swing.JPanel PainelSolicitacoesAdmin;
    private javax.swing.JPanel PainelSugestoes;
    private javax.swing.JPanel PainelSugestoesAdmin;
    private javax.swing.JButton Registrar;
    private javax.swing.JScrollPane ScrollSoli;
    private javax.swing.JScrollPane ScrollSoli1;
    private java.awt.TextField SearchBar;
    private java.awt.TextField SearchBar1;
    private java.awt.TextField SearchBarExemplar;
    private java.awt.Button Solicitar;
    private javax.swing.JTable TabelaLivros;
    private javax.swing.JTable TabelaLivros1;
    private javax.swing.JTable TabelaSoli;
    private javax.swing.JTable TabelaSoliAdmin;
    private javax.swing.JTable TabelaSugestoes;
    private javax.swing.JLabel TextoBarraCima;
    private javax.swing.JTextField autorBox;
    private javax.swing.JButton cadastrarAdmin;
    private javax.swing.JPasswordField confSenhaAdmin;
    private javax.swing.JTextField confSenhaBox;
    private javax.swing.JTextField editoraBox;
    private javax.swing.JTextField emailBox;
    private javax.swing.JTextField emailBoxAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField nomeBox;
    private javax.swing.JTextField nomeBoxAdmin;
    private javax.swing.JTextField nomeLoginBox;
    private javax.swing.JTextField senhaBox;
    private javax.swing.JPasswordField senhaBoxAdmin;
    private javax.swing.JPasswordField senhaLoginBox;
    private javax.swing.JButton solicitacoes;
    private javax.swing.JButton submeteSugestao;
    private javax.swing.JTextField sugestaoAutor;
    private javax.swing.JTextField sugestaoNome;
    private javax.swing.JButton sugestoes;
    private javax.swing.JTextField tituloBox;
    private javax.swing.JTextField volumeBox;
    // End of variables declaration//GEN-END:variables
}
