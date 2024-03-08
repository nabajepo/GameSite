import javax.swing.*;
public class Tic_Tac_Toe extends JFrame {
    private JButton start;
    private JButton back;
    private ImageIcon icon; 
    ////////////////////////////////////////
    private String namePlayer;
    private String newPlayer;
    private String namePlayerAvatar;
    private String newPlayerAvatar;
    private final int playAlone=1;
    private final int playTwo=2;
    private int playerQuantity;
    public Tic_Tac_Toe(String name,String avatar){
        this.namePlayer=name;
        this.namePlayerAvatar=avatar;
        icon=new ImageIcon("ImagesGameSite//ImageProjetEntier.jpg");
        howManyPlayer();
    }
    private int howManyPlayer(){/////Here we choose how many Are going to play
        JFrame frameChoose=new JFrame("Choose how much player");
        frameChoose.setIconImage(icon.getImage());
        frameChoose.setBounds(440,90,600,480);
        frameChoose.setResizable(false);
        frameChoose.setVisible(true);
        frameChoose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         return 0;
    }
    
}
