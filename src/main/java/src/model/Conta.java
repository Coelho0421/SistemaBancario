/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

/**
 *
 * @author felip
 */
public class Conta {
    
    private Integer id;
    private String numeroConta;
    private String tipoConta;
    private Double saldo;
    private Double limiteCredito;

    public Conta(Integer id, String numeroConta, String tipoConta, Double saldo, Double limiteCredito) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.limiteCredito = limiteCredito;
    }

    public Integer getId() {
        return id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
    
    

}
