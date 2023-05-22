/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Matheus
 */

@Entity 
public class FormaPagamento {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idFP;
    
    @Column (name="formaPagamento", length = 250, nullable = false)
    private String forma_Pagamento;

    public int getIdFP() {
        return idFP;
    }

    public void setIdFP(int idFP) {
        this.idFP = idFP;
    }

    public String getForma_Pagamento() {
        return forma_Pagamento;
    }

    public void setForma_Pagamento(String forma_Pagamento) {
        this.forma_Pagamento = forma_Pagamento;
    }

    public FormaPagamento(int idFP, String forma_Pagamento) {
        this.idFP = idFP;
        this.forma_Pagamento = forma_Pagamento;
    }

    public FormaPagamento() {
    }    
}
