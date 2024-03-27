import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
                  letPlayTicWithTwo("person1");
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
      System.out.println("We have one player with level: "+getNiv);
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
      int startWith=JOptionPane.showConfirmDialog(null,"Would you like to start","Who start",JOptionPane.YES_NO_CANCEL_OPTION);
      if(startWith==0){
         letPlayTicWithOne("person1",getNiv);
         System.out.println("You start");
      }
      else if(startWith==2){
         Tic_Tac_Toe bacN=new Tic_Tac_Toe(namePlayer, namePlayerAvatar);
      }
      else{
         letPlayTicWithOne("person2",getNiv);
         System.out.println("You don't start");
      }
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
      avatarNewPlayer=new JLabel();
      avatarDisplay(new ImageIcon("AvatarImage//Avatar1.PNG"));
      playAvailable.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e){
              avatarDisplay(new ImageIcon("AvatarImage//"+playAvailable.getSelectedItem()+".PNG"));
          }
      });
      return playAvailable;                           
  }
  private void letPlayTicWithOne(String startWith,String level){
   System.out.println("The level is "+level);
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
    this.setVisible(true);
  }
  private void progressionBar(String avatar1,String avatar2){
   ImageIcon av1=new ImageIcon(avatar1);
   ImageIcon av2=new ImageIcon(avatar2);
   //////////////////////////////////////////////////////////
   frameR=new JFrame("Progression Winner");
   frameR.setBounds(1050,90,310,600);
   frameR.setIconImage(icon.getImage());
   frameR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frameR.setLayout(null);
   //////////////////////////////////////
   
   JLabel ava1=new JLabel();
   ava1.setIcon(av1);
   ava1.setBounds(0,10,av1.getIconWidth(),av1.getIconHeight());
   //////////////////////////////////////////
   
   JLabel ava2=new JLabel();
   ava2.setIcon(av2);
   ava2.setBounds(0,300,av2.getIconWidth(),av2.getIconHeight());
   /////////////////////////////////////////
   frameR.add(ava1);
   frameR.add(ava2);
   frameR.setVisible(true);

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
