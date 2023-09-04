package br.com.rural.store.testes;

import java.util.List;

import java.util.Scanner;

import br.com.rural.store.dao.UsuarioDao;
import br.com.rural.store.modelo.Usuario;
import br.com.rural.store.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class UpdateTeste {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		CreateTeste.main(args);

		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDao usuarioDao = new UsuarioDao(em);

		List<Usuario> lista = usuarioDao.buscarTodos();

		System.out.println("\n\nPopulação do banco de dados concluída.");
		System.out.println("Pressione Enter para listar.");
		scanner.nextLine(); 

		for (Usuario usuario : lista) {
			System.out.println("ID: " + usuario.getId());
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Endereço: " + usuario.getEndereco());
			System.out.println("Telefone: " + usuario.getTelefone());
			System.out.println("Email: " + usuario.getEmail());
			System.out.println("============================");
		}

		System.out.println("\n\nListagem completa.");
		System.out.println("Alterando os dados de todos os usuários.");
		System.out.println("Pressione Enter para listar.");
		scanner.nextLine();

		for (Usuario usuario : lista) {
			usuario.setNome("Nome Alterado.");
			usuario.setEndereco("Endereço Alterado.");
			usuario.setTelefone("Telefone Alterado.");
			usuario.setEmail("e-mail Alterado.");
			usuarioDao.atualizar(usuario);
		}

		for (Usuario usuario : lista) {
			System.out.println("ID: " + usuario.getId());
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Endereço: " + usuario.getEndereco());
			System.out.println("Telefone: " + usuario.getTelefone());
			System.out.println("Email: " + usuario.getEmail());
			System.out.println("============================");
		}

		System.out.println("\nTodos os registros alterados.");
		scanner.close();

		em.close();
	}

}
