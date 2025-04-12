package com.example.ProPapeleria.Repository;

import com.example.ProPapeleria.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value = "SELECT p.id_proveedor, p.nombre AS nombre_proveedor, pr.id_producto, pr.nombre AS nombre_producto, pr.descripcion, pr.precio, pr.stock " +
            "FROM proveedor p " +
            "JOIN producto pr ON p.id_proveedor = pr.id_proveedor " +
            "WHERE p.id_proveedor = :proveedorId", nativeQuery = true)
    List<Object[]> buscarProductosPorProveedor(@Param("proveedorId") int proveedorId);

}
