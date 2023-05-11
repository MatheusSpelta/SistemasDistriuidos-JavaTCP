/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name = "produto_venda")

//Tabela auxiliar, que relaciona os produtos as vendas feitas
public class ProdutoVendaDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private ProdutoDAO produto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venda_id")
    private VendaDAO venda;
    
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
    
}
