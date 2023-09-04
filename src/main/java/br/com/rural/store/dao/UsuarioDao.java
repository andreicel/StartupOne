package br.com.rural.store.dao;


import java.util.List;


import br.com.rural.store.modelo.Usuario;
import jakarta.persistence.EntityManager;

public class UsuarioDao {

    private final EntityManager em;

    public UsuarioDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        
    }

	public void atualizar(Usuario usuario) {
		this.em.merge(usuario);
	}

	public void remover(Usuario usuario) {
//		em.getTransaction().begin();
		usuario = em.merge(usuario);
		this.em.remove(usuario);
//		em.getTransaction().commit();
		
	}
	
	public Usuario buscarPorId(Long id) {
		return em.find(Usuario.class, id);
	}
	
	public List<Usuario> buscarTodos() {
		String jpql = "SELECT p FROM Usuario p";
		return em.createQuery(jpql, Usuario.class).getResultList();
	}

    
    
    
}
