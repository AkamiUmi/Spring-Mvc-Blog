package blog.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString

public class User {
    private Long id;
    private String username;
    private String passwordHash;
    private String fullName;
    private Set<Post> post = new HashSet<>();

    public User(Long id, String username, String fullName) {
        this.id = id; this.username = username; this.fullName = fullName;
    }

}
