package manager.action;

import client.dao.ClientDao;
import client.model.Client;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;

public class ManageUserAction {
    ClientDao clientDao=new ClientDao();
    List<Client> clients;
    Client client;
    long clientId;

    public String manageUserPage(){
        this.clients=clientDao.getAllClient();
        return "success";
    }

    public String addUserPage(){
        clientDao.save(client);
        return "success";
    }

    public String addUser(){
        return "success";
    }

    public String modifyUserPage(){
        client=clientDao.getClientById(clientId);
        return "success";

    }

    public String modifyUser(){
        Client client=clientDao.getClientById(clientId);
        if(!client.getName().equals("")){
            client.setName(client.getName());
        }
        if(!client.getGender().equals("")){
            client.setGender(client.getGender());
        }
        if(client.getAge()>0){
            client.setAge(client.getAge());
        }
        if(!client.getEmail().equals("")){
            client.setEmail(client.getEmail());
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
}
