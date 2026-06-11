package org.ejemplo.tareas.services;

import org.ejemplo.tareas.models.Tarea;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    public final List<Tarea> tareas = List.of(
                new Tarea(1L, "Empezar", false),
                new Tarea(2L, "Intermedio", true),
                new Tarea(3L, "Terminar", false)
    );

    public List<Tarea> getTareas() {
        return tareas;
    }
}
