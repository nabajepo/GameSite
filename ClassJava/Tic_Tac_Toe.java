import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import java.util.Calendar;
import java.util.Random;
import java.util.TimerTask;
import java.util.Date;
import java.util.Timer;

import javax.swing.*;
public class Tic_Tac_Toe extends JFrame {
    private JButton start;
    private JButton back;
    private ImageIcon icon; 
    private JComboBox<String> playAvailable;
    private JLabel avatarLabel;
    private JLabel namePly;
    private JLabel avatarNewPlayer;
    private JFrame newP;
    private JProgressBar pl1;
    private JProgressBar pl2;
    private JLabel count;
    private JFrame startCount;
    ////////////////////////////////////////
    private String namePlayer;
    private String newPlayerName;
    private String namePlayerAvatar;
    private String newPlayerAvatar;
    private int playerQuantity;
    private ActivityPlayer actTic;
    private File nameFile;
    private String niv1="EASY";
    private String niv2="DIFFICULT";
    private JFrame frameR;
    public Tic_Tac_Toe(String name,String avatar){
        this.namePlayer=name;
        this.namePlayerAvatar=avatar;
        icon=new ImageIcon("ImagesGameSite//ImageProjetEntier.jpg");
        actTic=new ActivityPlayer(name, avatar);
        playerQuantity=1;
        nameFile=new File("Info//"+name+"//ACTIVITYPLAYER");
        avatarNewPlayer=new JLabel();
        pl1=new JProgressBar();
        pl1.setValue(0);
        pl2=new JProgressBar();
        pl2.setValue(0);
        howManyPlayer();
    }
    private void howManyPlayer(){/////Here we choose how many Are going to play
      JFrame frameChoose=new JFrame("Choose how much player");
      /////////////////////////////////////////////////////fo level(1)
       String[] nivAv={niv1,niv2};
       JComboBox<String> niv=new JComboBox<>(nivAv);
        ///////////////////////////////////////////////////for Logo label
        ImageIcon avatP=new ImageIcon(namePlayerAvatar);
        avatarLabel=new JLabel();
        avatarLabel.setIcon(avatP);
        avatarLabel.setBounds(230,5,avatP.getIconWidth(),avatP.getIconHeight());
        //////////////////////////////////////////////////For name
        namePly=new JLabel(namePlayer);
        namePly.setBounds(avatarLabel.getX()+avatarLabel.getWidth(),5,avatP.getIconWidth()+5,25);
        namePly.setForeground(Color.WHITE);
        namePly.setBackground(Color.GRAY);
        namePly.setFont(new Font(null,Font.BOLD,20));
        namePly.setHorizontalAlignment(JLabel.CENTER);
        namePly.setHorizontalTextPosition(JLabel.CENTER);
        namePly.setVerticalAlignment(JLabel.CENTER);
        namePly.setVerticalTextPosition(JLabel.CENTER);
        namePly.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
        /////////////////////////////////////////////////// for Combox
        String[] player={"1 player","2 players"};
        playAvailable=new JComboBox<>(player);
        playAvailable.setBackground(Color.ORANGE);
        playAvailable.setBounds(70,avatarLabel.getHeight()+40,400,40);
        playAvailable.setForeground(Color.black);
        playAvailable.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e){//To complete
             if(playAvailable.getSelectedIndex()==0){
                playerQuantity=1;
                niv.setEnabled(true);
             }
             else{
                playerQuantity=2;
                niv.setEnabled(false);
             }
          }  
        });
        //////////////////////////////////////////////////////////For difficulty level(2)
        niv.setBackground(Color.pink);
        niv.setBounds(70,avatarLabel.getHeight()+90,400,40);
        niv.setForeground(Color.black);
        //////////////////////////////////////////////////////////For label level
        JLabel level=new JLabel("Level: ");
        level.setFont(new Font(null,Font.BOLD,20)) ;
        level.setForeground(Color.BLACK);
        level.setBackground(Color.GRAY);
        level.setBounds(0,avatarLabel.getHeight()+90,100,40);
        //////////////////////////////////////////////////////////For Button back
        JButton backToMain=new JButton("Back");
        backToMain.setBounds(70,avatarLabel.getHeight()+140,185,40);
        backToMain.setBackground(Color.ORANGE);
        backToMain.setForeground(Color.WHITE);
        backToMain.setFont(new Font(null,Font.ROMAN_BASELINE,20));
        backToMain.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
              //MainActivity back=new MainActivity(namePlayer, namePlayerAvatar);
           }
        });
        //////////////////////////////////////////////////////////For button Continue
        JButton continueT=new JButton("Continue");
        continueT.setBounds(285,avatarLabel.getHeight()+140,185,40);
        continueT.setBackground(Color.GREEN);
        continueT.setForeground(Color.WHITE);
        continueT.setFont(new Font(null,Font.ROMAN_BASELINE,20));
        continueT.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e){
                playAvailable.setEnabled(false);
                niv.setEnabled(false);
                if(playerQuantity==2){
                  frameChoose.dispose();
                   TooPlayer();
                }
                else{
                   frameChoose.dispose();
                   OnePlayer(nivAv[niv.getSelectedIndex()]);
                }
             }
        });
        ////////////////////////////////////////////////////////// for Frame
        frameChoose.setIconImage(icon.getImage());
        frameChoose.setBounds(440,90,550,390);
        frameChoose.setResizable(false);
        frameChoose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameChoose.getContentPane().setBackground(Color.gray);
        frameChoose.setLayout(null);
        frameChoose.add(avatarLabel);
        frameChoose.add(namePly);
        frameChoose.add(playAvailable);
        frameChoose.add(level);
        frameChoose.add(niv);
        frameChoose.add(backToMain);
        frameChoose.add(continueT);
        frameChoose.setVisible(true);
    }
    //private void chooseTool(){
    //}//:Here we choose what we play with
    private void TooPlayer(){
      newP=new JFrame("Player Too"); 
      newP.setIconImage(icon.getImage());
      newP.getContentPane().setBackground(Color.gray);
      newP.setBounds(440,90,550,390);
      newP.setLayout(null);
      ///////////////////////////////
      JLabel newPlayer=new JLabel("Second Player name:");
      newPlayer.setBackground(Color.GRAY);
      newPlayer.setFont(new Font(null,Font.BOLD,20));
      newPlayer.setForeground(Color.BLACK);
      newPlayer.setBounds(5,10,200,40);
      /////////////////////////////////
      JLabel labelAv=new JLabel("Choose your avatar:");
      labelAv.setBackground(Color.GRAY);
      labelAv.setFont(new Font(null,Font.BOLD,20));
      labelAv.setForeground(Color.BLACK);
      labelAv.setBounds(5,200,200,30);
      //////////////////////////////
      JTextField insertName=new JTextField("need at least and more 8 chars");
      insertName.setFont(new Font(null,Font.ITALIC,20));
      insertName.setForeground(Color.BLACK);
      insertName.setBackground(Color.WHITE);
      insertName.setBounds(227,18,300,30);
      insertName.setCaretColor(Color.GREEN);
      /////////////////////////////
      JButton back=new JButton("back");
        back.setBounds(5,300,185,40);
        back.setBackground(Color.ORANGE);
        back.setForeground(Color.WHITE);
        back.setFont(new Font(null,Font.ROMAN_BASELINE,20));
        back.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
              newP.dispose();
              howManyPlayer();
           }
        });
        ////////////////////////////////////
        JButton continu=new JButton("Continue");
        continu.setBounds(340,300,185,40);
        continu.setBackground(Color.GREEN);
        continu.setForeground(Color.WHITE);
        continu.setFont(new Font(null,Font.ROMAN_BASELINE,20));
        continu.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e){
                String[] nameSec=insertName.getText().trim().split("");
                if(nameSec.length>8||nameSec.length<8){
                  JOptionPane.showMessageDialog(insertName, "We need 8 chars", "Error about second player name", JOptionPane.ERROR_MESSAGE);
                }
                else{
                  newPlayerName=insertName.getText().trim();
                  newPlayerAvatar="AvatarImage//"+playAvailable.getSelectedItem()+".PNG";
                  newP.dispose();
                  letPlayTicWithTwo(startWithP());
                }
             }
        });
      
      /////////////////////////////
      newP.add(newPlayer);
      newP.add(insertName);
      newP.add(labelAv);
      newP.add(ChooseAvatarTic());
      newP.add(back);
      newP.add(continu);
      newP.setVisible(true);



    }
    private void OnePlayer(String getNiv){
      String chooseTool="";
      String x="X";
      String o="O";
      while(true){
         chooseTool=JOptionPane.showInputDialog("Choose your tool X or O").toUpperCase().trim();
         if(chooseTool.equals(o)||chooseTool.equals(x)){
            JOptionPane.showMessageDialog(null, "You chose player : "+chooseTool, "Player", JOptionPane.INFORMATION_MESSAGE);
            break;
         }
         
      }
      newPlayerName="robot";
      letPlayTicWithOne(startWithP(),getNiv);
      
    }
    private void avatarDisplay(ImageIcon image){
      avatarNewPlayer.setBackground(Color.BLACK);
      avatarNewPlayer.setIcon(image);
      avatarNewPlayer.setBounds(340,57,image.getIconWidth(),image.getIconHeight());
      newP.add(avatarNewPlayer);
  }
  private JComboBox<String> ChooseAvatarTic(){
      String[] avatar={"Avatar1","Avatar2","Avatar3","Avatar4","Avatar5","Avatar6","Avatar7","Avatar8"};
      playAvailable=new JComboBox<>(avatar);
      playAvailable.setBackground(Color.GREEN);
      playAvailable.setBounds(226,200,300,30);
      avatarDisplay(new ImageIcon("AvatarImage//Avatar1.PNG"));
      playAvailable.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e){
              avatarDisplay(new ImageIcon("AvatarImage//"+playAvailable.getSelectedItem()+".PNG"));
          }
      });
      return playAvailable;                           
  }
  private void letPlayTicWithOne(String startWith,String level){
   System.out.println("We start with :"+startWith);
   progressionBar(namePlayerAvatar, "AvatarImage//robot.PNG");
   ///////////////////////////////////////////////////
   this.setTitle("Let's Play with robot");
   this.setIconImage(icon.getImage());
   this.setResizable(false);
    this.setBounds(400,90,600,600);
    this.getContentPane().setBackground(Color.WHITE);
    this.setLayout(new GridLayout(3,3,10,10));
    JButton[] allButtons={new JButton("1"),new JButton("2"),new JButton("3"),new JButton("4"),new JButton("5"),new JButton("6"),new JButton("7"),new JButton("8"),new JButton("9")};
    for(int index=0;index<allButtons.length;index++){
      JButton loc=allButtons[index];
      this.add(loc);
      loc.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            System.out.println("You touch button  "+loc.getText());
         }
      });
      
    }
    ///////////////////////////////////////////////////
    this.setEnabled(false);
    this.setVisible(true);
  }
  private void letPlayTicWithTwo(String startWith){
   progressionBar(namePlayerAvatar, newPlayerAvatar);
   this.setTitle("Let's Play with another person");
   this.setIconImage(icon.getImage());
   this.setResizable(false);
    this.setBounds(420,90,600,600);
    this.getContentPane().setBackground(Color.WHITE);
    this.setLayout(new GridLayout(3,3,10,10));
    JButton[] allButtons={new JButton("1"),new JButton("2"),new JButton("3"),new JButton("4"),new JButton("5"),new JButton("6"),new JButton("7"),new JButton("8"),new JButton("9")};
    for(int index=0;index<allButtons.length;index++){
      JButton loc=allButtons[index];
      this.add(loc);
      loc.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            System.out.println("You touch button  "+loc.getText());
         }
      });
      
    }
    ///////////////////////////////////////////////////
    this.setEnabled(false);
    this.setVisible(true);
  }
  private String startWithP(){
   String[] listPl={"person1","person2"};
   Random start=new Random();
   return listPl[start.nextInt(0,1)];
  }
  private void progressionBar(String avatar1,String avatar2){
   ImageIcon av1=new ImageIcon(avatar1);
   ImageIcon av2=new ImageIcon(avatar2);
   //////////////////////////////////////////////////////////
   frameR=new JFrame("Progression Winner");
   frameR.setBounds(1050,90,310,550);
   frameR.setIconImage(icon.getImage());
   frameR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frameR.setLayout(null);
   frameR.getContentPane().setBackground(Color.gray);;
   //////////////////////////////////////
   JLabel ava1=new JLabel();
   ava1.setIcon(av1);
   ava1.setBounds(3,10,av1.getIconWidth(),av1.getIconHeight());
   namePly.setBounds(av1.getIconWidth()+5,10,100,25);
   pl1.setBounds(av1.getIconWidth()+5,45,150,30);
   pl1.setStringPainted(true);
   pl1.setFont(new Font(null,Font.ITALIC,25));
   pl1.setForeground(Color.YELLOW);
   pl1.setBackground(Color.WHITE);
   //////////////////////////////////////////
   JLabel vs=new JLabel("VS");
   vs.setBounds(130,170,100,30);
   vs.setFont(new Font(null,Font.ITALIC,30));
   vs.setForeground(Color.WHITE);
   vs.setBackground(Color.GRAY);
   vs.setOpaque(true);
   /////////////////////////////////////////
   JLabel ava2=new JLabel();
   ava2.setIcon(av2);
   ava2.setBounds(3,250,av2.getIconWidth(),av2.getIconHeight());
   avatarNewPlayer.setBounds(av2.getIconWidth()+5,250,100,25);
   avatarNewPlayer.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
   avatarNewPlayer.setForeground(Color.WHITE);
   avatarNewPlayer.setBackground(Color.GRAY);
   avatarNewPlayer.setFont(new Font(null,Font.BOLD,20));
   avatarNewPlayer.setIcon(null);
   avatarNewPlayer.setText(newPlayerName);
   pl2.setBounds(av2.getIconWidth()+5,285,150,30);
   pl2.setStringPainted(true);
   pl2.setFont(new Font(null,Font.ITALIC,25));
   pl2.setForeground(Color.magenta);
   pl2.setBackground(Color.WHITE);
   /////////////////////////////////////////
   JButton startB=new JButton("Start game");
   startB.setBounds(3,450,145,30);
   startB.setFont(new Font(null,Font.BOLD,20));
   startB.setForeground(Color.WHITE);
   startB.setBackground(Color.GREEN);
   startB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
         startCounter(550,"GO");
      }
   });
   ////////////////////////////////////////
   JButton backP=new JButton("back");
   backP.setBounds(151,450,142,30);
   backP.setFont(new Font(null,Font.BOLD,20));
   backP.setForeground(Color.WHITE);
   backP.setBackground(Color.BLUE);
   backP.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
         Tic_Tac_Toe bacK=new Tic_Tac_Toe(namePlayer,namePlayerAvatar);
      }
   });
   ///////////////////////////////////////
   frameR.add(ava1);
   frameR.add(namePly);
   frameR.add(pl1);
   frameR.add(vs);
   frameR.add(ava2);
   frameR.add(avatarNewPlayer);
   frameR.add(pl2);
   frameR.add(startB);
   frameR.add(backP);
   frameR.setVisible(true);
  }
  private void startCounter(int c,String t){
        startCount=new JFrame("Counter");
        startCount.setBounds(c,200,350,300);
        startCount.setIconImage(icon.getImage());
        startCount.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        startCount.setResizable(false);
        ///////////////////////////////////////////////
        count=new JLabel("1");
        count.setBounds(400,10,300,200);
        count.setFont(new Font(null,Font.BOLD,200));
        count.setForeground(Color.BLUE);
        count.setVerticalAlignment(JLabel.CENTER);
        count.setHorizontalAlignment(JLabel.CENTER);
        /////////////////////////////////////
        startCount.add(count);
        /////////////////////////////////////
        Date date=new Date();
        String[] precision=date.toString().split(" ");
        String[] time=realTime(precision[3]);
        int month=MonthSelection(precision[1]);
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {
           int countR=2;
            public void run(){
                if(countR<=5){
                  String nmb=""+countR;
                  count.setText(nmb);
                  countR++;
                  
                }
               else{
                   count.setForeground(Color.GREEN);
                    count.setText(t);
                    setE(true);
                    try{
                     Thread.sleep(2000);
                    }
                    catch(InterruptedException e){
                        JOptionPane.showMessageDialog(null, "Error during process","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    startCount.dispose();
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
                //////////////////////////////////////////////////////////
                startCount.setVisible(true);
            }
            
        
        
        
private void setE(boolean t){
   this.setEnabled(t);

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
  
    private void addActivity(String nameAc){
        actTic.startA();
        FileOutputStream outP;
        ObjectOutputStream putIn;
        try{
            if(!actTic.exist()){
                outP=new FileOutputStream(nameFile);
                putIn=new ObjectOutputStream(outP);
                actTic.addActivity(nameAc);
                putIn.writeObject(actTic);
                putIn.close();
                outP.close();
            }
            else{
                FileInputStream inP=new FileInputStream(nameFile);
                ObjectInputStream oIn=new ObjectInputStream(inP);
                actTic=(ActivityPlayer)oIn.readObject();
                actTic.addActivity(nameAc);
                oIn.close();
                inP.close();
                outP=new FileOutputStream(nameFile);
                putIn=new ObjectOutputStream(outP);
                putIn.writeObject(actTic);
                putIn.close();
                outP.close();
            }

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error during process", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
