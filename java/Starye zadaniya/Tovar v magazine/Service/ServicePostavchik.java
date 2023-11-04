package test.Service;

import test.domain.Postavchik;
import test.repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class ServicePostavchik implements Service<Postavchik>{
    private final Repository<Postavchik> repository;

    public ServicePostavchik(Repository<Postavchik> repository) {
        this.repository = repository;
    }

    @Override
    public Postavchik find(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Postavchik> getAll() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Postavchik obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Postavchik obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Postavchik obj) throws SQLException {
        repository.delete(obj);
    }

    @Override
    public List<Postavchik> getListPoId(Long id) throws SQLException {
        return repository.getListPoId(id);
    }

    @Override
    public List<Postavchik> getListNoId() {
        return null;
    }

    @Override
    public List<Postavchik> getListPoIdPostav(Long id) {
        return null;
    }
}
