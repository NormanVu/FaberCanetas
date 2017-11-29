package br.com.fabercanetas.exceptions;

@SuppressWarnings("serial")
/**
 * Classe de exce��o quando da tentativa de atualizar algum dado do Banco de Dados.
 * @author TDS Tecnologia
 *
 */
public class UpdateException extends DAOException {

	public UpdateException() {
		super("ERRO - N�o foi poss�vel atualizar os dados. Um erro aconteceu ao manipular ou conectar com o banco de dados.");
	}
	
}
