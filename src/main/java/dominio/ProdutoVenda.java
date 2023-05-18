/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import dominio.Produto;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Matheus
 */

@Entity
@Table(name = "produto_venda")

//Tabela auxiliar, que relaciona os produtos as vendas feitas
public class ProdutoVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private Produto produto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venda_id")
    private Venda venda;
    
    @Column(name = "quantidade")
    private Integer quantidade;
    
    @Column(name = "valor_unit")
    private BigDecimal valorUnit;
    
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    
    @Column(name = "desconto_unit")
    private BigDecimal descontoUnit;
    
    @Column(name = "desconto_total")
    private BigDecimal descontoTotal;
    
    
    
    //Setter, Getter and Constructors

    public ProdutoVenda() {
    }

    public ProdutoVenda(Long id, Produto produto, Venda venda, Integer quantidade, BigDecimal valorUnit, BigDecimal valorTotal, BigDecimal descontoUnit, BigDecimal descontoTotal) {
        this.id = id;
        this.produto = produto;
        this.venda = venda;
        this.quantidade = quantidade;
        this.valorUnit = valorUnit;
        this.valorTotal = valorTotal;
        this.descontoUnit = descontoUnit;
        this.descontoTotal = descontoTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(BigDecimal valorUnit) {
        this.valorUnit = valorUnit;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getDescontoUnit() {
        return descontoUnit;
    }

    public void setDescontoUnit(BigDecimal descontoUnit) {
        this.descontoUnit = descontoUnit;
    }

    public BigDecimal getDescontoTotal() {
        return descontoTotal;
    }

    public void setDescontoTotal(BigDecimal descontoTotal) {
        this.descontoTotal = descontoTotal;
    }
    
    
}
