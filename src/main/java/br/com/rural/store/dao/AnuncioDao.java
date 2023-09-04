package br.com.rural.store.dao;

import java.util.List;

import br.com.rural.store.modelo.Anuncio;
import jakarta.persistence.EntityManager;

public class AnuncioDao {

	//adicionando
    private final EntityManager em;

    public AnuncioDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Anuncio anuncio) {
        em.getTransaction().begin();
        em.persist(anuncio);
        em.getTransaction().commit();
    }
    
	public void atualizar(Anuncio anuncio) {
		this.em.merge(anuncio);
	}

	public void remover(Anuncio anuncio) {
//		 em.getTransaction().begin();
		anuncio = em.merge(anuncio);
		this.em.remove(anuncio);
//		em.getTransaction().commit();
	}
	
	public Anuncio buscarPorId(Long id) {
		return em.find(Anuncio.class, id);
	}
    
	public List<Anuncio> buscarTodos() {
		String jpql = "SELECT p FROM Anuncio p";
		return em.createQuery(jpql, Anuncio.class).getResultList();
	}

}
