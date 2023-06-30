/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author mathe
 */
public class GerenciadorRelatorio {

    public void relComLista(List lista, String nome) {
        try {
            InputStream rel = getClass().getResourceAsStream("../relatorios/" + nome);

            Map parametros = new HashMap();

            JRBeanCollectionDataSource dados = new JRBeanCollectionDataSource(lista);
            JasperPrint print;
            print = JasperFillManager.fillReport(rel, parametros, dados);

            if (print.getPages().size() > 0) {

                JasperViewer jrViewer = new JasperViewer(print, true);
                JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
                viewer.setSize(800, 600);
                viewer.setLocationRelativeTo(null);
                viewer.getContentPane().add(jrViewer.getContentPane());
                viewer.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Relatório vazio.");
            }

        } catch (JRException erro) {
            JOptionPane.showMessageDialog(null, "ERRO ao abrir relatório. " + erro.getMessage());

        }
    }
}
