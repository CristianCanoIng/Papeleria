package com.example.ProPapeleria.Repository;

import com.example.ProPapeleria.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT c.id_cliente, c.nombre, c.cedula, c.telefono, c.correo, " +
            "v.id_venta, v.fecha, dv.id_detalle, dv.cantidad, dv.precio_unitario " +
            "FROM cliente c " +
            "JOIN venta v ON c.id_cliente = v.id_cliente " +
            "JOIN detalle_venta dv ON v.id_venta = dv.id_venta " +
            "ORDER BY c.id_cliente", nativeQuery = true)
    List<Object[]> listarClientesConDetallesDeVenta();

}
