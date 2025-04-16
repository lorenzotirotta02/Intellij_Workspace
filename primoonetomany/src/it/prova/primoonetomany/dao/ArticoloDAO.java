package it.prova.primoonetomany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.primoonetomany.connection.MyConnection;
import it.prova.primoonetomany.model.Articolo;
import it.prova.primoonetomany.model.Negozio;

public class ArticoloDAO {

	public List<Articolo> list() {

		List<Articolo> result = new ArrayList<Articolo>();

		try (Connection c = MyConnection.getConnection();
				Statement s = c.createStatement();
				// STRATEGIA EAGER FETCHING
				ResultSet rs = s.executeQuery("select * from articolo a inner join negozio n on n.id=a.negozio_id")) {

			while (rs.next()) {
				Articolo articoloTemp = new Articolo();
				articoloTemp.setNome(rs.getString("a.NOME"));
				articoloTemp.setMatricola(rs.getString("matricola"));
				articoloTemp.setId(rs.getLong("a.id"));

				Negozio negozioTemp = new Negozio();
				negozioTemp.setId(rs.getLong("n.id"));
				negozioTemp.setNome(rs.getString("n.nome"));
				negozioTemp.setIndirizzo(rs.getString("indirizzo"));
				negozioTemp.setDataApertura(
						rs.getDate("dataapertura") != null ? rs.getDate("dataapertura").toLocalDate() : null);


				articoloTemp.setNegozio(negozioTemp);
				result.add(articoloTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// rilancio in modo tale da avvertire il chiamante
			throw new RuntimeException(e);
		}
		return result;
	}

	public Articolo findById(Long idArticoloInput) {

		if (idArticoloInput == null || idArticoloInput < 1)
			throw new RuntimeException("Impossibile recuperare Articolo: id mancante!");

		Articolo result = null;
		try (Connection c = MyConnection.getConnection();
				PreparedStatement ps = c.prepareStatement("select * from articolo a where a.id=?")) {

			ps.setLong(1, idArticoloInput);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					result = new Articolo();
					result.setNome(rs.getString("NOME"));
					result.setMatricola(rs.getString("matricola"));
					result.setId(rs.getLong("id"));
				} else {
					result = null;
				}
			} // niente catch qui

		} catch (Exception e) {
			e.printStackTrace();
			// rilancio in modo tale da avvertire il chiamante
			throw new RuntimeException(e);
		}
		return result;
	}

	public int insert(Articolo articoloInput) {

		if (articoloInput.getNegozio() == null || articoloInput.getNegozio().getId() < 1)
			throw new RuntimeException("Impossibile inserire Articolo: Negozio mancante!");

		int result = 0;
		try (Connection c = MyConnection.getConnection();
				PreparedStatement ps = c
						.prepareStatement("INSERT INTO articolo (nome, matricola,negozio_id) VALUES (?, ?, ?)")) {

			ps.setString(1, articoloInput.getNome());
			ps.setString(2, articoloInput.getMatricola());
			ps.setLong(3, articoloInput.getNegozio().getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// rilancio in modo tale da avvertire il chiamante
			throw new RuntimeException(e);
		}
		return result;
	}

	// TODO
	public Articolo findByIdEager(Long idInput) {
		Articolo result = null;

		try (Connection c = MyConnection.getConnection();
			 PreparedStatement ps = c.prepareStatement(
					 "SELECT * FROM articolo " +
							 "INNER JOIN negozio ON articolo.negozio_id = negozio.id " +
							 "WHERE articolo.id = ?")) {

			ps.setLong(1, idInput);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Articolo articoloTemp = new Articolo();
					articoloTemp.setId(rs.getLong("articolo.id"));
					articoloTemp.setNome(rs.getString("articolo.nome"));
					articoloTemp.setMatricola(rs.getString("matricola"));

					Negozio negozioTemp = new Negozio();
					negozioTemp.setId(rs.getLong("negozio.id"));
					negozioTemp.setNome(rs.getString("negozio.nome"));
					negozioTemp.setIndirizzo(rs.getString("indirizzo"));
					negozioTemp.setDataApertura(
							rs.getDate("dataapertura") != null ? rs.getDate("dataapertura").toLocalDate() : null
					);

					articoloTemp.setNegozio(negozioTemp);
					result = articoloTemp;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return result;
	}

	public int update(Articolo articoloInput) {
		if (articoloInput.getNegozio() == null || articoloInput.getNegozio().getId() < 1)
			throw new RuntimeException("Impossibile modificare Articolo: Negozio mancante!");

		int result = 0;
		try (Connection c = MyConnection.getConnection();
			 PreparedStatement ps = c.prepareStatement(
					 "UPDATE articolo SET nome = ?, matricola = ?, negozio_id = ? WHERE id = ?")) {

			ps.setString(1, articoloInput.getNome());
			ps.setString(2, articoloInput.getMatricola());
			ps.setLong(3, articoloInput.getNegozio().getId());
			ps.setLong(4, articoloInput.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// rilancio in modo tale da avvertire il chiamante
			throw new RuntimeException(e);
		}
		return result;
	}

	public int delete(Long idToDelete) {
		if (idToDelete == null || idToDelete < 1) {
			return 0;
		}

		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = MyConnection.getConnection();
			ps = connection.prepareStatement("DELETE from articolo where id=?;");
			ps.setLong(1, idToDelete);

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				ps.close();
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// implementare inoltre
	public List<Articolo> findAllByNegozio(Negozio negozioInput) {
		List<Articolo> result = new ArrayList<>();
		if (negozioInput == null || negozioInput.getId() == null || negozioInput.getId() < 1)
			return result;

		try (Connection conn = MyConnection.getConnection();
			 PreparedStatement ps = conn.prepareStatement(
					 "SELECT articolo where negozio_id = ?")) {
			ps.setLong(1, negozioInput.getId());

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {

					Articolo articolo = new Articolo(
							rs.getLong("id"),
							rs.getString("nome"),
							rs.getString("matricola"),
							negozioInput
					);

					result.add(articolo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<Articolo> findAllByMatricola(String matricolaInput) {
		Connection connection = null;
		PreparedStatement ps = null;
		List<Articolo> result = new ArrayList<>();
		ResultSet rs = null;

		try {
			connection = MyConnection.getConnection();
			ps = connection.prepareStatement(
					"SELECT * from articolo where matricola = ?"
			);
			ps.setString(1, matricolaInput);


			rs = ps.executeQuery();

			while (rs.next()) {
				Articolo articolo = new Articolo();
				articolo.setId(rs.getLong("id"));
				articolo.setNome(rs.getString("nome"));
				articolo.setMatricola(rs.getString("matricola"));


				result.add(articolo);
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				ps.close();
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public List<Articolo> findAllByIndirizzoNegozio(String indirizzoNegozioInput) {
		List<Articolo> result = new ArrayList<>();
		if (indirizzoNegozioInput == null)
			return result;

		try (Connection conn = MyConnection.getConnection();
			 PreparedStatement ps = conn.prepareStatement(
					 "SELECT articolo.id, articolo.nome, articolo.matricola, " +
							 "negozio.id, negozio.nome, negozio.indirizzo, negozio.dataapertura " +
							 "FROM articolo " +
							 "JOIN negozio ON articolo.negozio_id = negozio.id " +
							 "WHERE negozio.indirizzo = ?")) {

			ps.setString(1, indirizzoNegozioInput);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Negozio negozio = new Negozio(
							rs.getLong("id"),
							rs.getString("nome"),
							rs.getString("indirizzo"),
							rs.getDate("dataapertura").toLocalDate()
					);

					Articolo articolo = new Articolo(
							rs.getLong("id"),
							rs.getString("nome"),
							rs.getString("matricola"),
							negozio
					);

					result.add(articolo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
