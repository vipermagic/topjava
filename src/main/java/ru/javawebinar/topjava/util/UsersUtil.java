package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;

public class UsersUtil {
    public static final List<User> USERS = asList(
            new User(10, "admin", "admin@bestmeals.com", "admin", 1500, true, new HashSet<>(asList(Role.ROLE_USER, Role.ROLE_ADMIN))),
            new User(11, "test_user", "ttt@bestmeals.com", "test", 1600, true, new HashSet<>(Collections.singletonList(Role.ROLE_USER))),
            new User(12, "John", "john77@gmail.com", "123456", 1700, true, new HashSet<>(Collections.singletonList(Role.ROLE_USER))),
            new User(13, "Marsha", "mrscool@gmail.com", "pswgtr7l2", 1800, true, new HashSet<>(Collections.singletonList(Role.ROLE_USER))),
            new User(14, "Vasil", "vas555@protonmail.com", "hidden787well", 1900, false, new HashSet<>(Collections.singletonList(Role.ROLE_USER))),
            new User(15, "SomePerson", "nowhere@tutanota.com", "7423zvgEOtu", 2000, true, new HashSet<>(Collections.singletonList(Role.ROLE_USER)))
    );
}
