package repository;

import model.User;

import java.util.List;

public interface DefaultRepository<T> {

    int create(T t);

    List<T> getList();

    T get(int index);

    int update(User user, int index);

    int delete(int index);

}
