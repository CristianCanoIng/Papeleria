package com.example.ProPapeleria.Service;

import com.example.ProPapeleria.Model.Proveedor;
import com.example.ProPapeleria.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listarProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Optional<Proveedor> obtenerProveedorPorId(int id) {
        return proveedorRepository.findById(id);
    }

    public void eliminarProveedor(int id) {
        proveedorRepository.deleteById(id);
    }
}
