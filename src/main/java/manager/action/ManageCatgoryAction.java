package manager.action;

import common.dao.CatgoryDao;
import common.model.Catgory;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Sma
 * @date: 2017-10-28 15:07
 * @explain:
 */
public class ManageCatgoryAction {
    CatgoryDao catgoryDao=new CatgoryDao();
    List<Catgory> catgories;
    Catgory catgory;
    private long catgoryId;
    private File img;
    private String imgFileName;

    public String manageCatgoryPage(){
        this.catgories=catgoryDao.getCatgories();
        return "success";
    }

    public String addCatgoryPage(){
        return "success";
    }

    public String addCatgory() throws IOException {
        if(imgFileName!=null && !"".equals(imgFileName)){
            String realPath= ServletActionContext.getServletContext().
                    getRealPath("/imgs/catgory/");
            File saveFile=new File(realPath,imgFileName);
            FileUtils.copyFile(img,saveFile);
            catgory.setUrlImage(realPath+imgFileName);
        }
        catgoryDao.save(catgory);
        return "success";
    }

    public String modifyCatgoryPage(){
        catgory=catgoryDao.getCategoryById(catgoryId);
        return "success";
    }

    public String modifyCatgory() throws IOException {
        Catgory client=catgoryDao.getCategoryById(catgoryId);
        if(catgory.getName()!=null && !"".equals(catgory.getName())){
            catgory.setName(catgory.getName());
        }
        if(catgory.getTitle()!=null && !"".equals(catgory.getTitle())){
            catgory.setTitle(catgory.getTitle());
        }
        if(imgFileName!=null && !"".equals(imgFileName)){
            String realPath= ServletActionContext.getServletContext().
                    getRealPath("/imgs/catgory/");
            File saveFile=new File(realPath,imgFileName);
            FileUtils.copyFile(img,saveFile);
            catgory.setUrlImage(realPath+imgFileName);
        }
        catgoryDao.save(catgory);
        return "success";
    }

    public String deleteCatgory(){
        Catgory catgory=catgoryDao.getCategoryById(catgoryId);
        catgoryDao.remove(catgory);
        return "success";
    }

    public List<Catgory> getCatgories() {
        return catgories;
    }

    public void setCatgories(List<Catgory> catgories) {
        this.catgories = catgories;
    }

    public Catgory getCatgory() {
        return catgory;
    }

    public void setCatgory(Catgory catgory) {
        this.catgory = catgory;
    }

    public long getCatgoryId() {
        return catgoryId;
    }

    public void setCatgoryId(long catgoryId) {
        this.catgoryId = catgoryId;
    }

    public File getImg() {
        return img;
    }

    public void setImg(File img) {
        this.img = img;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }
}
