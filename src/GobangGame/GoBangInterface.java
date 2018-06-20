package GobangGame;

import javax.swing.*;

public interface GoBangInterface {
    //棋子的大小
    public static final int Size = 44;
    public static final int X = 25;
    public static final int Y = 25;
    public static final int Row = 15;
    public static final int Coloum = 15;
    //存旗子的数组
    public static final int[][] array = new int[Row][Coloum];
    //几个主要组件
    public static JFrame frame = new JFrame();
    public static GameMain chesspanel = new GameMain();
    public static JPanel controlpanel = new JPanel();
    public static JPanel messagepanel = new JPanel();
    public static JLabel statuslabel = new JLabel("请点击开始游戏按钮");
    public static JLabel label1 = new JLabel("当前回合:\t0");
    public static JLabel label2 = new JLabel("黑子:\t0");
    public static JLabel label3 = new JLabel("白子:\t0");
    public static JLabel label4 = new JLabel("游戏等待开始");
}