package com.example.ProPapeleria.Repository;

import com.example.ProPapeleria.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
    @Query(value = "SELECT " +
            "e.id_empleado, e.nombre AS nombre_empleado, e.cargo, e.telefono AS telefono_empleado, " +
            "v.id_venta, v.fecha, " +
            "c.id_cliente, c.nombre AS nombre_cliente, c.cedula, c.telefono AS telefono_cliente, c.correo " +
            "FROM empleado e " +
            "JOIN venta v ON e.id_empleado = v.id_empleado " +
            "JOIN cliente c ON v.id_cliente = c.id_cliente " +
            "WHERE e.id_empleado = :empleadoId " +
            "ORDER BY v.fecha",
            nativeQuery = true)
    List<Object[]> buscarVentasConClientePorEmpleado(@Param("empleadoId") int empleadoId);

    @Query("SELECT v FROM Venta v WHERE v.empleado.id_empleado = :empleadoId ORDER BY v.fecha DESC")
    List<Venta> buscarVentasPorEmpleadoOrdenFecha(int empleadoId);
}
