package br.com.rural.store.testes;

import java.util.Scanner;
import java.util.List;

import br.com.rural.store.dao.AnuncioDao;
import br.com.rural.store.dao.UsuarioDao;
import br.com.rural.store.modelo.Anuncio;
import br.com.rural.store.modelo.Usuario;
import br.com.rural.store.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class DeleteTeste {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		ReadTeste.main(args);

		System.out.println("\nListagem completa.");
		System.out.println("\nPrecione ENTER para excluir os dados de todos os usuários e anúncios.");

		scanner.nextLine();
		//
		
		EntityManager em = JPAUtil.getEntityManager();
        UsuarioDao usuarioDao = new UsuarioDao(em);
        AnuncioDao anuncioDao = new AnuncioDao(em);
        
		// Buscar todos os usuários cadastrados
        List<Anuncio> anuncios = anuncioDao.buscarTodos();
		List<Usuario> usuarios = usuarioDao.buscarTodos();

		 // Remova todos os usuários
        em.getTransaction().begin();
        for (Anuncio anuncio : anuncios) {
            anuncioDao.remover(anuncio);
        }
        // E também anuncios
        for (Usuario usuario : usuarios) {
            usuarioDao.remover(usuario);
        }
        
        List<Anuncio> anuncios2 = anuncioDao.buscarTodos();
        if (anuncios2.isEmpty()) {
        	System.out.println("\nNenhum registro na tabela Anúncio.\n");
        } else {
        	System.out.println("\nA tabela ainda contém registros.\n");
        }
        List<Usuario> usuarios2 = usuarioDao.buscarTodos();
        if (usuarios2.isEmpty()) {
        	System.out.println("\nNenhum registro na tabela Usuário.");
        } else {
        	System.out.println("\nA tabela ainda contém registros.\n");
        }
        

        em.getTransaction().commit();

        em.close();

	}

}
