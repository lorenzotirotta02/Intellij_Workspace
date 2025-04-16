package it.prova.dao.user;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.prova.dao.AbstractMySQLDAO;
import it.prova.model.User;

public class UserDAOImpl extends AbstractMySQLDAO implements UserDAO {

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<User> list() throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<User> result = new ArrayList<User>();

		try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery("select * from user")) {

			while (rs.next()) {
				User userTemp = new User();
				userTemp.setNome(rs.getString("NOME"));
				userTemp.setCognome(rs.getString("COGNOME"));
				userTemp.setLogin(rs.getString("LOGIN"));
				userTemp.setPassword(rs.getString("PASSWORD"));
				userTemp.setDateCreated(
						rs.getDate("DATECREATED") != null ? rs.getDate("DATECREATED").toLocalDate() : null);
				userTemp.setId(rs.getLong("ID"));
				result.add(userTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public User get(Long idInput) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (idInput == null || idInput < 1)
			throw new Exception("Valore di input non ammesso.");

		User result = null;
		try (PreparedStatement ps = connection.prepareStatement("select * from user where id=?")) {

			ps.setLong(1, idInput);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					result = new User();
					result.setNome(rs.getString("NOME"));
					result.setCognome(rs.getString("COGNOME"));
					result.setLogin(rs.getString("LOGIN"));
					result.setPassword(rs.getString("PASSWORD"));
					result.setDateCreated(
							rs.getDate("DATECREATED") != null ? rs.getDate("DATECREATED").toLocalDate() : null);
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
	public int insert(User utenteInput) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (utenteInput == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO user (nome, cognome, login, password, dateCreated) VALUES (?, ?, ?, ?, ?);")) {
			ps.setString(1, utenteInput.getNome());
			ps.setString(2, utenteInput.getCognome());
			ps.setString(3, utenteInput.getLogin());
			ps.setString(4, utenteInput.getPassword());
			// quando si fa il setDate serve un tipo java.sql.Date
			ps.setDate(5, java.sql.Date.valueOf(utenteInput.getDateCreated()));
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int update(User utenteInput) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (utenteInput == null || utenteInput.getId() == null || utenteInput.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement(
				"UPDATE user SET nome=?, cognome=?, login=?, password=?, dateCreated=? where id=?;")) {
			ps.setString(1, utenteInput.getNome());
			ps.setString(2, utenteInput.getCognome());
			ps.setString(3, utenteInput.getLogin());
			ps.setString(4, utenteInput.getPassword());
			// quando si fa il setDate serve un tipo java.sql.Date
			ps.setDate(5, java.sql.Date.valueOf(utenteInput.getDateCreated()));
			ps.setLong(6, utenteInput.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int delete(Long idDaRimuovere) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (idDaRimuovere == null || idDaRimuovere < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement("DELETE FROM user WHERE ID=?")) {
			ps.setLong(1, idDaRimuovere);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<User> findByExample(User example) throws Exception {

		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (example == null)
			throw new Exception("Valore di input non ammesso.");

		ArrayList<User> result = new ArrayList<User>();

		String query = "select * from user where 1=1 ";
		if (example.getCognome() != null && !example.getCognome().isEmpty()) {
			query += " and cognome like '" + example.getCognome() + "%' ";
		}

		if (example.getNome() != null && !example.getNome().isEmpty()) {
			query += " and nome like '" + example.getNome() + "%' ";
		}

		if (example.getLogin() != null && !example.getLogin().isEmpty()) {
			query += " and login like '" + example.getLogin() + "%' ";
		}

		if (example.getPassword() != null && !example.getPassword().isEmpty()) {
			query += " and password like '" + example.getPassword() + "%' ";
		}

		if (example.getDateCreated() != null) {
			query += " and DATECREATED='" + java.sql.Date.valueOf(example.getDateCreated()) + "' ";
		}

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				User userTemp = new User();
				userTemp.setNome(rs.getString("NOME"));
				userTemp.setCognome(rs.getString("COGNOME"));
				userTemp.setLogin(rs.getString("LOGIN"));
				userTemp.setPassword(rs.getString("PASSWORD"));
				userTemp.setDateCreated(
						rs.getDate("DATECREATED") != null ? rs.getDate("DATECREATED").toLocalDate() : null);
				userTemp.setId(rs.getLong("ID"));
				result.add(userTemp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<User> findByQuelliCheUsernameIniziaCon(String iniziale) throws Exception {
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");
		if(iniziale == null){
			throw new Exception("Valore di input non ammesso.");
		}
		List<User> risultati = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement("select * from user where login like ?")) {

			ps.setString(1, iniziale + "%");
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					User result = new User();
					result.setNome(rs.getString("NOME"));
					result.setCognome(rs.getString("COGNOME"));
					result.setLogin(rs.getString("LOGIN"));
					result.setPassword(rs.getString("PASSWORD"));
					result.setDateCreated(
							rs.getDate("DATECREATED") != null ? rs.getDate("DATECREATED").toLocalDate() : null);
					result.setId(rs.getLong("ID"));
					risultati.add(result);
				}
			} // niente catch qui

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return risultati;
	}

	@Override
	public List<User> findByQuelliCreatiPrimaDi(LocalDate dataConfronto) throws Exception {
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");
		if(dataConfronto == null){
			throw new Exception("Valore di input non ammesso.");
		}
		List<User> risultati = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement("select * from user where datecreated < ?")) {

			ps.setDate(1, Date.valueOf(dataConfronto));
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					User result = new User();
					result.setNome(rs.getString("NOME"));
					result.setCognome(rs.getString("COGNOME"));
					result.setLogin(rs.getString("LOGIN"));
					result.setPassword(rs.getString("PASSWORD"));
					result.setDateCreated(
							rs.getDate("DATECREATED") != null ? rs.getDate("DATECREATED").toLocalDate() : null);
					result.setId(rs.getLong("ID"));
					risultati.add(result);
				}
			} // niente catch qui

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return risultati;
	}

	@Override
	public List<User> findByCognomeENomeCheInziaCon(String cognomeInput, String inizialeNomeInput) throws Exception {
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");
		if(cognomeInput == null & inizialeNomeInput == null){
			throw new Exception("Valore di input non ammesso.");
		}
		List<User> risultati = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement("select * from user where cognome = ? and nome like ?")) {

			ps.setString(1, cognomeInput);
			ps.setString(2, inizialeNomeInput + "%");
			try (ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					User result = new User();
					result.setNome(rs.getString("NOME"));
					result.setCognome(rs.getString("COGNOME"));
					result.setLogin(rs.getString("LOGIN"));
					result.setPassword(rs.getString("PASSWORD"));
					result.setDateCreated(
							rs.getDate("DATECREATED") != null ? rs.getDate("DATECREATED").toLocalDate() : null);
					result.setId(rs.getLong("ID"));
					risultati.add(result);
				}
			} // niente catch qui

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return risultati;
	}

	@Override
	public User login(String loginInput, String passwordInput) throws Exception {
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");
		if(loginInput == null & passwordInput == null){
			throw new Exception("Valore di input non ammesso.");
		}
		User result;
		try (PreparedStatement ps = connection.prepareStatement("select * from user where login= ? and password= ?")) {

			ps.setString(1, loginInput);
			ps.setString(2, passwordInput);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					result = new User();
					result.setNome(rs.getString("NOME"));
					result.setCognome(rs.getString("COGNOME"));
					result.setLogin(rs.getString("LOGIN"));
					result.setPassword(rs.getString("PASSWORD"));
					result.setDateCreated(
							rs.getDate("DATECREATED") != null ? rs.getDate("DATECREATED").toLocalDate() : null);
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
}
