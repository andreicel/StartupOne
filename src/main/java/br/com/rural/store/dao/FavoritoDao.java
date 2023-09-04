package br.com.rural.store.dao;

import br.com.rural.store.modelo.Favorito;
import jakarta.persistence.EntityManager;

public class FavoritoDao {

    private final EntityManager em;

    public FavoritoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Favorito favorito) {
        em.getTransaction().begin();
        em.persist(favorito);
        em.getTransaction().commit();
    }


}
