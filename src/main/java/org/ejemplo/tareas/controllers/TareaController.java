package org.ejemplo.tareas.controllers;

import org.ejemplo.tareas.models.Tarea;
import org.ejemplo.tareas.services.TareaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    public List<Tarea> getTareas() {
        return tareaService.getTareas();
    }

    @PostMapping
    public ResponseEntity<Tarea> crear(@RequestBody Tarea tarea){
        Tarea t = tareaService.crearTarea(tarea);
        return ResponseEntity.status(201).body(t);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizar (@PathVariable Long id, @RequestBody Tarea tarea) {
        Optional<Tarea> tareaActualizada = tareaService.actualizarTarea(id, tarea);
        return tareaActualizada.map(value -> ResponseEntity.status(200).body(value)).orElseGet(() -> ResponseEntity.status(404).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tarea> borrar (@PathVariable Long id){
        boolean borrado = tareaService.borrarTarea(id);
        if (!borrado){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(204).build();
    }


}