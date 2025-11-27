package pe.edu.tecsup.mvvm.app.modelo;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TareaServicio {
    private final TareaRepositorio repositorio;

    public TareaServicio(TareaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Tarea> buscarTareas() {
        return repositorio.buscarTareas();
    }

    public void guardar(Tarea tarea) {
        repositorio.guardar(tarea);
    }

    public void eliminar(int id) {
        repositorio.eliminar(id);
    }
}