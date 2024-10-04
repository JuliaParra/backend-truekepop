package dev.julia.truekepop.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_favorites")
public class UserFavorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "trueke_id", nullable = false)
    private Trueke trueke;

    public UserFavorites() {}

    public UserFavorites(User user, Trueke trueke) {
        this.user = user;
        this.trueke = trueke;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Trueke getTrueke() {
        return trueke;
    }

    public void setTrueke(Trueke trueke) {
        this.trueke = trueke;
    }
}

