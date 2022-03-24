package persistence;

import models.PostComment;

public interface PostCommentDao {
    void save(PostComment postComment);
}
