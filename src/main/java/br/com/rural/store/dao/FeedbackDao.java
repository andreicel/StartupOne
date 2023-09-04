package br.com.rural.store.dao;

import br.com.rural.store.modelo.Feedback;
import jakarta.persistence.EntityManager;

public class FeedbackDao {

    private final EntityManager em;

    public FeedbackDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Feedback feedback) {
        em.getTransaction().begin();
        em.persist(feedback);
        em.getTransaction().commit();
    }


}
