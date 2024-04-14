package Models;

public class CteateResponseModel {

    public String id;
    public  int user_id ;
    public String title;
    public   String due_on ;
    public   String status;

    public CteateResponseModel() {
    }

    public CteateResponseModel(String id,int u, String t, String due_on, String status) {
        this.id =id;
        this.user_id = u;
        this.title = t;
        this.due_on = due_on;
        this.status = status;
    }
}
