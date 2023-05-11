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

}
