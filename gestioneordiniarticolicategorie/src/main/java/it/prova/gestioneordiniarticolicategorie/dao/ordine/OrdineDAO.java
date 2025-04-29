package it.prova.gestioneordiniarticolicategorie.dao.ordine;

import it.prova.gestioneordiniarticolicategorie.dao.IBaseDAO;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

import java.time.LocalDateTime;
import java.util.List;

public interface OrdineDAO extends IBaseDAO<Ordine> {
    Ordine findByIdEager(Long id) throws Exception;
    Ordine findPiuRecenteByCategoria(Long idCategoria) throws Exception;
    boolean findByNomeDestinatario(String nomeDestinatario) throws Exception;
    List<Ordine> findDistinctByStringInNumeroSeriale(String stringa) throws Exception;
}
