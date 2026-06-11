package org.ejemplo.tareas.services;

import org.ejemplo.tareas.models.Tarea;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final List<Tarea> tareas = new ArrayList<>();
    private Long idSiguiente = 4L;

    public TareaService() {
        tareas.add(new Tarea(1L, "Empezar", false));
        tareas.add(new Tarea(2L, "Intermedio", true));
        tareas.add(new Tarea(3L, "Terminar", false));
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public Tarea crearTarea(Tarea tarea) {
        tarea.setId(idSiguiente++);
        tareas.add(tarea);
        return tarea;
    }

    public Optional<Tarea> actualizarTarea(Long id, Tarea otraTarea) {
        for (Tarea t : tareas) {
            if (t.getId().equals(id)) {
                t.setTitulo(otraTarea.getTitulo());
                t.setCompletada(otraTarea.isCompletada());
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    public boolean borrarTarea(Long id) {

        for (int i = 0; i < tareas.size(); i++) {
            Tarea t = tareas.get(i);
            if (t.getId().equals(id)) {
                tareas.remove(i);
                return true;
            }
        }
        return false;
    }

}