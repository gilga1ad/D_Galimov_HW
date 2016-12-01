package inno.repository;


import inno.model.User;

public interface UserRepository {

    boolean add(User user);

    User find(Long id);

    User findByLogin(String login);

}
