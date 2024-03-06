import java.io.Serializable;

public class ActivityPlayer implements Serializable{
    public class NodeActivity{
        private String nameActivity;
        private NodeActivity left;
        private NodeActivity right;
        public NodeActivity(NodeActivity left,String nameActivity,NodeActivity right){
            this.nameActivity=nameActivity;
            this.left=left;
            this.right=right;
        }
    }
    private String namePlayer;
    private NodeActivity head;
    private NodeActivity next;
    public ActivityPlayer(String name){
        this.namePlayer=name;
        head=null;
        next=null;
    }
    public void addActivity(String activityname){///Continue-------
        NodeActivity newOne=new NodeActivity(null, activityname, null);
        if(head==null){
            head=newOne;
            next=newOne;
        }
        else{
            newOne.left=next;
            next.right=newOne;
            next=newOne;
        }
    }
   
}