/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uig;

import controle.AreaDeConhecimentoControle;
import controle.AutorControle;
import controle.EditoraControle;
import controle.LivroControle;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelos.classes.AreaDeConhecimento;
import modelos.classes.Autor;
import modelos.classes.Editora;
import modelos.classes.Livro;
import modelos.interfaces.ICRUDAreaDeConhecimento;
import modelos.interfaces.ICRUDAutor;
import modelos.interfaces.ICRUDEditora;
import modelos.interfaces.ICRUDLivro;
import modelos.utilidades.GeradorID;
import persistencia.EditoraPersistencia;
import static uig.Home.jDesktopPane_AreaTrabalho;

/**
 *
 * @author jsfr
 */
public class TelaLivro extends javax.swing.JInternalFrame {

    private final ComboboxArray comboboxEditora = new ComboboxArray();
    ICRUDEditora objEditora = new EditoraControle();
    ICRUDAutor objAutor = new AutorControle();
    ICRUDAreaDeConhecimento objAreaDeConhecimento = new AreaDeConhecimentoControle();
    ICRUDLivro objControle = new LivroControle();
    Listagem objetoListarLivro = new Listagem();

    /**
     * Creates new form TelaLivro
     *
     * @throws java.lang.Exception
     */
    public TelaLivro() throws Exception {
        initComponents();
        jButton_editar.setEnabled(false);
        jButton_excluir.setEnabled(false);
        criarModelEditora(objEditora.recuperar());
        criarModelAutor(objAutor.recuperar());
        criarModelAreaConhecimento(objAreaDeConhecimento.recuperar());
        //carregarCombobox(objEditora.recuperar());

        //Criando tabela Listar Livros
        DefaultTableModel modelLivros = (DefaultTableModel) jTable_tabelaLivros.getModel();
        jTable_tabelaLivros.setRowSorter(new TableRowSorter(modelLivros));

        try {
            objetoListarLivro.listarDadosNaTelaLivro(objControle.recuperar(), modelLivros);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }

    private void limparTela() {
        jButton_editar.setEnabled(false);
        jButton_excluir.setEnabled(false);
        jButton_incluir.setEnabled(true);
        jTextField_titulo.setText("");
        jTextField_isbn.setText("");
        jComboBox_editora.setSelectedIndex(0);
        jComboBox_autor.setSelectedIndex(0);
        jComboBox_areaDeConhecimento.setSelectedIndex(0);
    }

    //Metodo para jogar lista de Editora na ListModel
    private void carregarCombobox(ArrayList<Editora> lista) {
        lista.forEach((aux) -> {
            comboboxEditora.addEditora(aux);
        });
    }

    //Metodo para jogar lista de Autor na ListModel
    private void criarModelEditora(ArrayList<Editora> lista) throws Exception {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBox_editora.getModel();
            jComboBox_editora.removeAllItems();
            jComboBox_editora.addItem(null);
            for (int pos = 0; pos < lista.size(); pos++) {
                Editora aux = lista.get(pos);
                jComboBox_editora.addItem(aux.toString());
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher  Area de Conhecimento");
        }
    }
    //Metodo para jogar lista de Autor na ListModel

    private void criarModelAutor(ArrayList<Autor> lista) throws Exception {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBox_autor.getModel();
            jComboBox_autor.removeAllItems();
            jComboBox_autor.addItem(null);
            for (int pos = 0; pos < lista.size(); pos++) {
                Autor aux = lista.get(pos);
                jComboBox_autor.addItem(aux.toString());
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher  Area de Conhecimento");
        }
    }

    //Metodo para jogar lista de Area de Conhecimento na ListModel
    private void criarModelAreaConhecimento(ArrayList<AreaDeConhecimento> lista) throws Exception {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBox_areaDeConhecimento.getModel();
            jComboBox_areaDeConhecimento.removeAllItems();
            jComboBox_areaDeConhecimento.addItem(null);
            for (int pos = 0; pos < lista.size(); pos++) {
                AreaDeConhecimento aux = lista.get(pos);
                jComboBox_areaDeConhecimento.addItem(aux.toString());
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher  Area de Conhecimento");
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

        jLabel1 = new javax.swing.JLabel();
        jComboBox_editora = new javax.swing.JComboBox<>();
        Label2 = new javax.swing.JLabel();
        jComboBox_autor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_areaDeConhecimento = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField_titulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_isbn = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_tabelaLivros = new javax.swing.JTable();
        jButton_chamarTelaEditora = new javax.swing.JButton();
        jButton_chamarTelaAutor = new javax.swing.JButton();
        jButton_chamarTelaAreaConhecimento = new javax.swing.JButton();
        jButton_incluir = new javax.swing.JButton();
        jButton_editar = new javax.swing.JButton();
        jButton_excluir = new javax.swing.JButton();
        jButton_limpar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Livro");

        jLabel1.setText("Editora:");

        jComboBox_editora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Label2.setText("Autor:");

        jComboBox_autor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Area de Conhecimento:");

        jComboBox_areaDeConhecimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Título:");

        jLabel4.setText("ISBN:");

        jTable_tabelaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "EDITORA", "AUTOR", "AREA CONHECIMENTO", "TÍTULO", "ISBN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_tabelaLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_tabelaLivrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_tabelaLivros);
        if (jTable_tabelaLivros.getColumnModel().getColumnCount() > 0) {
            jTable_tabelaLivros.getColumnModel().getColumn(0).setPreferredWidth(3);
            jTable_tabelaLivros.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable_tabelaLivros.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable_tabelaLivros.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable_tabelaLivros.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTable_tabelaLivros.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        jButton_chamarTelaEditora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit.png"))); // NOI18N
        jButton_chamarTelaEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_chamarTelaEditoraActionPerformed(evt);
            }
        });

        jButton_chamarTelaAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit.png"))); // NOI18N
        jButton_chamarTelaAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_chamarTelaAutorActionPerformed(evt);
            }
        });

        jButton_chamarTelaAreaConhecimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit.png"))); // NOI18N
        jButton_chamarTelaAreaConhecimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_chamarTelaAreaConhecimentoActionPerformed(evt);
            }
        });

        jButton_incluir.setText("Incluir");
        jButton_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_incluirActionPerformed(evt);
            }
        });

        jButton_editar.setText("Editar");
        jButton_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_editarActionPerformed(evt);
            }
        });

        jButton_excluir.setText("Excluir");
        jButton_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_excluirActionPerformed(evt);
            }
        });

        jButton_limpar.setText("Limpar");
        jButton_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_limparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton_limpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_excluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_editar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_incluir))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jTextField_isbn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBox_autor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox_editora, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_titulo, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_chamarTelaEditora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_chamarTelaAutor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox_areaDeConhecimento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_chamarTelaAreaConhecimento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox_editora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jButton_chamarTelaEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox_autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Label2))
                    .addComponent(jButton_chamarTelaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_chamarTelaAreaConhecimento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_areaDeConhecimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_isbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_incluir)
                    .addComponent(jButton_editar)
                    .addComponent(jButton_excluir)
                    .addComponent(jButton_limpar))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
        );

        setBounds(200, 0, 841, 542);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_chamarTelaEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_chamarTelaEditoraActionPerformed
        // TODO add your handling code here:
        TelaDaEditora TelaDaEditora_Interna = new TelaDaEditora();
        jDesktopPane_AreaTrabalho.add(TelaDaEditora_Interna);
        TelaDaEditora_Interna.setVisible(true);
    }//GEN-LAST:event_jButton_chamarTelaEditoraActionPerformed

    private void jButton_chamarTelaAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_chamarTelaAutorActionPerformed
        // TODO add your handling code here:
        TelaDoAutor TelaDoAutor = new TelaDoAutor();
        jDesktopPane_AreaTrabalho.add(TelaDoAutor);
        TelaDoAutor.setVisible(true);
    }//GEN-LAST:event_jButton_chamarTelaAutorActionPerformed

    private void jButton_chamarTelaAreaConhecimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_chamarTelaAreaConhecimentoActionPerformed
        // TODO add your handling code here:
        TelaAreaDeConhecimento TelaAreaDeConhecimento = new TelaAreaDeConhecimento();
        jDesktopPane_AreaTrabalho.add(TelaAreaDeConhecimento);
        TelaAreaDeConhecimento.setVisible(true);
    }//GEN-LAST:event_jButton_chamarTelaAreaConhecimentoActionPerformed

    private void jButton_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_incluirActionPerformed
        // TODO add your handling code here:
        try {
            GeradorID GerarID = new GeradorID();
            int id = GerarID.getID();
            GerarID.finalize();
            int idEditora = objEditora.recuperar(jComboBox_editora.getSelectedItem().toString()).getId();
            int idAutor = objAutor.recuperar(jComboBox_autor.getSelectedItem().toString()).getId();
            int idAreaConhecimento = objAreaDeConhecimento.recuperar(jComboBox_areaDeConhecimento.getSelectedItem().toString()).getId();
            Livro objetoLivro = new Livro(id, idEditora, idAutor, idAreaConhecimento,
                    jTextField_titulo.getText(), Integer.parseInt(jTextField_isbn.getText()));

            objControle.incluir(objetoLivro);
            DefaultTableModel modelLivros = (DefaultTableModel) jTable_tabelaLivros.getModel();
            jTable_tabelaLivros.setRowSorter(new TableRowSorter(modelLivros));
            objetoListarLivro.listarDadosNaTelaLivro(objControle.recuperar(), modelLivros);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro, "Atenção ", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButton_incluirActionPerformed

    private void jButton_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_editarActionPerformed
        // TODO add your handling code here:
        try {
            String idEditora = jComboBox_editora.getSelectedItem().toString();
            idEditora = idEditora.substring(0, idEditora.indexOf(" "));
            String idAutor = jComboBox_autor.getSelectedItem().toString();
            idAutor = idAutor.substring(0, idAutor.indexOf(" "));
            String idAreaConhecimento = jComboBox_areaDeConhecimento.getSelectedItem().toString();
            idAreaConhecimento = idAreaConhecimento.substring(0, idAreaConhecimento.indexOf(" "));
            Livro objetoLivro = new Livro(Integer.parseInt(jTable_tabelaLivros.getModel().getValueAt(jTable_tabelaLivros.getSelectedRow(), 0).toString()), Integer.parseInt(idEditora), Integer.parseInt(idAutor), Integer.parseInt(idAreaConhecimento),
                    jTextField_titulo.getText(), Integer.parseInt(jTextField_isbn.getText()));

            objControle.editar(objetoLivro);
            DefaultTableModel modelLivros = (DefaultTableModel) jTable_tabelaLivros.getModel();
            jTable_tabelaLivros.setRowSorter(new TableRowSorter(modelLivros));
            objetoListarLivro.listarDadosNaTelaLivro(objControle.recuperar(), modelLivros);
            limparTela();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro, "Atenção ", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButton_editarActionPerformed

    private void jButton_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_excluirActionPerformed
        // TODO add your handling code here:
        try {
            objControle.excluir(Integer.parseInt(jTextField_isbn.getText()));

            // Criando Tabela Listar Colaboradores
            DefaultTableModel modelLivros = (DefaultTableModel) jTable_tabelaLivros.getModel();
            jTable_tabelaLivros.setRowSorter(new TableRowSorter(modelLivros));
            objetoListarLivro.listarDadosNaTelaLivro(objControle.recuperar(), modelLivros);
            limparTela();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, ui);
        }
    }//GEN-LAST:event_jButton_excluirActionPerformed

    private void jTable_tabelaLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_tabelaLivrosMouseClicked
        // TODO add your handling code here:
        try {
            jButton_editar.setEnabled(true);
            jButton_excluir.setEnabled(true);
            jButton_limpar.setEnabled(true);
            jButton_incluir.setEnabled(false);
            for (int e = 1; e < jComboBox_editora.getItemCount(); e++) {
                String RowCombo = jComboBox_editora.getItemAt(e);
                String jTable = jTable_tabelaLivros.getModel().getValueAt(jTable_tabelaLivros.getSelectedRow(), 1).toString();
                if (RowCombo.equals(jTable)) {
                    jComboBox_editora.setSelectedIndex(e);
                }
            }
            for (int a = 1; a < jComboBox_autor.getItemCount(); a++) {
                String RowCombo = jComboBox_autor.getItemAt(a);
                String jTable = jTable_tabelaLivros.getModel().getValueAt(jTable_tabelaLivros.getSelectedRow(), 2).toString();
                if (RowCombo.equals(jTable)) {
                    jComboBox_autor.setSelectedIndex(a);
                }
            }
            
            for (int ac = 1; ac < jComboBox_areaDeConhecimento.getItemCount(); ac++) {
                String RowCombo = jComboBox_areaDeConhecimento.getItemAt(ac);
                String jTable = jTable_tabelaLivros.getModel().getValueAt(jTable_tabelaLivros.getSelectedRow(), 3).toString();
                if (RowCombo.equals(jTable)) {
                    jComboBox_areaDeConhecimento.setSelectedIndex(ac);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaLivro.class.getName()).log(Level.SEVERE, null, ex);
        }

        jTextField_titulo.setText(jTable_tabelaLivros.getModel().getValueAt(jTable_tabelaLivros.getSelectedRow(), 4).toString());
        jTextField_isbn.setText(jTable_tabelaLivros.getModel().getValueAt(jTable_tabelaLivros.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_jTable_tabelaLivrosMouseClicked

    private void jButton_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_limparActionPerformed
        // TODO add your handling code here:
        limparTela();
    }//GEN-LAST:event_jButton_limparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label2;
    private javax.swing.JButton jButton_chamarTelaAreaConhecimento;
    private javax.swing.JButton jButton_chamarTelaAutor;
    private javax.swing.JButton jButton_chamarTelaEditora;
    private javax.swing.JButton jButton_editar;
    private javax.swing.JButton jButton_excluir;
    private javax.swing.JButton jButton_incluir;
    private javax.swing.JButton jButton_limpar;
    private javax.swing.JComboBox<String> jComboBox_areaDeConhecimento;
    private javax.swing.JComboBox<String> jComboBox_autor;
    private javax.swing.JComboBox<String> jComboBox_editora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_tabelaLivros;
    private javax.swing.JTextField jTextField_isbn;
    private javax.swing.JTextField jTextField_titulo;
    // End of variables declaration//GEN-END:variables
}
