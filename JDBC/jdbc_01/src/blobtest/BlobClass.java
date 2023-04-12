package blobtest;

/**
 * @author muchen
 * @create 2023 - 01 - 2023/1/7 14:12
 */
public class BlobClass {
    private int id;
    private String name;
    private String email;
    private String birth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public BlobClass() {
    }

    public BlobClass(int id, String name, String email, String birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }




    @Override
    public String
    toString() {
        return "BlobClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}
