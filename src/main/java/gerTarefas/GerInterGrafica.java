/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas;

import dominio.Cliente;
import dominio.Produto;
import dominio.UnidadeMedida;
import intergraf.DlgMenuEstoque;
import intergraf.DlgMenuVenda;
import intergraf.DlgMenuClient;
import intergraf.DlgPesquisaCliente;
import intergraf.DlgPesquisaProduto;
import intergraf.FrmPrincipal;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;

/**
 *
 * @author matheus
 */
public class GerInterGrafica {

    private FrmPrincipal janPrinc = null;
    private DlgMenuEstoque janEstoque = null;
    private DlgMenuClient janCliente = null;
    private DlgMenuVenda janVenda = null;
    private DlgPesquisaCliente janPesqCli = null;
    private DlgPesquisaProduto janPesqPro = null;

    GerenciadorDominio gerDominio;

    public GerInterGrafica() {
        try {
            gerDominio = new GerenciadorDominio();
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(janPrinc, "Erro de conexão com o banco." + ex.getMessage());
            System.exit(-1);
        }
    }

    public GerenciadorDominio getGerDominio() {
        return gerDominio;
    }

    private JDialog abrirDialog(java.awt.Frame parent, JDialog dlg, Class classe) {
        if (dlg == null) {
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class, GerInterGrafica.class).newInstance(parent, true, this);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName());
            }
        }
        dlg.setVisible(true);
        return dlg;
    }

    public void JanelaPrincipal() {
        janPrinc = new FrmPrincipal(this);
        janPrinc.setVisible(true);
    }

    public void JanelaCliente() {
        janCliente = (DlgMenuClient) abrirDialog(janPrinc, janCliente, DlgMenuClient.class);
    }

    public void JanelaEstoque() {
        janEstoque = (DlgMenuEstoque) abrirDialog(janPrinc, janEstoque, DlgMenuEstoque.class);

    }

    public void JanelaVenda() {
        janVenda = (DlgMenuVenda) abrirDialog(janPrinc, janVenda, DlgMenuVenda.class);
    }

    public Cliente janelaPesqCliente() {
        janPesqCli = (DlgPesquisaCliente) abrirDialog(janPrinc, janPesqCli, DlgPesquisaCliente.class);
        return janPesqCli.getCliente();
    }

    public Produto janelaPesqProduto() {
        janPesqPro = (DlgPesquisaProduto) abrirDialog(janPrinc, janPesqPro, DlgPesquisaProduto.class);
        return janPesqPro.getProduto();
    }

    public void carregarComboUnidadeMedida(JComboBox combo, Class classe) {
        try {
            List<UnidadeMedida> lista = gerDominio.listar(classe);
            combo.setModel(new DefaultComboBoxModel(lista.toArray()));
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(janPrinc, "Erro ao carregar unidades de medida." + ex.getMessage());
        }
    }

    public static void main(String args[]) {
        GerInterGrafica gerIG = new GerInterGrafica();
        gerIG.JanelaPrincipal();
    }
}
