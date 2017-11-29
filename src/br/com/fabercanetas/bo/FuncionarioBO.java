package br.com.fabercanetas.bo;

import java.sql.SQLException;

import br.com.fabercanetas.dao.FuncionarioDAO;
import br.com.fabercanetas.exceptions.RetrieveException;
import br.com.fabercanetas.to.Funcionario;

public class FuncionarioBO {

	public Funcionario buscarFuncionario(int codigoFuncionario) throws RetrieveException {
		try {
			return new FuncionarioDAO().buscarFuncionario(codigoFuncionario);
		} catch (SQLException e) {
			throw new RetrieveException();
		}
	}
	
	/**
	 * M�todo que pesquisa um funcionario no banco de dados atrav�s da Classe FuncionarioDAO e retorna os dados do funcionario atrav�s 
	 * de um objeto Funcionario.
	 * O par�metro que deve ser passado para a pesquisa � o e-mail do funcion�rio e a senha do funcion�rio.
	 * @param email (e-mail do funcion�rio), senha (senha do funcion�rio)
	 * @return Funcionario (retorna um objeto do tipo Funcionario) ou null se o email e a senha n�o existirem no banco de dados.
	 * @throws SQLException
	 * @see br.com.fabercanetas.dao.FuncionarioDAO
	 */
	public Funcionario buscarFuncionario(String email, String senha) throws RetrieveException {
		try {
			return new FuncionarioDAO().buscarFuncionario(email, senha);
		} catch (SQLException e) {
			throw new RetrieveException();
		}
	}
	
}
