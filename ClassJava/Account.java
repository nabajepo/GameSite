import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.Timer;


public class Account extends JFrame {
    public class AccountInformationCreation implements Serializable{
        String name;
        String password;
        String avatar;
        public AccountInformationCreation(String name,String password,String avatar){
            this.name=name;
            this.password=password;
            this.avatar=avatar;
        }
        public String getName(){return this.name;}
        public String getPassword(){return this.password;}
        public String getAvatar(){return this.avatar;}
    }
    private JLabel labelGame;
    private JLabel labelName;
    private JLabel labelPassword;
    private JLabel labelConfirmePassword;
    private JTextField username;
    private JTextField userpassword;
    private JTextField ComfirmePassword;
    private JCheckBox boxNoRobot;
    private Border labelGameBorder;
    private JButton create;
    private JButton back;
    private ImageIcon imageIcon;
    private JComboBox<String> avatarChoose;
    private JLabel chooseAvLabel;
    private JLabel avatarImage=new JLabel();
    private JFrame frameWaiting;
    private JLabel labelWaiting;
    private JProgressBar barWaiting;
    private JButton start;
   
    
    public Account(){
        //////////The label of the game
        imageIcon=new ImageIcon("ImagesGameSite//ImageProjetEntier.jpg");
        //////////////Here we make Frame
        BuildFrame();
        ////////////////here we set frame to visible
        this.setVisible(true);
    }
    private void BuildFrame(){
        this.setTitle("Creation_Account");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(imageIcon.getImage());
        this.setLayout(null);
        this.setBounds(440,90,600,600);
        this.getContentPane().setBackground(Color.BLACK);
        ////////////////For the label au top
        this.add(LabelTop());
        //////////////// For the Check if your robot or not
        this.add(BoxRobot());
        /////////////// For the name Label
        this.add(Labelname());
        //////////////For the nameTextField
        this.add(TextFieldName());
        //////////////// For ths password label
        this.add(Labelpassword());
        /////////////// For the text password
        this.add(TextFieldpassword());
        //////////////////For comfirmation label
        this.add(LabelpasswordConfirm());
        /////////////////For comfirmation password
        this.add(TextFieldpasswordConfirm());
        ////////////////For avatar label
        this.add(chooseAvMakeLabel());
        ////////////////For avatar  choose
        this.add(ChooseAvatar());
        ///////////////For Button Create
        this.add(creactionAccButton());
        ///////////////For back Button
        this.add(backFrame());

    }
    private JLabel LabelTop(){
        labelGame=new JLabel();
        labelGame.setText("GameSite");
        labelGameBorder=BorderFactory.createLineBorder(Color.GREEN,3);
        labelGame.setVerticalAlignment(JLabel.CENTER);
        labelGame.setHorizontalAlignment(JLabel.CENTER);
        labelGame.setFont(new Font(null,Font.BOLD,20));
        labelGame.setBorder(labelGameBorder);
        labelGame.setForeground(Color.GREEN);
        labelGame.setBounds(0,0,584,50);
        return this.labelGame;
    }
    private JCheckBox BoxRobot(){
        boxNoRobot=new JCheckBox();
        boxNoRobot.setText("Aren't you a robot");
        boxNoRobot.setBounds(10,60,400,40);
        boxNoRobot.setFont(new Font(null,Font.BOLD,20));
        boxNoRobot.setForeground(Color.GREEN);
        boxNoRobot.setBackground(Color.BLACK);
        return boxNoRobot;
    }
    private JLabel Labelname(){
        labelName=new JLabel();
        labelName.setText("Name   :");
        labelName.setHorizontalAlignment(JLabel.LEFT);
        labelName.setVerticalAlignment(JLabel.CENTER);
        labelName.setBounds(0,120,200,40);
        labelName.setForeground(Color.GREEN);
        labelName.setFont(new Font(null,Font.BOLD,20));
        labelName.setBorder(labelGameBorder);
        return labelName;
    }
    private JTextField TextFieldName(){
        username=new JTextField("𝐸𝑛𝑡𝑒𝑟 𝑦𝑜𝑢 𝑛𝑎𝑚𝑒 (8_𝑐ℎ𝑎𝑟𝑎𝑐𝑡𝑒𝑟𝑠)");
        username.setBounds(201,120,369,40);
        username.setFont(new Font(null,Font.PLAIN,20));
        username.setBackground(Color.BLACK);
        username.setCaretColor(Color.GREEN);
        username.setForeground(Color.pink);
        username.setEditable(true);
        return username;
    }
    private JLabel Labelpassword(){
        labelPassword=new JLabel();
        labelPassword.setText("Password :");
        labelPassword.setHorizontalAlignment(JLabel.LEFT);
        labelPassword.setVerticalAlignment(JLabel.CENTER);
        labelPassword.setBounds(0,180,120,40);
        labelPassword.setForeground(Color.GREEN);
        labelPassword.setFont(new Font(null,Font.BOLD,20));
        labelPassword.setBorder(labelGameBorder);
        return  labelPassword;
    }
    private JTextField TextFieldpassword(){
        userpassword=new JTextField("𝐸𝑛𝑡𝑒𝑟 𝑦𝑜𝑢 𝑝𝑎𝑠𝑠𝑤𝑜𝑟𝑑 (8 𝑐ℎ𝑎𝑟𝑎𝑐𝑡𝑒𝑟𝑠)");
        userpassword.setBounds(121,180,450,40);
        userpassword.setFont(new Font(null,Font.PLAIN,20));
        userpassword.setBackground(Color.BLACK);
        userpassword.setCaretColor(Color.GREEN);
        userpassword.setForeground(Color.pink);
        userpassword.setEditable(true);
        return userpassword;
    }
    private JLabel LabelpasswordConfirm(){
        labelConfirmePassword=new JLabel();
        labelConfirmePassword.setText("Comfirm_Password :");
        labelConfirmePassword.setHorizontalAlignment(JLabel.LEFT);
        labelConfirmePassword.setVerticalAlignment(JLabel.CENTER);
        labelConfirmePassword.setBounds(0,240,220,40);
        labelConfirmePassword.setForeground(Color.GREEN);
        labelConfirmePassword.setFont(new Font(null,Font.BOLD,20));
        labelConfirmePassword.setBorder(labelGameBorder);
        return  labelConfirmePassword;
    }
    private JTextField TextFieldpasswordConfirm(){
        ComfirmePassword=new JTextField("𝐶𝑜𝑛𝑓𝑖𝑟𝑚 𝑦𝑜𝑢𝑟 𝑝𝑎𝑠𝑠𝑤𝑜𝑟𝑑");
        ComfirmePassword.setBounds(221,240,350,40);
        ComfirmePassword.setFont(new Font(null,Font.PLAIN,20));
        ComfirmePassword.setBackground(Color.BLACK);
        ComfirmePassword.setCaretColor(Color.GREEN);
        ComfirmePassword.setForeground(Color.pink);
        ComfirmePassword.setEditable(true);
        return ComfirmePassword;
    }
    private JLabel chooseAvMakeLabel(){
        chooseAvLabel=new JLabel();
        chooseAvLabel.setText("Choose_your_avatar:");
        chooseAvLabel.setHorizontalAlignment(JLabel.LEFT);
        chooseAvLabel.setVerticalAlignment(JLabel.CENTER);
        chooseAvLabel.setBounds(0,440,230,40);
        chooseAvLabel.setForeground(Color.GREEN);
        chooseAvLabel.setFont(new Font(null,Font.BOLD,20));
        chooseAvLabel.setBorder(labelGameBorder);
        return  chooseAvLabel;

    }
    private void avatarDisplay(ImageIcon image){
        avatarImage.setBackground(Color.BLACK);
        avatarImage.setIcon(image);
        avatarImage.setBounds(340,295,image.getIconWidth(),image.getIconHeight());
        this.add(avatarImage);
    }
    private JComboBox<String> ChooseAvatar(){
        String[] avatar={"Avatar1","Avatar2","Avatar3","Avatar4","Avatar5","Avatar6","Avatar7","Avatar8"};
        avatarChoose=new JComboBox<String>(avatar);
        avatarChoose.setBackground(Color.PINK);
        avatarChoose.setBounds(231,440,300,40);
        avatarDisplay(new ImageIcon("AvatarImage//Avatar1.PNG"));
        avatarChoose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                avatarDisplay(new ImageIcon("AvatarImage//"+avatarChoose.getSelectedItem()+".PNG"));
            }
        });
        return avatarChoose;                           
    }
    private JButton creactionAccButton(){
        create=new JButton();
        create.setBounds(231,500,300,40);
        create.setText("Create GameSite Account");
        create.setBackground(Color.BLUE);
        create.setForeground(Color.WHITE);
        create.setHorizontalAlignment(JButton.CENTER);
        create.setVerticalAlignment(JButton.CENTER);
        create.setFont(new Font(null,Font.BOLD,20));
        create.setBorder(labelGameBorder);
        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
                if((isNotRobot()==true)&&
                   (isNameEmpty()==false)&&
                   (isEnoughChars(8,username,"for username")==true)&&
                   (isPasswordEmpty()==false)&&
                   (isEnoughChars(8,userpassword,"for userpassword")==true)&&
                   (isComfirmpasswordEmpty()==false)&&
                   (isPasswordSame()==true)
                   ){
                    username.setEditable(false);
                    userpassword.setEditable(false);
                    ComfirmePassword.setEditable(false);
                    avatarChoose.setEditable(false);
                    closeFrameAccount();
                    if(isReallyNotRobot()==true){
                        //JOptionPane.showMessageDialog(null, "isAccountCreate ? "+isAccountCreate(), "Welcoming", JOptionPane.PLAIN_MESSAGE);  
                        if(CreateAccount()==true){
                            creationWaiting();
                            WaitLoading();
                            //closeFrameAccount();
                            //Identification_Page backToconnection=new Identification_Page();
                            }
                        }
                        
                    else{
                        closeFrameAccount();
                        JOptionPane.showMessageDialog(null, "Sorry we can proceed with the creatio,response doesn't match",
                        "Not Allowed",
                         JOptionPane.ERROR_MESSAGE);
                         Identification_Page backToconnection=new Identification_Page();
                         
                        }}
                else if(isNotRobot()==false){
                    JOptionPane.showMessageDialog(boxNoRobot, "Sorry,We can't create an account for a robot",
                                                  "WARNING INFORMATION",
                                                   JOptionPane.ERROR_MESSAGE);}}});
        return create;
    }
    private JButton backFrame(){
        back=new JButton();
        back.setBounds(0,500,200,40);
        back.setText("Back to Connection");
        back.setBackground(Color.ORANGE);
        back.setForeground(Color.WHITE);
        back.setHorizontalAlignment(JButton.CENTER);
        back.setVerticalAlignment(JButton.CENTER);
        back.setFont(new Font(null,Font.BOLD,20));
        back.setBorder(labelGameBorder);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                closeFrameAccount();
                Identification_Page backToconnection=new Identification_Page();
               
            }
        }) ;
        return back;

    }
    private void closeFrameAccount(){
        this.dispose();
    }
    private boolean isNotRobot(){
        return boxNoRobot.isSelected();
    }
    private boolean isReallyNotRobot(){///here we make a random message for the maker of the account to verify if he is really not a robot
        String alpht="abcdefghijklmnopqrstuvwxyz";
        String num="123456789";
        String[] alphabet=alpht.split("");
        String[] number=num.split("");
        int index=0;
        String messagedisplay="";
        while(index<10){
            if(index%2==0){// if it's pair we use alphabet
               messagedisplay=messagedisplay+alphabet[randomChoose(alphabet)];
            }
            else{///////if it's not we use number
                messagedisplay=messagedisplay+number[randomChoose(number)];
            }
            index++;
        }
        if(ShowMessageRandomAndConfirmMessage(messagedisplay).equals(messagedisplay)){
            return true;
        }
        else{
            return false;
        }
        
        
    }
    private int randomChoose(String[] alphNum){
        Random choose=new Random();
        return choose.nextInt(0,alphNum.length);
    }
    private String ShowMessageRandomAndConfirmMessage(String message){
        JOptionPane.showMessageDialog(null, message, "THIS IS YOUR COMFIRMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        return JOptionPane.showInputDialog("Please enter the confirmation message sent ");
    }
    private boolean isNameEmpty(){
        if(username.getText().equals("𝐸𝑛𝑡𝑒𝑟 𝑦𝑜𝑢 𝑛𝑎𝑚𝑒 (8_𝑐ℎ𝑎𝑟𝑎𝑐𝑡𝑒𝑟𝑠)")){
            JOptionPane.showMessageDialog(username, "You must enter a name at more 8 characters", "ERROR DURING CREATING ACCOUNT",JOptionPane.ERROR_MESSAGE);
            return true;
        }
        else{
            return false;
        }
    }
    private boolean isPasswordEmpty(){
        if(userpassword.getText().equals("𝐸𝑛𝑡𝑒𝑟 𝑦𝑜𝑢 𝑝𝑎𝑠𝑠𝑤𝑜𝑟𝑑 (8 𝑐ℎ𝑎𝑟𝑎𝑐𝑡𝑒𝑟𝑠)")){
            JOptionPane.showMessageDialog(userpassword, "You must enter a password at more 8 characters", "ERROR DURING CREATING ACCOUNT", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        else{
            return false;
        }
    }
    private boolean isComfirmpasswordEmpty(){
        if(ComfirmePassword.getText().equals("𝐶𝑜𝑛𝑓𝑖𝑟𝑚 𝑦𝑜𝑢𝑟 𝑝𝑎𝑠𝑠𝑤𝑜𝑟𝑑")){
            JOptionPane.showMessageDialog(ComfirmePassword, "You must comfirm your password", "ERROR DURING CREATING ACCOUNT", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        else{
            return false;
        }
    }
    private boolean  isPasswordSame(){
        if((userpassword.getText().trim().equals(ComfirmePassword.getText().trim()))==false){
            JOptionPane.showMessageDialog(ComfirmePassword, "we must have two same password on password and comfirmpassword", "ERROR DURING CREATING ACCOUNT", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            return true;
        }
    }
    private boolean isEnoughChars(int number_of_char,JTextField text,String name){
        String[] loStrings=text.getText().trim().split("");
        if((loStrings.length>number_of_char)||((loStrings.length<number_of_char))){
            JOptionPane.showMessageDialog(text, "we must have 8 characters "+name, "ERROR DURING CREATING ACCOUNT", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            return true;
        }
        
    }
    private boolean CreateAccount(){
        try{
            File file0=new File("Info//"+username.getText()+"//");
            File file=new File("Info//"+username.getText()+"//AccountPersonal.StockInfo");
            if((file0.exists())&&
            (file.exists())){
                throw new IOException();
            }
            else{
                file0.mkdir();
                String avatarWay="AvatarImage//"+avatarChoose.getSelectedItem()+".PNG";
                AccountInformationCreation infoCreation=new AccountInformationCreation(username.getText().trim(), userpassword.getText().trim(),avatarWay);
                FileOutputStream create_account=new FileOutputStream(file);
                ObjectOutputStream insertStream=new ObjectOutputStream(create_account);
                insertStream.writeObject(infoCreation);
                insertStream.close();
                create_account.close();
                return true;
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(avatarChoose, "Can't create your account,because you have a account", "ERROR DURING CREATION", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    private  void creationWaiting(){
        frameWaiting=new JFrame();
        frameWaiting.setTitle("Create an  Account please wait 5 seconds ........");
        frameWaiting.getContentPane().setBackground(Color.BLACK);
        frameWaiting.setIconImage(imageIcon.getImage());
        frameWaiting.setLayout(null);
        frameWaiting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameWaiting.setBounds(500,200,520,180);
        frameWaiting.setResizable(false);
        ////////////////Label
        labelWaiting=new JLabel("Creation in process....");
        labelWaiting.setBounds(0,20,200,40);
        labelWaiting.setBackground(Color.BLACK);
        labelWaiting.setFont(new Font(null,Font.ITALIC,20));
        labelWaiting.setForeground(Color.GREEN);
        frameWaiting.add(labelWaiting);
        /////////Progression bar
        barWaiting=new JProgressBar();
        barWaiting.setValue(0);
        barWaiting.setBounds(204,20,300,40);
        barWaiting.setStringPainted(true);
        barWaiting.setFont(new Font(null,Font.ITALIC,20));
        barWaiting.setForeground(Color.PINK);
        barWaiting.setBackground(Color.BLACK);
        frameWaiting.add(barWaiting);
        ////////For label Start
        start=new JButton("Start");
        start.setBounds(barWaiting.getX()+56,barWaiting.getY()+70,200,40);
        start.setBackground(Color.GREEN);
        start.setFont(new Font(null,Font.BOLD,20));
        start.setForeground(Color.WHITE);
        start.setEnabled(false);
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frameWaiting.dispose();
                Identification_Page back=new Identification_Page();
            }
        });
       
        frameWaiting.add(start);
        ////////////Visibility
        frameWaiting.setVisible(true);
        //////////////////////to wait
       
        
       
    }
    
     private void WaitLoading(){
        Date date=new Date();
        String[] precision=date.toString().split(" ");
        String[] time=realTime(precision[3]);
        int month=MonthSelection(precision[1]);
       
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            int load=barWaiting.getValue();
            public void run(){
                if(barWaiting.getValue()<100){
                    barWaiting.setValue(load);
                    load=load+20;
                    
                }
                else{
                    frameWaiting.setTitle("Creation Completed");
                    labelWaiting.setText("Account :");
                    barWaiting.setString(" created successful");
                    start.setEnabled(true);
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
