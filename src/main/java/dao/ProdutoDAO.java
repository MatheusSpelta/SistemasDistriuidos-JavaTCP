/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Produto;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Matheus
 */
public class ProdutoDAO extends GenericDAO {

    public List<Produto> pesquisar(String pesq, int tipo) throws HibernateException {
        List lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Produto.class);

            Root tabela = consulta.from(Produto.class);

            Predicate restricoes = null;

            switch (tipo) {
                case 0:
                    restricoes = builder.like(tabela.get("descricao"), pesq + "%");
                    break;
                case 1:
                    restricoes = builder.like(tabela.get("marca"), pesq + "%");
                    break;
                case 2:
                    restricoes = builder.like(tabela.get("idProduto").as(String.class), pesq + "%");
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

    public List<Produto> pesquisarDescricao(String pesq) throws HibernateException {
        return pesquisar(pesq, 0);
    }

    public List<Produto> pesquisarMarca(String pesq) throws HibernateException {
        return pesquisar(pesq, 1);
    }

    public List<Produto> pesquisaPorID(String pesq) throws HibernateException {
        return pesquisar(pesq, 2);
    }

}
