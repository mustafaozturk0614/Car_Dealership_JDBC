/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilgeadam.cardealers.repository;

import com.bilgeadam.cardealers.entity.Car;
import com.bilgeadam.cardealers.utility.DbConnection;
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
        String sql= "update car set brand=?,car_model=?, model_year=?,dealership_id=? where id=?";
            try {
                PreparedStatement ps =DbConnection.getInstance().getConnection().prepareStatement(sql);
                ps.setString(1, t.getBrand());
                ps.setString(2, t.getCarModel());
                ps.setString(3, t.getModelYear());
                ps.setLong(4, t.getDealershipId());
              ps.setLong(5, id);
              ps.executeUpdate();
            
            } catch (SQLException ex) {
                Logger.getLogger(CarRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void delete(long id) {
        String sql= "delete from car where id=?";
            try {
                PreparedStatement ps=DbConnection.getInstance().getConnection().prepareStatement(sql);
                ps.setLong(1, id);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(CarRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public List<Car> findAll() {
         List<Car> cars=new ArrayList<>();
		String sql="Select * from car order by id";
		PreparedStatement ps;
                
            try {
                ps = DbConnection.getInstance().getConnection().prepareStatement(sql);
            
             ResultSet rs=ps.executeQuery();
   
                while(rs.next()){
                    Long id=rs.getLong(1);
                    String brand=rs.getString("brand");
                    String carModel=rs.getString("car_model");
                    String modelYear=rs.getString("model_year");
                     Long dealershipId=rs.getLong(5);
                    Car car=new Car(id,brand, carModel, modelYear,dealershipId);
                    cars.add(car);
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(CarRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
                  
                
                return  cars;
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
       public boolean  databaseControl(){
           boolean control=false;
           String sql="select id from car";
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
