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
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venda_id")
    private Venda venda;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "valor_unit")
    private Float valorUnit;

    @Column(name = "valor_total")
    private Float valorTotal;

    @Column(name = "desconto")
    private Float desconto;

    //Setter, Getter and Constructors
    public ProdutoVenda() {
    }

    public ProdutoVenda(int id, Produto produto, Venda venda, Integer quantidade, Float valorUnit, Float valorTotal, Float descontoUnit, Float desconto) {
        this.id = id;
        this.produto = produto;
        this.venda = venda;
        this.quantidade = quantidade;
        this.valorUnit = valorUnit;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
    }

    public ProdutoVenda(Produto produto, Venda venda, Integer quantidade, Float valorUnit, Float valorTotal, Float desconto) {
        this.produto = produto;
        this.venda = venda;
        this.quantidade = quantidade;
        this.valorUnit = valorUnit;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Float getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(Float valorUnit) {
        this.valorUnit = valorUnit;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

}
