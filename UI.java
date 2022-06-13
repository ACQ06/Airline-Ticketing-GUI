import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class LaunchPage extends JFrame implements ActionListener {
    public int Height = 755, Width = 1025;
    public int White = 0xffffff, Purple = 0x5D36FF;
    JButton book;
    Font titleFont = new Font("Open Sans", Font.BOLD, 60);
    Font contentFont = new Font("Open Sans", Font.BOLD, 30);

    LaunchPage(){

        //Book Now button
        book = new JButton();
        book.setBounds((Width/2)-126, (Height/2)+25, 252, 50);
        book.setOpaque(false);
        book.setContentAreaFilled(false);
        book.setBorderPainted(false);
        book.addActionListener(this);


        //FRAME
        this.setUndecorated(true);
        this.setResizable(false);
        this.setSize(Width,Height);
        this.setBackground(new Color(0, 0, 0,0));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(book);
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        //ANTI ALIASING
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //FRAME
        g2D.setColor(new Color(White));
        RoundRectangle2D frame = new RoundRectangle2D.Float(0, 0, Width, Height, 50, 50);
        g2D.fill(frame);



        //MANILA AIR TEXT
        g2D.setColor(new Color(Purple));
        g.setFont(titleFont);
        g2D.drawString("MANILA AIR", (Width/2)-170, Height/2);

        //BUTTON RECT
        RoundRectangle2D book = new RoundRectangle2D.Float((Width/2)-126, (Height/2)+25, 252, 50, 20, 20);
        g2D.fill(book);

        //BUTTON TEXT
        g2D.setColor(new Color(White));
        g.setFont(contentFont);
        g2D.drawString("BOOK NOW!",((Width/2)-88),(Height/2)+60);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==book){
            this.setVisible(false);
            new FirstPage();
        }
    }
}

class FirstPage extends  JFrame implements ActionListener {
    public int Height = 755, Width = 1025;
    public int White = 0xffffff, Purple = 0x5D36FF;
    Font headerFont = new Font("Open Sans", Font.BOLD, 30);
    Font contentFont = new Font("Open Sans", Font.BOLD, 16);
    JButton Private, Business, Regular;
    BufferedImage image;
    {
        try {
            image = ImageIO.read(new File("D:\\Alven - School works\\SECOND SEM\\COMPROG2\\PROJECT\\LOGOS\\1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    FirstPage(){

        /*
           BUTTONS
         */
        Private = new JButton();
        Private.setBounds(95,480,150,40);
        Private.setOpaque(false);
        Private.setContentAreaFilled(false);
        Private.setBorderPainted(false);
        Private.addActionListener(this);

        Business = new JButton();
        Business.setBounds(440,480,150,40);
        Business.setOpaque(false);
        Business.setContentAreaFilled(false);
        Business.setBorderPainted(false);
        Business.addActionListener(this);

        Regular = new JButton();
        Regular.setBounds(780,480,150,40);
        Regular.setOpaque(false);
        Regular.setContentAreaFilled(false);
        Regular.setBorderPainted(false);
        Regular.addActionListener(this);


        //FRAME
        this.setUndecorated(true);
        this.setResizable(false);
        this.setSize(Width,Height);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(Private);
        this.add(Business);
        this.add(Regular);
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        //ANTI ALIASING
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //FRAME RECT
        g2D.setColor(new Color(White));
        RoundRectangle2D frame = new RoundRectangle2D.Float(0, 0, Width, Height, 50, 50);
        g2D.fill(frame);


        /*
            HEADER
         */

        //HEADER RECT
        g2D.setColor(new Color(Purple));
        RoundRectangle2D header = new RoundRectangle2D.Float(0,0,Width,80,45,45);
        g2D.fill(header);

        Image logo = image.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        g2D.drawImage(logo,5,0,null);
        g2D.setColor(new Color(White));
        g2D.setFont(headerFont);
        g2D.drawString("MANILA",80,35);
        g2D.drawString("AIR",80,70);




        //TITLE TEXT
        g2D.setFont(headerFont);
        g2D.drawString("AIRPLANE TYPE", ((Width/2)-88),(Height/20));

        //PROGRESS BAR
        g2D.setColor(new Color(255,255,255));
        g2D.fillOval(341, 45, 25,25);
        g2D.setColor(new Color(255,255,255,75));
        g2D.fillRect(366,56,96,4);
        g2D.fillOval(462, 45, 25,25);
        g2D.fillRect(487,56,96,4);
        g2D.fillOval(583, 45, 25,25);
        g2D.fillRect(608,56,96,4);
        g2D.fillOval(704, 45, 25,25);




        //CONTENTS
        g2D.setColor(new Color(Purple));

        /*
            PRIVATE
            AIRLINE
            TYPE
         */
        RoundRectangle2D Private = new RoundRectangle2D.Float(46,250,250,300,25,25);
        g2D.fill(Private);

        g2D.setColor(new Color(White));
        g.setFont(headerFont);
        g2D.drawString("PRIVATE",105,300);
        g.setFont(contentFont);
        g2D.drawString("20 MAXIMUM CAPACITY",56,350);
        g2D.drawString("₱ 550 TRANSACTION FEE",56,400);
        g2D.drawString("₱ 4,260 TAX PER PASSENGER",56,450);

        RoundRectangle2D privateSelect = new RoundRectangle2D.Float(95,480,150,40,40,40);
        g2D.fill(privateSelect);

        g2D.setColor(new Color(Purple));
        g.setFont(headerFont);
        g2D.drawString("SELECT",110,512);


        /*
            BUSINESS
            AIRLINE
            TYPE
         */
        RoundRectangle2D Business = new RoundRectangle2D.Float(387,250,250,300,25,25);
        g2D.fill(Business);

        g2D.setColor(new Color(White));
        g.setFont(headerFont);
        g2D.drawString("BUSINESS",435,300);
        g.setFont(contentFont);
        g2D.drawString("30 MAXIMUM CAPACITY",397,350);
        g2D.drawString("₱ 550 TRANSACTION FEE",397,400);
        g2D.drawString("₱ 5,700 TAX PER PASSENGER",397,450);

        RoundRectangle2D businessSelect = new RoundRectangle2D.Float(440,480,150,40,40,40);
        g2D.fill(businessSelect);

        g2D.setColor(new Color(Purple));
        g.setFont(headerFont);
        g2D.drawString("SELECT",455,512);


        /*
            REGULAR
            AIRLINE
            TYPE
         */
        RoundRectangle2D Regular = new RoundRectangle2D.Float(728,250,250,300,25,25);
        g2D.fill(Regular);

        g2D.setColor(new Color(White));
        g.setFont(headerFont);
        g2D.drawString("REGULAR",780,300);
        g.setFont(contentFont);
        g2D.drawString("20 MAXIMUM CAPACITY",738,350);
        g2D.drawString("₱ 255 TRANSACTION FEE",738,400);
        g2D.drawString("₱ 2,500 TRANSACTION FEE",738,450);

        RoundRectangle2D regularSelect = new RoundRectangle2D.Float(780,480,150,40,40,40);
        g2D.fill(regularSelect);

        g2D.setColor(new Color(Purple));
        g.setFont(headerFont);
        g2D.drawString("SELECT",795,512);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Private){
            System.out.print("Private");
            this.setVisible(false);
            new SecondPage();
        }

        else if (e.getSource()==Business){
            System.out.print("Business");
            this.setVisible(false);
            new SecondPage();
        }

        else if (e.getSource()==Regular){
            System.out.print("Regular");
            this.setVisible(false);
            new SecondPage();
        }
    }
}

class SecondPage extends  JFrame implements ActionListener {
    public int Height = 755, Width = 1025;
    public int White = 0xffffff, Purple = 0x5D36FF;
    public int i=0,num=0;
    Font headerFont = new Font("Open Sans", Font.BOLD, 30);
    JTextField NumberOfPassengers, Name, Age;
    JButton next1, next2;
    BufferedImage image;
    {
        try {
            image = ImageIO.read(new File("D:\\Alven - School works\\SECOND SEM\\COMPROG2\\PROJECT\\LOGOS\\1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    SecondPage(){


        /*
            TEXT BOX
         */
        NumberOfPassengers = new JTextField();
        NumberOfPassengers.setBounds(450,113,100,50);
        NumberOfPassengers.setFont(headerFont);

        Name = new JTextField();
        Name.setBounds(30,550,400,50);
        Name.setFont(headerFont);

        Age = new JTextField();
        Age.setBounds(541,550,400,50);
        Age.setFont(headerFont);

        /*
            BUTTONS
         */
        next1 = new JButton();
        next1.setBounds(580,117,120,40);
        next1.setOpaque(true);
        next1.setContentAreaFilled(true);
        next1.setBorderPainted(true);
        next1.addActionListener(this);

        next2 = new JButton();
        next2.setBounds(850,650,120,40);
        next2.setOpaque(false);
        next2.setContentAreaFilled(false);
        next2.setBorderPainted(false);
        next2.addActionListener(this);

        /*
            FRAME
         */
        this.setUndecorated(true);
        this.setResizable(false);
        this.setSize(Width,Height);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(NumberOfPassengers);
        this.add(Name);
        this.add(Age);
        this.add(next1);
        this.add(next2);
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        //ANTI ALIASING
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //FRAME
        g2D.setColor(new Color(White));
        RoundRectangle2D frame = new RoundRectangle2D.Float(0, 0, Width, Height, 50, 50);
        g2D.fill(frame);

        /*
            HEADER
         */

        //HEADER RECT
        g2D.setColor(new Color(Purple));
        RoundRectangle2D header = new RoundRectangle2D.Float(0,0,Width,80,45,45);
        g2D.fill(header);

        Image logo = image.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        g2D.drawImage(logo,5,0,null);
        g2D.setColor(new Color(White));
        g2D.setFont(headerFont);
        g2D.drawString("MANILA",80,35);
        g2D.drawString("AIR",80,70);

        //TITLE TEXT
        g2D.setFont(headerFont);
        g2D.drawString("PASSENGER DETAILS", ((Width/2)-88),(Height/20));



        //PROGRESS BAR
        g2D.setColor(new Color(255,255,255,25));
        g2D.fillOval(341, 45, 25,25);
        g2D.fillRect(366,56,96,4);
        g2D.setColor(new Color(White));
        g2D.fillOval(462, 45, 25,25);
        g2D.setColor(new Color(255,255,255,25));
        g2D.fillRect(487,56,96,4);
        g2D.fillOval(583, 45, 25,25);
        g2D.fillRect(608,56,96,4);
        g2D.fillOval(704, 45, 25,25);

        /*
            CONTENTS
        */
        g2D.setColor(new Color(Purple));
        g2D.setFont(headerFont);
        g2D.drawString("NUMBER OF PASSENGERS: ", 30,150);

        RoundRectangle2D next1 = new RoundRectangle2D.Float(580,117,120,40,40,40);
        g2D.fill(next1);

        g2D.setColor(new Color(White));
        g2D.drawString("NEXT",600,147);

        g2D.setColor(new Color(Purple));
        RoundRectangle2D details = new RoundRectangle2D.Float((Width/2)-75,300,150,50,15,15);
        g2D.fill(details);

        g2D.fillRect((Width/2)-2,420,2,250);

        g2D.setColor(new Color(White));
        g2D.drawString("DETAILS",(Width/2)-63,335);

        g2D.setColor(new Color(Purple));
        g2D.drawString("NAME", 30,550);
        g2D.drawString("AGE",541,550);

        g2D.fillRect(30,600,400,2);
        g2D.fillRect(541,600,400,2);

        RoundRectangle2D next2 = new RoundRectangle2D.Float(850,650,120,40,40,40);
        g2D.fill(next2);

        g2D.setColor(new Color(White));
        g2D.drawString("NEXT",870,680);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next1){
            num = Integer.parseInt(NumberOfPassengers.getText());
        }
        System.out.print(num);

        Infos []info = new Infos[num];
        if (e.getSource() == next2){

            info[i].setName(Name.getText());
            info[i].setAge(Integer.parseInt(Age.getText()));

            System.out.print("Info["+i+"]");

            System.out.println(info[i].getName());
            System.out.println(info[i].getAge());

            i++;
        }
    }
}

class ThirdPage extends JFrame{
    public int Height = 755, Width = 1025;
    public int White = 0xffffff, Purple = 0x5D36FF;
    Font headerFont = new Font("Open Sans", Font.BOLD, 30);
    BufferedImage image;
    {
        try {
            image = ImageIO.read(new File("D:\\Alven - School works\\SECOND SEM\\COMPROG2\\PROJECT\\LOGOS\\1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ThirdPage(){
        //FRAME
        this.setUndecorated(true);
        this.setResizable(false);
        this.setSize(1025,755);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        //ANTI ALIASING
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //FRAME
        g2D.setColor(new Color(0xffffff));
        RoundRectangle2D frame = new RoundRectangle2D.Float(0, 0, 1025, 755, 50, 50);
        g2D.fill(frame);

         /*
            HEADER
         */

        //HEADER RECT
        g2D.setColor(new Color(Purple));
        RoundRectangle2D header = new RoundRectangle2D.Float(0,0,Width,80,45,45);
        g2D.fill(header);

        Image logo = image.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        g2D.drawImage(logo,5,0,null);
        g2D.setColor(new Color(White));
        g2D.setFont(headerFont);
        g2D.drawString("MANILA",80,35);
        g2D.drawString("AIR",80,70);




        //TITLE TEXT
        g2D.setFont(headerFont);
        g2D.drawString("AIRPLANE TYPE", ((Width/2)-88),(Height/20));

        //PROGRESS BAR
        g2D.setColor(new Color(255,255,255));
        g2D.fillOval(341, 45, 25,25);
        g2D.setColor(new Color(255,255,255,25));
        g2D.fillRect(366,56,96,4);
        g2D.fillOval(462, 45, 25,25);
        g2D.fillRect(487,56,96,4);
        g2D.fillOval(583, 45, 25,75);
        g2D.fillRect(608,56,96,4);
        g2D.fillOval(704, 45, 25,25);
    }
}

class FourthPage extends JFrame{
    public int Height = 755, Width = 1025;
    public int White = 0xffffff, Purple = 0x5D36FF;
    Font headerFont = new Font("Open Sans", Font.BOLD, 30);
    Font contentFont = new Font("Open Sans", Font.BOLD, 16);
    BufferedImage image;
    {
        try {
            image = ImageIO.read(new File("D:\\Alven - School works\\SECOND SEM\\COMPROG2\\PROJECT\\LOGOS\\1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    FourthPage(){
        //FRAME
        this.setUndecorated(true);
        this.setResizable(false);
        this.setSize(1025,755);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        //ANTI ALIASING
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //FRAME
        g2D.setColor(new Color(0xffffff));
        RoundRectangle2D frame = new RoundRectangle2D.Float(0, 0, 1025, 755, 50, 50);
        g2D.fill(frame);

        /*
            HEADER
         */

        //HEADER RECT
        g2D.setColor(new Color(Purple));
        RoundRectangle2D header = new RoundRectangle2D.Float(0,0,Width,80,45,45);
        g2D.fill(header);

        Image logo = image.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        g2D.drawImage(logo,5,0,null);
        g2D.setColor(new Color(White));
        g2D.setFont(headerFont);
        g2D.drawString("MANILA",80,35);
        g2D.drawString("AIR",80,70);




        //TITLE TEXT
        g2D.setFont(headerFont);
        g2D.drawString("AIRPLANE TYPE", ((Width/2)-88),(Height/20));

        //PROGRESS BAR
        g2D.setColor(new Color(255,255,255));
        g2D.fillOval(341, 45, 25,25);
        g2D.setColor(new Color(255,255,255,25));
        g2D.fillRect(366,56,96,4);
        g2D.fillOval(462, 45, 25,25);
        g2D.fillRect(487,56,96,4);
        g2D.fillOval(583, 45, 25,75);
        g2D.fillRect(608,56,96,4);
        g2D.fillOval(704, 45, 25,25);
    }
}

class EndPage extends JFrame{
    public int Height = 755, Width = 1025;
    public int White = 0xffffff, Purple = 0x5D36FF;
    Font headerFont = new Font("Open Sans", Font.BOLD, 30);
    BufferedImage image;
    {
        try {
            image = ImageIO.read(new File("D:\\Alven - School works\\SECOND SEM\\COMPROG2\\PROJECT\\LOGOS\\1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    EndPage(){
        //FRAME
        this.setUndecorated(true);
        this.setResizable(false);
        this.setSize(1025,755);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        //ANTI ALIASING
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //FRAME
        g2D.setColor(new Color(0xffffff));
        RoundRectangle2D frame = new RoundRectangle2D.Float(0, 0, 1025, 755, 50, 50);
        g2D.fill(frame);

        /*
            HEADER
         */

        //HEADER RECT
        g2D.setColor(new Color(Purple));
        RoundRectangle2D header = new RoundRectangle2D.Float(0,0,Width,80,45,45);
        g2D.fill(header);

        Image logo = image.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        g2D.drawImage(logo,5,0,null);
        g2D.setColor(new Color(White));
        g2D.setFont(headerFont);
        g2D.drawString("MANILA",80,35);
        g2D.drawString("AIR",80,70);
    }
}