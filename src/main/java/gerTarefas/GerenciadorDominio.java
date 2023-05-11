/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas;

import dao.ClienteDAO;
import dao.ConexaoHibernate;
import dao.GenericDAO;
import java.sql.SQLException;
import org.hibernate.HibernateException;

/**
 *
 * @author mathe
 */
public class GerenciadorDominio {
    
    ClienteDAO cliDao = null;
    GenericDAO genDao = null;
    
    public GerenciadorDominio() throws HibernateException {
        // TESTE
        ConexaoHibernate.getSessionFactory();
        
        genDao = new GenericDAO();
        cliDao = new ClienteDAO();
    }
}
