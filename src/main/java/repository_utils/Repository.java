package repository_utils;


import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class Repository<T> implements CRUDRepository<T>, Serializable {
    private final SessionProducer sp;
    private final Class<T> table;

    public Repository(Class<T> table) {
        sp = new SessionProducer();
        this.table = table;
    }

    @Override
    public T find(Integer id) {
        return sp.produceSession().find(table, id);
    }

    @Override
    public List<T> findAll() {
        return sp.produceSession().createQuery("FROM " + table.getSimpleName(), table).getResultList();
    }

    @Override
    public void save(T object) {
        Transaction t = sp.produceSession().getTransaction();
        if (!t.isActive()) {
            t.begin();
        }
        sp.produceSession().persist(object);
        if (t.isActive()) {
            t.commit();
        }
    }

    @Override
    public void delete(T object) {
        sp.produceSession().remove(object);
    }
}
