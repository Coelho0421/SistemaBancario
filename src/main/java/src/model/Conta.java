/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

import java.util.List;

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
    private Usuario usuario;

    public Conta(Integer id, String numeroConta, String tipoConta, Double saldo, Double limiteCredito, Usuario usuario) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.limiteCredito = limiteCredito;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
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
