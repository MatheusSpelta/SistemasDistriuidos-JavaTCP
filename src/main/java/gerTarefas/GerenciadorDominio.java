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
import dominio.Endereco;
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

    public int inserirCliente(String nome, String CPF, String CNPJ, String celular, String CEP, String cidade, String rua, String bairro, int numero, String UF) throws HibernateException {
        Endereco endereco = new Endereco(CEP, bairro, rua, numero);
        Cliente cli = new Cliente(nome, CPF, CNPJ, celular, endereco);
        cliDAO.inserir(cli);
        return cli.getIdCliente();
    }

    public List<Cidade> listarCidades() {
        return genDAO.listar(Cidade.class);
    }
}
