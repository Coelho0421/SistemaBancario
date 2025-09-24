/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

import java.time.LocalDateTime;

/**
 *
 * @author felip
 */
public class Transacao {
    
    private Integer id;
    private String tipo;
    private Double valor;
    private LocalDateTime dataTransacao;
    private String descricao;

    public Transacao(Integer id, String tipo, Double valor, LocalDateTime dataTransacao, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDateTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
