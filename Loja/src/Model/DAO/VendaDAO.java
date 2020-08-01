/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Connection.ConnectionFactory;
import Model.bean.ItensDaVenda;
import Model.bean.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rayrisson
 */
public class VendaDAO {
    public void create(Venda venda){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbVenda(dataVenda, fkFP, fkCliente) VALUES (?, ?, ?)");
            stmt.setString(1, venda.getData());
            stmt.setInt(2, venda.getPagamento().getId());
            stmt.setInt(3, venda.getCliente().getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }    
    }
    
}
