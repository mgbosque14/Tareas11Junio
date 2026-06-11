package org.ejemplo.tareas.repo;

import org.ejemplo.tareas.models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
