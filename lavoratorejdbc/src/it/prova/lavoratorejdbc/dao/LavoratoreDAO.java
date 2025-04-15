package it.prova.lavoratorejdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.lavoratorejdbc.connection.MyConnection;
import it.prova.lavoratorejdbc.model.Lavoratore;

public class LavoratoreDAO {
	// =============================================== LIST
	public List<Lavoratore> elencaTuttiQuelliAttualmenteSullaBaseDati() {

		Connection connection = null;
		ResultSet rs = null;
		Statement s = null;
		Lavoratore temp = null;
		List<Lavoratore> result = new ArrayList<Lavoratore>();

		try {

			connection = MyConnection.getConnection();
			s = connection.createStatement();

			rs = s.executeQuery("select * from lavoratore;");

			while (rs.next()) {
				temp = new Lavoratore();
				temp.setId(rs.getLong("id"));
				temp.setNome(rs.getString("nome"));
				temp.setCognome(rs.getString("cognome"));
				temp.setDataDiNascita(rs.getDate("datadinascita"));
				temp.setRal(rs.getInt("ral"));
				result.add(temp);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				rs.close();
				s.close();
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// =============================================== INSERT
	public int insert(Lavoratore input) {

		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = MyConnection.getConnection();
			ps = connection.prepareStatement(
					"INSERT INTO lavoratore (nome, cognome, datadinascita, ral) " + "VALUES (?, ?, ?,?) ");
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			// quando si fa il setDate serve un tipo java.sql.Date
			ps.setDate(3, new java.sql.Date(input.getDataDiNascita().getTime()));
			ps.setInt(4, input.getRal());

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

	// =============================================== UPDATE
	public int update(Lavoratore input) {

		if (input == null || input.getId() < 1) {
			return 0;
		}

		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = MyConnection.getConnection();
			ps = connection.prepareStatement("UPDATE lavoratore SET nome=?, cognome=?, " + "datadinascita=?, ral=? where id=?;");
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			// quando si fa il setDate serve un tipo java.sql.Date
			ps.setDate(3, new java.sql.Date(input.getDataDiNascita().getTime()));
			ps.setInt(4, input.getRal());
			ps.setLong(5, input.getId());

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

	// =============================================== DELETE
	public int delete(Long idElementToDelete) {

		if (idElementToDelete == null || idElementToDelete < 1) {
			return 0;
		}

		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = MyConnection.getConnection();
			ps = connection.prepareStatement("DELETE from lavoratore where id=?;");
			ps.setLong(1, idElementToDelete);

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

	// =============================================== FINDBYID
	public Lavoratore findById(Long input) {

		if (input == null || input < 1) {
			return null;
		}

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Lavoratore result = null;

		try {

			connection = MyConnection.getConnection();
			ps = connection.prepareStatement("select * from lavoratore u where u.id=?;");
			ps.setLong(1, input);

			rs = ps.executeQuery();

			if (rs.next()) {
				result = new Lavoratore();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("NOME"));
				result.setCognome(rs.getString("COGNOME"));
				result.setDataDiNascita(rs.getDate("datadinascita"));
				result.setRal(rs.getInt("ral"));
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				rs.close();
				ps.close();
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

//			// =============================================== BY Nome and Cognome
	public List<Lavoratore> selectByNomeCognomeIniziaPer(String nome, String cognome) {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Lavoratore temp = null;
		List<Lavoratore> result = new ArrayList<Lavoratore>();

		try {

			connection = MyConnection.getConnection();
			ps = connection.prepareStatement("select * from lavoratore u where u.nome like ? and u.cognome like ? ");
			ps.setString(1, nome + '%');
			ps.setString(2, cognome + '%');

			rs = ps.executeQuery();

			while (rs.next()) {
				temp = new Lavoratore();
				temp.setId(rs.getLong("id"));
				temp.setNome(rs.getString("nome"));
				temp.setCognome(rs.getString("cognome"));
				temp.setDataDiNascita(rs.getDate("datadinascita"));
				temp.setRal(rs.getInt("ral"));
				result.add(temp);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				rs.close();
				ps.close();
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
