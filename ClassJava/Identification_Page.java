import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;




public class Identification_Page extends JFrame {
    private JTextField username;
    private JPasswordField userpassword;
    private JLabel labelGame;
    private JLabel name;
    private JLabel password;
    private JButton changeBackgroundColor;
    private ImageIcon iconGame;
    private Border labelGameBorder;
    private JButton proceed;
    private JButton create_Account;
    private JButton forgot_password;
    private boolean ColorChange;
    private String nameGame;
    private String avatar;
  
    
   
    public Identification_Page(){
        labelGame=new JLabel();
        iconGame=new ImageIcon("ImagesGameSite//ImageProjetEntier.jpg");
        //Here we design the all the components of the frame
        MakeFrame();
        //Here we add all for finish
        this.setVisible(true);


       
        

    }
    private void MakeFrame(){
        ColorChange=false;///////////we start to the frame made  before
        this.setTitle("Identification Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(iconGame.getImage());
        this.setLayout(null);
        this.setBounds(440,90,600,500);
        this.getContentPane().setBackground(Color.BLACK);
        // Here we make and add the First label
        this.add(firstLable());
        //Here we make and add the nameLabel
        this.add(nameLabel());
        //Here we make and add the nameTextField
        this.add(namTextField());
        // Here we make and add passwordlabel
        this.add(passwordLabel());
       //Here we make and add passwordTextField
       this.add(passwordTextField());
       //Here is the representation of proceedButton
       this.add(proceedButton());
       //Here is  the representation of create_Account_Button
       this.add(createAccountButton());
       //Here is the representation of forgot_password
       this.add(forget_passwordButton());
       //here we make changeBackground label too gray 
        this.add(changeBackgroundColorLabel());
        ///here we make button for the deleteAccount
        
       

    }
    private JLabel firstLable(){
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
    private JLabel nameLabel(){
        name=new JLabel();
        name.setText("GameSite's name:");
        name.setHorizontalAlignment(JLabel.LEFT);
        name.setVerticalAlignment(JLabel.CENTER);
        name.setBounds(0,100,200,40);
        name.setForeground(Color.GREEN);
        name.setFont(new Font(null,Font.BOLD,20));
        name.setBorder(labelGameBorder);
        return name;
    }
    private JTextField namTextField(){
        username=new JTextField();
        username.setBounds(201,100,369,40);
        username.setFont(new Font(null,Font.PLAIN,20));
        username.setBackground(Color.BLACK);
        username.setCaretColor(Color.GREEN);
        username.setForeground(Color.GREEN);
        username.setEditable(true);
        return username;
    }
    private JLabel passwordLabel(){
        password=new JLabel();
        password.setText("Password :");
        password.setHorizontalAlignment(JLabel.LEFT);
        password.setVerticalAlignment(JLabel.CENTER);
        password.setBounds(0,180,120,40);
        password.setForeground(Color.GREEN);
        password.setFont(new Font(null,Font.BOLD,20));
        password.setBorder(labelGameBorder);
        return password;
    }
    private JTextField passwordTextField(){
        userpassword=new JPasswordField();
        userpassword.setBounds(121,180,450,40);
        userpassword.setFont(new Font(null,Font.PLAIN,20));
        userpassword.setBackground(Color.BLACK);
        userpassword.setCaretColor(Color.GREEN);
        userpassword.setForeground(Color.WHITE);
        userpassword.setEditable(true);
        return userpassword;
    }
    private JButton proceedButton(){
        proceed=new JButton();
        proceed.setBounds(122,250,450,40);
        proceed.setText("Proceed");
        proceed.setBackground(Color.GREEN);
        proceed.setForeground(Color.WHITE);
        proceed.setHorizontalAlignment(JButton.CENTER);
        proceed.setVerticalAlignment(JButton.CENTER);
        proceed.setFont(new Font(null,Font.BOLD,20));
        proceed.setBorder(labelGameBorder);
        proceed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
              if((isNameEmpty()==false)&&
              (isPasswordEmpty()==false)){
                if(checkInformationAccount()==true){
                    closeFrame();
                    Preparation_Page load=new Preparation_Page(nameGame, avatar);
                }
                else{
                    JOptionPane.showMessageDialog(userpassword, "Sorry we can't proceed", "ERROR OF IDENTIFICATION", JOptionPane.ERROR_MESSAGE);
                  }
              }
              
            }
        });
        return proceed;
    }
    private JButton createAccountButton(){
        create_Account=new JButton();
        create_Account.setBounds(122,300,220,40);
        create_Account.setText("Create_Account");
        create_Account.setBackground(Color.DARK_GRAY);
        create_Account.setForeground(Color.WHITE);
        create_Account.setHorizontalAlignment(JButton.CENTER);
        create_Account.setVerticalAlignment(JButton.CENTER);
        create_Account.setFont(new Font(null,Font.BOLD,20));
        create_Account.setBorder(labelGameBorder);
        create_Account.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e){
                closeFrame();
                Account newAccount=new Account();
             }
        });
        return create_Account;
    }
    private JButton forget_passwordButton(){
        forgot_password=new JButton();
       forgot_password.setBounds(350,300,221,40);
       forgot_password.setText("Forgot password?");
       forgot_password.setBackground(Color.RED);
       forgot_password.setForeground(Color.WHITE);
       forgot_password.setHorizontalAlignment(JButton.CENTER);
       forgot_password.setVerticalAlignment(JButton.CENTER);
       forgot_password.setFont(new Font(null,Font.BOLD,20));
       forgot_password.setBorder(labelGameBorder); 
       forgot_password.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            if(isNameEmpty()==false){
                passwordShow();
            }
              
        }
       });
       return forgot_password;
    }
    private JButton changeBackgroundColorLabel(){///here we change the clor of the background
        changeBackgroundColor=new JButton();
        changeBackgroundColor.setText("Change Background");
        changeBackgroundColor.setHorizontalAlignment(JLabel.LEFT);
        changeBackgroundColor.setVerticalAlignment(JLabel.CENTER);
        changeBackgroundColor.setBounds(0,400,200,40);
        changeBackgroundColor.setForeground(Color.GREEN);
        changeBackgroundColor.setFont(new Font(null,Font.BOLD,20));
        changeBackgroundColor.setBorder(labelGameBorder);
        changeBackgroundColor.setBackground(Color.BLACK);
        changeBackgroundColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(ColorChange==true){OldFrame();}//back to the old frame
                else{ ChangeFrame();}//we change frame
               
            }
        });
        return changeBackgroundColor;
    }
    
    private void closeFrame(){
        this.dispose();
    }
    private void ChangeFrame(){
        this.getContentPane().setBackground(Color.WHITE);
        /////////////border change color green to black
        labelGameBorder=BorderFactory.createLineBorder(Color.BLACK,3);
        ///////////////we change le labelGame border et the text's color
        labelGame.setForeground(Color.BLACK);
        labelGame.setBorder(labelGameBorder);
        ////////////////the name and the border color
        name.setForeground(Color.BLACK);
        name.setBorder(labelGameBorder);
        ////////////////the username color 
        username.setBackground(Color.WHITE);
        username.setCaretColor(Color.BLACK);
        username.setForeground(Color.BLACK);
        //////////////password
        password.setForeground(Color.BLACK);
        password.setBorder(labelGameBorder);
        //////////////the userpassword
        userpassword.setBackground(Color.WHITE);
        userpassword.setCaretColor(Color.BLACK);
        userpassword.setForeground(Color.BLACK);
        /////////////Proceed's button
        proceed.setBackground(Color.GRAY);
        proceed.setForeground(Color.WHITE);
        proceed.setBorder(labelGameBorder);
        /////////////CreateAccount's button
        create_Account.setBackground(Color.blue);
        create_Account.setBorder(labelGameBorder);
        ////////////forgot_Password's button
        forgot_password.setBackground(Color.orange);
        forgot_password.setBorder(labelGameBorder);
        ////////////////ChangeBacground's button
        changeBackgroundColor.setBackground(Color.WHITE);
        changeBackgroundColor.setForeground(Color.BLACK);
        changeBackgroundColor.setBorder(labelGameBorder);
        //////////////for change deleteButton
      
        //////////////////////we change the frame,so
        ColorChange=true;

    }
    private void OldFrame(){//save the old frame
        this.getContentPane().setBackground(Color.BLACK);
        /////////////border change color green to black
        labelGameBorder=BorderFactory.createLineBorder(Color.GREEN,3);
        ///////////////we change le labelGame border et the text's color
        labelGame.setForeground(Color.GREEN);
        labelGame.setBorder(labelGameBorder);
        ////////////////the name and the border color
        name.setForeground(Color.GREEN);
        name.setBorder(labelGameBorder);
        ////////////////the username color 
        username.setBackground(Color.BLACK);
        username.setCaretColor(Color.GREEN);
        username.setForeground(Color.GREEN);
        //////////////password
        password.setForeground(Color.GREEN);
        password.setBorder(labelGameBorder);
        //////////////the userpassword
        userpassword.setBackground(Color.BLACK);
        userpassword.setCaretColor(Color.GREEN);
        userpassword.setForeground(Color.GREEN);
        /////////////Proceed's button
        proceed.setBackground(Color.GREEN);
        proceed.setForeground(Color.WHITE);
        proceed.setBorder(labelGameBorder);
        /////////////CreateAccount's button
        create_Account.setBackground(Color.DARK_GRAY);
        create_Account.setBorder(labelGameBorder);
        ////////////forgot_Password's button
        forgot_password.setBackground(Color.PINK);
        forgot_password.setBorder(labelGameBorder);
        ////////////////ChangeBacground's button
        changeBackgroundColor.setBackground(Color.BLACK);
        changeBackgroundColor.setForeground(Color.GREEN);
        changeBackgroundColor.setBorder(labelGameBorder);
        //////////////////////we change the frame,so
        ColorChange=false;
    }
    private boolean checkInformationAccount(){
        File file2=new File("Info//"+username.getText()+"//");
        File file=new File("Info//"+username.getText()+"//AccountPersonal.StockInfo");
        try{ 
            if((file.exists()==false)&&
            (file2.exists()==false)){
                throw new IOException();
            }
            else{
                FileInputStream fileT=new FileInputStream(file);
                ObjectInputStream in=new ObjectInputStream(fileT);
                Account.AccountInformationCreation acc=(Account.AccountInformationCreation)in.readObject();
                in.close();
                fileT.close();
                nameGame=acc.getName();
                avatar=acc.getAvatar();
                if((checkEnterredInfo(username.getText().trim(), acc.getName())==true)&&
                 ((checkEnterredInfo(userpassword.getText().trim(), acc.getPassword())==true))){
                    return true;
                }
                else{
                    throw new ClassNotFoundException();
                }
                
            }
           

        }
        catch(IOException e){
            JOptionPane.showMessageDialog(userpassword, "Can't find your account on our dataset","ERROR",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        catch(ClassNotFoundException g){
            JOptionPane.showMessageDialog(userpassword, "ERROR ON NAME OR PASSWORD ","ERROR",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
       
    }
    private boolean checkEnterredInfo(String npE,String npS){
        return npE.equals(npS);
    }
    private boolean isNameEmpty(){
        if(username.getText().equals("")){
            JOptionPane.showMessageDialog(username, "You should enter your name", "ERROR DURING PROCEEDING",JOptionPane.ERROR_MESSAGE);
            return true;
        }
        else{
            return false;
        }
    }
    private boolean isPasswordEmpty(){
        if(userpassword.getText().equals("")){
            JOptionPane.showMessageDialog(userpassword, "you should enter your password", "ERROR DURING PROCEEDING", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        else{
            return false;
        }
    }
    private void passwordShow(){
        File fileI2=new File("Info//"+username.getText());
        try{
            File fileID=new File("Info//"+username.getText()+"//AccountPersonal.StockInfo");
            if((fileI2.exists())&&
            (fileID.exists())){
                FileInputStream fileT=new FileInputStream(fileID);
                ObjectInputStream in=new ObjectInputStream(fileT);
                 Account.AccountInformationCreation acc=(Account.AccountInformationCreation)in.readObject();
                 in.close();
                 fileT.close();
                if(isNameEmpty()==false){
                    if(checkEnterredInfo(username.getText().trim(),acc.getName())==true){
                        JOptionPane.showMessageDialog(password, "This is your password : "+acc.getPassword()+" please try again "+acc.getName(), " PASSWORD SHOW ", JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                    else{
                        throw new IOException();
                    }
    

                }
                else{
                   throw new ClassNotFoundException();
                }
                
                
            }
            else{
                throw new IOException();
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(password, "Sorry,we can't find you in our dataset", " ERROR CONFIRMATION ", JOptionPane.ERROR_MESSAGE);
        }
        catch(ClassNotFoundException g){
            JOptionPane.showMessageDialog(username, "please enter your name", " ERROR NAME ", JOptionPane.ERROR_MESSAGE);
        }
        
    }
   

}
