package client.actionInterface;

import client.daoInterface.AddressDaoInter;
import client.model.AuthMessage;
import client.model.Province;
import common.daoInterface.ClientDaoInter;

import java.io.IOException;
import java.util.List;

public interface AuthenticationActionInter {
    String authPage();

    String authentication() throws Exception;

    String beginAuthentication(String sendJson) throws Exception;

    String getCity() throws IOException;

    String authMessagePage();

    AuthMessage getMessage();

    void setMessage(AuthMessage message);

    List<Province> getProvinces();

    void setProvinces(List<Province> provinces);

    long getProvinceId();

    void setProvinceId(long provinceId);

    String getReturnCity();

    void setReturnCity(String returnCity);

    ClientDaoInter getClientDao();

    void setClientDao(ClientDaoInter clientDao);

    AddressDaoInter getAddressDao();

    void setAddressDao(AddressDaoInter addressDao);
}
