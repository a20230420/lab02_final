package com.example.lab02.repository;

import com.example.lab02.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Integer> {
    List<Mascota> findByNombreContainingIgnoreCase(String nombre);
    List<Mascota> findByEspecieContainingIgnoreCase(String especie);
    List<Mascota> findByEstado(int estado);

    @Query("SELECT MAX(m.edad) FROM Mascota m")
    Integer findMaxEdad();

    @Query("SELECT MIN(m.edad) FROM Mascota m")
    Integer findMinEdad();

    @Query("SELECT AVG(m.edad) FROM Mascota m")
    Double findAvgEdad();

    @Query("SELECT COUNT(m) FROM Mascota m")
    Long findTotalMascotas();
}
