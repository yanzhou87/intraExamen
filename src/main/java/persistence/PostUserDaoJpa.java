package persistence;

import models.PostUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PostUserDaoJpa implements PostUserDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("intra.exe");

    public void save(PostUser postUser) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(postUser);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public PostUser findPostUser(long postUserId) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        PostUser postUser = em.find(PostUser.class, postUserId);

        em.getTransaction().commit();
        em.close();

        return postUser;
    }


}
