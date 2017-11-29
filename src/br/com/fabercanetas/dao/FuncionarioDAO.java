package br.com.fabercanetas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.fabercanetas.to.Funcionario;

/**
 * Classe de persist�ncia de dados de funcion�rio no banco de dados.
 * @author TDS Tecnologia
 * @see br.com.fabercanetas.bo.FuncionarioBO
 * @see br.com.fabercanetas.to.Funcionario
 * @since 01/10/2017
 * @version 1.0
 *
 */
public class FuncionarioDAO {

	/**
	 * M�todo que busca um registro de funcionario no banco de dados atrav�s de um n�mero inteiro que representa o c�digo do funcion�rio.
	 * O m�todo retorna um objeto do tipo funcion�rio com todos os dados existentes no BD daquele funcion�rio.
	 * @param int codigoFuncionario, que representa o c�digo do funcion�rio a buscar.
	 * @return Funcionario funcionario. Objeto funcion�rio criado com os dados encontrados no BD.
	 * @throws SQLException
	 */
	public Funcionario buscarFuncionario(int codigoFuncionario) throws SQLException {
		
		Connection conn = null;
		Funcionario funcionario = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			String query = "SELECT * FROM T_TDS_FUNCIONARIO WHERE cd_funcionario = ?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, codigoFuncionario);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				funcionario = FuncionarioDAO.setFuncionarioFromBD(funcionario, rs);
			}
			return funcionario;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao conectar ou manipular o Bando de Dados.", e);
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	/**
	 * M�todo que pesquisa um funcionario no banco e retorna os dados do funcionario atrav�s de um objeto Funcionario.
	 * O par�metro que deve ser passado para a pesquisa � o e-mail do funcion�rio e a senha do funcion�rio.
	 * @param email (e-mail do funcion�rio), senha (senha do funcion�rio)
	 * @return Funcionario (retorna um objeto do tipo Funcionario) ou null se o email e a senha n�o existirem no banco de dados.
	 * @throws SQLException
	 */
	public Funcionario buscarFuncionario(String email, String senha) throws SQLException {
		
		Connection conn = null;
		Funcionario funcionario = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			String query = "SELECT * FROM T_TDS_FUNCIONARIO WHERE ds_email = ? AND pw_senha = ?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, email);
			pstm.setString(2, senha);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				funcionario = FuncionarioDAO.setFuncionarioFromBD(funcionario, rs);
			}
			return funcionario;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao conectar ou manipular o Bando de Dados.", e);
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
		
	}
	
	/**
	 * M�todo que seta um objeto funcion�rio com as informa��es contidas no banco de dados que est�o no ResultSet e ao final retorna
	 * o objeto funcion�rio. 
	 * @param Funcionario funcionario
	 * @param ResultSet rs
	 * @return Funcionario funcionario
	 * @throws SQLException
	 */
	private static Funcionario setFuncionarioFromBD(Funcionario funcionario, ResultSet rs) throws SQLException {
		funcionario = new Funcionario();
		funcionario.setCodigo(rs.getInt("cd_funcionario"));
		funcionario.setDepartamento(new DepartamentoDAO().buscarDepartamento(rs.getInt("cd_departamento")));
		funcionario.setFuncao(new FuncaoDAO().buscarFuncao(rs.getInt("cd_funcao")));
		funcionario.setDataCadastro(rs.getDate("dt_cadastro").toLocalDate());
		funcionario.setEmail(rs.getString("ds_email"));
		funcionario.setSenha(rs.getString("pw_senha"));
		funcionario.setNome(rs.getString("nm_funcionario"));
		
		return funcionario;
	}
	
}
