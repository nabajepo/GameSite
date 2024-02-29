import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Timer;


public class PlayMusic implements MouseListener,Serializable {
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    
    //For Frame and label and audio
    private JFrame activityFrame;
    private JFrame frameWaiting;
    private JFrame displayMusic;
    private JFrame playSection;
    private JFrame getAll;
    private JLabel musicPlaying;
    private AudioInputStream audioSong;
    private Clip audioR;
    private JButton start;
    private JLabel labelWaiting;
    private JProgressBar barWaiting;
    ////For all button we need and ImageIcon
    private JButton Start_Music;
    private JButton Stop_Music;
    private JButton Restart_Music;
    private JButton Next_Music;
    private JButton Delet_Music;
    private JButton see_my_historic;
    private boolean audio_Player;
    ////For all and Historic
    private String name;
    private String avatar;
    private String infoCondition="";
    private int location;
    private  String wayA;
    private ArrayList<String> dispoNibleFile;
    private int rep;
    private String myFlag;
    private final String action1="ADD NEW TYPE";
    private final String action2="ADD NEW SINGER";
    private final String YELLOW="-14336";
    private final String WHITE="-1";
    private final String GRAY="-8355712";
    private final String BLUE="-16776961";
    private int oneShow=1;
   

    
    public PlayMusic(String name,String avatar,int location){
        File activity=new File("Info//"+name+"//ACTIVITY.txt");
        if(activity.exists()){
            showActivity();
        }
        this.name=name;
        this.avatar=avatar;
        this.location=location;
        audio_Player=false;
        conditionOfuse();
        
    }
    private void conditionOfuse(){
        //////////////////////////for frame
        JFrame Condition_and_Availablity=new JFrame("Condtion and use ");
        Condition_and_Availablity.setBounds(location,100,830,350);
        Condition_and_Availablity.setResizable(false);
        ImageIcon icon =new ImageIcon("ImagesGameSite//ImageProjetEntier.jpg");
        Condition_and_Availablity.setIconImage(icon.getImage());
        Condition_and_Availablity.getContentPane().setBackground(Color.black);
        Condition_and_Availablity.setLayout(null);
        /////////////////////////for textCondition
        JLabel displayCondition=new JLabel("#Important information about Music_GameSite");
        displayCondition.setBounds(20,0,480,25);
        displayCondition.setForeground(Color.green);
        displayCondition.setFont(new Font(null,Font.ITALIC,20));
        displayCondition.setBackground(Color.BLACK);
        displayCondition.setOpaque(true);
        displayCondition.setVerticalAlignment(JLabel.TOP);
        displayCondition.setHorizontalAlignment(JLabel.LEFT);
        JLabel displayCondition1=new JLabel("----------------------------------------------------------------/");
        displayCondition1.setBounds(0,16,500,25);
        displayCondition1.setForeground(Color.pink);
        displayCondition1.setFont(new Font(null,Font.ITALIC,20));
        displayCondition1.setBackground(Color.BLACK);
        displayCondition1.setOpaque(true);
        displayCondition1.setVerticalAlignment(JLabel.TOP);
        displayCondition1.setHorizontalAlignment(JLabel.LEFT);
        JLabel displayCondition2=new JLabel("#Hello,for this file you can't add more than 8 singers or songs");
        displayCondition2.setBounds(20,40,850,25);
        displayCondition2.setForeground(Color.green);
        displayCondition2.setFont(new Font(null,Font.ITALIC,20));
        displayCondition2.setBackground(Color.BLACK);
        displayCondition2.setOpaque(true);
        displayCondition2.setVerticalAlignment(JLabel.TOP);
        displayCondition2.setHorizontalAlignment(JLabel.LEFT);
        JLabel displayCondition3=new JLabel("#This file content files for Singers with each 3 personal music(like personal PlayList)");
        displayCondition3.setBounds(20,70,850,25);
        displayCondition3.setForeground(Color.green);
        displayCondition3.setFont(new Font(null,Font.ITALIC,20));
        displayCondition3.setBackground(Color.BLACK);
        displayCondition3.setOpaque(true);
        displayCondition3.setVerticalAlignment(JLabel.TOP);
        displayCondition3.setHorizontalAlignment(JLabel.LEFT);
        JLabel displayCondition4=new JLabel("#But you can create your own file(PlayList)  and manage it as you want");
        displayCondition4.setBounds(20,100,850,25);
        displayCondition4.setForeground(Color.green);
        displayCondition4.setFont(new Font(null,Font.ITALIC,20));
        displayCondition4.setBackground(Color.BLACK);
        displayCondition4.setOpaque(true);
        displayCondition4.setVerticalAlignment(JLabel.TOP);
        displayCondition4.setHorizontalAlignment(JLabel.LEFT);
        JLabel displayCondition5=new JLabel("#Thank you for reading and enjoy !");
        displayCondition5.setBounds(20,130,850,30);
        displayCondition5.setForeground(Color.green);
        displayCondition5.setFont(new Font(null,Font.ITALIC,20));
        displayCondition5.setBackground(Color.BLACK);
        displayCondition5.setOpaque(true);
        displayCondition5.setVerticalAlignment(JLabel.TOP);
        displayCondition5.setHorizontalAlignment(JLabel.LEFT);
        ///////////////////////////for accepting
        JCheckBox agreeCondtion=new JCheckBox("Did you undestand ?");
        agreeCondtion.setForeground(Color.PINK);
        agreeCondtion.setFont(new Font(null,Font.BOLD,20));
        agreeCondtion.setBounds(20,170,500,20);
        agreeCondtion.setBackground(Color.black);
        //////////////////////////For ready 
        JButton readyToStart=new JButton("Ready to start GameSite Music");
        readyToStart.setBounds(220,200,400,40);
        readyToStart.setForeground(Color.WHITE);
        readyToStart.setFont(new Font(null,Font.ITALIC,20));
        readyToStart.setBackground(Color.GREEN);
        readyToStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(agreeCondtion.isSelected()){
                    Condition_and_Availablity.dispose();
                    chooseTypeRap("MusicGameSite//","Please choose your type","Add new type ","Flag//",1);
                }
                else{
                    JOptionPane.showMessageDialog(agreeCondtion, "You have to respond the box question ", "Uncheck block", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
       
        /////////////////////////Back to Main
        JButton back=new JButton("Back ");
        back.setBounds(220,250,400,40);
        back.setForeground(Color.WHITE);
        back.setFont(new Font(null,Font.ITALIC,20));
        back.setBackground(Color.PINK);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                MainActivity bac=new MainActivity(name, avatar);
            }
        });
        /////////////////////////add and visibility
        Condition_and_Availablity.add(displayCondition);
        Condition_and_Availablity.add(displayCondition1);
        Condition_and_Availablity.add(displayCondition2);
        Condition_and_Availablity.add(displayCondition3);
        Condition_and_Availablity.add(displayCondition4);
        Condition_and_Availablity.add(displayCondition5);
        Condition_and_Availablity.add(agreeCondtion);
        Condition_and_Availablity.add(agreeCondtion);
        Condition_and_Availablity.add(readyToStart);
        Condition_and_Availablity.add(back);
        Condition_and_Availablity.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Condition_and_Availablity.setVisible(true);
    }
    private void chooseTypeRap(String name,String title,String add,String obj,int time){
        File way=new File(name);
        ArrayList<String> allFile= getNameType(way.listFiles());
        ImageIcon icon=new ImageIcon("ImagesGameSite//ImageProjetEntier.jpg");
        getAll=new JFrame("All type");
        getAll.setBounds(450,90,500,600);
        getAll.setResizable(false);
        getAll.setIconImage(icon.getImage());
        getAll.getContentPane().setBackground(Color.BLACK);
        getAll.setLayout(null);
        getAll.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel top=new JLabel(title);
        top.setBounds(100,0,300,25);
        top.setForeground(Color.green);
        top.setFont(new Font(null,Font.ITALIC,20));
        top.setBackground(Color.BLACK);
        top.setOpaque(true);
        top.setVerticalAlignment(JLabel.TOP);
        top.setHorizontalAlignment(JLabel.CENTER);
        getAll.add(top);
        ////////////////////////////////////////////////////////////////
        int height=45;
        for(String label:allFile){
           JLabel type=new JLabel(label);
           type.setBounds(150,height,200,30);
           type.setFont(new Font(null,Font.ITALIC,20));
           type.setForeground(Color.black);
           type.setBackground(Color.WHITE);
           type.setOpaque(true);
           type.setVerticalAlignment(JLabel.TOP);
           type.setHorizontalAlignment(JLabel.CENTER);
           mouse(type,obj,time);
           getAll.add(type);
           height=height+40;
        }
        ////////////////////////////////////////////////////
        JButton createN=new JButton(add);
        createN.setBounds(120,height+20,250,30);
        createN.setForeground(Color.WHITE);
        createN.setFont(new Font(null,Font.ITALIC,20));
        createN.setBackground(Color.GREEN);
        createN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(allFile.size()>=9){
                   JOptionPane.showMessageDialog(null, "Sorry you can add more than 8 folder","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(time==1){
                        if(conditionNewType("For creating a new type you have to enter a name with at least 8 characters and his flag")==0){
                            getAll.dispose();
                            createNewType("MusicGameSite//","Flag//",action1,"Choose a flag");
                        }
                        
                    }
                    if(time==2){
                        if(conditionNewType("For creating a new Singer you have to enter a name with at least 8 characters,choose his image and background color")==0){
                            getAll.dispose();
                            createNewType(name+"//",obj,action2,"Choose a image");
                        }
                    }

                }
                
            }
        });
        getAll.add(createN);
        JButton back=new JButton("Back");
        back.setBounds(120,height+60,250,30);
        back.setForeground(Color.WHITE);
        back.setFont(new Font(null,Font.ITALIC,20));
        back.setBackground(Color.blue);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(time==1){
                    getAll.dispose();
                    conditionOfuse();
                }
                if(time==2){
                    getAll.dispose();
                    chooseTypeRap("MusicGameSite//","Please choose your type","Add new type ","Flag//",1);
                }
            }
        });
        getAll.add(back);
        /////////////////////////////////////////////////////
        JButton delet=new JButton("Delete this folder");
        delet.setBounds(120,height+100,250,30);
        delet.setForeground(Color.WHITE);
        delet.setFont(new Font(null,Font.ITALIC,20));
        delet.setBackground(Color.RED);
        if(time==1){
            delet.setEnabled(false);
        }
        delet.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
               File musicFile=new File(name);
               File imageFile=new File(obj);
               File flagFile=new File("Flag//"+musicFile.getName()+".PNG");
               if(JOptionPane.showConfirmDialog(null,"Are you sure about deleting "+musicFile.getName()+" ?","Comfirmation",JOptionPane.YES_NO_OPTION)==0){
                if(audio_Player==true){
                    audioR.close();
                    playSection.dispose();
                    audio_Player=false;
                }
                File[] allFile=musicFile.listFiles();
                for(File all:allFile){
                     removeAllElement(all.getAbsolutePath());
                     all.delete();
                }
                removeAllElement(name);
                removeAllElement(obj);
                musicFile.delete();
                imageFile.delete();
                flagFile.delete();
                creationWaiting();
                 WaitLoading();
                getAll.dispose();

            }
               
                
         }
        });
        getAll.add(delet);
        /////////////////////////////////////////////////////
        getAll.setVisible(true);
    }
    private ArrayList<String> getNameType(File[] file){
        ArrayList<String> allName=new ArrayList<>();
        for(File name:file){
            allName.add(name.getName());
        }
        return allName;
    }
    private void mouse(JLabel label,String obj,int time){
        ImageIcon icon=new ImageIcon("ImagesGameSite//ImageProjetEntier.jpg");
        ImageIcon image=new ImageIcon(obj+label.getText()+".PNG");
        JLabel labelFLabel=new JLabel();
        labelFLabel.setBounds(0,0,image.getIconWidth(),image.getIconHeight()+10);
        labelFLabel.setIcon(image);
        JFrame frameFlag=new JFrame("Diffusion");
        frameFlag.setBounds(940,90,labelFLabel.getWidth(),labelFLabel.getHeight());
        frameFlag.setResizable(false);
        frameFlag.setLayout(null);
        frameFlag.setIconImage(icon.getImage());
        frameFlag.add(labelFLabel);
        frameFlag.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e){
                frameFlag.dispose();
                if(time==1){
                    
                    getAll.dispose();
                    chooseTypeRap("MusicGameSite//"+label.getText(),"Please choose your singer","Add new singer ","ImageSingers//"+label.getText()+"//",2);
                    
                }
                else{
                    getAll.dispose();
                    String[] sFile=new String[3];
                    sFile[0]="MusicGameSite//";
                    sFile[2]=label.getText();
                    playMusicMakeFrame(sFile,obj+label.getText()+".PNG");
                }
                
            }
            public void mousePressed(MouseEvent e){
                frameFlag.setVisible(true);
            }
            public void mouseReleased(MouseEvent e){
                frameFlag.dispose();
                if(time==1){
                    getAll.dispose();
                    chooseTypeRap("MusicGameSite//"+label.getText(),"Please choose your singer","Add new singer ","ImageSingers//"+label.getText()+"//",2);
                }
            }
            public void mouseEntered(MouseEvent e){
                frameFlag.setVisible(true);
            }
            public void mouseExited(MouseEvent e){
               frameFlag.dispose();
            }
        });
    }
    private void playMusicMakeFrame(String[] songs,String imageSinger){
        displayMusic=new JFrame();
        displayMusic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon=new ImageIcon("ImagesGameSite//ImageProjetEntier.jpg");
        ImageIcon imageS=new ImageIcon(imageSinger);//Pour l'image de l'Artiste
        JLabel iconImage=new JLabel();
        iconImage.setBounds(0,0,imageS.getIconWidth(),imageS.getIconHeight());
        iconImage.setIcon(imageS);
        songs[1]=localiseFile(imageSinger);
        String allS=songs[0]+songs[1]+songs[2];
        File allMusic=new File(allS);
        dispoNibleFile=getNameType(allMusic.listFiles());
        int color=getColorRDB(allS+"//"+dispoNibleFile.remove(dispoNibleFile.indexOf("Color.txt")));
        displayMusic.setTitle("Music Player");
        displayMusic.setBounds(0,0,imageS.getIconWidth(),imageS.getIconHeight()+425);
        displayMusic.setLayout(null);
        displayMusic.add(iconImage);
        displayMusic.setIconImage(icon.getImage());
        displayMusic.getContentPane().setBackground(new Color(color));
        displayMusic.setResizable(false);
        ////////////////////////////
        JButton createN=new JButton("Add new song");
        createN.setBounds(0,imageS.getIconHeight()+2,imageS.getIconWidth()/2,30);
        createN.setForeground(Color.WHITE);
        createN.setFont(new Font(null,Font.ITALIC,20));
        createN.setBackground(Color.MAGENTA);
        createN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(dispoNibleFile.size()>=8){
                    JOptionPane.showMessageDialog(null, "Sorry you can add more than 8 folder","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(conditionNewType("For this program you have to insert WAV file")==0){
                        JFileChooser choose=new JFileChooser();
                        rep=choose.showOpenDialog(null);
                        if(rep==0){
                            File nameF=new File(choose.getSelectedFile().getAbsolutePath());
                            if(isMatch(choose.getSelectedFile().getAbsolutePath(),"wav")){
                                myFlag=choose.getSelectedFile().getAbsolutePath();
                                createFile(myFlag,allS+"//",nameF.getName(),"");
                                displayMusic.dispose();
                                creationWaiting();
                                WaitLoading();
                               
                            }
                            else{
                                JOptionPane.showMessageDialog(choose, "Please choose an wav ", "ERROR ", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }

                }
               
            }
        });
        displayMusic.add(createN);
        ////////////////////////////
        JButton back=new JButton("Back");
        back.setBounds(imageS.getIconWidth()/2,imageS.getIconHeight()+2,imageS.getIconWidth()/2,30);
        back.setForeground(Color.WHITE);
        back.setFont(new Font(null,Font.ITALIC,20));
        back.setBackground(Color.cyan);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(audio_Player==true){
                  playSection.dispose();
                  audioR.stop();
                  closeMusic();
                  audio_Player=false;
                  chooseTypeRap("MusicGameSite//","Please choose your type","Add new type ","Flag//",1);
                }
                else{
                    closeMusic();
                    chooseTypeRap("MusicGameSite//","Please choose your type","Add new type ","Flag//",1);
                }
                
            }
        });
        displayMusic.add(back);
        ///////////////////////////////////
        JButton DeteSinger=new JButton("Delect this Singer");
        DeteSinger.setBounds(0,imageS.getIconHeight()+32,imageS.getIconWidth(),30);
        DeteSinger.setForeground(Color.WHITE);
        DeteSinger.setFont(new Font(null,Font.ITALIC,20));
        DeteSinger.setBackground(Color.RED);
        displayMusic.add(DeteSinger);
        DeteSinger.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                File file=new File(allS);
                File file2=new File(imageSinger);
                if(JOptionPane.showConfirmDialog(null,"Are you sure about deleting "+file.getName()+" ?","Comfirmation",JOptionPane.YES_NO_OPTION)==0){
                    if(audio_Player==true){
                        audioR.close();
                        playSection.dispose();
                        audio_Player=false;
                    }
                    removeAllElement(allS);
                   file.delete();
                   file2.delete();
                   creationWaiting();
                   WaitLoading();
                   displayMusic.dispose();
                   //playSection.dispose();
                  
                }
            }
        });
        ////////////////////////////////////
        int height=65;
        for(String file:dispoNibleFile){
            JButton type=new JButton(file);
            type.setBounds(20,iconImage.getHeight()+height,imageS.getIconWidth()-60,30);
            type.setFont(new Font(null,Font.BOLD,20));
            type.setForeground(Color.BLACK);
            type.setBackground(Color.WHITE);
            type.setOpaque(true);
            type.setVerticalAlignment(JLabel.TOP);
            type.setHorizontalAlignment(JLabel.CENTER);
            type.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    if(audio_Player==false){
                        playMucic(type,allS+"//",imageS.getIconWidth()+1);
                    }
                    else{
                        audioR.stop();
                        audioR.close();
                        playSection.dispose();
                        playMucic(type,allS+"//",imageS.getIconWidth()+1);
                    }
                    
                }
            });
            displayMusic.add(type);
            height=height+35;
         }

        //////////////////////////////////
        
        displayMusic.setVisible(true);
        
    }
    private int getColorRDB(String file){
        File wayToFile=new File(file);
        String number="";
        try{
            FileReader  readNumber=new FileReader(wayToFile);
            int dataNumber=readNumber.read();
            while(dataNumber!=-1){
                number=number+((char)dataNumber);
                dataNumber=readNumber.read();
            }
            readNumber.close();

        }
        catch(Exception e){
            conditionOfuse();
        }
        return Integer.valueOf(number);
    }
    private String localiseFile(String name ){
        String[] specific=name.split("//");
        return specific[1]+"//";
    }
    private void closeMusic(){
        displayMusic.dispose();
    }
    private void playMucic(JButton music,String way,int start){
        wayA=way+music.getText();
        ImageIcon icon=new ImageIcon("ImagesGameSite//ImageProjetEntier.jpg");
        playSection=new JFrame("audio Player");
        playSection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Border bor=BorderFactory.createLineBorder(Color.ORANGE,3);
        //////////////////////////////
        musicPlaying=new JLabel(music.getText());
        musicPlaying.setBounds(0,0,485,33);
        musicPlaying.setHorizontalAlignment(JLabel.CENTER);
        musicPlaying.setVerticalAlignment(JLabel.CENTER);
        musicPlaying.setForeground(Color.BLACK);
        musicPlaying.setFont(new Font(null,Font.BOLD,20));
        music.setBackground(Color.WHITE);
        musicPlaying.setBorder(bor);
        ///////////////////////
        Start_Music=new JButton("Start");
        Start_Music.setBounds(10,35,90,40);
        Start_Music.setForeground(Color.white);
        Start_Music.setFont(new Font(null,Font.ITALIC,20));
        Start_Music.setBackground(Color.lightGray);
        Start_Music.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                openAudio(wayA);
                
            }
        });
        /////////////////////
        Stop_Music=new JButton("Close");
        Stop_Music.setBounds(130,35,90,40);
        Stop_Music.setForeground(Color.white);
        Stop_Music.setFont(new Font(null,Font.ITALIC,20));
        Stop_Music.setBackground(Color.PINK);
        Stop_Music.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                audioR.stop();
                playSection.dispose();
                
            }
        });

        ///////////////////
        Restart_Music=new JButton("Restart");
        Restart_Music.setBounds(250,35,100,40);
        Restart_Music.setForeground(Color.white);
        Restart_Music.setFont(new Font(null,Font.ITALIC,20));
        Restart_Music.setBackground(Color.BLUE);
        Restart_Music.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                audioR.setMicrosecondPosition(0);
            }
        });
        //////////////////
        Next_Music=new JButton("Next ");
        Next_Music.setBounds(380,35,100,40);
        Next_Music.setForeground(Color.white);
        Next_Music.setFont(new Font(null,Font.ITALIC,20));
        Next_Music.setBackground(Color.GREEN);
        Next_Music.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(audio_Player==true){
                    audioR.close();
                    String[] next=getNextSong(wayA);
                    wayA=next[0];
                    musicPlaying.setText(next[1]);
                    openAudio(next[0]);
                }
            }
        });
        //////////////////////
        Delet_Music=new JButton("Delet this music");
        Delet_Music.setBounds(10,78,470,30);
        Delet_Music.setForeground(Color.white);
        Delet_Music.setFont(new Font(null,Font.ITALIC,20));
        Delet_Music.setBackground(Color.RED);
        Delet_Music.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){/////////////////////////////////
                File file=new File(wayA);
                if(JOptionPane.showConfirmDialog(null,"Are you sure about deleting "+file.getName()+" ?","Comfirmation",JOptionPane.YES_NO_OPTION)==0){
                    if(audio_Player==true){
                        audioR.close();
                        playSection.dispose();
                        audio_Player=false;
                    }
                  
                   file.delete();
                   creationWaiting();
                   WaitLoading();
                   playSection.dispose();
                   displayMusic.dispose();
                }
            }
        });
        ///////////////////
        playSection.setBounds(start,0,500,150);
        playSection.setLayout(null);
        playSection.add(musicPlaying);
        playSection.add(Start_Music);
        playSection.add(Stop_Music);
        playSection.add(Restart_Music);
        playSection.add(Next_Music);
        playSection.add(Delet_Music);
        playSection.setIconImage(icon.getImage());
        playSection.setVisible(true);

    }
    private void openAudio(String audioWay){
        if(oneShow==1){
            showActivity();
            oneShow++;
        }
        saveNewActivity(audioWay);
        File audio=new File(audioWay);
        audio_Player=true;
        try{
            audioSong=AudioSystem.getAudioInputStream(audio);
            audioR=AudioSystem.getClip();
            audioR.open(audioSong);
            audioR.start();
            Start_Music.setEnabled(false);
            
        }
        catch(IOException e){}
        catch(LineUnavailableException t){}
        catch(UnsupportedAudioFileException r){}
    }
    private String[] getNextSong(String nameSongPlaying){
        String[] song=new String[2];
        String[] getSong=nameSongPlaying.split("//");
        int indexofSong=dispoNibleFile.indexOf(getSong[3]);
        if(indexofSong+1>=dispoNibleFile.size()){
            song[0]=getSong[0]+"//"+getSong[1]+"//"+getSong[2]+"//"+dispoNibleFile.get(0);
            song[1]=dispoNibleFile.get(0);
            return song ;
        }
        else{
            song[0]=getSong[0]+"//"+getSong[1]+"//"+getSong[2]+"//"+dispoNibleFile.get(indexofSong+1);
            song[1]=dispoNibleFile.get(indexofSong+1);
            return song ;
           
        }

       
    }
    private int conditionNewType(String name){
        String[] condition={"Understood","Cancel"};
        return JOptionPane.showOptionDialog(null,name, "Information message", 0,JOptionPane.INFORMATION_MESSAGE, null, condition, 0);
        
    }
    private void createNewType(String wayLocation,String stock,String action,String image){
        myFlag=null;
        ImageIcon icon=new ImageIcon("ImagesGameSite//ImageProjetEntier.jpg");
        ImageIcon iconavtr=new ImageIcon(avatar);
        JFrame newType=new JFrame("New type");
        newType.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newType.setBounds(400,100,540,480);
        newType.setLayout(null);
        newType.setResizable(false);
        newType.setIconImage(icon.getImage());
        newType.getContentPane().setBackground(Color.GRAY);
        /////////////////////////////////////////////
        JLabel iconavatar=new JLabel();
        iconavatar.setIcon(iconavtr);
        iconavatar.setBounds(220,5,iconavtr.getIconWidth(),iconavtr.getIconHeight());
        newType.add(iconavatar);
        ////////////////////////////////////////////
        JLabel nameP=new JLabel(name);
        nameP.setBounds(220,iconavatar.getHeight()+5,iconavtr.getIconWidth(),25);
        nameP.setForeground(Color.BLACK);
        nameP.setBackground(Color.GRAY);
        nameP.setFont(new Font(null,Font.BOLD,20));
        nameP.setHorizontalAlignment(JLabel.CENTER);
        newType.add(nameP);
        ////////////////////////////////////////////
        JLabel actionTodo=new JLabel(action);
        actionTodo.setBounds(200,175,200,20);
        actionTodo.setForeground(Color.YELLOW);
        actionTodo.setBackground(Color.GRAY);
        actionTodo.setFont(new Font(null,Font.ITALIC,20));
        newType.add(actionTodo);
        ////////////////////////////////////////////
        JTextField newName=new JTextField("Insert name with minimun 4 or maximum 8 chars");
        newName.setBounds(10,200,500,40);
        newName.setBackground(Color.LIGHT_GRAY);
        newName.setFont(new Font(null,Font.ITALIC,20));
        newName.setForeground(Color.black);
        newName.setCaretColor(Color.GREEN);
        newType.add(newName);
        /////////////////////////////////////
        JButton chooseImage=new JButton(image);
        chooseImage.setBounds(10,245,500,40);
        chooseImage.setBackground(Color.BLUE);
        chooseImage.setForeground(Color.WHITE);
        chooseImage.setFont(new Font(null,Font.BOLD,20));
        chooseImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFileChooser choose=new JFileChooser();
                rep=choose.showOpenDialog(null);
                if(rep==0){
                    if(isMatch(choose.getSelectedFile().getAbsolutePath(),"PNG")){
                        myFlag=choose.getSelectedFile().getAbsolutePath();
                        chooseImage.setText("Image saved successful");
                        chooseImage.setEnabled(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(choose, "Please choose an image ", "ERROR ", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        newType.add(chooseImage);
        //////////////////////////////////
        String[] color={"YELLOW","WHITE","BLUE","GRAY"};
        JComboBox chooseColor=new JComboBox<String>(color);
        if(action.equals(action1)){
            chooseColor.setEnabled(false);
        }
        chooseColor.setBounds(10,285,500,40);
        chooseColor.setBackground(Color.BLACK);
        chooseColor.setFont(new Font(null,Font.BOLD,20));
        chooseColor.setForeground(Color.WHITE);
        newType.add(chooseColor);
        /////////////////////////////////
        JButton createFile=new JButton(" create ");
        createFile.setBounds(10,330,500,40);
        createFile.setBackground(Color.GREEN);
        createFile.setForeground(Color.WHITE);
        createFile.setFont(new Font(null,Font.BOLD,20));
        createFile.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
             if((isEnoughChar(newName.getText().trim())&&(myFlag.equals(null)==false))){
                File newFile=new File(wayLocation+newName.getText().trim());
                File newImage=new File(stock+newName.getText());
                File imageL=new File("ImageSingers//"+newName.getText().trim());
                createFile.setEnabled(false);
                if(newFile.exists()||newImage.exists()){
                    JOptionPane.showMessageDialog(createFile, "The file already exixts ", "ERROR ", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(action.equals(action1)){
                        newFile.mkdir();
                        imageL.mkdir();
                        createFile(myFlag,stock,newName.getText().trim(),".PNG");
                        newType.dispose();
                        creationWaiting();
                        WaitLoading();
                    }
                    else{//////////////:Here
                        newFile.mkdir();
                        insetColorChoose(chooseColor.getSelectedIndex(),wayLocation+newName.getText().trim());
                        createFile(myFlag,stock,newName.getText().trim(),".PNG");
                        newType.dispose();
                        creationWaiting();
                        WaitLoading();
                    }
                }
             }
             else{
                JOptionPane.showMessageDialog(createFile, "Please respect all condition  ", "ERROR  during creation", JOptionPane.ERROR_MESSAGE);
             }
           }
        });
        newType.add(createFile);
        ////////////////////////////////////////
        JButton back=new JButton("back");
        back.setBounds(0,380,100,40);
        back.setBackground(Color.ORANGE);
        back.setForeground(Color.WHITE);
        back.setFont(new Font(null,Font.BOLD,20));
        back.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
             newType.dispose();
             chooseTypeRap("MusicGameSite//","Please choose your type","Add new type ","Flag//",1);
           } 
        });
        newType.add(back);
        ///////////////////////////////////////
        newType.setVisible(true);

    }
    private boolean isEnoughChar(String name){
        String[] chart=name.split("");
        if(chart.length<4){
            JOptionPane.showMessageDialog(null, "Please more than 3 chars  ", "ERROR  ", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if( chart.length>8){
            JOptionPane.showMessageDialog(null, "Please less than 8 chars ", "ERROR ", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            return true;
        }
        
    }
    private boolean isMatch(String name,String type){
        String[] flagt=name.split("");
        return (flagt[flagt.length-3]+flagt[flagt.length-2]+flagt[flagt.length-1]).equals(type);
    }
    private  void creationWaiting(){
        ImageIcon icon=new ImageIcon("ImagesGameSite//ImageProjetEntier.jpg");
        frameWaiting=new JFrame();
        frameWaiting.setTitle("Operation in process  ........");
        frameWaiting.getContentPane().setBackground(Color.GRAY);
        frameWaiting.setIconImage(icon.getImage());
        frameWaiting.setLayout(null);
        frameWaiting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameWaiting.setBounds(500,200,520,180);
        frameWaiting.setResizable(false);
        ////////////////Label
        labelWaiting=new JLabel("process....");     
        labelWaiting.setBounds(0,20,200,40);
        labelWaiting.setBackground(Color.BLACK);
        labelWaiting.setFont(new Font(null,Font.ITALIC,20));
        labelWaiting.setForeground(Color.YELLOW);
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
        start=new JButton("Start again");
        start.setBounds(barWaiting.getX()+56,barWaiting.getY()+70,200,40);
        start.setBackground(Color.white);
        start.setFont(new Font(null,Font.BOLD,20));
        start.setForeground(Color.BLACK);
        start.setEnabled(false);
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frameWaiting.dispose();
                PlayMusic startAgain=new PlayMusic(name, avatar, location);
            }
        });
       
        frameWaiting.add(start);
        ////////////Visibility
        frameWaiting.setVisible(true);
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
                    frameWaiting.setTitle("Completed");
                    labelWaiting.setText("Operation :");
                    barWaiting.setString(" completed");
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
    private void createFile(String sourceW,String nameFlag,String name,String type){
        Path source=Paths.get(sourceW);
        Path direction=Paths.get(nameFlag);
        try{
            Files.move(source,direction.resolve(name+type));
        }
        catch(Exception e){}
       
    }
    private void insetColorChoose(int color,String way){
        if(color==0){
           createColor(YELLOW,way);
        }
        else if(color==1){
            createColor(WHITE,way);
        }
        else if(color==2){
            createColor(BLUE,way);
        }
        else{
            createColor(GRAY,way);
        }
    }
    private void createColor(String color,String wayToInsert){
        File place=new File(wayToInsert+"//Color.txt");
        try{
            place.createNewFile();
            FileWriter writeColor=new FileWriter(place);
            writeColor.write(color);
            writeColor.close();
        }
        catch(Exception e){}
    }
    private void removeAllElement(String way){
         File file=new File(way);
         File[] all=file.listFiles(); 
         for(File s:all) {
            s.delete();
         }
    }
    private void showActivity(){
        ImageIcon icon=new ImageIcon("ImagesGameSite//ImageProjetEntier.jpg");
        JButton activity=new JButton("see yours activities");
        activity.setBackground(Color.green);
        activity.setFont(new Font(null,Font.BOLD,20));
        activity.setForeground(Color.WHITE);
        activity.setBounds(0,0,300,40);
        activity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(conditionNewType("To get your historic you have to show where you want to save it and insert a name")==0){
                    JFileChooser file=new JFileChooser();
                    if((file.showSaveDialog(null))==0){
                        saveHistorique(file.getSelectedFile().getAbsolutePath());
                        JOptionPane.showMessageDialog(null, "You can now check your hsitoric", "Comfirmation", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        ///////////////////////////////////////////////////
        activityFrame=new JFrame("Activity");
        activityFrame.setBounds(1085,0,300,100);
        activityFrame.setIconImage(icon.getImage());
        activityFrame.add(activity);
        activityFrame.setVisible(true);

    }
    private void saveNewActivity(String nameFile){
        String info="";
       File activity=new File("Info//"+name+"//ACTIVITY.txt");
       Date time=new Date();
       try{
         if(activity.exists()){
               FileReader oldFold=new FileReader(activity);
               int data=oldFold.read();
               while(data!=-1){
                 info=info+((char)data);
                 data=oldFold.read();
               }
               oldFold.close();
               info=info+"\n"+time.toString()+" you play :"+nameFile;
               FileWriter write=new FileWriter(activity);
               write.write(info);
               write.close();
         }
         else{
            activity.createNewFile();
            info=time.toString()+" you play :"+nameFile;
            FileWriter write=new FileWriter(activity);
            write.write(info);
            write.close();
         }
       }
       catch(Exception v){}
    }
    private void saveHistorique(String way){
        File activity=new File("Info//"+name+"//ACTIVITY.txt");
        File savein=new File(way+".txt");
        String info="";
        try{
            savein.createNewFile();
            FileReader oldFold=new FileReader(activity);
               int data=oldFold.read();
               while(data!=-1){
                 info=info+((char)data);
                 data=oldFold.read();
               }
               oldFold.close();
            FileWriter writeInfo=new FileWriter(savein);
            writeInfo.write(info);
            writeInfo.close();
            
        }
        catch(Exception e){}
        
        
    }
    
   
   
    
}
