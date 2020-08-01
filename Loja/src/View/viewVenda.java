/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DAO.CategoriaDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.FormaPagamentoDAO;
import Model.DAO.ItensDaVendaDAO;
import Model.DAO.ProdutoDAO;
import Model.DAO.VendaDAO;
import Model.bean.Categoria;
import Model.bean.Cliente;
import Model.bean.FormaPagamento;
import Model.bean.ItensDaVenda;
import Model.bean.Produto;
import Model.bean.Venda;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Rayrisson
 */
public class viewVenda extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public viewVenda() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        FormaPagamentoDAO fpdao = new FormaPagamentoDAO();
        readTableC();
        readTableP();
        modelButton();
        menu();
        this.getContentPane().setBackground(Color.WHITE);
        designTable();
        for(FormaPagamento fp : fpdao.read()){
            cbFP.addItem(fp);
        }
    }
    
    public void designTable(){
        jtClientes.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jtClientes.getTableHeader().setOpaque(false);
        jtClientes.getTableHeader().setBackground(new Color(32, 136, 203));
        jtClientes.getTableHeader().setForeground(new Color(255, 255, 255));
        jtClientes.setRowHeight(25); 
        jtProdutos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jtProdutos.getTableHeader().setOpaque(false);
        jtProdutos.getTableHeader().setBackground(new Color(32, 136, 203));
        jtProdutos.getTableHeader().setForeground(new Color(255, 255, 255));
        jtProdutos.setRowHeight(25); 
    
    }
    
    public void modelButton(){
        buttonConcluir.setContentAreaFilled(false);
        buttonConcluir.setOpaque(true);
        buttonConcluir.setBackground(new Color(32,136,203));
        buttonFP.setContentAreaFilled(false);
        buttonFP.setOpaque(true);
        buttonFP.setBackground(new Color(32,136,203));
        buttonHistorico.setContentAreaFilled(false);
        buttonHistorico.setOpaque(true);
        buttonHistorico.setBackground(new Color(32,136,203));
    }
    
    public void menu(){
        ImageIcon menu1 = new ImageIcon(getClass().getResource("/Images/scan.png"));
        menu1.setImage(menu1.getImage().getScaledInstance(40, 40, 1));
        jLabel7.setIcon(menu1);
        ImageIcon menu2 = new ImageIcon(getClass().getResource("/Images/list.png"));
        menu2.setImage(menu2.getImage().getScaledInstance(40, 40, 1));
        jLabel6.setIcon(menu2);
        ImageIcon menu3 = new ImageIcon(getClass().getResource("/Images/customer.png"));
        menu3.setImage(menu3.getImage().getScaledInstance(40, 40, 1));
        jLabel8.setIcon(menu3);
        ImageIcon menu4 = new ImageIcon(getClass().getResource("/Images/online-shopping2.png"));
        menu4.setImage(menu4.getImage().getScaledInstance(40, 40, 1));
        jLabel9.setIcon(menu4);
    }
    
    public void readTableP(){
        DefaultTableModel model = (DefaultTableModel) jtProdutos.getModel();
        jtProdutos.setRowSorter(new TableRowSorter(model));
        model.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();
        for(Produto prod : pdao.read()){
            model.addRow(new Object[]{
                prod.getId(),
                prod.getCodBarras(),
                prod.getNome(),
                prod.getPreco(),
                prod.getQtd(),
                prod.getCategoria()
            });
        }
    }
        
    public void readTableC(){
        DefaultTableModel model = (DefaultTableModel) jtClientes.getModel();
        jtClientes.setRowSorter(new TableRowSorter(model));
        model.setNumRows(0);
        ClienteDAO cdao = new ClienteDAO();
        for(Cliente cli : cdao.read()){
            model.addRow(new Object[]{
                cli.getId(),
                cli.getNome(),
                cli.getTelefone(),
                cli.getCPF()
            });
        }
    }
    
    public void searchP(String nome){
        DefaultTableModel model = (DefaultTableModel) jtProdutos.getModel();
        jtProdutos.setRowSorter(new TableRowSorter(model));
        model.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();
        for(Produto prod : pdao.search(nome)){
            model.addRow(new Object[]{
                prod.getId(),
                prod.getCodBarras(),
                prod.getNome(),
                prod.getPreco(),
                prod.getQtd(),
                prod.getCategoria()
            });
        }
    }
    
    public void searchC(String nome){
        DefaultTableModel model = (DefaultTableModel) jtClientes.getModel();
        jtClientes.setRowSorter(new TableRowSorter(model));
        model.setNumRows(0);
        ClienteDAO cdao = new ClienteDAO();
        for(Cliente cli : cdao.search(nome)){
            model.addRow(new Object[]{
                cli.getId(),
                cli.getNome(),
                cli.getTelefone(),
                cli.getCPF()
            });
        }
    }
    
    boolean isInteger(String text){
        try{
            Integer.parseInt(text);
            return true;
        }catch(NumberFormatException e){
            return false;
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

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();
        txtPesquisarC = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtProdutos = new javax.swing.JTable();
        buttonConcluir = new javax.swing.JButton();
        cbFP = new javax.swing.JComboBox<>();
        txtQuantidade = new javax.swing.JTextField();
        buttonFP = new javax.swing.JButton();
        buttonHistorico = new javax.swing.JButton();
        txtPesquisarP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(32, 136, 203));
        jPanel1.setPreferredSize(new java.awt.Dimension(56, 0));

        jPanel4.setBackground(new java.awt.Color(32, 136, 203));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(32, 136, 203));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(32, 136, 203));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VENDA      ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(115, 115, 115)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtClientes.setFocusable(false);
        jtClientes.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtClientes.setRowHeight(25);
        jtClientes.setSelectionBackground(new java.awt.Color(232, 57, 95));
        jtClientes.setShowVerticalLines(false);
        jtClientes.getTableHeader().setReorderingAllowed(false);
        jtClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtClientes);

        txtPesquisarC.setText("Pesquisar");
        txtPesquisarC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPesquisarCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPesquisarCFocusLost(evt);
            }
        });
        txtPesquisarC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarCKeyReleased(evt);
            }
        });

        jtProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Código de barras", "Nome", "Preço", "Quantidade", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProdutos.setFocusable(false);
        jtProdutos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtProdutos.setRowHeight(25);
        jtProdutos.setSelectionBackground(new java.awt.Color(232, 57, 95));
        jtProdutos.setShowVerticalLines(false);
        jtProdutos.getTableHeader().setReorderingAllowed(false);
        jtProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdutosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtProdutos);

        buttonConcluir.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        buttonConcluir.setForeground(new java.awt.Color(255, 255, 255));
        buttonConcluir.setText("CONCLUIR");
        buttonConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConcluirActionPerformed(evt);
            }
        });

        txtQuantidade.setText("Quantidade");
        txtQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQuantidadeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantidadeFocusLost(evt);
            }
        });

        buttonFP.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        buttonFP.setForeground(new java.awt.Color(255, 255, 255));
        buttonFP.setText("...");
        buttonFP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFPActionPerformed(evt);
            }
        });

        buttonHistorico.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        buttonHistorico.setForeground(new java.awt.Color(255, 255, 255));
        buttonHistorico.setText("HISTORICO");
        buttonHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHistoricoActionPerformed(evt);
            }
        });

        txtPesquisarP.setText("Pesquisar");
        txtPesquisarP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPesquisarPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPesquisarPFocusLost(evt);
            }
        });
        txtPesquisarP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarPKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(cbFP, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(buttonFP)
                            .addGap(334, 334, 334)
                            .addComponent(buttonHistorico)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonConcluir))
                        .addComponent(txtPesquisarC, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txtPesquisarP, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtPesquisarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(txtPesquisarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonConcluir)
                    .addComponent(cbFP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFP)
                    .addComponent(buttonHistorico))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClientesMouseClicked
        if(jtClientes.getSelectedRow() > (-1)){
            //txtNome.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(),1).toString());
            //txtTelefone.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(),2).toString());
            //txtCPF.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(),3).toString());
        }
    }//GEN-LAST:event_jtClientesMouseClicked

    private void txtPesquisarCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPesquisarCFocusGained
        if(txtPesquisarC.getText().equals("Pesquisar")){
            txtPesquisarC.setText("");
        }
    }//GEN-LAST:event_txtPesquisarCFocusGained

    private void txtPesquisarCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPesquisarCFocusLost
        if(txtPesquisarC.getText().equals("")){
            txtPesquisarC.setText("Pesquisar");
        }
    }//GEN-LAST:event_txtPesquisarCFocusLost

    private void txtPesquisarCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarCKeyReleased
        searchC(txtPesquisarC.getText());
    }//GEN-LAST:event_txtPesquisarCKeyReleased

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        jPanel5.setBackground(new Color(32,156,223));
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        jPanel5.setBackground(new Color(32,136,203));
    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        jPanel6.setBackground(new Color(32,136,203));
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        jPanel6.setBackground(new Color(32,156,223));
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jtProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutosMouseClicked

    }//GEN-LAST:event_jtProdutosMouseClicked

    private void buttonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConcluirActionPerformed
        if(jtProdutos.getSelectedRow() > (-1) && jtClientes.getSelectedRow() > (-1) && isInteger(txtQuantidade.getText())){
            Venda venda = new Venda();
            VendaDAO vdao = new VendaDAO();
            Cliente cli = new Cliente();
            FormaPagamento fp = (FormaPagamento) cbFP.getSelectedItem();
            cli.setId((int) jtClientes.getValueAt(jtClientes.getSelectedRow(), 0));
            cli.setNome(jtClientes.getValueAt(jtClientes.getSelectedRow(), 1).toString());
            cli.setTelefone(jtClientes.getValueAt(jtClientes.getSelectedRow(), 2).toString());
            cli.setCPF(jtClientes.getValueAt(jtClientes.getSelectedRow(), 3).toString());
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
            String dataFormatada = formatterData.format(agora);
            venda.setData(dataFormatada);
            venda.setPagamento(fp);
            venda.setCliente(cli);
            vdao.create(venda);

            ItensDaVenda IV = new ItensDaVenda();
            ItensDaVendaDAO ivdao = new ItensDaVendaDAO();
            CategoriaDAO cdao = new CategoriaDAO();
            Produto prod = new Produto();
            ProdutoDAO pdao = new ProdutoDAO();
            prod.setId((int) jtProdutos.getValueAt(jtProdutos.getSelectedRow(), 0));
            prod.setNome(jtProdutos.getValueAt(jtProdutos.getSelectedRow(), 2).toString());
            prod.setPreco(Double.parseDouble(jtProdutos.getValueAt(jtProdutos.getSelectedRow(), 3).toString()));
            prod.setQtd((int)jtProdutos.getValueAt(jtProdutos.getSelectedRow(), 4));
            prod.setCodBarras(jtProdutos.getValueAt(jtProdutos.getSelectedRow(), 1).toString());
            for(Categoria cat : cdao.read()){
                    if(cat.getNome() == null ? jtProdutos.getValueAt(jtProdutos.getSelectedRow(),5).toString() == null : cat.getNome().equals(jtProdutos.getValueAt(jtProdutos.getSelectedRow(),5).toString())){
                        prod.setCategoria(cat);
                        break;
                    }
            }
            IV.setProduto(prod);
            IV.setQtd(Integer.parseInt(txtQuantidade.getText()));
            ivdao.create(IV);
            prod.setQtd(prod.getQtd() - (Integer.parseInt(txtQuantidade.getText())));
            pdao.update(prod);
            readTableP();
            JOptionPane.showMessageDialog(null, "Compra realizada com êxito!");
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }
    }//GEN-LAST:event_buttonConcluirActionPerformed

    private void txtQuantidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeFocusGained
        if(txtQuantidade.getText().equals("Quantidade")){
            txtQuantidade.setText("");
        }
    }//GEN-LAST:event_txtQuantidadeFocusGained

    private void txtQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeFocusLost
        if(txtQuantidade.getText().equals("")){
            txtQuantidade.setText("Quantidade");
        }
    }//GEN-LAST:event_txtQuantidadeFocusLost

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        jPanel4.setBackground(new Color(32,156,223));
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        jPanel4.setBackground(new Color(32,136,203));
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        dispose();
        Home vhome = new Home();
        vhome.setVisible(true);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        dispose();
        viewCategoria vcat = new viewCategoria();
        vcat.setVisible(true);
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        dispose();
        viewCliente vcli = new viewCliente();
        vcli.setVisible(true);
    }//GEN-LAST:event_jPanel6MouseClicked

    private void buttonFPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFPActionPerformed
        viewFormaPagamento vfp = new viewFormaPagamento();
        vfp.setVisible(true);
    }//GEN-LAST:event_buttonFPActionPerformed

    private void buttonHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHistoricoActionPerformed
        viewHistoricoVendas vhv = new viewHistoricoVendas();
        vhv.setVisible(true);
    }//GEN-LAST:event_buttonHistoricoActionPerformed

    private void txtPesquisarPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPesquisarPFocusGained
        if(txtPesquisarP.getText().equals("Pesquisar")){
            txtPesquisarP.setText("");
        }
    }//GEN-LAST:event_txtPesquisarPFocusGained

    private void txtPesquisarPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPesquisarPFocusLost
        if(txtPesquisarP.getText().equals("")){
            txtPesquisarP.setText("Pesquisar");
        }
    }//GEN-LAST:event_txtPesquisarPFocusLost

    private void txtPesquisarPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarPKeyReleased
        searchP(txtPesquisarP.getText());
    }//GEN-LAST:event_txtPesquisarPKeyReleased

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConcluir;
    private javax.swing.JButton buttonFP;
    private javax.swing.JButton buttonHistorico;
    private javax.swing.JComboBox<Object> cbFP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtClientes;
    private javax.swing.JTable jtProdutos;
    private javax.swing.JTextField txtPesquisarC;
    private javax.swing.JTextField txtPesquisarP;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
