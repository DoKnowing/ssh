package common.daoInterface;

import common.model.Catgory;

import java.util.List;

public interface CatgoryDaoInter {
    List<Catgory> getCatgories();

    Catgory getCategoryById(long catgoryId);

    void save(Catgory catgory);

    void remove(Catgory catgory);
}
