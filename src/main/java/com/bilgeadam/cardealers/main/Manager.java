/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilgeadam.cardealers.main;

import com.bilgeadam.cardealers.entity.Car;
import com.bilgeadam.cardealers.entity.Dealership;
import com.bilgeadam.cardealers.repository.CarRepository;
import com.bilgeadam.cardealers.repository.DealershipRepository;
import com.bilgeadam.cardealers.utility.Constant;
import com.bilgeadam.cardealers.utility.FileUtils;
import java.util.Scanner;

/**
 *   
 * @author musty
 */
public class Manager {
     Scanner scanner=new Scanner(System.in);
    CarRepository carRepository;
    DealershipRepository dealershipRepository;

    public Manager() {
    this.carRepository=new CarRepository();
    this.dealershipRepository=new DealershipRepository();
    
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
                System.out.println("7-Bayi ekle");
              System.out.println("8-Bayi güncelle");
               System.out.println("9-Bayi Sil");
            System.out.println("10-Bayileri getir");
            input=Integer.parseInt(scanner.nextLine());
            
            switch(input){
                case 1:
                    if(carRepository.databaseControl()){
                        
                       System.out.println("daha önce veri aktarımı yapılmıştır");
                    }else{
                         carRepository.saveAll(FileUtils.getCarList(FileUtils.readFile(Constant.carFile)));
                        System.out.println("Database e veriler başarıyla aktarıldı");
                        
                    }
  
                    break;
                        case 2:
                    
                    if(dealershipRepository.databaseControl()){
                        System.out.println("daha önce veri aktarımı yapılmıştır");
                       
                    }else{
                        
                         dealershipRepository.saveAll(FileUtils.getDealership(FileUtils.readFile(Constant.dealershipFile)));
                        System.out.println("Database e veriler başarıyla aktarıldı");
                    }
   
                    break;
                        case 3:
                   
                    carRepository.save(getCarInformation());
         
                    break;
                     case 4:
                         System.out.println("Lütfen silmek istediğiniz id değerini giriniz");
                            long updateId=Long.parseLong(scanner.nextLine());
                    carRepository.update(getCarInformation(), updateId);
           
                    break;
                        case 5:
                    System.out.println("Lütfen silmek istediğiniz id değerini giriniz");
                          long id=Long.parseLong(scanner.nextLine());
                    carRepository.delete(id);
   
                    break;
                        case 6:
                    
                    carRepository.findAll().forEach(System.out::println);
    
                    break;
                    
                case 0:
                    System.exit(0);
                    break;
                    
                
                
                
                
            }
            
            
            
            
            
        } while (true);
        
        
        
    }
    
    
    public Car  getCarInformation(){
        System.out.println("Lütfen Araba Markasını ismini Giriniz");
       String brand= scanner.nextLine();
        System.out.println("Lütfen Araba modelini Giriniz");
       String carModel= scanner.nextLine();     
        System.out.println("Lütfen Model Yılını  Giriniz");
       String modelYear= scanner.nextLine();     
         System.out.println("Lütfen Bayi İdsini Giriniz");
       Long  dealershipId= Long.parseLong(scanner.nextLine());   
            
            return new Car(brand, carModel, modelYear, dealershipId);
            }
      public Dealership  getDealershipInformation(){
        System.out.println("Lütfen Bayi ismini Giriniz");
       String name= scanner.nextLine();
        System.out.println("Lütfen Ülek ismini Giriniz");
       String country= scanner.nextLine();     
        System.out.println("Lütfen Şehir ismini  Giriniz");
       String city= scanner.nextLine();     
           
            
            return new Dealership(name, country, city);
            }
    
    public static void main(String[] args) {
        Manager manager=new Manager();
        manager.menu();
    }
    
}
