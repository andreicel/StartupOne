package br.com.rural.store.testes;

import java.math.BigDecimal;
import java.util.Locale;


import br.com.rural.store.dao.AnuncioDao;
import br.com.rural.store.dao.UsuarioDao;
import br.com.rural.store.modelo.Anuncio;
import br.com.rural.store.modelo.Usuario;
import br.com.rural.store.modelo.Modalidade;
import br.com.rural.store.util.JPAUtil;
import jakarta.persistence.EntityManager;
import net.datafaker.Faker;

public class CreateTeste {

	private static final Faker faker = new Faker(Locale.forLanguageTag("pt-br"));

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDao usuarioDao = new UsuarioDao(em);
		 AnuncioDao anuncioDao = new AnuncioDao(em);
		


		for (int i = 0; i < 20; i++) { // Criar 10 categorias e produtos aleatórios
			Usuario usuario = new Usuario(faker.name().fullName(),faker.address().fullAddress(), faker.phoneNumber().cellPhone(), faker.internet().emailAddress());
	        usuarioDao.cadastrar(usuario);
	        Anuncio anuncio = new Anuncio(usuario, Modalidade.venda, faker.commerce().brand(), faker.commerce().brand(),BigDecimal.valueOf(faker.number().numberBetween(100, 1000)));
	        anuncioDao.cadastrar(anuncio);
		}
		
		System.out.println("\nA tabela Usuário e Anúncio foram criadas e populadas com vinte registro aleatórios cada. ");

		em.close();
	}

}
