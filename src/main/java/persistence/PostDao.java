package persistence;

import models.Post;
import models.PostComment;

public interface PostDao {

    void save(Post post);

    Post findPostById(long postId);

    void saveMerge(long postId, PostComment postComment);

}
