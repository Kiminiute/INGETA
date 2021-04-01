package repository_utils;


import org.hibernate.Transaction;
import java.util.List;

public class Repository<T> implements CRUDRepository<T> {
    private final SessionProducer sp = new SessionProducer();
    private final Class<? extends T> table;

    public Repository(Class<? extends T> table) {
        this.table = table;
    }

    @Override
    public T find(Integer id) {
        return sp.produceSession().find(table, id);
    }

    @Override
    public List<T> findAll(Class<T> type) {
        return sp.produceSession().createQuery("FROM " + type.getSimpleName(), type).getResultList();
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
