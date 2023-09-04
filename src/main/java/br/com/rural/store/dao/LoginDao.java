package br.com.rural.store.dao;

import br.com.rural.store.modelo.Login;
import jakarta.persistence.EntityManager;

public class LoginDao {

    private final EntityManager em;

    public LoginDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Login login) {
        em.getTransaction().begin();
        em.persist(login);
        em.getTransaction().commit();
    }


}
