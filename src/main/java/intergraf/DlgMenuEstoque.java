/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package intergraf;

import dominio.Produto;
import dominio.UnidadeMedida;
import gerTarefas.GerInterGrafica;
import java.awt.Color;
import java.awt.HeadlessException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;

/**
 *
 * @author mathe
 */
public class DlgMenuEstoque extends javax.swing.JDialog {

    private GerInterGrafica gerIG;
    private Produto proSelecionado;

    /**
     * Creates new form DlgMenuEstoque
     */
    public DlgMenuEstoque(java.awt.Frame parent, boolean modal, GerInterGrafica gerIG) {
        super(parent, modal);
        initComponents();
        this.gerIG = gerIG;
    }

    private void limparCampos() {
        txtDescricao.setText("");
        txtMarca.setText("");
        spnEstoque.setValue(0);
        txtValorCompra.setText("");
        txtValorVenda.setText("");
    }

    private void preencherCampos(Produto pro) {
        if (pro != null) {
            chckAtivo.setEnabled(pro.isAtivo());
            txtDescricao.setText(pro.getDescricao());
            txtMarca.setText(pro.getMarca());
            spnEstoque.setValue(pro.getQuantidade());
            txtValorCompra.setText(pro.getValorCompra());
            txtValorVenda.setText(pro.getValorVenda());
            cmbUniMedida.setSelectedItem(pro.getUnidadeMedida());
        }
    }

    private boolean validarCampos() {
        String msgErro = "";
        lblDescricao.setForeground(Color.black);
        lblMarca.setForeground(Color.black);
        lblEstoque.setForeground(Color.black);
        lblValorCompra.setForeground(Color.black);
        lblValorVenda.setForeground(Color.black);

        if (txtDescricao.getText().isEmpty()) {
            msgErro = msgErro + "Informe a descricao do produto. \n";
            lblDescricao.setForeground(Color.red);
        }
        if (txtMarca.getText().isEmpty()) {
            msgErro = msgErro + "Informe a marca do produto. \n";
            lblMarca.setForeground(Color.red);
        }
        if (Integer.parseInt(spnEstoque.getValue().toString()) < 0) {
            msgErro = msgErro + "Quantidade não pode ser menor do que zero. \n";
            lblEstoque.setForeground(Color.red);
        }
        if (Integer.parseInt(txtValorCompra.getText()) < 0 || Integer.parseInt(txtValorCompra.getText()) > (Integer.parseInt(txtValorVenda.getText()))) {
            msgErro = msgErro + "Valor de compra não pode ser menor que zero ou maior que valor de venda \n";
            lblValorCompra.setForeground(Color.red);
        }
        if (Integer.parseInt(txtValorVenda.getText()) < 0 || Integer.parseInt(txtValorVenda.getText()) < (Integer.parseInt(txtValorCompra.getText()))) {
            msgErro = msgErro + "Valor de venda não pode ser menor que zero ou menor que valor de compra. \n";
            lblValorVenda.setForeground(Color.red);
        }
        if (msgErro.isEmpty()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, msgErro, "Erro Estoque", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        chckAtivo = new javax.swing.JCheckBox();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblUniMedida = new javax.swing.JLabel();
        cmbUniMedida = new javax.swing.JComboBox<>();
        lblEstoque = new javax.swing.JLabel();
        spnEstoque = new javax.swing.JSpinner();
        lblValorCompra = new javax.swing.JLabel();
        txtValorCompra = new javax.swing.JTextField();
        lblValorVenda = new javax.swing.JLabel();
        txtValorVenda = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estoque");
        setName("Estoque"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lblCodigo.setText("Codigo");

        txtCodigo.setEnabled(false);

        btnPesquisar.setText("jButton1");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        chckAtivo.setText("Ativo");

        lblDescricao.setText("Descrição");

        lblMarca.setText("Marca");

        lblUniMedida.setText("Unidade de Medida");

        cmbUniMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        lblEstoque.setText("Estoque");

        lblValorCompra.setText("Valor de compra");

        lblValorVenda.setText("Valor de Venda");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMarca)
                            .addComponent(lblDescricao)
                            .addComponent(lblCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chckAtivo))
                            .addComponent(txtDescricao)
                            .addComponent(txtMarca))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblValorCompra)
                            .addComponent(lblUniMedida))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbUniMedida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtValorCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstoque, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblValorVenda, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(chckAtivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUniMedida)
                    .addComponent(cmbUniMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstoque)
                    .addComponent(spnEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValorVenda, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblValorCompra)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCampos();
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        String descricao = txtDescricao.getText();
        String marca = txtMarca.getText();
        UnidadeMedida unidadeMedida = (UnidadeMedida) cmbUniMedida.getSelectedItem();
        int estoque = Integer.parseInt(spnEstoque.getValue().toString());
        String valorCompra = txtValorCompra.getText();
        String valorVenda = txtValorVenda.getText();

        if (validarCampos()) {
            try {
                if (proSelecionado == null) {
                    int id = gerIG.getGerDominio().inserirProduto(descricao, marca, unidadeMedida, estoque, valorCompra, valorVenda);
                    limparCampos();
                    JOptionPane.showMessageDialog(this, "Produto " + id + " inseriddo com sucesso.", "Inserir Produto", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (HibernateException ex) {
                JOptionPane.showMessageDialog(this, ex, "Erro Produto", JOptionPane.ERROR_MESSAGE);
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(this, ex, "Erro Produto", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        proSelecionado = gerIG.janelaPesqProduto();
        preencherCampos(proSelecionado);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        gerIG.carregarComboUnidadeMedida(cmbUniMedida, Produto.class);
    }//GEN-LAST:event_formComponentShown

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox chckAtivo;
    private javax.swing.JComboBox<String> cmbUniMedida;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblEstoque;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblUniMedida;
    private javax.swing.JLabel lblValorCompra;
    private javax.swing.JLabel lblValorVenda;
    private javax.swing.JSpinner spnEstoque;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtValorCompra;
    private javax.swing.JTextField txtValorVenda;
    // End of variables declaration//GEN-END:variables

}
