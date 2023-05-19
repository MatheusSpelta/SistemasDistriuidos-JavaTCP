/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Matheus
 */

@Entity
public class UnidadeMedida implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUnidadeMedida;
    
    @Column(name = "unidade_medida")
    private String unidadeMedida;
    
    @OneToMany(mappedBy = "unidadeMedida")
    private List<Produto> produtos;
    
    public List<Produto> getProduto(){
        return produtos;
    }
    
    public void setProdutos(List<Produto> produtos){
        this.produtos = produtos;
    }
}
