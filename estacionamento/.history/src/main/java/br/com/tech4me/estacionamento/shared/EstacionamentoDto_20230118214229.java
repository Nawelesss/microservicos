package br.com.tech4me.estacionamento.shared;

import br.com.tech4me.estacionamento.model.Carro;

public class EstacionamentoDto {
    private String nomeCarro;
    private String marca;
    private String idCarro;
    private Carro dadosCarro;
    private String cor;
    
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public String getIdPizza() {
        return idPizza;
    }
    public void setIdPizza(String idPizza) {
        this.idPizza = idPizza;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Carro getDadosPizza() {
        return dadosPizza;
    }
    public void setDadosPizza(Carro dadosPizza) {
        this.dadosPizza = dadosPizza;
    }
    
}
