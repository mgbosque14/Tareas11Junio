package org.ejemplo.tareas.controllers;

import org.ejemplo.tareas.models.Tarea;
import org.ejemplo.tareas.services.TareaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping("/tareas")
    public List<Tarea> getTareas() {
        return tareaService.getTareas();
    }
}