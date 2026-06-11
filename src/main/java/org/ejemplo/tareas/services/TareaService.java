package org.ejemplo.tareas.services;

import org.ejemplo.tareas.models.Tarea;

import org.ejemplo.tareas.repo.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final TareaRepository taRe;

    public TareaService(TareaRepository taRe) {
        this.taRe = taRe;
    }

    public List<Tarea> getTareas() {
        return taRe.findAll();
    }

    public Tarea crearTarea(Tarea tarea) {
        return taRe.save(tarea);
    }

    public Optional<Tarea> actualizarTarea(Long id, Tarea otraTarea) {
        Optional<Tarea> t = taRe.findById(id);
        if (t.isEmpty()) {
            return Optional.empty();
        }
        Tarea existente = t.get();
        existente.setTitulo(otraTarea.getTitulo());
        existente.setCompletada(otraTarea.isCompletada());
        Tarea guardada = taRe.save(existente);
        return Optional.of(guardada);
    }

    public boolean borrarTarea(Long id) {
        if (!taRe.existsById(id)) {
            return false;
        }
        taRe.deleteById(id);
        return true;
    }

}