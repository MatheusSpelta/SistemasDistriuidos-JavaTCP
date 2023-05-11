/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Matheus
 */

@Entity
@Table(name = "cliente")

public class ClienteDAO {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_cliente")
   private Long idCliente;
   
   @Column(name = "nome")
   private String nome;
   
   @Column(name = "cpf")
   private String cpf;
   
   @Column(name = "cnpj")
   private String cnpj;
   
   @Column(name = "telefone")
   private String telefone;
   
   @Column(name = "data_cadastro")
   private LocalDate dataCadastro;
   
   @Column(name = "qtdPontos")
   private Integer qtdProntos;
   
   @Column(name = "ativo")
   private Boolean ativo;
   
   
   //Relação de cliente com endereço, cada cliente so possui um endereço
   //e cada endereço esta relacionado somente a um cliente
   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "endereco_id")
   private EnderecoDAO endereco;
   
   
   //Relação de cliente com Vendas - Um cliente pode se relacionar a varias vendas
   //mas uma venda so pertence a um cliente
   @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   private List<VendaDAO> vendas = new ArrayList<>();
}
