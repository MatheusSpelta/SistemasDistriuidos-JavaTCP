/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas;

import dominio.Cliente;
import dao.ConexaoHibernate;
import dao.GenericDAO;
import org.hibernate.HibernateException;

/**
 *
 * @author matheus
 */
public class GerenciadorDominio {
    
    Cliente cliDao = null;
    GenericDAO genDao = null;
    
    public GerenciadorDominio() throws HibernateException {
        // TESTE
        ConexaoHibernate.getSessionFactory();
        
        genDao = new GenericDAO();
        cliDao = new Cliente();
    }
}
