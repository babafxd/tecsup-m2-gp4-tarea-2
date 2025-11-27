package pe.edu.tecsup.mvvm.app.vista.modelo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.tecsup.mvvm.app.modelo.Tarea;
import pe.edu.tecsup.mvvm.app.modelo.TareaServicio;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tareas")
public class TareaRestControlador {

    private final TareaServicio servicio;

    public TareaRestControlador(TareaServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Tarea> listar() {
        return servicio.buscarTareas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtener(@PathVariable int id) {
        return servicio.buscarTareas()
                .stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tarea> crear(@RequestBody Tarea tarea) {
        tarea.setId(0);
        servicio.guardar(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(@PathVariable int id, @RequestBody Tarea tarea) {
        tarea.setId(id);
        servicio.guardar(tarea);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
