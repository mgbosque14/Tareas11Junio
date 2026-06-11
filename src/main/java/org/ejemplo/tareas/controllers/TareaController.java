package org.ejemplo.tareas.controllers;

import org.ejemplo.tareas.models.Tarea;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TareaController {

    @GetMapping("/tareas")
    public List<Tarea> getTareas() {
        return List.of(
                new Tarea(1L, "Empezar", false),
                new Tarea(2L, "Intermedio", true),
                new Tarea(3L, "Terminar", false)
        );
    }
}