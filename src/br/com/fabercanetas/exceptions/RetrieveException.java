package br.com.fabercanetas.exceptions;

@SuppressWarnings("serial")
/**
 * Classe de exce��o quando da tentativa de recuperar algum dado do Banco de Dados.
 * @author TDS Tecnologia
 *
 */
public class RetrieveException extends DAOException {

	public RetrieveException() {
		super("ERRO - N�o foi poss�vel recuperar os dados. Um erro aconteceu ao manipular ou conectar com o banco de dados.");
	}

}
