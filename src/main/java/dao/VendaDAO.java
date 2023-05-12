/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Matheus
 */

@Entity
@Table(name = "venda")

public class VendaDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Long idVenda;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private ClienteDAO cliente;
    
    @Column(name = "data_venda")
    private LocalDateTime dataVenda;
    
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    
    @Column(name = "forma_pagamento")
    private String formaPagamento;
    
    @Column(name = "entrega")
    private boolean entrega;
    
    @Column(name = "valor_frete")
    private BigDecimal valorFrete;
    
    @Column(name = "cancelada")
    private boolean cancelada;
    
    @Column(name = "funcionario")
    private String funcionario;
    
    @OneToMany(mappedBy = "venda", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProdutoVendaDAO> produtos = new ArrayList<>();

    
    //Setter, Getter and Constructors

    public VendaDAO() {
    }

    public VendaDAO(Long idVenda, ClienteDAO cliente, LocalDateTime dataVenda, BigDecimal valorTotal, String formaPagamento, boolean entrega, BigDecimal valorFrete, boolean cancelada, String funcionario) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.entrega = entrega;
        this.valorFrete = valorFrete;
        this.cancelada = cancelada;
        this.funcionario = funcionario;
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public ClienteDAO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDAO cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public boolean isEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public List<ProdutoVendaDAO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoVendaDAO> produtos) {
        this.produtos = produtos;
    }
    
    
    
}
