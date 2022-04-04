package models;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String postData;

    @ManyToOne()
    @JoinColumn(name = "POSTUSER_ID")
    private PostUser postUser;

    private LocalDateTime dateTime = LocalDateTime.now();

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private  List<PostComment> comments = new ArrayList<>();

    public void addComments (PostComment postComment){
        comments.add(postComment);
        postComment.setPost(this);
    }

}
