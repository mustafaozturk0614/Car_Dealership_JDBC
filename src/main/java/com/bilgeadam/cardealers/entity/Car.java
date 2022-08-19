/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilgeadam.cardealers.entity;

/**
 *
 * @author musty
 */
public class Car {
    
  private  long id;
  private  String brand;
 private   String carModel;
 private   String modelYear;
 private   long dealershipId;

    public Car(long id, String brand, String carModel, String modelYear, long dealershipId) {
        this.id = id;
        this.brand = brand;
        this.carModel = carModel;
        this.modelYear = modelYear;
        this.dealershipId = dealershipId;
    }

    public Car(String brand, String carModel, String modelYear, long dealershipId) {
        this.brand = brand;
        this.carModel = carModel;
        this.modelYear = modelYear;
        this.dealershipId = dealershipId;
    }

    public Car(String brand, String carModel, String modelYear) {
        this.brand = brand;
        this.carModel = carModel;
        this.modelYear = modelYear;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public long getDealershipId() {
        return dealershipId;
    }

    public void setDealershipId(long dealershipId) {
        this.dealershipId = dealershipId;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", brand=" + brand + ", carModel=" + carModel + ", modelYear=" + modelYear + ", dealershipId=" + dealershipId + '}';
    }
    
    
}
