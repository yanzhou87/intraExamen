package persistence;

import models.Post;
import models.PostUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class PostDaoJpa implements PostDao{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("intra.exe");


    @Override
    public void save(Post post) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(post);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Post findPostById(long postId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Post post = em.find(Post.class, postId);

        em.getTransaction().commit();
        em.close();

        return post;
    }
}
