/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilgeadam.cardealers.repository;

import com.bilgeadam.cardealers.entity.Car;
import com.bilgeadam.cardealers.entity.Dealership;
import com.bilgeadam.cardealers.utility.DbConnection;
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
 * @author musty
 */
public class DealershipRepository implements ICrud<Dealership>{

    
    Connection connection;

    public DealershipRepository() {
    connection=DbConnection.getInstance().getConnection();
    
    }
    
    
    
    @Override
    public void save(Dealership t) {
        String sql="insert into dealership (name,country,city) values( ?,?,?)";
    
        try {    
            PreparedStatement ps= connection.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getCountry());
            ps.setString(3, t.getCity());
            ps.executeUpdate();
        
        
        } catch (SQLException ex) {
            Logger.getLogger(DealershipRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Dealership t, long id) {
       String sql="update dealership set name=?,country=?, city=?, where id=?";
    
        try {    
            PreparedStatement ps= connection.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getCountry());
            ps.setString(3, t.getCity());
            ps.setLong(4, id);
            ps.executeUpdate();
        
        
        } catch (SQLException ex) {
            Logger.getLogger(DealershipRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(long id) {
         String sql= "delete from dealership where id=?";
            try {
                PreparedStatement ps=connection.prepareStatement(sql);
                ps.setLong(1, id);
                ps.executeUpdate();
                
                
            } catch (SQLException ex) {
                Logger.getLogger(DealershipRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public List<Dealership> findAll() {
        List<Dealership> dealerships=new ArrayList<>();
		String sql="Select * from dealership";
		PreparedStatement ps;
                
            try {
                ps = connection.prepareStatement(sql);
            
             ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    Long id=rs.getLong(1);
                    String name=rs.getString("name");
                    String country=rs.getString("country");
                    String city=rs.getString("city");
                    
                    Dealership dealership=new Dealership(id,name ,country,city);
                    dealerships.add(dealership);
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(DealershipRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
                  
                
                return  dealerships;
    }

    @Override
    public void saveAll(List<Dealership> t) {
       String sql="insert into dealership (name,country,city,id) values(?,?,?,?)";
        t.forEach(s ->{
       
        try {    
            PreparedStatement ps= connection.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getCountry());
            ps.setString(3, s.getCity());
            ps.setLong(4, s.getId());
           
            ps.executeUpdate();
        
        
        } catch (SQLException ex) {
            Logger.getLogger(DealershipRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        } );
    }
    
    public boolean  databaseControl(){
            boolean control=false;
           String sql="select id from dealership";
           PreparedStatement ps;
           ResultSet rs = null;
           try {
               ps = DbConnection.getInstance().getConnection().prepareStatement(sql);
               rs = ps.executeQuery();
               control=rs.next();
           } catch (SQLException ex) {
               Logger.getLogger(DealershipRepository.class.getName()).log(Level.SEVERE, null, ex);
           }
        
      
    return  control;
        
        
    }
    
}
