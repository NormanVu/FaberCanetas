package br.com.fabercanetas.bo;

import java.sql.SQLException;

import br.com.fabercanetas.dao.PedidoDistribuicaoDAO;
import br.com.fabercanetas.exceptions.RetrieveException;
import br.com.fabercanetas.to.PedidoDistribuicao;

public class PedidoDistribuicaoBO {

	/**
	 * M�todo da camada de regra de negocios que chama o metodo da camada de persistencia insere um pedido de distribuicao no Banco de Dados.
	 * @param pedido PedidoVenda (objeto PedidoDistribuicao a ser inserido no BD)
	 * @return codigoDistribuicao (int), representa o codigo do pedido de distribuicao que foi gerado pela sequence no banco. 
	 * @throws SQLException
	 * @see br.com.fabercanetas.dao.PedidoDistribuicaoDAO
	 */
	public int inserirPedidoDistribuicao(PedidoDistribuicao pedido) throws RetrieveException {
		try {
			return new PedidoDistribuicaoDAO().inserirPedidoDistribuicao(pedido);
		} catch (SQLException e) {
			throw new RetrieveException();
		}
	}
	
	/**
	 * M�todo da camada de regra de negocios que chama o metodo da camada de persistencia que busca um pedido de distribuicao no Banco de Dados e retorna um objeto PedidoDistribuicao com todos os dados
	 * @param int codPedidoDistribuicao (c�digo do pedido a ser buscado)
	 * @return PedidoDistribuicao (objeto PedidoDistribuicao)
	 * @throws SQLException
	 */
	public PedidoDistribuicao buscarPedidoDistribuicao(int codPedidoDistribuicao) throws RetrieveException {
		try {
			return new PedidoDistribuicaoDAO().buscarPedidoDistribuicao(codPedidoDistribuicao);
		} catch (SQLException e) {
			throw new RetrieveException();
		}
	}
	
}
