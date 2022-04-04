package persistence;

import models.Post;
import models.PostComment;

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

        final TypedQuery<Post> query = em.createQuery("select p from Post p left join fetch p.comments where p.id = :nameToSearch " , Post.class );
        query.setParameter("nameToSearch",postId );
        Post post = query.getSingleResult();
       // Post post = em.find(Post.class, postId);

        em.getTransaction().commit();
        em.close();

        return post;
    }

    @Override
    public void saveMerge(long postID, PostComment postComment) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Post post = em.find(Post.class, postID);
        post.addComments(postComment);
        em.merge(post);

        em.getTransaction().commit();
        em.close();
    }


}
