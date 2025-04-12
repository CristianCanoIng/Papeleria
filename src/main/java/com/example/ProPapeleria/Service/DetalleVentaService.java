package com.example.ProPapeleria.Service;

import com.example.ProPapeleria.Model.DetalleVenta;
import com.example.ProPapeleria.Repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public List<DetalleVenta> listarDetalles() {
        return detalleVentaRepository.findAll();
    }

    public DetalleVenta guardarDetalle(DetalleVenta detalle) {
        return detalleVentaRepository.save(detalle);
    }

    public Optional<DetalleVenta> obtenerDetallePorId(int id) {
        return detalleVentaRepository.findById(id);
    }

    public void eliminarDetalle(int id) {
        detalleVentaRepository.deleteById(id);
    }
}
