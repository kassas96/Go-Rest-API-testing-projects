package Models;

public class CreateRequestModel {
  public  int user_id ;
   public String title;
  public   String due_on ;
  public   String status;

    public CreateRequestModel() {
    }

    public CreateRequestModel(int u, String t, String due_on, String status) {
        this.user_id = u;
        this.title = t;
        this.due_on = due_on;
        this.status = status;
    }

}
