package client.model;

import java.util.Date;
import java.util.List;

/**
 * @Author: Sma
 * @date: 2017-10-22 11:11
 * @explain:
 */
public class Activity {
    private long id;
    private String name;
    private Date time;
    private String location;
    private Client initiator;
    private String outline;
    private String detail;
    private Catgory catgory;
    private List<Client> participators;
    private String[] imgs;
    private String status;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Client getInitiator() {
        return initiator;
    }

    public void setInitiator(Client initiator) {
        this.initiator = initiator;
    }

    public List<Client> getParticipators() {
        return participators;
    }

    public void setParticipators(List<Client> participators) {
        this.participators = participators;
    }

    public String[] getImgs() {
        return imgs;
    }

    public void setImgs(String[] imgs) {
        this.imgs = imgs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Catgory getCatgory() {
        return catgory;
    }

    public void setCatgory(Catgory catgory) {
        this.catgory = catgory;
    }
}
