package com.example.ProPapeleria.Service;

import com.example.ProPapeleria.Model.Producto;
import com.example.ProPapeleria.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> obtenerProductoPorId(int id) {
        return productoRepository.findById(id);
    }

    public void eliminarProducto(int id) {
        productoRepository.deleteById(id);
    }

    public List<Object[]> obtenerProductosPorProveedor(int proveedorId) {
        return productoRepository.buscarProductosPorProveedor(proveedorId);
    }
}
