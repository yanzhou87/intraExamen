package persistence;

import models.Post;

public interface PostDao {

    void save(Post post);

    Post findPostById(long postId);
}
