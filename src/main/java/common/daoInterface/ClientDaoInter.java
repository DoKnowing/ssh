package common.daoInterface;

import common.model.Client;

import java.util.List;

public interface ClientDaoInter {
    void save(Client client);

    Client find(String email);

    void update(Client client);

    Client getClientById(long id);

    Client getClientByEmail(String email);

    List<Client> getAllClient();

    void remove(Client client);

    Client getClient(Client oriClient);
}
