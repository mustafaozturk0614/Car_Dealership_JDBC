/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilgeadam.cardealers.repository;

import com.bilgeadam.cardealers.entity.Car;
import com.bilgeadam.cardealers.utility.DbConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author musty
 */
public class CarRepository  implements ICrud<Car>{

    @Override
    public void save(Car t) {
        String sql="insert into car (brand,car_model,model_year,dealership_id) values( ?,?,?,? )";
    
        try {    
            PreparedStatement ps= DbConnection.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, t.getBrand());
            ps.setString(2, t.getCarModel());
            ps.setString(3, t.getModelYear());
            ps.setLong(4, t.getDealershipId());

            ps.executeUpdate();
        
        
        } catch (SQLException ex) {
            Logger.getLogger(CarRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }

    @Override
    public void update(Car t, long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Car> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveAll(List<Car> t) {
        String sql="insert into car (brand,car_model,model_year,dealership_id,id) values( ?,?,?,?,?)";
        t.forEach(s ->{
       
        try {    
            PreparedStatement ps= DbConnection.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, s.getBrand());
            ps.setString(2, s.getCarModel());
            ps.setString(3, s.getModelYear());
            ps.setLong(4, s.getDealershipId());
            ps.setLong(5, s.getId());
            ps.executeUpdate();
        
        
        } catch (SQLException ex) {
            Logger.getLogger(CarRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        } );
        
        
        
        
    }
    
}
