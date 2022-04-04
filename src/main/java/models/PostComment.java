package models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "POSTUSER_ID")
    private PostUser commentateur;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    @ToString.Exclude
    private Post post;
}
