/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Connection.ConnectionFactory;
import Model.bean.HistoricoVendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rayri
 */
public class HistoricoVendasDAO {
    public List<HistoricoVendas> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<HistoricoVendas> historico = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT idVenda, nomeProduto, IVqtd, nomeFP, dataVenda, nomeCliente, CPF FROM tbProduto INNER JOIN C WHERE fKProduto = idProduto");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                HistoricoVendas hist = new HistoricoVendas();
                hist.setIdVenda(rs.getInt("idVenda"));
                hist.setNomeProduto(rs.getString("nomeProduto"));
                hist.setQtd(rs.getInt("IVqtd"));
                hist.setPagamento(rs.getString("nomeFP"));
                hist.setData(rs.getString("dataVenda"));
                hist.setNomeCliente(rs.getString("nomeCliente"));
                hist.setCPF(rs.getString("CPF"));
                historico.add(hist);
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return historico;
    }
    
    public List<HistoricoVendas> search(String texto){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<HistoricoVendas> historico = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT idVenda, nomeProduto, IVqtd, nomeFP, dataVenda, nomeCliente, CPF FROM tbProduto INNER JOIN C WHERE fKProduto = idProduto AND nomeCliente LIKE ?");
            stmt.setString(1, "%"+texto+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                HistoricoVendas hist = new HistoricoVendas();
                hist.setIdVenda(rs.getInt("idVenda"));
                hist.setNomeProduto(rs.getString("nomeProduto"));
                hist.setQtd(rs.getInt("IVqtd"));
                hist.setPagamento(rs.getString("nomeFP"));
                hist.setData(rs.getString("dataVenda"));
                hist.setNomeCliente(rs.getString("nomeCliente"));
                hist.setCPF(rs.getString("CPF"));
                historico.add(hist);
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return historico;
    }
}
