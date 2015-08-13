/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import models.Item;
import java.util.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import models.Product;
import models.SaleOrder;
import models.SaleOrderLine;

@ManagedBean(name = "sp")
@SessionScoped

public class ShoppingCart implements Serializable{
    @EJB
    private DAOS.SaleOrderFacade saleOrderFacade;
    @EJB
    private DAOS.SaleOrderLineFacade sol_facade;
    private List<Item> car = new ArrayList<Item>();
    private double subTotal;
    private double total;
    private Date datetime;
    private String type;
    private int partner_id;

    public ShoppingCart() {
    }

    
    
    public String add2car(Product p){
       
        //Increment quantity Duplicate product
        for (Item item : car){
            if(item.getP().getId().equals(p.getId())){
                item.setQuantity(item.getQuantity() + 1);
                return "currentShop";
            }
        }
        
        Item i = new Item();
        i.setQuantity(1);
        i.setP(p);
        car.add(i);
        return "currentShop";
    }
    
    
    public void removeItem(Item i){
    
        for(Item item: car){
            if(item.equals(i)){
                car.remove(item);
                break;
            }
        }
    }
    
    public String paymetCar(){
        return "payment";
    }
    
    public int carCount(){
        return car.size();
    }
    
    public void clearCar(){
        car.clear();
    }
    
    public String confirmedShop(String result){
        
        if (result.equals("success")){
            Date date = new Date();
            //List<SaleOrderLine> sl_ids = new ArrayList<SaleOrderLine>();
            //if (usuarioController.getIdcliente() > 0) {
                
                SaleOrder so = new SaleOrder(date, subTotal, 0.0 , total, "invoice", 1);
                //so_facade.create(so);
                System.out.println(saleOrderFacade.count());
                for (Item  item: car) {
                    SaleOrderLine linea = new SaleOrderLine(
                            so.getId(), item.getP().getId(),
                            item.getQuantity(),
                            item.getP().getPurchasePrice(),
                            item.getSubtotal());
                    //sl_ids.add(linea);
                    //sol_facade.create(linea);
                }
            car.clear();
        }
            return "List";
//        } else {
//            FacesContext faces = FacesContext.getCurrentInstance();
//            faces.addMessage("mensajeError", new FacesMessage("Para poder comprar debes registrate o ingresar al sistema"));
//            return "carrito";
//        }
    
    
    }
    
    public List<Item> getCar() {
        return car;
    }

    public void setCar(List<Item> car) {
        this.car = car;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        subTotal = 0;
        for (Item item: car){
            subTotal+=item.getQuantity()*item.getP().getPurchasePrice();
        }
        this.subTotal = subTotal;
    }

    public double getTotal() {
        total = 0;
        for (Item item: car){
            total+=item.getQuantity()*item.getP().getPurchasePrice();
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(int partner_id) {
        this.partner_id = partner_id;
    }
       
}
