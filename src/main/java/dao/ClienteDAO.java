/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Cliente;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author Matheus
 */
public class ClienteDAO extends GenericDAO {

    private List<Cliente> pesquisar(String pesq, int tipo) throws HibernateException {
        List lista = null;
        Session sessao = null;

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Cliente.class);

            Root tabela = consulta.from(Cliente.class);

            Predicate restricoes = null;

            switch (tipo) {
                case 0:
                    restricoes = builder.like(tabela.get("nome"), pesq + "%");
                    break;
                case 1:
                    restricoes = builder.like(tabela.get("cpf"), pesq + "%");
                    break;
                case 2:
                    restricoes = builder.like(tabela.get("cnpj"), pesq + "%");
                    break;
                case 3:
                    restricoes = builder.like(tabela.get("endereco").get("cidade"), pesq + "%");
                    break;
                case 4:
                    restricoes = builder.like(tabela.get("endereco").get("UF"), pesq + "%");
                    break;
            }
            consulta.where(restricoes);
            lista = sessao.createQuery(consulta).getResultList();

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return lista;
    }

    public List<Cliente> pesquisarNome(String pesq) {
        return pesquisar(pesq, 0);
    }

    public List<Cliente> pesquisarCPF(String pesq) {
        return pesquisar(pesq, 1);
    }

    public List<Cliente> pesquisarCNPJ(String pesq) {
        return pesquisar(pesq, 2);
    }

    public List<Cliente> pesquisarCidade(String pesq) {
        return pesquisar(pesq, 3);
    }

    public List<Cliente> pesquisarUF(String pesq) {
        return pesquisar(pesq, 4);
    }
}
