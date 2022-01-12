package repository;

import model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserRepository implements DefaultRepository<User> {

    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setIndex(i);
            user.setName("유저" + i);
            user.setEmail("test" + i + "@email.com");
            user.setCreatedAt(new Date());
            users.add(user);
        }
    }

    @Override
    public int create(User user) {
        User lastUser = users.get(users.size() - 1);

        int newIndex = lastUser.getIndex() + 1;
        user.setIndex(newIndex);
        users.add(user);
        return newIndex;
    }

    @Override
    public List<User> getList() {
        return users;
    }

    @Override
    public User get(int index) {
        for (User user : users) {
            if (user.getIndex() == index) {
                return user;
            }
        }
        return null;
    }

    @Override
    public int update(User user, int index) {
        User u = this.get(index);
        if (u == null) {
            return 0;
        }
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setUpdatedAt(new Date());
        return 1;
    }

    @Override
    public int delete(int index) {
        User u = get(index);
        if (u == null) {
            return 0;
        }
        users.remove(u);
        return 1;
    }
}
