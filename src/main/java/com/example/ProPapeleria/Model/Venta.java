package com.example.ProPapeleria.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_venta;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> detalles;

    public Venta() {
    }

    public Venta(int id_venta, Empleado empleado, Cliente cliente, Date fecha, List<DetalleVenta> detalles) {
        this.id_venta = id_venta;
        this.empleado = empleado;
        this.cliente = cliente;
        this.fecha = fecha;
        this.detalles = detalles;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id_venta=" + id_venta +
                ", fecha=" + fecha +
                ", cliente=" + cliente +
                ", empleado=" + empleado +
                ", detalles=" + detalles +
                '}';
    }
}
