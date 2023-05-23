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
public class ClienteDAO extends GenericDAO {

    private List<Cliente> pesquisar(String pesq, int tipo) {
        return listar(Cliente.class);
    }

    public List<Cliente> pesquisarCodigo(String pesq) {
        return pesquisar(pesq, 0);
    }

    public List<Cliente> pesquisarNome(String pesq) {
        return pesquisar(pesq, 1);
    }

    public List<Cliente> pesquisarPontos(String pesq) {
        return pesquisar(pesq, 2);
    }

    public List<Cliente> pesquisarCPF(String pesq) {
        return pesquisar(pesq, 3);
    }

    public List<Cliente> pesquisarCNPJ(String pesq) {
        return pesquisar(pesq, 4);
    }

    public List<Cliente> pesquisarCidade(String pesq) {
        return pesquisar(pesq, 5);
    }

    public List<Cliente> pesquisarUF(String pesq) {
        return pesquisar(pesq, 6);
    }
}
