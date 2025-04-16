package it.prova.dao.user;

import it.prova.dao.IBaseDAO;
import it.prova.model.User;

import java.time.LocalDate;
import java.util.List;

public interface UserDAO extends IBaseDAO<User> {
    public List<User> findByQuelliCheUsernameIniziaCon(String iniziale) throws Exception;

    public List<User> findByQuelliCreatiPrimaDi(LocalDate dataConfronto) throws Exception;

    public List<User> findByCognomeENomeCheInziaCon(String cognomeInput, String inzialeNomeInput) throws Exception;

    public User login(String loginInput, String passwordInput) throws Exception;

	
}
