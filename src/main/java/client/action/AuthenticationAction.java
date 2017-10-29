package client.action;

import client.dao.AddressDao;
import common.dao.ClientDao;
import client.model.AuthMessage;
import common.model.Client;
import client.model.Province;
import com.opensymphony.xwork2.ActionContext;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthenticationAction {
    private ClientDao clientDao=new ClientDao();
    private AddressDao addressDao=new AddressDao();
    private AuthMessage message;
    private List<Province> provinces;

    private long provinceId;
    private String returnCity;

    public String authPage(){
        Client user=(Client) ActionContext.getContext().getSession().get("client");
        if(user.getIsAuthenticated()==1){
            return "authMessage";
        }
        provinces=addressDao.getProvinces();
        return "success";
    }

    public String authentication() throws Exception {
        Map map=new HashMap();
        if(message.getRealName()!=null && !"".equals(message.getRealName())) {
            map.put("name", message.getRealName());
        }
        if(message.getRealName()!=null && !"".equals(message.getRealName())) {
            map.put("location", message.getLocation());
        }
        if(message.getRealName()!=null && !"".equals(message.getRealName())) {
            map.put("provinceId", message.getProvinceId());
        }
        if(message.getRealName()!=null && !"".equals(message.getRealName())) {
            map.put("cityId", message.getCityId());
        }
        if(message.getRealName()!=null && !"".equals(message.getRealName())) {
           map.put("mode", message.getMode());
        }
        JSONObject json = JSONObject.fromObject(map);

        String result;
//        result=beginAuthentication(json.toString());
//        json=JSONObject.fromObject(result);
//
//        if(json.get("result").isok==true {
            Client user = (Client) ActionContext.getContext().getSession().get("client");
            user.setIsAuthenticated(1);
//            user.setInstitution(json.get("result").insititution);
            user.setInstitution("华南理工大学");
            clientDao.save(user);
//        }
        return "success";
    }

    public String beginAuthentication(String sendJson) throws Exception {
        String result;
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://apis.haoservice.com/idcard/VerifyIdcard");
        post.setHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Basic YWRtaW46");
        StringEntity s = new StringEntity(sendJson.toString(), "utf-8");
        s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json"));
        post.setEntity(s);

        HttpResponse httpResponse = client.execute(post);

        InputStream inStream = httpResponse.getEntity().getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader( inStream, "utf-8"));
        StringBuilder strber = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null)
            strber.append(line + "\n");
         inStream.close();

         result = strber.toString();
         return result;
    }
    public String getCity() throws IOException {
        Map cities=addressDao.getCitiesByProvId(provinceId);
        JSONObject json = JSONObject.fromObject(cities);
        returnCity=json.toString();
        return "success";
    }


    public String authMessagePage(){
        return "success";
    }

    public AuthMessage getMessage() {
        return message;
    }

    public void setMessage(AuthMessage message) {
        this.message = message;
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    public long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(long provinceId) {
        this.provinceId = provinceId;
    }

    public String getReturnCity() {
        return returnCity;
    }

    public void setReturnCity(String returnCity) {
        this.returnCity = returnCity;
    }
}
