package repository_utils;


import java.util.List;

public interface CRUDRepository<T> {

    T find(Integer id);

    List<T> findAll();

    void save(T object);

    void delete(T object);

}
