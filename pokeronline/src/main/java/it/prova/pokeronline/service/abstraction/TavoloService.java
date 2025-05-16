package it.prova.pokeronline.service.abstraction;

import it.prova.pokeronline.model.Tavolo;
import java.util.List;

public interface TavoloService {

    public void creaTavolo(Tavolo tavolo);

    public void aggiornaTavolo(Tavolo tavolo);

    public void disabilitaTavolo(Long idTavolo);

    public Tavolo cercaPerId(Long idTavolo);

    public List<Tavolo> listAll();

}
