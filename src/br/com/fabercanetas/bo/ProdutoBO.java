package br.com.fabercanetas.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fabercanetas.dao.ProdutoDAO;
import br.com.fabercanetas.exceptions.DeleteException;
import br.com.fabercanetas.exceptions.InsertException;
import br.com.fabercanetas.exceptions.RetrieveException;
import br.com.fabercanetas.exceptions.UpdateException;
import br.com.fabercanetas.to.Produto;

/**
 * Classe que persiste e faz o CRUD completo dos dados de Produto no banco de dados. Trata tambem as
 * regras de negocios que possam existir.
 * @author TDS Tecnologia
 * @see br.com.fabercanetas.to.Produto
 * @see br.com.fabercanetas.dao.ProdutoDAO
 */
public class ProdutoBO {

	/**
	 * M�todo para gravar um produto no banco de dados.
	 * Para tanto utiliza o metodo inserirProduto da classe de persistencia ProdutoDAO.
	 * @param objeto produto a ser gravado no banco (Produto)
	 * @throws InsertException
	 */
	public void inserirProduto(Produto produto) throws InsertException {
		try {
			new ProdutoDAO().inserirProduto(produto);
		} catch (SQLException e) {
			throw new InsertException();
		}
	}
	
	/**
	 * M�todo que busca um determinado produto pelo seu c�digo e retorna o objeto desse produto.
	 * Para tanto utiliza o metodo buscarProduto da classe de persistencia ProdutoDAO.
	 * @param codigoProduto id do produto que se quer buscar.
	 * @return Produto objeto produto buscado.
	 * @throws RetrieveException
	 */
	public Produto buscarProduto(int codigoProduto) throws RetrieveException {
		try {
			return new ProdutoDAO().buscarProduto(codigoProduto);
		} catch (SQLException e) {
			throw new RetrieveException();
		}
	}
	
	/**
	 * Busca produto por texto
	 * @param texto
	 * @return Produto
	 * @throws SQLException
	 */
	public Produto buscarProduto(String texto) throws RetrieveException {
		try {
			return new ProdutoDAO().buscarProduto(texto);
		} catch (SQLException e) {
			throw new RetrieveException();
		}
	}
	
	
	/**
	 * M�todo que atualiza as informa��es de um determinado produto.
	 * Para tanto utiliza o metodo atualizarProduto da classe de persist�ncia ProdutoDAO.
	 * @param produto Objeto produto que ser� atualizado
	 * @throws UpdateException
	 */
	public void atualizarProduto(Produto produto) throws UpdateException {
		try {
			new ProdutoDAO().atualizarProduto(produto);
		} catch (SQLException e) {
			throw new UpdateException();
		}
	}
	
	/**
	 * M�todo que exclui um produto. Espera como par�metro o inteiro c�digo do produto a ser exclu�do.
	 * Para tanto utiliza o metodo deletarProduto da classe de persist�ncia ProdutoDAO.
	 * @param codigoProduto C�digo do produto que ser� deletado
	 * @throws DeleteException
	 */
	public void deletarProduto(int codigoProduto) throws DeleteException {
		try {
			new ProdutoDAO().deletarProduto(codigoProduto);
		} catch (SQLException e) {
			throw new DeleteException();
		}
	}
	
	/**
	 * M�todo que cria uma lista com produtos dentro de um alcance o qual � limitado pelos parametros idInicio e idFim que
	 * representam qual o numero do id do produto que quero comecar at� o n�mero do id do produto que quero terminar.
	 * Para tanto utiliza o metodo listaProduto da classe de persist�ncia ProdutoDAO.
	 * @param codigoInicio c�digo do produto que quero comecar a por na lista.
	 * @param codigoFim c�digo do ultimo produto que quero por na lista.
	 * @return ArrayList<Produto> retorna um objeto ArrayList que contem produtos.
	 * @throws RetrieveException
	 */
	public List<Produto> listaProduto(int codigoInicio, int codigoFim) throws RetrieveException {
		try {
			return new ProdutoDAO().listaProduto(codigoInicio, codigoFim);
		} catch (SQLException e) {
			throw new RetrieveException();
		}
	}
	
}
