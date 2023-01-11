package com.izzat.restapi.dao;

import com.izzat.restapi.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static final List<User> users = new ArrayList<>();
    private final static AtomicLong id = new AtomicLong(1);

    static {
        users.add(new User(id.getAndIncrement(), "Izzat", LocalDate.now().minusYears(20)));
        users.add(new User(id.getAndIncrement(), "Ranga", LocalDate.now().minusYears(30)));
        users.add(new User(id.getAndIncrement(), "Jim", LocalDate.now().minusYears(15)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(Long id) {
        Predicate<? super User> search = getUserById(id);
        return users.stream().filter(search).findFirst().orElse(null);
    }

    public User saveUser(User user) {
            user.setUserId(id.getAndIncrement());
            users.add(user);
            return user;
    }

    public void deleteUser(Long id) {
        users.removeIf(getUserById(id));
    }

    private Predicate<? super User> getUserById(Long id) {
        return user -> user.getUserId().equals(id);
    }
}
