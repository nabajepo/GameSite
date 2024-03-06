import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;

public class MainActivity extends JFrame{
    private JButton Tic_Tac_Toe;
    private JButton PlayMusicList;
    private JFrame loadingChoose;
    private JProgressBar barLoading;
    private String name;
    private String avatar;
    private JLabel labelHelp;
    private Border border;
    private JLabel avatLabel;
    private ImageIcon imageAvat;
    private ImageIcon TicTacIcon;
    private ImageIcon musicIcon;
    private ImageIcon iconGame;
    private JLabel textTicA;
    private JLabel textMusicA;
    private JButton ready;
    private JButton back;
    public MainActivity(String name,String avatar){
        ///////////Store important value
        this.name=name;
        this.avatar=avatar;
        iconGame=new ImageIcon("ImagesGameSite//ImageProjetEntier.jpg");
        imageAvat=new ImageIcon(avatar);
        TicTacIcon=new ImageIcon("ImagesGameSite//GameButton//Tic_Tac_ToeButton.PNG");
        musicIcon=new ImageIcon("ImagesGameSite//GameButton//PlayMusicListButton.PNG");
        ///////////We make a frame appropriate and his own action
        buildFrameMain();
        /////here we set frameVisible
        this.setVisible(true);
        
    }
    private void buildFrameMain(){
        this.setTitle("MainActivity");
        this.setIconImage(iconGame.getImage());
        this.getContentPane().setBackground(Color.BLACK);
        this.setBounds(400,120,800,430);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        ///Here we build the border
        border=BorderFactory.createLineBorder(Color.WHITE,3);
         //Here we make the label profil
         this.add(avatJLabel());
        ///Here we make the first label and add tit
        this.add(helpLabel());
        ///Here we add Button Tic Tac Toe
        this.add(chooseTicTacToe());
        ///Here we make the the PlayList button
        this.add(choosePlayMusicList());
        ////////////Here we make TicTacToe Logo
        this.add(displayTicTacLogo());
          ////////////Here we make Music logo
        this.add(displayMusicLogo());
       

    }
    private void closeFrameMain(){
        this.dispose();
    }
    private JLabel avatJLabel(){
        avatLabel=new JLabel();
        avatLabel.setHorizontalAlignment(JLabel.CENTER);
        avatLabel.setVerticalAlignment(JLabel.CENTER);
        avatLabel.setBounds(350,5,imageAvat.getIconWidth(),imageAvat.getIconHeight());
        avatLabel.setIcon(imageAvat);
        avatLabel.setBorder(border);
        return avatLabel;
    }
    private JLabel helpLabel(){
        labelHelp=new JLabel();
        border=BorderFactory.createLineBorder(Color.GREEN,3);
        labelHelp.setText(" Please click on a GameSite below  "+name);
        labelHelp.setHorizontalAlignment(JLabel.CENTER);
        labelHelp.setVerticalAlignment(JLabel.CENTER);
        labelHelp.setBounds(0,avatLabel.getHeight()+5,785,40);
        labelHelp.setForeground(Color.white);
        labelHelp.setFont(new Font(null,Font.ITALIC,20));
        labelHelp.setBackground(Color.BLACK);
        labelHelp.setBorder(border);
        return labelHelp;
    }
    private JButton chooseTicTacToe(){
        Tic_Tac_Toe=new JButton();
        border=BorderFactory.createLineBorder(Color.ORANGE,3);
        Tic_Tac_Toe.setIcon(TicTacIcon);
        Tic_Tac_Toe.setBounds(0,190,TicTacIcon.getIconWidth(),TicTacIcon.getIconHeight());
        Tic_Tac_Toe.setBorder(border);
        Tic_Tac_Toe.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e){
                newFrameLoadind("ImagesGameSite//GameButton//Tic_Tac_Toeload.PNG",
                                " play game ,please click on start");
                ready.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        JOptionPane.showMessageDialog(null, "Not available for moment", "Information", JOptionPane.INFORMATION_MESSAGE);
                        /////////////We continue here
                        

                    }
                   });
            }
        });
        return this.Tic_Tac_Toe;
    }
    private JButton choosePlayMusicList(){
        PlayMusicList=new JButton();
        border=BorderFactory.createLineBorder(Color.YELLOW,3);
        PlayMusicList.setIcon(musicIcon);
        PlayMusicList.setBounds(620,190,TicTacIcon.getIconWidth(),TicTacIcon.getIconHeight());
        PlayMusicList.setBorder(border);
        PlayMusicList.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e){
                newFrameLoadind("ImagesGameSite//GameButton//PlayMusicListload.PNG",
                                " listen some music,please click on start");
                ready.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        closeFrameMain();
                        loadingChoose.dispose();
                        PlayMusic playMusic=new PlayMusic(name, avatar,400);
                    }
                   });
            }
        });
        return PlayMusicList;
    }
    private JLabel displayTicTacLogo(){
        textTicA=new JLabel("TicTacToe");
        border=BorderFactory.createLineBorder(Color.PINK,3);
        textTicA.setBounds(28,342,100,40);
        textTicA.setHorizontalAlignment(JLabel.CENTER);
        textTicA.setVerticalAlignment(JLabel.CENTER);
        textTicA.setFont(new Font(null,Font.ITALIC,20));
        textTicA.setForeground(Color.MAGENTA);
        textTicA.setBackground(Color.BLACK);
        textTicA.setBorder(border);
        return textTicA;
   }
    private JLabel displayMusicLogo(){
         textMusicA=new JLabel("Music");
         border=BorderFactory.createLineBorder(Color.PINK,3);
         textMusicA.setHorizontalAlignment(JLabel.CENTER);
         textMusicA.setVerticalAlignment(JLabel.CENTER);
         textMusicA.setBounds(652,342,100,40);
         textMusicA.setFont(new Font(null,Font.ITALIC,20));
         textMusicA.setForeground(Color.MAGENTA);
         textMusicA.setBackground(Color.BLACK);
         textMusicA.setBorder(border);
         return textMusicA;
    }
    private void newFrameLoadind(String logo,String type){
       ImageIcon choose=new ImageIcon(logo);
       closeFrameMain();
       //here we make a frame of loading
       loadingChoose=new JFrame("Loading information wait 5 seconds...");
       loadingChoose.getContentPane().setBackground(Color.BLACK);
       loadingChoose.setBounds(this.getX(),this.getY(),choose.getIconWidth(),choose.getIconHeight()+161);
       loadingChoose.setIconImage(iconGame.getImage());
       loadingChoose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       loadingChoose.setResizable(false);
       loadingChoose.setLayout(null);
       ///////Here we make and add the ImageChargement
       JLabel loadLabel=new JLabel();
       loadLabel.setIcon(choose);
       loadLabel.setBounds(0,0,choose.getIconWidth(),choose.getIconHeight());
       loadLabel.setBackground(Color.BLACK);
       loadingChoose.add(loadLabel);
       ///////Here we make a bar progression
       barLoading=new JProgressBar();
       barLoading.setValue(0);
       barLoading.setBounds(0,choose.getIconHeight()+1,choose.getIconWidth()-17,40);
       barLoading.setStringPainted(true);
       barLoading.setFont(new Font(null,Font.ITALIC,20));
       barLoading.setForeground(Color.GREEN);
       barLoading.setBackground(Color.BLACK);
       loadingChoose.add(barLoading);
       WaitLoading(type);
       /////Here we make ready Button
       ready=new JButton("Start ");
       ready.setBounds(0,choose.getIconHeight()+41,choose.getIconWidth()-17,40);
       ready.setBackground(Color.magenta);
       ready.setFont(new Font(null,Font.ITALIC,20));
       ready.setForeground(Color.WHITE);
       ready.setEnabled(false);
       loadingChoose.add(ready);
       ////Here we make back Button
       back=new JButton("Back");
       back.setBounds(0,choose.getIconHeight()+81,choose.getIconWidth()-17,40);
       back.setBackground(Color.ORANGE);
       back.setFont(new Font(null,Font.ITALIC,20));
       back.setForeground(Color.WHITE);
       loadingChoose.add(back);
       back.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            loadingChoose.dispose();
            MainActivity newOne=new MainActivity(name, avatar);
         }
       });
       //////Here we make all the component visible
       loadingChoose.setVisible(true);
    }
    private void WaitLoading(String type){
        Date date=new Date();
        String[] precision=date.toString().split(" ");
        int month=MonthSelection(precision[1]);
        String[] time=realTime(precision[3]);
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            int load=barLoading.getValue();
            public void run(){
                if(barLoading.getValue()<100){
                    barLoading.setValue(load);
                    load=load+20;
                }
                else{
                    loadingChoose.setTitle("Loading completed ");
                    ready.setEnabled(true);
                    barLoading.setString("Let's "+type);
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
