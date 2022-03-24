package service;

import models.Post;
import models.PostComment;
import models.PostUser;
import persistence.*;

public class ServicePost {

    PostUserDao postUserDao ;
    PostDao postDao ;
    PostCommentDao postCommentDao ;

    public ServicePost(PostUserDao postUserDao, PostDao postDao, PostCommentDao postCommentDao) {
        this.postUserDao = postUserDao;
        this.postDao = postDao;
        this.postCommentDao = postCommentDao;
    }

    public long createPostUser(String name) {
        PostUser postUser = new PostUser();
              postUser.setName(name);
        postUserDao.save(postUser);
        return postUser.getId();
    }

    public long createPost(long postUserId, String description) {
        Post post = new Post();
        post.setPostUser(postUserDao.findPostUser(postUserId));
        post.setPostData(description);

        postDao.save(post);
        return  post.getId();
    }


    public void addComment(long commenteurId, long postId, String comment) {
        PostComment postComment = new PostComment();
        Post post = postDao.findPostById(postId);

        postComment.setCommentateur(postUserDao.findPostUser(commenteurId));
        postComment.setComment(comment);
        post.addComments(postComment);

        postCommentDao.save(postComment);
    }

    public Post findPost(long postId) {
        return postDao.findPostById(postId);
    }
}
