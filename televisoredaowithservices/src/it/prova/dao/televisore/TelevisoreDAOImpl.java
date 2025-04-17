package it.prova.dao.televisore;

import it.prova.dao.AbstractMySQLDAO;
import it.prova.model.Televisore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TelevisoreDAOImpl extends AbstractMySQLDAO implements TelevisoreDAO {

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List list() throws Exception {
        if (isNotActive())
            throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

        ArrayList<Televisore> result = new ArrayList<Televisore>();

        try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery("select * from televisore")) {

            while (rs.next()) {
                Televisore televisoreTemp = new Televisore();
                televisoreTemp.setModello(rs.getString("modello"));
                televisoreTemp.setMarca(rs.getString("marca"));
                televisoreTemp.setPollici(rs.getInt("pollici"));
                televisoreTemp.setDataproduzione(
                        rs.getDate("dataproduzione") != null ? rs.getDate("dataproduzione").toLocalDate() : null);
                televisoreTemp.setId(rs.getLong("ID"));
                result.add(televisoreTemp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public Televisore get(Long idInput) throws Exception {
        if (isNotActive())
            throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

        if (idInput == null || idInput < 1)
            throw new Exception("Valore di input non ammesso.");

        Televisore result = null;
        try (PreparedStatement ps = connection.prepareStatement("select * from televisore where id=?")) {

            ps.setLong(1, idInput);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    result = new Televisore();
                    result.setMarca(rs.getString("marca"));
                    result.setModello(rs.getString("modello"));
                    result.setPollici(rs.getInt("pollici"));
                    result.setDataproduzione(
                            rs.getDate("dataproduzione") != null ? rs.getDate("dataproduzione").toLocalDate() : null);
                    result.setId(rs.getLong("ID"));
                } else {
                    result = null;
                }
            } // niente catch qui

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public int update(Televisore input) throws Exception {
        if (isNotActive())
            throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

        if (input == null || input.getId() == null || input.getId() < 1)
            throw new Exception("Valore di input non ammesso.");

        int result = 0;
        try (PreparedStatement ps = connection.prepareStatement(
                "UPDATE televisore SET modello=?, marca=?, pollici=?, dataproduzione=? where id=?;")) {
            ps.setString(1, input.getModello());
            ps.setString(2, input.getMarca());
            ps.setInt(3, input.getPollici());
            // quando si fa il setDate serve un tipo java.sql.Date
            ps.setDate(4, java.sql.Date.valueOf(input.getDataproduzione()));
            ps.setLong(5, input.getId());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public int insert(Televisore input) throws Exception {
        if (isNotActive())
            throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

        if (input == null)
            throw new Exception("Valore di input non ammesso.");

        int result = 0;
        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO televisore (marca, modello, pollici, dataproduzione) VALUES (?, ?, ?, ?);")) {
            ps.setString(1, input.getMarca());
            ps.setString(2, input.getModello());
            ps.setInt(3, input.getPollici());
            ps.setDate(4, java.sql.Date.valueOf(input.getDataproduzione()));
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public int delete(Long idDaRimuovere) throws Exception {
        if (isNotActive())
            throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

        if (idDaRimuovere == null || idDaRimuovere < 1)
            throw new Exception("Valore di input non ammesso.");

        int result = 0;
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM televisore WHERE ID=?")) {
            ps.setLong(1, idDaRimuovere);
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public Televisore findTelevisorePiuGrande() throws Exception {
        if (isNotActive())
            throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

        Televisore result = null;
        try (PreparedStatement ps = connection.prepareStatement("select * from televisore order by pollici desc limit 1;")) {

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    result = new Televisore();
                    result.setMarca(rs.getString("marca"));
                    result.setModello(rs.getString("modello"));
                    result.setPollici(rs.getInt("pollici"));
                    result.setDataproduzione(
                            rs.getDate("dataproduzione") != null ? rs.getDate("dataproduzione").toLocalDate() : null);
                    result.setId(rs.getLong("ID"));
                } else {
                    result = null;
                }
            } // niente catch qui

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public int countProdottiInUnIntervallo(LocalDate dataIniziale, LocalDate dataFinale) throws Exception {
        if (isNotActive())
            throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

        int results = 0;
        try (PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM televisore WHERE dataproduzione BETWEEN ? AND ?;")) {

            ps.setDate(1, java.sql.Date.valueOf(dataIniziale));
            ps.setDate(2, java.sql.Date.valueOf(dataFinale));

            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    results = rs.getInt(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return results;
    }

    @Override
    public List<Televisore> findTelevisoriProdottiNegliUltimiMesi(LocalDate dataInput) throws Exception {
        if (isNotActive())
            throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

        List<Televisore> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement("SELECT distinct marca  FROM televisore  WHERE dataproduzione > ? ")) {

            ps.setDate(1, java.sql.Date.valueOf(dataInput));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Televisore televisoreTemp = new Televisore();
                    televisoreTemp.setMarca(rs.getString("marca"));
                    result.add(televisoreTemp);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return result;
    }



}
