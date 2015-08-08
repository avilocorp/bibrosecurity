/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.SaleOrderLineFacade;
import controller.SaleOrderFacade;
import controller.SaleOrder;
import controller.SaleOrderLine;
import controller.Product;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author dansan
 */
@Named(value = "carritoController")
@SessionScoped
public class CarritoController implements Serializable {

    @EJB
    private SaleOrderLineFacade saleOrderLineFacade;
    @EJB
    private SaleOrderFacade saleOrderFacade;
    /**
     * Atributos utiles para el controlador Carrito
     */
    @Inject
    private ProductController productController;
    @Inject
    //private UsuarioController usuarioController;
    private ArrayList<Product> carrito = new ArrayList<Product>();
    private Product productoSelecionado;
    private int idProductoSeleccionado;
    private double totalCompra = 0.0;

    public CarritoController() {
    }

    //metodos
    public String agregarAlCarrito(int idProducto) {
        setIdProductoSeleccionado(idProducto);
        Product p = buscarProductoCarrito(idProductoSeleccionado);
        if (p != null && p.getQtyAvailable()> 0) {
            int n = carrito.indexOf(p);
            carrito.get(n).setCantidad(carrito.get(n).getCantidad() + 1);
            totalCompra+=p.getPurchasePrice();
        } else {
                productoSelecionado = productController.
                        productController.doBuscarProductoParaElCarrito(idProductoSeleccionado);
                productoSelecionado.setCantidad(1);
                if(productoSelecionado.getStock()>0){
                    carrito.add(productoSelecionado);
                    totalCompra+=productoSelecionado.getPrecio().doubleValue();
                }
                    
        }        
        return "carritoactual";
    }

    private Product buscarProductoCarrito(int idProducto) {
        Product p = null;
        for (Product prod : carrito) {
            if (prod.getIdproducto() == idProducto) {
                p = prod;
                break;
            }
        }
        return p;
    }

    public String borrarDelCarrito(int idProducto) {
        boolean encontrado = false;
        int i = 0;
        while (!encontrado) {
            if (carrito.get(i).getIdproducto() == idProducto) {
                totalCompra-=carrito.get(i).getPrecio().doubleValue();
                carrito.remove(i);                
                encontrado = true;
            }
            i++;
        }
        return "carritoactual";
    }

    public String confirmarPedido() {
        Date date = new Date();
        ArrayList<SaleOrderLine> pedidos = new ArrayList<SaleOrderLine>();
//        if (usuarioController.getIdcliente() > 0) {
//            Pedido pedido = new Pedido(date, usuarioController.getIdcliente(), 'a');
            SaleOrder pedido = new SaleOrder(date, 'a');
            for (Product p : carrito) {
                Number n = p.getCantidad();
                BigDecimal cant = new BigDecimal(n.toString());
                BigDecimal monto = p.getPrecio().multiply(cant);
                BigDecimal descuento = new BigDecimal(0.0);
                if (p.getCantidad() >= 10) {
                    descuento = monto.multiply(new BigDecimal(0.1));
                }
                SaleOrderLine linea = 
                        new SaleOrderLine(
                                pedido,
                                p.getIdproducto(),
                                descuento, p.getCantidad(), monto);
                pedidos.add(linea);
            }
            pedido.setPedidos(pedidos);
            saleOrderFacade.create(pedido);            
            carrito.clear();
            totalCompra = 0.0;
            return "confirmacion";
//        } else {
//            FacesContext faces = FacesContext.getCurrentInstance();
//            faces.addMessage("mensajeError", new FacesMessage("Para poder comprar debes registrate o ingresar al sistema"));
//            return "carrito";
//        }
    }

    public String doIrCarrito() {
        productController.doListarTodosProductos();
        return "carrito";
    }

    public String doIrCarritoActual() {
        return "carritoactual";
    }

    public ArrayList<Product> getCarrito() {
        return carrito;
    }

    public void setCarrito(ArrayList<Product> carrito) {
        this.carrito = carrito;
    }

    public Product getProductoSelecionado() {
        return productoSelecionado;
    }

    public void setProductoSelecionado(Product productoSelecionado) {
        this.productoSelecionado = productoSelecionado;
    }

    public int getIdProductoSeleccionado() {
        return idProductoSeleccionado;
    }

    public void setIdProductoSeleccionado(int idProductoSeleccionado) {
        this.idProductoSeleccionado = idProductoSeleccionado;
    }

    public SaleOrderLineFacade getLineapedidoFacade() {
        return saleOrderLineFacade;
    }

    public void setLineapedidoFacade(SaleOrderLineFacade saleOrderLineFacade) {
        this.saleOrderLineFacade = saleOrderLineFacade;
    }

    public SaleOrderFacade getPedidoFacade() {
        return saleOrderFacade;
    }

    public void setPedidoFacade(SaleOrderFacade pedidoFacade) {
        this.saleOrderFacade = saleOrderFacade;
    }

    public ProductController getProductoController() {
        return productController;
    }

    public void setProductoController(ProductController productController) {
        this.productController = productController;
    }

//    public UsuarioController getUsuarioController() {
//        return usuarioController;
//    }
//
//    public void setUsuarioController(UsuarioController usuarioController) {
//        this.usuarioController = usuarioController;
//    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

  
}