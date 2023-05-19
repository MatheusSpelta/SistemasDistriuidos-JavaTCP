/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Cliente;
import org.hibernate.Session;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Matheus
 */
public class ClienteDAO extends GenericDAO{
   
    private List<Cliente> pesquisar(String pesq, int tipo){
       return null;
   }
   
    public List<Cliente> pesquisarPorNome(String pesq){
        return pesquisar(pesq,1);
    }
    
    public List<Cliente> pesquisarPorBairro(String pesq){
        return pesquisar(pesq,2);
    }
    
    public List<Cliente> pesquisarPorMes(String pesq){
        return pesquisar(pesq,3);
    }
}
