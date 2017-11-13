package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.util.UsersUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {
    private static final Logger log = LoggerFactory.getLogger(InMemoryUserRepositoryImpl.class);

    private Map<Integer, User> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        UsersUtil.USERS.forEach(this::save);
    }

    @Override
    public boolean delete(int id) {
        log.info("delete {}", id);
        return repository.remove(id, repository.get(id));
    }

    @Override
    public User save(User user) {
        log.info("save {}", user);
        if(user.isNew()) {
            user.setId(counter.incrementAndGet());
        }
        return repository.put(user.getId(), user);
    }

    @Override
    public User get(int id) {
        log.info("get {}", id);
        return repository.get(id);
    }

    @Override
    public List<User> getAll() {
        log.info("getAll");

        List<User> result = new ArrayList<>(repository.values());
        result.sort((user, t1) -> {
            int c = user.getName().compareTo(t1.getName());

            if (c == 0) {
                c = user.getId().compareTo(t1.getId());
            }

            return c;
        });

        return result;
    }

    @Override
    public User getByEmail(String email) {
        log.info("getByEmail {}", email);

        List<User> list = new ArrayList<>(repository.values());
        User result = null;
        for(User i : list) {
            if(i.getEmail().equals(email)) {
                result = i;
            }
        }

        return result;
    }
}
