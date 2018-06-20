package GobangGame;

import java.awt.*;
import java.awt.event.*;

public class chesspanelListener extends MouseAdapter implements GoBangInterface
{
    private Judge j;
    private Graphics2D g;
    private int x,y;
    public static int num = 1;//当前棋盘上落子数

    public chesspanelListener(GameMain panel) {
        g = (Graphics2D)panel.getGraphics();
    }

    public void mouseReleased(MouseEvent e)
    {
        if(GameMain.isStarted && ! GameMain.isEnded) {
            //取得坐标
            x = e.getX();
            y = e.getY();
            //计算行列
            int row = (y - Y + Size / 2) / Size;
            int coloum = (x - X + Size / 2) / Size;

            if (row < Row && coloum < Coloum) {
                if (array[row][coloum] == 0) {
                    //确定在数组的位置
                    x = X + row * Size - Size / 4;
                    y = Y + coloum * Size - Size / 4;

                    if (num % 2 != 0) {
                        g.setColor(Color.black);
                    } else {
                        g.setColor(Color.white);
                    }
                    array[row][coloum] = num;

                    g.fillOval(y, x, Size / 2, Size / 2);
                    //执行判断
                    j = new Judge(row, coloum);
                    j.judge();
                    num++;
                    //更新组件显示信息
                    label1.setText("当前回合:\t"+((num+1)/2));
                    label2.setText("黑子:\t"+(num/2));
                    label3.setText("白子:\t"+(num-1)/2);
                    if(label4.getText() == "黑棋落子")
                        label4.setText("白棋落子");
                    else
                        label4.setText("黑棋落子");
                }
            }
        }

    }
}