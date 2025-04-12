package com.example.ProPapeleria.Service;

import com.example.ProPapeleria.Model.Cliente;
import com.example.ProPapeleria.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> obtenerClientePorId(int id) {
        return clienteRepository.findById(id);
    }

    public void eliminarCliente(int id) {
        clienteRepository.deleteById(id);
    }

    public List<Object[]> obtenerClientesConDetalleVenta() {
        return clienteRepository.listarClientesConDetallesDeVenta();
    }
}
