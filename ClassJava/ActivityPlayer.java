import java.io.File;
import java.io.Serializable;
import java.util.Date;

public class ActivityPlayer implements Serializable{
    public class NodeActivity implements Serializable{
        public String nameActivity;
        public NodeActivity left;
        public NodeActivity right;
        public NodeActivity(NodeActivity left,String nameActivity,NodeActivity right){
            this.nameActivity=nameActivity;
            this.left=left;
            this.right=right;
        }
        
    }
    private String namePlayer;
    private String avatarPlayer;
    private NodeActivity head;
    private NodeActivity next;
    private String descript="Name of Player : ";
    private String descript2="Name of Avatar : ";
    private String descript3="Started Activities : ";
    private String line="-------------------------------------------------------------------------";
    public ActivityPlayer(String name,String avatar){
        this.namePlayer=name;
        this.avatarPlayer=avatar;
        descript=descript+name;
        descript2=descript2+avatar;
        head=null;
        next=null;
    }
    public void addActivity(String activityname){//Here we add new Activity
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
    public String getInFoActivity(){
        String allNode="";
        NodeActivity act=head;
        while(act!=null){
            allNode=allNode+act.nameActivity+"\n";
            act=act.right;
        }
        return allNode;
    }
    public boolean exist(){//Here we check if the file exist to avoid to rewrite name and avatar
        File cuSt=new File("Info//"+namePlayer+"//ACTIVITYPLAYER");
        return cuSt.exists();
    }
    public void startA(){
        if(!exist()){
            Date newPl=new Date();
            descript3=descript3+newPl.toString();
            addActivity(line);addActivity(descript);addActivity(descript2);addActivity(descript3);addActivity(line);}
    }
   
}