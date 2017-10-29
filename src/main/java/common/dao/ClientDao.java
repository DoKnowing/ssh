package common.dao;

import common.model.Client;

import java.util.LinkedList;
import java.util.List;

public class ClientDao {
    public void save(Client client){

    }

    public Client find(String email){
        return null;
    }

    public void update(Client client1) {

    }

    public Client getClientById(long id){
        Client client=new Client();
        client.setName("lq");
        client.setAge(3);
        client.setGender("女");
        client.setIsAuthenticated(1);
        client.setInstitution("华南理工大学");
        client.setImgUrl("imgs/1.jpg");
        return client;
    }

    public Client getClientByEmail(String email){
        Client client=new Client();
        client.setIsAuthenticated(1);
        client.setInstitution("1");
        return client;
    }

    public List<Client> getAllClient() {
        List<Client> clients=new LinkedList<>();
        Client client=new Client();
        client.setName("lq");
        client.setAge(3);
        client.setGender("女");
        client.setIsAuthenticated(1);
        client.setInstitution("华南理工大学");
        client.setImgUrl("imgs/1.jpg");
        clients.add(client);
        return clients;

    }

    public void remove(Client client) {
    }

    public Client getClient(Client oriClient) {
        Client client=new Client();
        client.setName("lq");
        client.setAge(3);
        client.setGender("女");
        client.setIsAuthenticated(1);
        client.setInstitution("华南理工大学");
        client.setImgUrl("imgs/1.jpg");
        return client;
    }
}
