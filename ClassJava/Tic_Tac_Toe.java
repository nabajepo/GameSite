import java.awt.Color;
import java.awt.Font;
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
    ////////////////////////////////////////
    private String namePlayer;
    private String newPlayer;
    private String namePlayerAvatar;
    private String newPlayerAvatar;
    private int playerQuantity;
    private ActivityPlayer actTic;
    private File nameFile;
    private String niv1="EASY";
    private String niv2="DIFFICULT";
    private String niv;
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
        avatarLabel.setBounds(240,5,avatP.getIconWidth(),avatP.getIconHeight());
        //////////////////////////////////////////////////For name
        namePly=new JLabel(namePlayer);
        namePly.setBounds(210,avatarLabel.getHeight()+5,150,25);
        namePly.setForeground(Color.BLACK);
        namePly.setBackground(Color.GRAY);
        namePly.setFont(new Font(null,Font.BOLD,20));
        namePly.setHorizontalAlignment(JLabel.CENTER);
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
      System.out.println("We have too players");

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
      if(JOptionPane.showConfirmDialog(null,"Would you like to start","Who start",JOptionPane.YES_NO_CANCEL_OPTION)==0){
         System.out.println("You start");
      }
      else{
         System.out.println("You don't start");
      }
    }
    private void makeSecondPlay(){}
    private void playAlone(){

    }
    private void playTwo(String nameSecondPlay){}
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
