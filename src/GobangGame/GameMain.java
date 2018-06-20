package GobangGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.applet.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.File;

public class GameMain extends JPanel implements GoBangInterface{
    /**
     * @param args
     */
    //游戏状态
    public static boolean isStarted = false;
    public static boolean isEnded = false;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        chesspanel.gobang();

    }

    public void gobang()
    {
       //设置背景音乐
        /*File file1 = new File("Days - Nuit Silencieuse.wav");
        AudioClip sound1 = null;
        try {
            sound1 = Applet.newAudioClip(file1.toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        sound1.play();
        sound1.loop();*/

        messagepanel.setPreferredSize(new Dimension(0,50));
        messagepanel.setLayout(null);
        //添加图片
        java.net.URL imgURL=getClass().getResource("title.png");
        ImageIcon icon = new ImageIcon(imgURL);
        //通过label显示
        JLabel l = new JLabel();
        l.setIcon(icon);
        l.setBounds(5,0,150,50);
        messagepanel.add(l);
        statuslabel.setBounds(300,5,500,50);
        messagepanel.add(statuslabel);
        statuslabel.setFont(new Font("微软雅黑",Font.PLAIN,20));

        setcontrolpanel();

        setFrame();

        chesspanelListener listener = new chesspanelListener(this);
        this.addMouseListener(listener);
    }
    public void setFrame()
    {
        //设置版面
        frame.setTitle("五子棋");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(850,750);
        //设置布局
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(this,BorderLayout.CENTER);
        frame.getContentPane().add(messagepanel,BorderLayout.NORTH);
        frame.getContentPane().add(controlpanel,BorderLayout.EAST);

        frame.setVisible(true);
    }
    public void setcontrolpanel()
    {
        controlpanel.setPreferredSize(new Dimension(150,0));
        controlpanel.setLayout(new BoxLayout(controlpanel,BoxLayout.Y_AXIS));

        JButton button1 = new JButton("开始游戏");
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);//设置组件横向居中
        button1.setFont(new Font("微软雅黑",Font.PLAIN,18));//设置字体
        button1.setMaximumSize(new Dimension(110,40));
        //添加按钮点击事件
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isStarted){
                    isStarted = true;
                    isEnded = false;
                    statuslabel.setText("游戏开始");
                    button1.setText("重新开始");
                    label1.setText("当前回合:\t 1");
                    label4.setText("黑棋落子");
                    return;
                }
                if(isStarted || isEnded) {
                    chesspanel.repaint();
                    clear();
                    statuslabel.setText("重新开始");
                    isEnded = false;
                }
            }});

        JButton button2 = new JButton("退出游戏");
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setFont(new Font("微软雅黑",Font.PLAIN,18));
        button2.setMaximumSize(new Dimension(110,40));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        JButton button3 = new JButton("作者博客");
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);
        button3.setFont(new Font("微软雅黑",Font.PLAIN,18));
        button3.setMaximumSize(new Dimension(110,40));
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent events) {
                if(java.awt.Desktop.isDesktopSupported()){
                    try{
                        //创建一个URI实例,注意不是URL
                        java.net.URI uri=java.net.URI.create("http://www.ayews.com/?p=137");
                        //获取当前系统桌面扩展
                        java.awt.Desktop dp=java.awt.Desktop.getDesktop();
                        //判断系统桌面是否支持要执行的功能
                        if(dp.isSupported(java.awt.Desktop.Action.BROWSE)){
                            //获取系统默认浏览器打开链接
                            dp.browse(uri);
                        }
                    }catch(java.lang.NullPointerException e){
                        //此为uri为空时抛出异常
                    }catch(java.io.IOException e){
                        //此为无法获取系统默认浏览器
                    }
                }
            }
        });
        //设置字体
        label1.setFont(new Font("微软雅黑",Font.PLAIN,20));
        label1.setAlignmentX(CENTER_ALIGNMENT);

        label2.setFont(new Font("微软雅黑",Font.PLAIN,20));
        label2.setAlignmentX(CENTER_ALIGNMENT);

        label3.setFont(new Font("微软雅黑",Font.PLAIN,20));
        label3.setAlignmentX(CENTER_ALIGNMENT);

        label4.setFont(new Font("微软雅黑",Font.PLAIN,20));
        label4.setAlignmentX(CENTER_ALIGNMENT);

        //添加图片
        java.net.URL imgURL=getClass().getResource("logo.png");
        ImageIcon icon = new ImageIcon(imgURL);
        JLabel label = new JLabel();
        label.setIcon(icon);
        label.setAlignmentX(CENTER_ALIGNMENT);

        //添加组件
        controlpanel.add(Box.createVerticalStrut(15));//添空
        controlpanel.add(button1);
        controlpanel.add(Box.createVerticalStrut(35));
        controlpanel.add(button2);
        controlpanel.add(Box.createVerticalStrut(35));
        controlpanel.add(button3);
        controlpanel.add(Box.createVerticalStrut(45));
        controlpanel.add(label1);
        controlpanel.add(Box.createVerticalStrut(45));
        controlpanel.add(label2);
        controlpanel.add(Box.createVerticalStrut(25));
        controlpanel.add(label3);
        controlpanel.add(Box.createVerticalStrut(40));
        controlpanel.add(label4);
        controlpanel.add(Box.createVerticalStrut(110));
        controlpanel.add(label);

    }
    public void clear()
    {
        //初始化方法
        for(int i = 0;i < Row;i++)
        {
            for(int j = 0;j < Coloum;j++)
                array[i][j] = 0;
        }
        chesspanelListener.num = 1;
        label1.setText("当前回合:\t 1");
        label2.setText("黑子:\t0");
        label3.setText("白子:\t0");
        label4.setText("黑棋落子");
    }
    public void paint(Graphics g)
    {
        super.paint(g);//调用父类的绘图方法
        //绘制背景图片
        java.net.URL imgURL=getClass().getResource("bgimg.jpg");//获取路径
        ImageIcon icon = new ImageIcon(imgURL);
        Image img = icon.getImage();//获取图片
        g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);//添加图片
        Graphics2D gg = (Graphics2D) g;
        //画出整个棋盘
        for(int i = 0; i < Row; i++)//行
        {
            gg.drawLine(X, Y+i*Size, X+Size*(Coloum-1), Y+i*Size);
        }
        for(int i = 0; i < Coloum; i++)//列
        {
            gg.drawLine(X + i * Size, Y, X + i * Size, Y + Size * (Row - 1));
        }
    }

}
