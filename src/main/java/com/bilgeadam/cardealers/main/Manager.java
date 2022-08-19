/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilgeadam.cardealers.main;

import com.bilgeadam.cardealers.repository.CarRepository;
import com.bilgeadam.cardealers.utility.Constant;
import com.bilgeadam.cardealers.utility.FileUtils;
import java.util.Scanner;

/**
 *   
 * @author musty
 */
public class Manager {
     
    CarRepository carRepository;

    public Manager() {
    this.carRepository=new CarRepository();
    
    }
    
    
    
    public void menu (){
        Scanner scanner=new Scanner(System.in);
        int input=0;
        do {            
            System.out.println("0-Çıkış ");
            System.out.println("1-Dosyadan Databese Arabaları Aktarma");
            System.out.println("2-Dosyadan Databese Bayileri Aktarma");
             System.out.println("3-Araba ekle");
              System.out.println("4-Araba güncelle");
               System.out.println("5-Araba Sil");
            System.out.println("6-Arabaları getir");
            
            
            input=Integer.parseInt(scanner.nextLine());
            
            switch(input){
                case 1:
                    
                    carRepository.saveAll(FileUtils.getCarList(FileUtils.readFile(Constant.carFile)));
                   
                    
              
                    
                    break;
                    
                case 0:
                    System.exit(0);
                    break;
                    
                
                
                
                
            }
            
            
            
            
            
        } while (true);
        
        
        
    }
    
    
    public static void main(String[] args) {
        Manager manager=new Manager();
        manager.menu();
    }
    
}
