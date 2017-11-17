package manager.action;

import common.dao.ClientDao;
import common.daoInterface.ClientDaoInter;
import common.model.Client;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
@Controller@Scope("prototype")
public class ManageUserAction implements manager.actionInterface.ManageUserActionInter {
    @Resource private ClientDaoInter clientDao;
    private List<Client> clients;
    private Client client;
    private long clientId;
    private File img;
    private String imgFileName;

    @Override
    public String manageUserPage(){
        this.clients=clientDao.getAllClient();
        return "success";
    }

    @Override
    public String addUserPage(){
        return "success";
    }

    @Override
    public String addUser() throws IOException {
        if (this.imgFileName != null && !"".equals(this.imgFileName)) {
            String relativePath="/imgs/client/";
            String realPath="E:\\Idea_Workplace\\ssh\\src\\main\\webapp\\imgs\\client";
            File saveFile = new File(realPath, this.imgFileName);
            FileUtils.copyFile(this.img, saveFile);
            client.setImgUrl(relativePath +this.imgFileName);
        }
        clientDao.save(client);
        return "success";
    }

    @Override
    public String modifyUserPage(){
        client=clientDao.getClientById(clientId);
        return "success";

    }

    @Override
    public String modifyUser() throws IOException {
        Client client=clientDao.getClientById(clientId);
        if(client.getName()!=null && !"".equals(client.getName())){
            client.setName(client.getName());
        }
        if(client.getGender()!=null && !"".equals(client.getGender())){
            client.setGender(client.getGender());
        }
        if(client.getAge()>0){
            client.setAge(client.getAge());
        }
        if(client.getEmail()!=null && !"".equals(client.getEmail())){
            client.setEmail(client.getEmail());
        }
        if(imgFileName!=null && !"".equals(imgFileName)){
            String relativePath="/imgs/client/";
            String realPath="E:\\Idea_Workplace\\ssh\\src\\main\\webapp\\imgs\\client";
            File saveFile = new File(realPath, this.imgFileName);
            FileUtils.copyFile(this.img, saveFile);
            client.setImgUrl(relativePath +this.imgFileName);
        }
        clientDao.save(client);
        return "success";

    }


    @Override
    public String deleteUser(){
        Client client=clientDao.getClientById(clientId);
        clientDao.remove(client);
        return "success";
    }

    @Override
    public List<Client> getClients() {
        return clients;
    }

    @Override
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public long getClientId() {
        return clientId;
    }

    @Override
    public void setClientId(long clientId) {
        this.clientId = clientId;
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
    public ClientDaoInter getClientDao() {
        return clientDao;
    }

    @Override
    public void setClientDao(ClientDaoInter clientDao) {
        this.clientDao = clientDao;
    }
}
