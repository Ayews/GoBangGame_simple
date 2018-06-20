package GobangGame;

public class Judge implements GoBangInterface{
    private int x,y;//坐标
    private int count;//连子数
    private boolean isWhite;//胜方
    public Judge(int x,int y)
    {
        this.x = x;
        this.y = y;
        count = 1;//计数变量
    }

    public void judge()
    {
        //System.out.println(array[x][y]);
        count = 1;
        //竖向检查
        for(int i = x+1; i < Coloum; i++)
        {
            if(array[i][y] != 0 )
            {
                if((array[x][y]%2) == (array[i][y]%2))
                {
                    count++;
                }else break;
            }else break;
        }
        for(int i = x-1; i >= 0; i--)
        {
            if(array[i][y] != 0 )
            {
                if((array[x][y]%2) == (array[i][y]%2))
                    count++;
                else break;
            }else break;
        }
        if(count >= 5) {
            //连子达到5个，游戏结束
            message();
            return;
        }
            count = 1;
        //横向检查
        for(int i = y+1; i < Row; i++)
        {
            if(array[x][i] != 0 )
            {
                if((array[x][y]%2) == array[x][i]%2)
                    count++;
                else break;
            }else break;
        }
        for(int i = y-1; i >= 0; i--)
        {
            if(array[x][i] != 0 )
            {
                if(array[x][y]%2 == array[x][i]%2)
                    count++;
                else break;
            }else break;
        }
        if(count >= 5) {
            message();
            return;
        }
        count = 1;
        //斜向检查（从左上角到右下角）
        for(int i = x-1,j = y-1;i>=0&&j>=0; i--,j--)
        {
            if(array[i][j] != 0 )
            {
                if((array[x][y]%2) == (array[i][j]%2))
                    count++;
                else break;
            }else break;
        }
        for(int i = x+1,j = y+1;i<Coloum&&j<Row; i++,j++)
        {
            if(array[i][j] != 0 )
            {
                if((array[x][y]%2) == (array[i][j]%2))
                    count++;
                else break;
            }else break;
        }
        if(count >= 5) {
            message();
            return;
        }
        count = 1;
        //斜向检查（从左下角到右上角）
        for(int i = x-1,j = y+1;i>=0&&j<Row; i--,j++)
        {
            if(array[i][j] != 0 )
            {
                if((array[x][y]%2) == (array[i][j]%2))
                    count++;
                else break;
            }else break;
        }
        for(int i = x+1,j = y-1;i<Coloum&&j>=0; i++,j--)
        {
            if(array[i][j] != 0 )
            {
                if((array[x][y]%2) == (array[i][j]%2))
                    count++;
                else break;
            }else break;
        }
        if(count >= 5) {
            message();
            return;
        }
    }
    public void message()
    {
        GameMain.isEnded = true;
        label4.setText("游戏结束");
        if(array[x][y]%2 != 0)
            isWhite = false;
        else
            isWhite = true;
        if(isWhite)
            statuslabel.setText("游戏结束,白棋获胜。点击重新开始按钮重新开始游戏");
        else
            statuslabel.setText("游戏结束,黑棋获胜。点击重新开始按钮重新开始游戏");
    }
}
//549