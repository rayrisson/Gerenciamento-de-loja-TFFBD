/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Connection.ConnectionFactory;
import Model.bean.FormaPagamento;
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
public class FormaPagamentoDAO {
    public void create(FormaPagamento fp){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbFormaPagamento(nomeFP) VALUES (?)");
            stmt.setString(1, fp.getNome());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }    
    }
    
    public List<FormaPagamento> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<FormaPagamento> pagamentos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tbFormaPagamento");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                FormaPagamento fp = new FormaPagamento();
                fp.setId(rs.getInt("idFormaPagamento"));
                fp.setNome(rs.getString("nomeFP"));
                pagamentos.add(fp);
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pagamentos;
    }
    
    public void delete(FormaPagamento fp){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbFormaPagamento WHERE idFormaPagamento = ?");
            stmt.setInt(1, fp.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }    
    }
}
