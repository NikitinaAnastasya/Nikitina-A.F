package test.Service;

import test.domain.Prodavec;
import test.repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class ServiceProdavec implements Service<Prodavec>{
    private final Repository<Prodavec> repository;

    public ServiceProdavec(Repository<Prodavec> repository) {
        this.repository = repository;
    }

    @Override
    public Prodavec find(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Prodavec> getAll() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Prodavec obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Prodavec obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Prodavec obj) throws SQLException {
        repository.delete(obj);
    }

    @Override
    public List<Prodavec> getListPoId(Long id) throws SQLException {
        return repository.getListPoId(id);
    }

    @Override
    public List<Prodavec> getListNoId() {
        return null;
    }

    @Override
    public List<Prodavec> getListPoIdPostav(Long id) {
        return null;
    }
}
