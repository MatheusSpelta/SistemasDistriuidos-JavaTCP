/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas;

import dao.ClienteDAO;
import dominio.Cliente;
import dao.ConexaoHibernate;
import dao.GenericDAO;
import dominio.Cidade;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author matheus
 */
public class GerenciadorDominio {
    
    private GenericDAO genDAO;
    private ClienteDAO cliDAO;
    
    public GerenciadorDominio() throws HibernateException {
        // TESTE
        ConexaoHibernate.getSessionFactory();
        
        genDAO = new GenericDAO();
        cliDAO = new ClienteDAO();
    }
    
    public List<Cidade> listarCidades(){
        return genDAO.listar(Cidade.class);
    }
}
