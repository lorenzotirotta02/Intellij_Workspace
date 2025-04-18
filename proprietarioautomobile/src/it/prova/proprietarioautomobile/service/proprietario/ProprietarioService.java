package it.prova.proprietarioautomobile.service.proprietario;

import it.prova.proprietarioautomobile.dao.proprietario.ProprietarioDAO;
import it.prova.proprietarioautomobile.model.Proprietario;

import java.util.List;

public interface ProprietarioService {

    public void setProprietarioDAO(ProprietarioDAO proprietarioDAO);

    public List<Proprietario> listAllProprietari() throws Exception;

    public void inserisciNuovo(Proprietario proprietario) throws Exception;

    public void aggiorna(Proprietario proprietario) throws Exception;

    public void rimuovi(Long idProprietario) throws Exception;

    public Proprietario caricaSingoloProprietario(Long id) throws Exception;


}
