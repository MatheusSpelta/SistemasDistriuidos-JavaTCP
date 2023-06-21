/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas;

import dao.ClienteDAO;
import dominio.Cliente;
import dao.ConexaoHibernate;
import dao.EnderecoDAO;
import dao.GenericDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;

import dominio.Endereco;
import dominio.Produto;
import dominio.UnidadeMedida;
import dominio.Venda;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author matheus
 */
public class GerenciadorDominio {

    private GenericDAO genDAO;
    private ClienteDAO cliDAO;
    private EnderecoDAO endDAO;
    private ProdutoDAO proDAO;
    private VendaDAO venDAO;

    public GerenciadorDominio() throws HibernateException {
        // TESTE
        ConexaoHibernate.getSessionFactory();

        genDAO = new GenericDAO();
        cliDAO = new ClienteDAO();
        endDAO = new EnderecoDAO();
        proDAO = new ProdutoDAO();
        venDAO = new VendaDAO();
    }

    public int inserirProduto(String descricao, String marca, UnidadeMedida unidadeMedida, int estoque, float valorVenda, float valorCompra) {
        Produto pro = new Produto(descricao, marca, estoque, valorVenda, valorCompra, unidadeMedida);
        proDAO.inserir(pro);
        return pro.getId();
    }

    public int inserirCliente(String nome, String CPF, String CNPJ, String celular, String CEP, String cidade, String rua, String bairro, int numero, String UF) throws HibernateException {
        Endereco endereco = new Endereco(CEP, bairro, rua, numero, UF, cidade);
        Cliente cli = new Cliente(nome, CPF, CNPJ, celular, endereco);
        cliDAO.inserir(cli);
        return cli.getIdCliente();
    }

    public int inserirVenda() {
        Venda ven = new Venda();
        return ven.getIdVenda();
    }

    public void alterarCliente(Cliente cli, int id, boolean ativo, String nome, String CPF, String CNPJ, String celular, String CEP, String cidade, String rua, String bairro, int numero, String UF) throws HibernateException {
        cli.setIdCliente(id);
        cli.setNome(nome);
        cli.setCpf(CPF);
        cli.setCnpj(CNPJ);
        cli.setCelular(celular);
        cli.getEndereco().setCep(CEP);
        cli.getEndereco().setCidade(cidade);
        cli.getEndereco().setRua(rua);
        cli.getEndereco().setBairro(bairro);
        cli.getEndereco().setNumero(numero);
        cli.getEndereco().setUf(UF);
        cli.setAtivo(ativo);

        cliDAO.alterar(cli);
    }

    public void alterarProduto(Produto pro, String descricao, String marca, UnidadeMedida unidadeMedida, int estoque, float valorVenda, float valorCompra) {
        pro.setDescricao(descricao);
        pro.setMarca(marca);
        pro.setUnidadeMedida(unidadeMedida);
        pro.setQuantidade(estoque);
        pro.setValorCompra(valorCompra);
        pro.setValorVenda(valorVenda);

        proDAO.alterar(pro);
    }

    public List<Cliente> pesquisarCliente(String pesq, int tipo) throws HibernateException {
        List<Cliente> lista = null;
        switch (tipo) {
            case 0:
                lista = cliDAO.pesquisarNome(pesq);
                break;
            case 1:
                lista = cliDAO.pesquisarCPF(pesq);
                break;
            case 2:
                lista = cliDAO.pesquisarCNPJ(pesq);
                break;
            case 3:
                lista = cliDAO.pesquisarCidade(pesq);
                break;
            case 4:
                lista = cliDAO.pesquisarUF(pesq);
                break;

        }
        return lista;
    }

    public List listar(Class classe) throws HibernateException {
        return genDAO.listar(classe);
    }

    public void excluir(Object obj) throws HibernateException {
        genDAO.excluir(obj);
    }

    public List<Produto> pesquisarProduto(String pesq, int tipo) throws HibernateException {
        List<Produto> lista = null;
        switch (tipo) {
            case 0:
                lista = proDAO.pesquisarDescricao(pesq);
                break;
            case 1:
                lista = proDAO.pesquisarMarca(pesq);
                break;
        }
        return lista;
    }

}
