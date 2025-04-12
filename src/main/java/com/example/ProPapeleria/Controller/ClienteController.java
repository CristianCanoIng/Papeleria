package com.example.ProPapeleria.Controller;

import com.example.ProPapeleria.Model.Cliente;
import com.example.ProPapeleria.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtener(@PathVariable int id) {
        return clienteService.obtenerClientePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        clienteService.eliminarCliente(id);
    }

    @GetMapping("/todoscondetalles")
    public ResponseEntity<List<Object[]>> obtenerClientesConDetalleVenta() {
        List<Object[]> resultado = clienteService.obtenerClientesConDetalleVenta();
        return ResponseEntity.ok(resultado);
    }
}


