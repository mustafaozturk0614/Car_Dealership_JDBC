/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilgeadam.cardealers.utility;

import com.bilgeadam.cardealers.entity.Car;
import com.bilgeadam.cardealers.entity.Dealership;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileUtils {
    
    
    
    public static List<String> readFile(String path ){
        
        List<String> list=new ArrayList<String>();
        try {
            BufferedReader reader= new BufferedReader(new FileReader(path));
            String line="";
            
            while ((line=reader.readLine())  !=null) {
               
                list.add(line) ;
            }
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  list;
        
    }
    
    public static List<Car>  getCarList(List<String> list){
        List<Car> cars=new ArrayList<>();
        for (String string : list) {
         cars.add(convertToCar(string.split(",")));
        }
        return  cars;
    }
    
    
    public static  Car convertToCar(String [] array){
        
        
        Car car= new Car(Long.parseLong(array[0]),array[1] , array[2], array[3],Long.parseLong(array[4]) );
        
        
        return  car;
    }
    
        public static List<Dealership>  getDealership(List<String> list){
        List<Dealership> dealerships=new ArrayList<>();
        for (String string : list) {
         dealerships.add(convertToDealership(string.split(",")));
        }
        return  dealerships;
    }
    
    
    public static  Dealership convertToDealership(String [] array){
        
        
       return new Dealership(Long.parseLong(array[0]), array[1], array[2], array[3]);
        
        
        
    }
    
    public static void main(String[] args) {
        FileUtils f=new FileUtils();
     List<Car> list= f.getCarList(f.readFile(Constant.carFile));
        
        for (Car car : list) {
            System.out.println(car);
            
        }
     
    }
    
}
