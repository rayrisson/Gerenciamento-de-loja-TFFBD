/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

/**
 *
 * @author rayri
 */
public class HistoricoVendas {
    private int idVenda;
    private String nomeProduto;
    private int qtd;
    private String pagamento;
    private String Data;
    private String nomeCliente;
    private String CPF;

    public HistoricoVendas() {
    }
    
    public HistoricoVendas(int idVenda, String nomeProduto, int qtd, String pagamento, String Data, String nomeCliente, String CPF) {
        this.idVenda = idVenda;
        this.nomeProduto = nomeProduto;
        this.qtd = qtd;
        this.pagamento = pagamento;
        this.Data = Data;
        this.nomeCliente = nomeCliente;
        this.CPF = CPF;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
