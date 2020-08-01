/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Connection.ConnectionFactory;
import Model.bean.ItensDaVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rayrisson
 */
public class ItensDaVendaDAO {
    public void create(ItensDaVenda iv){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbItensDaVenda VALUES (?, (SELECT max(idVenda) FROM tbVenda), ?)");
            stmt.setInt(1, iv.getProduto().getId());
            stmt.setInt(2, iv.getQtd());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }    
    }
}
