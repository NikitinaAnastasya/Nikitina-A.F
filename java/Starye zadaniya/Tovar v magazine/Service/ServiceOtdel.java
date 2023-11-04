package test.Service;

import test.domain.Otdel;
import test.repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class ServiceOtdel implements Service<Otdel>{

    private final Repository<Otdel> repository;

    public ServiceOtdel(Repository<Otdel> repository) {
        this.repository = repository;
    }

    @Override
    public Otdel find(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Otdel> getAll() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Otdel obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Otdel obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Otdel obj) throws SQLException {
        repository.delete(obj);
    }

    @Override
    public List<Otdel> getListPoId(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Otdel> getListNoId() {
        return null;
    }

    @Override
    public List<Otdel> getListPoIdPostav(Long id) {
        return null;
    }
}
