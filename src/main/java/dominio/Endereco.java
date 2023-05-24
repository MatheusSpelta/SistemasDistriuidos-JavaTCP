package dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Matheus
 */
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

    @Id
    private int idEndereco;

    @Column(length = 9)
    private String cep;
    private String bairro;
    private String rua;
    private int numero;
    private String cidade;

    @Column(length = 2)
    private String uf;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idEndereco")
    private Cliente cliente;

    public Endereco() {
    }

    public Endereco(String cep, String uf, String bairro, String cidade, String logradouro, String complemento) {
        this.cep = cep;
        this.uf = uf;
        this.bairro = bairro;
        this.cidade = cidade;
        this.rua = logradouro;
    }

    // Para ser UTILIZADO pela classe CLIENTE
    public Endereco(String cep, String bairro, String rua, int num, String uf, String cidade) {
        this.cep = cep;
        this.uf = uf;
        this.bairro = bairro;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = num;
    }

    //Para utilizar na tabela de vendas
    public Endereco(String bairro, String rua, int numero, String cidade, Cliente cliente) {
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
