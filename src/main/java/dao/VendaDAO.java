/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Venda;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Matheus
 */
public class VendaDAO extends GenericDAO {

    private List<Venda> pesquisar(String pesq, int tipo) throws HibernateException {
        List lista = null;
        Session sessao = null;

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Venda.class);

            Root tabela = consulta.from(Venda.class);

            Predicate restricoes = null;

            switch (tipo) {
                case 0:
                    restricoes = builder.equal(tabela.get("idVenda"), pesq);
                    break;
                case 1:
                    restricoes = builder.like(tabela.get("cliente"), pesq + "%");

                    break;
                case 2:
                    restricoes = builder.like(tabela.get("dataVenda"), pesq + "%");
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

    public List<Venda> pesquisarCodigo(String pesq) {
        return pesquisar(pesq, 0);
    }

    public List<Venda> pesquisarCliente(String pesq) {
        return pesquisar(pesq, 1);
    }

    public List<Venda> pesquisarData(String pesq) {
        return pesquisar(pesq, 2);
    }

}
