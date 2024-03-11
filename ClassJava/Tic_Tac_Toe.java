import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    public Tic_Tac_Toe(String name,String avatar){
        this.namePlayer=name;
        this.namePlayerAvatar=avatar;
        icon=new ImageIcon("ImagesGameSite//ImageProjetEntier.jpg");
        actTic=new ActivityPlayer(name, avatar);
        playerQuantity=1;
        howManyPlayer();
    }
    private void howManyPlayer(){/////Here we choose how many Are going to play
        ///////////////////////////////////////////////////for Logo label
        ImageIcon avatP=new ImageIcon(namePlayerAvatar);
        avatarLabel=new JLabel();
        avatarLabel.setIcon(avatP);
        avatarLabel.setBounds(220,5,avatP.getIconWidth(),avatP.getIconHeight());
        //////////////////////////////////////////////////For name
        namePly=new JLabel(namePlayer);
        namePly.setBounds(190,avatarLabel.getHeight()+5,150,25);
        namePly.setForeground(Color.BLACK);
        namePly.setBackground(Color.GRAY);
        namePly.setFont(new Font(null,Font.BOLD,20));
        namePly.setHorizontalAlignment(JLabel.CENTER);
        /////////////////////////////////////////////////// for Combox
        String[] player={"1 player","2 players"};
        playAvailable=new JComboBox<>(player);
        playAvailable.setBackground(Color.ORANGE);
        playAvailable.setBounds(50,avatarLabel.getHeight()+40,400,40);
        playAvailable.setForeground(Color.black);
        playAvailable.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e){//To complete
             if(playAvailable.getSelectedIndex()==0){
                playerQuantity=1;
             }
             else{
                playerQuantity=2;
             }
          }  
        });
        //////////////////////////////////////////////////////////For Button back
        JButton backToMain=new JButton("Back");
        backToMain.setBounds(50,avatarLabel.getHeight()+90,185,40);
        backToMain.setBackground(Color.ORANGE);
        backToMain.setForeground(Color.WHITE);
        backToMain.setFont(new Font(null,Font.ROMAN_BASELINE,20));
        //////////////////////////////////////////////////////////For button Continue
        JButton continueT=new JButton("Continue");
        continueT.setBounds(265,avatarLabel.getHeight()+90,185,40);
        continueT.setBackground(Color.GREEN);
        continueT.setForeground(Color.WHITE);
        continueT.setFont(new Font(null,Font.ROMAN_BASELINE,20));
        continueT.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e){
                playAvailable.setEnabled(false);
                if(playerQuantity==2){
                   TooPlayer();
                }
                else{
                   OnePlayer();
                }
             }
        });
        ////////////////////////////////////////////////////////// for Frame
        JFrame frameChoose=new JFrame("Choose how much player");
        frameChoose.setIconImage(icon.getImage());
        frameChoose.setBounds(440,90,530,310);
        frameChoose.setResizable(false);
        frameChoose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameChoose.getContentPane().setBackground(Color.gray);
        frameChoose.setLayout(null);
        frameChoose.add(avatarLabel);
        frameChoose.add(namePly);
        frameChoose.add(playAvailable);
        frameChoose.add(backToMain);
        frameChoose.add(continueT);
        frameChoose.setVisible(true);
    }
    private void chooseTool(){
    }//:Here we choose what we play with
    private void TooPlayer(){
      System.out.println("We have too players");
    }
    private void OnePlayer(){
      System.out.println("We have one player");
    }
    
}
