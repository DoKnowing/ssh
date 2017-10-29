package manager.action;

import common.dao.ClientDao;
import common.model.Client;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ManageUserAction {
    ClientDao clientDao=new ClientDao();
    List<Client> clients;
    Client client;
    private long clientId;
    private File img;
    private String imgFileName;

    public String manageUserPage(){
        this.clients=clientDao.getAllClient();
        return "success";
    }

    public String addUserPage(){
        return "success";
    }

    public String addUser(){
        clientDao.save(client);
        return "success";
    }

    public String modifyUserPage(){
        client=clientDao.getClientById(clientId);
        return "success";

    }

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
            String realPath= ServletActionContext.getServletContext().
                    getRealPath("/imgs/client/");
            File saveFile=new File(realPath,imgFileName);
            FileUtils.copyFile(img,saveFile);
            client.setImgUrl(realPath+imgFileName);
        }
        clientDao.save(client);
        return "success";

    }


    public String deleteUser(){
        Client client=clientDao.getClientById(clientId);
        clientDao.remove(client);
        return "success";
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
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
