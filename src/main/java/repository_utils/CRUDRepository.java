package repository_utils;


import java.util.List;

public interface CRUDRepository<T> {

    T find(Integer id);

    List<T> findAll(Class<T> clazz);

    void save(T object);

    void delete(T object);

}
