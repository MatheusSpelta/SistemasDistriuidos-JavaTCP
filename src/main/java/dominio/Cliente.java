/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.text.ParseException;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Matheus
 */
@Entity
@Table(name = "cliente")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int idCliente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "celular")
    private String celular;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "ativo")
    private Boolean ativo;

    @OneToOne(mappedBy = "cliente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Endereco endereco;

    //Relação de cliente com Vendas - Um cliente pode se relacionar a varias vendas
    //mas uma venda so pertence a um cliente
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Venda> vendas = new ArrayList<>();

    //Constructor para CPF
    public Cliente(String nome, String cpf, String cnpj, String celular, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.celular = celular;
        this.endereco = endereco;
        this.dataCadastro = LocalDate.now();
        this.ativo = true;
        endereco.setCliente(this);

    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Cliente() {
    }

    public Object[] toArray() throws ParseException {
        return new Object[]{this, this.nome, this.cpf, this.cnpj, endereco.getCidade(), endereco.getUf(), this.ativo};
    }

    @Override
    public String toString() {
        return "" + idCliente;
    }

}
