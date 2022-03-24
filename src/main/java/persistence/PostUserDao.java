package persistence;

import models.PostUser;

public interface PostUserDao {

   void save(PostUser postUser);

   PostUser findPostUser(long postUserId);
}
