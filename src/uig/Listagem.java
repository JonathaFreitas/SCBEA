/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uig;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelos.classes.AreaDeConhecimento;
import modelos.classes.Autor;
import modelos.classes.Editora;
import modelos.classes.Colaborador;
import persistencia.AreaDeConhecimentoPersistencia;
import persistencia.AutorPersistencia;
import persistencia.EditoraPersistencia;
import persistencia.ColaboradorPersistencia;

/**
 *
 * @author jsfr
 */
public class Listagem extends javax.swing.JInternalFrame {
    EditoraPersistencia editora = null;
    AutorPersistencia autor = null;
    AreaDeConhecimentoPersistencia areaDeConhecimento = null;
    ColaboradorPersistencia colaborador=null;
    /**
     * Creates new form ListagemEditora_Interna
     */
    public Listagem() {
        initComponents();
        editora = new EditoraPersistencia("Editoras.txt");
        autor = new AutorPersistencia("Autores.txt");
        areaDeConhecimento = new AreaDeConhecimentoPersistencia("DDD.txt");
        colaborador = new ColaboradorPersistencia("Colaboradores.txt");
        
        // Criando tabela Listar Autor
        DefaultTableModel modelAutores = (DefaultTableModel) jTable_tabelaAutores.getModel();
        jTable_tabelaAutores.setRowSorter(new TableRowSorter(modelAutores)); 
        
        // Criando tabala Listar Area de Conhecimento
        DefaultTableModel modelAreasDeConhecimento = (DefaultTableModel) jTable_tabelaAreaDeConhecimento.getModel();
        jTable_tabelaAreaDeConhecimento.setRowSorter(new TableRowSorter(modelAreasDeConhecimento));  
        
        //Criando tabela Listar Colaboradores
        DefaultTableModel modelColaboradores = (DefaultTableModel) jTable_tabelaColaboradores.getModel();
        jTable_tabelaColaboradores.setRowSorter(new TableRowSorter(modelColaboradores));
        
        try{
            listarDadosNaTelaEditora(editora.recuperar());
            listarDadosNaTelaAutor(autor.recuperar(),modelAutores);
            listarDadosNaTelaAreaDeConhecimento(areaDeConhecimento.recuperar(), modelAreasDeConhecimento);
            listarDadosNaTelaColaborador(colaborador.recuperar(),modelColaboradores);
        }catch (Exception erro){
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }
    
        private void listarDadosNaTelaEditora(ArrayList<Editora> lista) {
        //Ordenando o Array por nome
        //Criando tabela Listar Editoras
        DefaultTableModel modelEditoras = (DefaultTableModel) jTable_tabelaEditoras.getModel();
        jTable_tabelaEditoras.setRowSorter(new TableRowSorter(modelEditoras));
        //Limpando a tela
        modelEditoras.setNumRows(0);
        //Correr o ArrayList
        for (int pos = 0; pos < lista.size(); pos++) {
            String[] linha = new String[2];
            Editora aux = lista.get(pos);
            linha[0] = ""+aux.getId();
            linha[1] = aux.getNome();
            modelEditoras.addRow(linha);
        }
    }
    
        void listarDadosNaTelaAutor(ArrayList<Autor> lista, DefaultTableModel model) {
        //Ordenando o Array por nome
        //Limpando a tela
        model.setNumRows(0);
        //Correr o ArrayList
        for (int pos = 0; pos < lista.size(); pos++) {
            String[] linha = new String[2];
            Autor aux = lista.get(pos);
            linha[0] = ""+aux.getId();
            linha[1] = aux.getNome();
            model.addRow(linha);
        }
    }
        
        public void listarDadosNaTelaAreaDeConhecimento(ArrayList<AreaDeConhecimento> lista, DefaultTableModel model) {
        //Ordenando o Array por nome
        //Limpando a tela
        model.setNumRows(0);
        //Correr o ArrayList
        for (int pos = 0; pos < lista.size(); pos++) {
            String[] linha = new String[3];
            AreaDeConhecimento aux = lista.get(pos);
            linha[0] = "" + aux.getId();
            linha[1]=aux.getClassificacaoDecimalDireito();
            linha[2] = aux.getDescricao();
            model.addRow(linha);
        }
    }
        
        void listarDadosNaTelaColaborador(ArrayList<Colaborador> lista,DefaultTableModel model ) {
        //Ordenando o Array por nome
        //Criando a Tabela
        
        //Limpando a tela
        model.setNumRows(0);
        //Correr o ArrayList
        for (int pos = 0; pos < lista.size(); pos++) {
            String[] linha = new String[9];
            Colaborador aux = lista.get(pos);
            linha[0] = ""+aux.getId();
            linha[1] = ""+aux.getMatricula();
            linha[2] = aux.getNome();
            linha[3] = ""+aux.getNumeroOAB();
            linha[4] = ""+aux.getCpf();
            linha[5] = aux.getEmail();
            linha[6] = ""+aux.getTelefone();
            linha[7] = aux.getTipo().toString();
            linha[8] = aux.getStatus().toString();
            model.addRow(linha);
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

        jTable_tabelaListagem = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_tabelaEditoras = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_tabelaAutores = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_tabelaAreaDeConhecimento = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_tabelaLivros = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_tabelaColaboradores = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Listagem");

        jTable_tabelaEditoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME DA EDITORA"
            }
        ));
        jScrollPane1.setViewportView(jTable_tabelaEditoras);
        if (jTable_tabelaEditoras.getColumnModel().getColumnCount() > 0) {
            jTable_tabelaEditoras.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable_tabelaEditoras.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );

        jTable_tabelaListagem.addTab("Editora", jPanel1);

        jTable_tabelaAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME DO AUTOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable_tabelaAutores);
        if (jTable_tabelaAutores.getColumnModel().getColumnCount() > 0) {
            jTable_tabelaAutores.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable_tabelaAutores.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );

        jTable_tabelaListagem.addTab("Autor", jPanel2);

        jTable_tabelaAreaDeConhecimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CÓDIGO CDD", "DESCRIÇÃO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable_tabelaAreaDeConhecimento);
        if (jTable_tabelaAreaDeConhecimento.getColumnModel().getColumnCount() > 0) {
            jTable_tabelaAreaDeConhecimento.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable_tabelaAreaDeConhecimento.getColumnModel().getColumn(1).setPreferredWidth(25);
            jTable_tabelaAreaDeConhecimento.getColumnModel().getColumn(2).setPreferredWidth(300);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );

        jTable_tabelaListagem.addTab("Area", jPanel4);

        jTable_tabelaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TÍTULO DO LIVRO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable_tabelaLivros);
        if (jTable_tabelaLivros.getColumnModel().getColumnCount() > 0) {
            jTable_tabelaLivros.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable_tabelaLivros.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );

        jTable_tabelaListagem.addTab("Livro", jPanel3);

        jTable_tabelaColaboradores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MATRICULA", "NOME", "OAB", "CPF", "e-MAIL", "TELEFONE", "TIPO", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable_tabelaColaboradores);
        if (jTable_tabelaColaboradores.getColumnModel().getColumnCount() > 0) {
            jTable_tabelaColaboradores.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable_tabelaColaboradores.getColumnModel().getColumn(1).setPreferredWidth(10);
            jTable_tabelaColaboradores.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTable_tabelaColaboradores.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable_tabelaColaboradores.getColumnModel().getColumn(4).setPreferredWidth(11);
            jTable_tabelaColaboradores.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTable_tabelaColaboradores.getColumnModel().getColumn(6).setPreferredWidth(10);
            jTable_tabelaColaboradores.getColumnModel().getColumn(7).setPreferredWidth(10);
            jTable_tabelaColaboradores.getColumnModel().getColumn(8).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );

        jTable_tabelaListagem.addTab("Colaborador", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTable_tabelaListagem, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTable_tabelaListagem)
        );

        setBounds(130, 1, 1024, 620);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable_tabelaAreaDeConhecimento;
    private javax.swing.JTable jTable_tabelaAutores;
    private javax.swing.JTable jTable_tabelaColaboradores;
    private javax.swing.JTable jTable_tabelaEditoras;
    private javax.swing.JTabbedPane jTable_tabelaListagem;
    private javax.swing.JTable jTable_tabelaLivros;
    // End of variables declaration//GEN-END:variables
}
