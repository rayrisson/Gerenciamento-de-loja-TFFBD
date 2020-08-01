/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Connection.ConnectionFactory;
import Model.bean.Categoria;
import Model.bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rayrisson
 */
public class ProdutoDAO {
    public void create(Produto produto){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbProduto(nomeProduto, precoProduto, qtdProduto, codigoBarrasProduto ,fkCategoria) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQtd());
            stmt.setString(4, produto.getCodBarras());
            stmt.setInt(5, produto.getCategoria().getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }    
    }
    
    public List<Produto> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT idProduto, codigoBarrasProduto, nomeProduto, precoProduto, qtdProduto, nomeCategoria FROM tbProduto INNER JOIN tbCategoria WHERE idcategoria = fkcategoria");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("idproduto"));
                produto.setCodBarras(rs.getString("codigoBarrasProduto"));
                produto.setNome(rs.getString("nomeproduto"));
                produto.setPreco(rs.getDouble("precoproduto"));
                produto.setQtd(rs.getInt("qtdproduto"));
                produto.setNome(rs.getString("nomeproduto"));
                Categoria cat = new Categoria();
                cat.setNome(rs.getString("nomecategoria"));
                produto.setCategoria(cat);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;
    }
    
    public void update(Produto produto){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbProduto SET nomeProduto = ?, precoProduto = ?, qtdProduto = ?, codigoBarrasProduto = ?, fkCategoria = ? WHERE idProduto = ?");
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQtd());
            stmt.setString(4, produto.getCodBarras());
            stmt.setInt(5, produto.getCategoria().getId());
            stmt.setInt(6, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }    
    }
    
    public void delete(Produto produto){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbProduto WHERE idProduto = ?");
            stmt.setInt(1, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }    
    }
    
    public List<Produto> search(String nome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT idProduto, codigoBarrasProduto, nomeProduto, precoProduto, qtdProduto, nomeCategoria FROM tbProduto INNER JOIN tbCategoria WHERE idcategoria = fkcategoria AND nomeProduto LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("idproduto"));
                produto.setCodBarras(rs.getString("codigoBarrasProduto"));
                produto.setNome(rs.getString("nomeproduto"));
                produto.setPreco(rs.getDouble("precoproduto"));
                produto.setQtd(rs.getInt("qtdproduto"));
                produto.setNome(rs.getString("nomeproduto"));
                Categoria cat = new Categoria();
                cat.setNome(rs.getString("nomecategoria"));
                produto.setCategoria(cat);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;
    }
}
