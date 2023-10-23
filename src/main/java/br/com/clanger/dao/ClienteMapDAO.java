package br.com.clanger.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import br.com.clanger.namespace.model.Cliente;

public class ClienteMapDAO implements IClienteDAO{
	
	private Map<Long, Cliente> map;
	
	public ClienteMapDAO() {
		this.map = new HashMap<>();
	}
	@Override
	public Boolean cadastrar(Cliente cliente) {
		if(this.map.containsKey(cliente.getCpf())) {
			return false;
		}
		this.map.put(cliente.getCpf(), cliente);
		return true;
	}

	@Override
	public void excluir(Long cpf) {
		Cliente clienteCadastrado = this.map.get(cpf);
		
		if(clienteCadastrado != null) {
			this.map.remove(cpf, clienteCadastrado);
		}
		
	}

	@Override
	public void alterar(Cliente cliente) {
		Cliente clienteCadastrado = this.map.get(cliente.getCpf());
		
		if(clienteCadastrado != null) {
			clienteCadastrado.setNome(cliente.getNome());
			clienteCadastrado.setCidade(cliente.getCidade());
			clienteCadastrado.setEnd(cliente.getEnd());
			clienteCadastrado.setNumero(cliente.getNumero());
			clienteCadastrado.setEstado(cliente.getEstado());
			clienteCadastrado.setTel(cliente.getTel());
		}
	}

	@Override
	public Cliente consultar(Long cpf) {
		return this.map.get(cpf);
	}

	@Override
	public Collection<Cliente> buscarTodosClientes() {
		return this.map.values();
	}
	@Override
	public int hashCode() {
		return Objects.hash(map);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteMapDAO other = (ClienteMapDAO) obj;
		return Objects.equals(map, other.map);
	}
}
