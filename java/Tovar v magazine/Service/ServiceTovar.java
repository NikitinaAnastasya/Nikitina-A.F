package test.Service;

import test.domain.Tovar;
import test.repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class ServiceTovar implements Service<Tovar>{
    private final Repository<Tovar> repository;

    public ServiceTovar(Repository<Tovar> repository) {
        this.repository = repository;
    }

    @Override
    public Tovar find(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Tovar> getAll() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Tovar obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Tovar obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Tovar obj) throws SQLException {
        repository.delete(obj);
    }

    @Override
    public List<Tovar> getListPoId(Long id) throws SQLException {
        return repository.getListPoId(id);
    }

    @Override
    public List<Tovar> getListNoId() {
        return null;
    }

    @Override
    public List<Tovar> getListPoIdPostav(Long id) {
        return null;
    }
}
