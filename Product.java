//package test;
public class Product {

    private String namn;
    private String tel;
    private String email;
    private String info;

    public Product(){
        this.namn = "";
        this.tel = "";
        this.email = "";
        this.info="";
    }

    public Product(String name, String tel, String email,String info){
        this.namn = name;
        this.tel = tel;
        this.email = email;
        this.info= info;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String name) {
        this.namn = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }

}