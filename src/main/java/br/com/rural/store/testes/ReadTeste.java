package br.com.rural.store.testes;

import java.util.List;

import br.com.rural.store.dao.UsuarioDao;
import br.com.rural.store.modelo.Usuario;
import br.com.rural.store.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class ReadTeste {
	public static void main(String[] args) {

		CreateTeste.main(args);

		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDao usuarioDao = new UsuarioDao(em);

		List<Usuario> usuarios = usuarioDao.buscarTodos();

		// Imprimir informações dos usuários
		for (Usuario usuario : usuarios) {
			System.out.println("ID: " + usuario.getId());
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Endereço: " + usuario.getEndereco());
			System.out.println("Telefone: " + usuario.getTelefone());
			System.out.println("Email: " + usuario.getEmail());
			System.out.println("============================");

		}
		em.close();
		System.out.println("\nA tabela Usuário e Anúncio foram criadas, populadas com vinte registro aleatórios cada e impressa no console");
	}
}
