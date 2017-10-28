package client.model;

/**
 * @Author: Sma
 * @date: 2017-10-22 11:11
 * @explain:
 */
public class Catgory {
    private long id;
    private String name;
    private String title;
    private String urlImage;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
