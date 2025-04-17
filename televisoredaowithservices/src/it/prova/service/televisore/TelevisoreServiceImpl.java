package it.prova.service.televisore;

import it.prova.connection.MyConnection;
import it.prova.dao.Constants;
import it.prova.dao.televisore.TelevisoreDAO;
import it.prova.model.Televisore;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public class TelevisoreServiceImpl implements TelevisoreService{

    private TelevisoreDAO televisoreDao;


    @Override
    public void setTelevisoreDao(TelevisoreDAO televisoreDao) {
        this.televisoreDao = televisoreDao;
    }

    @Override
    public List<Televisore> listAll() throws Exception {
        List<Televisore> result;
        try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

            televisoreDao.setConnection(connection);
            result = televisoreDao.list();
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public Televisore findById(Long idInput) throws Exception {
        if (idInput == null || idInput < 1)
            throw new Exception("Valore di input non ammesso.");

        Televisore result = null;
        try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

            // inietto la connection nel dao
            televisoreDao.setConnection(connection);

            // eseguo quello che realmente devo fare
            result = televisoreDao.get(idInput);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public int aggiorna(Televisore input) throws Exception {
        if (input == null || input.getId() == null || input.getId() < 1)
            throw new Exception("Valore di input non ammesso.");

        int result = 0;
        try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

            // inietto la connection nel dao
            televisoreDao.setConnection(connection);

            // eseguo quello che realmente devo fare
            result = televisoreDao.update(input);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public int inserisciNuovo(Televisore input) throws Exception {
        if (input == null)
            throw new Exception("Valore di input non ammesso.");

        int result = 0;
        try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

            // inietto la connection nel dao
            televisoreDao.setConnection(connection);

            // eseguo quello che realmente devo fare
            result = televisoreDao.insert(input);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public int rimuovi(Long idDaRimuovere) throws Exception {
        if (idDaRimuovere == null || idDaRimuovere < 1)
            throw new Exception("Valore di input non ammesso.");

        int result = 0;
        try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

            // inietto la connection nel dao
            televisoreDao.setConnection(connection);

            // eseguo quello che realmente devo fare
            result = televisoreDao.delete(idDaRimuovere);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public Televisore cercaIlPiuGrande() throws Exception{

        Televisore result = null;
        try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

            // inietto la connection nel dao
            televisoreDao.setConnection(connection);

            // eseguo quello che realmente devo fare
            result = televisoreDao.findTelevisorePiuGrande();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public int contaITelevisoriProdottiInUnIntervallo(LocalDate dataIniziale, LocalDate dataFinale) throws Exception {
        int result;
        try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

            televisoreDao.setConnection(connection);
            result = televisoreDao.countProdottiInUnIntervallo(dataIniziale,dataFinale);
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public List<Televisore> cercaPerMarcheDistinteTelevisoriProdottiNegliUltimiMesi(LocalDate dataInput) throws Exception {
        List<Televisore> result;
        try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

            televisoreDao.setConnection(connection);
            result = televisoreDao.findTelevisoriProdottiNegliUltimiMesi(dataInput);
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }
}
