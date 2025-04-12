package com.example.ProPapeleria.Service;

import com.example.ProPapeleria.Model.Empleado;
import com.example.ProPapeleria.Model.Venta;
import com.example.ProPapeleria.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    public Venta guardarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Optional<Venta> obtenerVentaPorId(int id) {
        return ventaRepository.findById(id);
    }

    public void eliminarVenta(int id) {
        ventaRepository.deleteById(id);
    }

    public List<Object[]> obtenerVentasConClientePorEmpleado(int empleadoId) {
        return ventaRepository.buscarVentasConClientePorEmpleado(empleadoId);
    }

    public List<Venta> listarVentasPorEmpleadoPorFecha(int empleadoId) {
        return ventaRepository.buscarVentasPorEmpleadoOrdenFecha(empleadoId);
    }
}
