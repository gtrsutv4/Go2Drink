/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.g2d.model;

import com.g2d.domain.DrinkType;
import com.g2d.domain.Go2DrinkException;
import com.g2d.domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class RDBProductDAO {
    private static final String COL_LIST = "id , name , price , ice , sugar , url , type ";
    private static final String SELECT_BYDRINKTYPE_SQL = "SELECT " + COL_LIST + " FROM product WHERE type=?";
    private static final String SELECT_SQL = "SELECT " + COL_LIST + " FROM product WHERE name=?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM product";
    private static final String INSERT_SQL = "INSERT INTO product (name,price) VALUE(?,?)";
    private static final String UPDATE_SQL = "UPDATE product SET price=? WHERE name=?";
    private static final String DELETE_SQL = "DELETE FROM product WHERE name=?";
    private static final String SELECT_ID_SQL = "SELECT " + COL_LIST + " FROM product WHERE id=?";

    
    public Product get(int id)throws Go2DrinkException, SQLException{
        try(Connection connection =  RDBConnection.getConnection();
            PreparedStatement pstmt =connection.prepareStatement(SELECT_ID_SQL)){
            pstmt.setInt(1, id);
            try(ResultSet rs = pstmt.executeQuery();){  
                Product p = new Product();
                while (rs.next()){
                        p.setId(rs.getInt("id"));
                        p.setName(rs.getString("name"));
                        p.setUntiPrice(rs.getDouble("price"));
                        p.setUrl(rs.getString("url"));
                }
            return p;
            }   
        }
    }
    public Product get(String name)throws Go2DrinkException, SQLException{
        try(Connection connection =  RDBConnection.getConnection();
            PreparedStatement pstmt =connection.prepareStatement(SELECT_SQL)){
            pstmt.setString(1, name);
            try(ResultSet rs = pstmt.executeQuery();){  
                Product p = new Product();
                while (rs.next()){
                        p.setId(rs.getInt("id"));
                        p.setName(rs.getString("name"));
                        p.setUntiPrice(rs.getDouble("price"));
                        p.setUrl(rs.getString("url"));
                }
            return p;
            }   
        }
    }
    public List<Product> getByDrinkType(DrinkType Drinktype)throws Go2DrinkException, SQLException{
        try(Connection connection =  RDBConnection.getConnection();
            PreparedStatement pstmt =connection.prepareStatement(SELECT_BYDRINKTYPE_SQL)){
            pstmt.setString(1, Drinktype.toString());
            try(ResultSet rs = pstmt.executeQuery();){  
                List<Product> list = new ArrayList<>();
                while (rs.next()){
                        Product p = new Product();
                        p.setId(rs.getInt("id"));
                        p.setName(rs.getString("name"));
                        p.setUntiPrice(rs.getDouble("price"));
                        p.setUrl(rs.getString("url"));
                        list.add(p);
                }
            return list;
            }   
        }
    }
    public List<Product> getAll()throws Go2DrinkException,SQLException{
        List<Product> list = new ArrayList<>();
        try(Connection connection =  RDBConnection.getConnection();
            Statement stmt =connection.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL_SQL);){
                while(rs.next()){
                    Product p = new Product();
                    p.setName(rs.getString("name"));
                    p.setUntiPrice(rs.getDouble("price"));
                    p.setUrl(rs.getString("url"));
                    list.add(p);
            }
        }catch(SQLException ex) {
            throw new Go2DrinkException("查詢全部產品失敗", ex);
        }
          return list;
    }
    public void insert(Product p)throws Go2DrinkException{
        try(
                Connection connection = RDBConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(INSERT_SQL);
            ){
            pstmt.setString(1,p.getName());
            pstmt.setDouble(2,p.getUntiPrice());
            pstmt.executeUpdate();  
        }catch(SQLException ex) {
            throw new Go2DrinkException("新增產品失敗!", ex);
        }
    }
    public void update(Product p)throws Go2DrinkException{
        try(
                Connection connection = RDBConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(UPDATE_SQL);
            ){
            pstmt.setDouble(1,p.getUntiPrice());
            pstmt.setString(2,p.getName());
            pstmt.executeUpdate();  
        }catch(SQLException ex) {
            throw new Go2DrinkException("修改產品失敗!", ex);
        }
    }
    public void delete(Product p )throws Go2DrinkException{
        try (Connection connection = RDBConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(DELETE_SQL);) {
            pstmt.setString(1, p.getName());            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            throw new Go2DrinkException("刪除產品失敗!", ex);
        }
    }       
}
