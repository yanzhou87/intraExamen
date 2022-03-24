package persistence;

import models.PostComment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PostCommentDaoJpa implements PostCommentDao{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("intra.exe");


    @Override
    public void save(PostComment postComment) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(postComment);

        em.getTransaction().commit();
        em.close();
    }
}
