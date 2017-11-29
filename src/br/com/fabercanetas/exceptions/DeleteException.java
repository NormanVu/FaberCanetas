package br.com.fabercanetas.exceptions;

@SuppressWarnings("serial")
/**
 * Classe de exce��o quando da tentativa de deletar algum dado do Banco de Dados.
 * @author TDS Tecnologia
 *
 */
public class DeleteException extends DAOException {

	public DeleteException() {
		super("ERRO - N�o foi poss�vel deletar. Um erro aconteceu ao manipular ou conectar com o banco de dados.");
	}
	
}
