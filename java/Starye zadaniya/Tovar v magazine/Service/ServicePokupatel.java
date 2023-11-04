package test.Service;

import test.domain.Pokupatel;
import test.repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class ServicePokupatel implements  Service<Pokupatel>{

    private final Repository<Pokupatel> repository;

    public ServicePokupatel(Repository<Pokupatel> repository) {
        this.repository = repository;
    }

    @Override
    public Pokupatel find(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Pokupatel> getAll() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Pokupatel obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Pokupatel obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Pokupatel obj) throws SQLException {
        repository.delete(obj);
    }

    @Override
    public List<Pokupatel> getListPoId(Long id) throws SQLException {
        return repository.getListPoId(id);
    }

    @Override
    public List<Pokupatel> getListNoId() {
        return null;
    }

    @Override
    public List<Pokupatel> getListPoIdPostav(Long id) {
        return null;
    }
}
