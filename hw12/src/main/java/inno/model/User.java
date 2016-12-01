package inno.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "users")
@SequenceGenerator(sequenceName = "user_seq", name = "userSequence")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
    @Column(name = "id")
    long id;

    @Length(min = 5, max = 16, message = "Логин должен иметь минимум 5 символов")
    @Column
    String login;

    @Length(min = 5, max = 25, message = "Пароль должен иметь минимум 5 символов")
    @Column
    String password;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
