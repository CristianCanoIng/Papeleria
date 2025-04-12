package com.example.ProPapeleria.Controller;

import com.example.ProPapeleria.Model.Empleado;
import com.example.ProPapeleria.Model.Venta;
import com.example.ProPapeleria.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> listar() {
        return ventaService.listarVentas();
    }

    @PostMapping
    public Venta guardar(@RequestBody Venta venta) {
        return ventaService.guardarVenta(venta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtener(@PathVariable int id) {
        return ventaService.obtenerVentaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        ventaService.eliminarVenta(id);
    }

    @GetMapping("/empleado/{id}")
    public List<Object[]> listarVentasConClientePorEmpleado(@PathVariable("id") int empleadoId) {
        return ventaService.obtenerVentasConClientePorEmpleado(empleadoId);
    }

    @GetMapping("/fecha/empleado/{empleadoId}")
    public List<Venta> listarVentasDeEmpleado(@PathVariable int empleadoId) {
        return ventaService.listarVentasPorEmpleadoPorFecha(empleadoId);
    }
}
