package br.com.fabercanetas.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Classe respons�vel por fazer a conex�o com o banco de dados. Utiliza pool de conex�o o qual est� setado no arquivo context. 
 * @author TDS Tecnologia
 *
 */
class ConnectionManager {

	private static ConnectionManager connectionManager;
	private DataSource ds;

	/**
	 * Construtor privado da classe pois ningu�m poder� criar instancias desta classe.
	 * @throws ClassNotFoundException
	 * @throws NamingException 
	 */
	private ConnectionManager() throws NamingException {
		
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		ds = (DataSource) envContext.lookup("jdbc/dataSourcePool");
	}

	public static ConnectionManager getInstance() throws SQLException {

		try {

			// verifica se jah existe uma instancia, se nao existe entao instancia
			if (connectionManager == null) {
				connectionManager = new ConnectionManager();
			}

		} catch (NamingException e) {

			throw new SQLException("O DataSource nao foi encontrado!");

		}

		return connectionManager;

	}
	
	/**
	 * M�todo que abre uma conex�o com o banco de dados e retorna um objeto Connection.
	 * @return Connection. Um objeto que representa a conex�o com o banco de dados (Connection)
	 * @throws SQLException 
	 */
	public Connection getConnection() throws SQLException {
		
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao obter a conex�o com banco de dados", e);
		}
	}

}
