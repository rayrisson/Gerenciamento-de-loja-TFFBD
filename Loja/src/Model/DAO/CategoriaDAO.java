/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Connection.ConnectionFactory;
import Model.bean.Categoria;
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
public class CategoriaDAO {
    public void create(Categoria categoria){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbcategoria(nomecategoria) VALUES (?)");
            stmt.setString(1, categoria.getNome());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }    
    }
    
    public List<Categoria> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Categoria> categorias = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tbcategoria");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("idcategoria"));
                cat.setNome(rs.getString("nomecategoria"));
                categorias.add(cat);
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return categorias;
    }
    
    public void update(Categoria categoria){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbCategoria SET nomeCategoria = ? WHERE idCategoria = ?");
            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }    
    }
    
    public void delete(Categoria categoria){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbCategoria WHERE idCategoria = ?");
            stmt.setInt(1, categoria.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }    
    }
    
    public List<Categoria> search(String nome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Categoria> categorias = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tbcategoria WHERE nomeCategoria LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("idcategoria"));
                cat.setNome(rs.getString("nomecategoria"));
                categorias.add(cat);
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return categorias;
    }
}
