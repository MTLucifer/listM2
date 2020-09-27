package produc_list.manage;

import java.util.List;

public interface IProduct<P> {
    void add(P object);
    void update(Integer id,P newObject);
    void delete(Integer id);
    P findById(Integer id);
    List<P> findByName(String name);
    List<P> findAll();
}
