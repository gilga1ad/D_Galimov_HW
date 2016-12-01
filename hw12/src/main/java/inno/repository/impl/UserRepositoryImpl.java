package inno.repository.impl;


import inno.model.User;
import inno.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public boolean add(User user) {
        em.persist(user);
        return true;
    }

    @Override
    public User find(Long id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public User findByLogin(String login) {
        TypedQuery<User> query = em.createQuery(
                "SELECT user FROM User user WHERE user.login LIKE :login",
                User.class);
        query.setParameter("login", login);
        User user;
        try {
            user = query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return user;
    }

}
