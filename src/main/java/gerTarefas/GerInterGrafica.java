/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas;

import intergraf.DlgEstoque;
import intergraf.DlgVenda;
import intergraf.DlgClient;
import intergraf.FrmPrincipal;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author mathe
 */
public class GerInterGrafica {
    private FrmPrincipal janPrinc = null;
    private DlgEstoque janEstoque = null;
    private DlgClient janCliente = null;
    private DlgVenda janVenda = null;
    
    GerenciadorDominio gerDominio;
    
    public GerInterGrafica(){
        try{
            gerDominio = new GerenciadorDominio();
        }catch (ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(janPrinc, "Erro de conexão com o banco. " + ex.getMessage() );
                System.exit(-1);
        }
    }
    
    public GerenciadorDominio getGerDominio(){
        return gerDominio;
    }
    
    
    private JDialog abrirDialog(java.awt.Frame parent, JDialog dlg,Class classe){
        if(dlg == null){
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class, GerInterGrafica.class).newInstance(true, this);
            }catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex){
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName() );
            }
        }
        dlg.setVisible(true);
        return dlg;
    }
    
    public void JanelaPrincipal(){
        janPrinc = new FrmPrincipal(this);
        janPrinc.setVisible(true);
    }
    
    public void JanelaCliente(){
        janCliente = (DlgClient) abrirDialog(janPrinc, janCliente,DlgClient.class);
    }
    
    public void JanelaEstoque(){
        janEstoque = (DlgEstoque) abrirDialog(janPrinc, janEstoque, DlgEstoque.class);
    }
    
    public void JanelaVenda(){
        janVenda = (DlgVenda) abrirDialog(janPrinc, janVenda, DlgVenda.class);
    }
 
    
    public static void main(String args[]){
        GerInterGrafica gerIG = new GerInterGrafica();
        gerIG.JanelaPrincipal();
    }
}
