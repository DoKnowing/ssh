package manager.action;

import common.dao.CatgoryDao;
import common.daoInterface.CatgoryDaoInter;
import common.model.Catgory;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Sma
 * @date: 2017-10-28 15:07
 * @explain:
 */
@Controller@Scope("prototype")
public class ManageCatgoryAction implements manager.actionInterface.ManageCatgoryActionInter {
    @Resource private CatgoryDaoInter catgoryDao;
    private List<Catgory> catgories;
    private Catgory catgory;
    private long catgoryId;
    private File img;
    private String imgFileName;

    @Override
    public String manageCatgoryPage(){
        this.catgories=catgoryDao.getCatgories();
        return "success";
    }

    @Override
    public String addCatgoryPage(){
        return "success";
    }

    @Override
    public String addCatgory() throws IOException {
        if(imgFileName!=null && !"".equals(imgFileName)){
            String relativePath="/imgs/catgory/";
            String realPath="E:\\Idea_Workplace\\ssh\\src\\main\\webapp\\imgs\\catgory";
            File saveFile=new File(realPath,imgFileName);
            FileUtils.copyFile(img,saveFile);
            catgory.setUrlImage(relativePath+imgFileName);
        }
        catgoryDao.save(catgory);
        return "success";
    }

    @Override
    public String modifyCatgoryPage(){
        catgory=catgoryDao.getCategoryById(catgoryId);
        return "success";
    }

    @Override
    public String modifyCatgory() throws IOException {
        Catgory client=catgoryDao.getCategoryById(catgoryId);
        if(catgory.getName()!=null && !"".equals(catgory.getName())){
            catgory.setName(catgory.getName());
        }
        if(catgory.getTitle()!=null && !"".equals(catgory.getTitle())){
            catgory.setTitle(catgory.getTitle());
        }
        if(imgFileName!=null && !"".equals(imgFileName)){
            String relativePath="/imgs/catgory/";
            String realPath="E:\\Idea_Workplace\\ssh\\src\\main\\webapp\\imgs\\catgory";
            File saveFile=new File(realPath,imgFileName);
            FileUtils.copyFile(img,saveFile);
            catgory.setUrlImage(realPath+imgFileName);
        }
        catgoryDao.save(catgory);
        return "success";
    }

    @Override
    public String deleteCatgory(){
        Catgory catgory=catgoryDao.getCategoryById(catgoryId);
        catgoryDao.remove(catgory);
        return "success";
    }

    @Override
    public List<Catgory> getCatgories() {
        return catgories;
    }

    @Override
    public void setCatgories(List<Catgory> catgories) {
        this.catgories = catgories;
    }

    @Override
    public Catgory getCatgory() {
        return catgory;
    }

    @Override
    public void setCatgory(Catgory catgory) {
        this.catgory = catgory;
    }

    @Override
    public long getCatgoryId() {
        return catgoryId;
    }

    @Override
    public void setCatgoryId(long catgoryId) {
        this.catgoryId = catgoryId;
    }

    @Override
    public File getImg() {
        return img;
    }

    @Override
    public void setImg(File img) {
        this.img = img;
    }

    @Override
    public String getImgFileName() {
        return imgFileName;
    }

    @Override
    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

    @Override
    public CatgoryDaoInter getCatgoryDao() {
        return catgoryDao;
    }

    @Override
    public void setCatgoryDao(CatgoryDaoInter catgoryDao) {
        this.catgoryDao = catgoryDao;
    }
}
