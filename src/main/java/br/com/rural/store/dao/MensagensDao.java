package br.com.rural.store.dao;

import br.com.rural.store.modelo.Mensagens;
import jakarta.persistence.EntityManager;

public class MensagensDao {

    private final EntityManager em;

    public MensagensDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Mensagens mensagem) {
        em.getTransaction().begin();
        em.persist(mensagem);
        em.getTransaction().commit();
    }


}
