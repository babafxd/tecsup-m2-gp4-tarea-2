package pe.edu.tecsup.mvvm.app.modelo;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class TareaRepositorio {
    private Map<Integer, Tarea> tareas = new HashMap<>();
    private int siguienteId = 1;

    public TareaRepositorio() {
        tareas.put(1, new Tarea(1, "Aprender Spring", false));
        tareas.put(2, new Tarea(2, "Hacer ejercicio", true));
        siguienteId = 3;
    }

    public List<Tarea> buscarTareas() {
        return new ArrayList<>(tareas.values());
    }

    public void guardar(Tarea tarea) {
        if (tarea.getId() == 0) {
            tarea.setId(siguienteId++);
        }
        tareas.put(tarea.getId(), new Tarea(tarea.getId(), tarea.getTitulo(), tarea.isCompletado()));
    }

    public void eliminar(int id) {
        tareas.remove(id);
    }
}
