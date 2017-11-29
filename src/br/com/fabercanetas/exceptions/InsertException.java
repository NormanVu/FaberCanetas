package br.com.fabercanetas.exceptions;

@SuppressWarnings("serial")
/**
 * Classe de exce��o quando da tentativa de inserir algum dado do Banco de Dados.
 * @author TDS Tecnologia
 *
 */
public class InsertException extends DAOException {

	public InsertException() {
		super("ERRO - N�o foi poss�vel inserir. Um erro aconteceu ao manipular ou conectar com o banco de dados.");
	}
	
}