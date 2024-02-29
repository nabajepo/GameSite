import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class Preparation_Page extends JFrame {
    private JLabel avatar;
    private JLabel nameLabel;
    private JLabel loading;
    private JProgressBar barLoading;
    private JLabel data;
    private String avatarWay;
    private JButton go;
    private ImageIcon logoFrame;
    private ImageIcon  imageAvatar;
    private Border labelBorder;
    private String nameGam;
    public Preparation_Page(String name,String avatar){
        logoFrame=new ImageIcon("ImagesGameSite//ImageProjetEntier.jpg");
        imageAvatar=new ImageIcon(avatar);
        labelBorder=BorderFactory.createLineBorder(Color.GREEN,3);
        nameGam=name;
        avatarWay=avatar;
        ////////BuildFrame
        //////////Brouillon to makeFrame
        buildFrame();
        /////////set frame to visible
        this.setVisible(true);

    }
   
    private void buildFrame(){
        this.setTitle("Preparation_Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(logoFrame.getImage());
        this.setLayout(null);
        this.setBounds(440,90,600,480);
        this.getContentPane().setBackground(Color.BLACK);
        // Here we make and add the First label
        this.add(avatarBuild());
        //Here we make and add the nameLabel
        this.add(nameLabelBuild());
        //Here we make and add the loadingLabel
        this.add(loadingBuild());
        // Here we make and add loadingBar
        this.add(barLoadingBuild());
       //Here we make and add DataBuild
        this.add(dataBuild());
       //Here we make loading progress
        WaitLoading();
       //Here is  the representation of goButton
        this.add(goBuild());
       //Here is the representation of forgot_password
      // this.add(forget_passwordButton());
       //here we make changeBackground label too gray 
      //  this.add(changeBackgroundColorLabel());
        
    }
    private JLabel avatarBuild(){
        avatar=new JLabel();
        labelBorder=BorderFactory.createLineBorder(Color.PINK,3);
        avatar.setHorizontalAlignment(JLabel.CENTER);
        avatar.setVerticalAlignment(JLabel.TOP);
        avatar.setIcon(imageAvatar);
        avatar.setBounds(250,10,imageAvatar.getIconWidth(),imageAvatar.getIconHeight());
        avatar.setBorder(labelBorder);
        return avatar;
    }
    private JLabel nameLabelBuild(){
        nameLabel=new JLabel();
        labelBorder=BorderFactory.createLineBorder(Color.PINK,3);
        nameLabel.setText(nameGam);/// Here we put name
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setVerticalAlignment(JLabel.CENTER);
        nameLabel.setBounds(178,imageAvatar.getIconHeight()+15,250,40);
        nameLabel.setForeground(Color.PINK);
        nameLabel.setFont(new Font(null,Font.BOLD,20));
        nameLabel.setBorder(labelBorder);
        nameLabel.setBackground(Color.BLACK);
        return nameLabel;
    }
    private JLabel loadingBuild(){
        loading=new JLabel();
        labelBorder=BorderFactory.createLineBorder(Color.PINK,3);
        loading.setText("Loading.......");
        loading.setHorizontalAlignment(JLabel.LEFT);
        loading.setVerticalAlignment(JLabel.CENTER);
        loading.setBounds(0,nameLabel.getY()+50,150,40);
        loading.setForeground(Color.YELLOW);
        loading.setFont(new Font(null,Font.ITALIC,20));
        loading.setBorder(labelBorder);
        loading.setBackground(Color.BLACK);
        return loading;
    }
    private JProgressBar barLoadingBuild(){
        barLoading=new JProgressBar();
        barLoading.setValue(0);
        barLoading.setBounds(151,loading.getY(),400,40);
        barLoading.setStringPainted(true);
        barLoading.setFont(new Font(null,Font.ITALIC,20));
        barLoading.setForeground(Color.ORANGE);
        barLoading.setBackground(Color.BLACK);
        return barLoading;
    }
    private JLabel dataBuild(){
        data=new JLabel();
        data.setText("");
        data.setHorizontalAlignment(JLabel.CENTER);
        data.setVerticalAlignment(JLabel.CENTER);
        data.setBounds(barLoading.getX()+30,barLoading.getY()+50,300,40);
        data.setForeground(Color.white);
        data.setFont(new Font(null,Font.ITALIC,20));
        data.setBackground(Color.BLACK);
        return data;
    }
   
    private JButton goBuild(){
        go=new JButton("Go");
       go.setBounds(data.getX()+75,data.getY()+80,221,40);
       labelBorder=BorderFactory.createLineBorder(Color.green,3);
       go.setBackground(Color.BLUE);
       go.setForeground(Color.WHITE);
       go.setHorizontalAlignment(JButton.CENTER);
       go.setVerticalAlignment(JButton.CENTER);
       go.setFont(new Font(null,Font.BOLD,30));
       go.setBorder(labelBorder); 
       go.setEnabled(false);
       go.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
           closeFramePreparation();
           MainActivity goPlay=new MainActivity(nameGam, avatarWay);
        }
       });
        return go;
    }
    private void WaitLoading(){
        Date date=new Date();
        String[] precision=date.toString().split(" ");
        int month=MonthSelection(precision[1]);
        String[] time=realTime(precision[3]);
        String[] dataExchange=new String[6];
        dataExchange[0]="Data loading ............";
        dataExchange[1]="Class loading ............";
        dataExchange[2]="Data transfer ............";
        dataExchange[3]="Info transfert ...........";
        dataExchange[4]="Enclose all info ..........";
        dataExchange[5]="We are ready to go"+"\n"+
                         " Click on Go";
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            int load=barLoading.getValue();
            int dataChange=0;
            public void run(){
                if(barLoading.getValue()<100){
                    barLoading.setValue(load);
                    load=load+20;
                    data.setText(dataExchange[dataChange]);
                    dataChange++;
                }
                else{
                    go.setEnabled(true);
                    barLoading.setString("Loading completed");
                    timer.cancel();
                }
            }
            
        };
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.YEAR,Integer.parseInt(precision[5]));
        cal.set(Calendar.MONTH,month);
        cal.set(Calendar.DAY_OF_MONTH,Integer.parseInt(precision[2]));
        cal.set(Calendar.HOUR_OF_DAY,Integer.parseInt(time[0]));
        cal.set(Calendar.MINUTE,Integer.parseInt(time[1]));
        cal.set(Calendar.SECOND,Integer.parseInt(time[2])+5);
        cal.set(Calendar.MILLISECOND,0);
        timer.scheduleAtFixedRate(task,cal.getTime(),1000);

    }
    private String[] realTime(String time){
        String[] timing=time.split(":");
        int hour=Integer.parseInt(timing[0]);
        int minute=Integer.parseInt(timing[1]);
        int sec=Integer.parseInt(timing[2]);
        if(sec+5>=60){
            minute++;
            timing[2]="05";
        }
        if(minute>=60){
            hour++;
            timing[1]="00";
            timing[2]="05";
        }
        if(hour>23){
            timing[0]="00";
            timing[1]="00";
            timing[2]="05";
        }
        return timing;
    }
    private void closeFramePreparation(){
        this.dispose();
    }
    private int MonthSelection(String month){
        String[] monhtsAbr={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        int index=0;
        while(index<monhtsAbr.length){
            if(month.equals(monhtsAbr[index])){
                break;
            }
            index++;
        }
        return index;
    }




}
