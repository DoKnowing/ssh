package manager.actionInterface;

import common.daoInterface.CatgoryDaoInter;
import common.model.Catgory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ManageCatgoryActionInter {
    String manageCatgoryPage();

    String addCatgoryPage();

    String addCatgory() throws IOException;

    String modifyCatgoryPage();

    String modifyCatgory() throws IOException;

    String deleteCatgory();

    List<Catgory> getCatgories();

    void setCatgories(List<Catgory> catgories);

    Catgory getCatgory();

    void setCatgory(Catgory catgory);

    long getCatgoryId();

    void setCatgoryId(long catgoryId);

    File getImg();

    void setImg(File img);

    String getImgFileName();

    void setImgFileName(String imgFileName);

    CatgoryDaoInter getCatgoryDao();

    void setCatgoryDao(CatgoryDaoInter catgoryDao);
}
