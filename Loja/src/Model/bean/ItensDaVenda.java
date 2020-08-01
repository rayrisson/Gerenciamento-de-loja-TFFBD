/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

/**
 *
 * @author Rayrisson
 */
public class ItensDaVenda {
    private Produto produto;
    private Venda venda;
    private int qtd;

    public ItensDaVenda() {
    }

    public ItensDaVenda(Produto produto, Venda venda, int qtd) {
        this.produto = produto;
        this.venda = venda;
        this.qtd = qtd;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
}
