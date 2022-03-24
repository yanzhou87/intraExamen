import models.Post;
import persistence.PostCommentDaoJpa;
import persistence.PostDaoJpa;
import persistence.PostUserDaoJpa;
import service.ServicePost;

public class Main {

    public static void main(String[] args) {
        ServicePost servicePost = new ServicePost(new PostUserDaoJpa(), new PostDaoJpa(), new PostCommentDaoJpa());

        long postUserId = servicePost.createPostUser("yan");
        long commenteurId = servicePost.createPostUser("Commentateur1");
        long postId = servicePost.createPost(postUserId, "Mon ier post");
        servicePost.addComment(commenteurId,postId,"Mon commentaire 1");

        final Post post = servicePost.findPost(postId);
        System.out.println(post);
    }
}
