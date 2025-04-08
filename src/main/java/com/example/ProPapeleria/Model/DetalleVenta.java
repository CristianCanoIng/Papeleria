package com.example.ProPapeleria.Model;

import jakarta.persistence.*;

@Entity
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_detalle;

    private int cantidad;
    private double precio_unitario;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    public DetalleVenta() {
    }

    public DetalleVenta(int id_detalle, int cantidad, Producto producto, Venta venta, double precio_unitario) {
        this.id_detalle = id_detalle;
        this.cantidad = cantidad;
        this.producto = producto;
        this.venta = venta;
        this.precio_unitario = precio_unitario;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "id_detalle=" + id_detalle +
                ", cantidad=" + cantidad +
                ", precio_unitario=" + precio_unitario +
                ", producto=" + producto +
                ", venta=" + venta +
                '}';
    }
}
