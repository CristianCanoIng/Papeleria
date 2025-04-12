package com.example.ProPapeleria.Service;

import com.example.ProPapeleria.Model.Empleado;
import com.example.ProPapeleria.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Optional<Empleado> obtenerEmpleadoPorId(int id) {
        return empleadoRepository.findById(id);
    }

    public void eliminarEmpleado(int id) {
        empleadoRepository.deleteById(id);
    }

}
