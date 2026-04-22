package com.example.lab02.controller;

import com.example.lab02.dto.MascotaForm;
import com.example.lab02.entity.Mascota;
import com.example.lab02.repository.MascotaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

    final MascotaRepository mascotaRepository;

    public MascotaController(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @GetMapping("/list")
    public String listaMascotas(Model model) {
        model.addAttribute("mascotas", mascotaRepository.findAll());
        return "listaMascotas";
    }

    public String validate(MascotaForm form) {
        if(form.getNombre() == null || form.getNombre().isBlank()) return "El nombre es obligatorio";
        if(form.getEspecie() == null || form.getEspecie().isBlank()) return "Indicar especie de la mascota";
        if(form.getRaza() == null || form.getRaza().isBlank()) return "Indicar raza de la mascota";
        if(form.getEdad() <= 0 || form.getEdad() >= 25) return "Indicar la edad de la mascota";
        if(form.getNombreDueno() == null || form.getNombreDueno().isBlank()) return "El nombre de dueño es obligatorio";
        if(form.getTelefono() == null || form.getTelefono().isBlank()) return "Indicar teléfono de contacto";
        if (!form.getTelefono().matches("\\d+")) return "El teléfono solo debe contener números";
        return null;
    }

    @GetMapping("/edit")
    public String editMascota(@RequestParam Integer id, Model model) {
        Mascota mascota = mascotaRepository.findById(id).orElse(null);
        if(mascota == null) return "redirect:/mascota/list";

        MascotaForm form = new MascotaForm();
        form.setIdMascota(mascota.getIdMascota());
        form.setNombre(mascota.getNombre());
        form.setEspecie(mascota.getEspecie());
        form.setRaza(mascota.getRaza());
        form.setEdad(mascota.getEdad());
        form.setNombreDueno(mascota.getNombreDueno());
        form.setTelefono(mascota.getTelefono());
        form.setEstado(mascota.getEstado());

        model.addAttribute("mascotaForm", form);
        model.addAttribute("mode","edit");
        return "formMascota";
    }

    @PostMapping("/update")
    public String updateMascota(@ModelAttribute MascotaForm form, Model model) {
        String error = validate(form);
        if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("mode","create");
            return "formMascota";
        }

        Mascota mascota = mascotaRepository.findById(form.getIdMascota()).orElse(null);
        if (mascota == null) return "mascota/list";
        mascota.setNombre(form.getNombre());
        mascota.setEspecie(form.getEspecie());
        mascota.setRaza(form.getRaza());
        mascota.setEdad(form.getEdad());
        mascota.setNombreDueno(form.getNombreDueno());
        mascota.setTelefono(form.getTelefono());
        mascota.setEstado((form.getEstado()));

        mascotaRepository.save(mascota);
        return "redirect:/mascota/list";
    }

    @GetMapping("/delete")
    public String deleteMascota(@RequestParam Integer id) {
        if(mascotaRepository.existsById(id)){
            mascotaRepository.deleteById(id);
        }
        return "redirect:/mascota/list";
    }

    @GetMapping("/buscar")
    public String buscarMascotas(
            @RequestParam(required = false) String criterio,   // Criterio de búsqueda (nombre, especie, estado)
            @RequestParam(required = false) String valorBusqueda, // Valor de búsqueda (nombre, especie, estado)
            Model model) {

        List<Mascota> mascotas;

        if (valorBusqueda == null || valorBusqueda.isEmpty()) {
            mascotas = mascotaRepository.findAll();
        } else {
            if ("nombre".equals(criterio)) {
                mascotas = mascotaRepository.findByNombreContainingIgnoreCase(valorBusqueda);
            }
            else if ("especie".equals(criterio)) {
                mascotas = mascotaRepository.findByEspecieContainingIgnoreCase(valorBusqueda);
            }
            else if ("estado".equals(criterio)) {
                int estado = Integer.parseInt(valorBusqueda);
                mascotas = mascotaRepository.findByEstado(estado);
            } else {
                mascotas = mascotaRepository.findAll();
            }
        }

        model.addAttribute("mascotas", mascotas);
        return "listaMascotas";
    }

}
