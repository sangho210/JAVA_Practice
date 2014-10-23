package com.omok;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextArea;

public abstract class Omok extends Frame {
    private static final long serialVersionUID = 4L;

    protected static final int NONE = 0;
    protected static final int BLACK = 1;
    protected static final int WHITE = 2;
    protected int[][] board = new int[19][19];
    protected boolean bWhTurn; // ���������� ������
    protected boolean bFlag; // ���ӻ���
    protected int panjeong;

    protected BadukPan gp;

    public abstract void gameInit();

    // ***************************************************************
    // ���� �÷���
    public boolean gamePlay(PointMsg pm, TextArea ta) {
        int ax, ay;
        ax = pm.getX();
        ay = pm.getY();

        board[ax][ay] = bWhTurn ? WHITE : BLACK;

        if(gamePanjeong(ax, ay)) {
            drawSite(ax, ay, board[ax][ay]);

            if (panjeong == BLACK) {
                ta.append("�������� �¸� �߽��ϴ�.\n");
            } else if (panjeong == WHITE) {
                ta.append("���� �¸� �߽��ϴ�.\n");
            }

            return true;
        } else {
            board[ax][ay] = NONE;

            return false;
        }

    }

    // ***************************************************************
    // ���� ����
    public boolean gamePanjeong(int ax, int ay) {
        int cnt0, cnt1, cnt2, cnt3;
        int i;
        int dol;
        boolean[][] noneDol = new boolean[4][2];
        int cntThree=0;

        dol = board[ax][ay];

        cnt0 = 1;
        for (i = 1; i < 6; i++) {
            if (ay - i < 0)
                break;
            if (board[ax][ay - i] == dol)
                cnt0++;
            else if(board[ax][ay - i]==NONE) {
                noneDol[0][0]=true;
                break;
            }
            else
                break;
        }
        for (i = 1; i < 6; i++) {
            if (ay + i >= 19)
                break;
            if (board[ax][ay + i] == dol)
                cnt0++;
            else if(board[ax][ay + i]==NONE) {
                noneDol[0][1]=true;
                break;
            }
            else
                break;
        }
        if (noneDol[0][0]&&noneDol[0][1]&&cnt0==3)
            cntThree++;
        if (cnt0 == 5) {
            panjeong = dol;
            return true;
        }

        cnt1 = 1;
        for (i = 1; i < 6; i++) {
            if (ax - i < 0)
                break;
            if (board[ax - i][ay] == dol)
                cnt1++;
            else if(board[ax - i][ay]==NONE) {
                noneDol[1][0]=true;
                break;
            }
            else
                break;
        }
        for (i = 1; i < 6; i++) {
            if (ax + i >= 19)
                break;
            if (board[ax + i][ay] == dol)
                cnt1++;
            else if(board[ax + i][ay]==NONE) {
                noneDol[1][1]=true;
                break;
            }
            else
                break;
        }
        if (noneDol[1][0]&&noneDol[1][1]&&cnt1==3)
            cntThree++;
        if (cnt1 == 5) {
            panjeong = dol;
            return true;
        }

        cnt2 = 1;
        for (i = 1; i < 6; i++) {
            if (ax - i < 0 || ay - i < 0)
                break;
            if (board[ax - i][ay - i] == dol)
                cnt2++;
            else if(board[ax - i][ay - i]==NONE) {
                noneDol[2][0]=true;
                break;
            }
            else
                break;
        }
        for (i = 1; i < 6; i++) {
            if (ax + i >= 19 || ay + i >= 19)
                break;
            if (board[ax + i][ay + i] == dol)
                cnt2++;
            else if(board[ax + i][ay + i]==NONE) {
                noneDol[2][1]=true;
                break;
            }
            else
                break;
        }
        if (noneDol[2][0]&&noneDol[2][1]&&cnt2==3)
            cntThree++;
        if (cnt2 == 5) {
            panjeong = dol;
            return true;
        }

        cnt3 = 1;
        for (i = 1; i < 6; i++) {
            if (ax + i >= 19 || ay - i < 0)
                break;
            if (board[ax + i][ay - i] == dol)
                cnt3++;
            else if(board[ax + i][ay - i]==NONE) {
                noneDol[3][0]=true;
                break;
            }
            else
                break;
        }
        for (i = 1; i < 6; i++) {
            if (ax - i < 0 || ay + i >= 19)
                break;
            if (board[ax - i][ay + i] == dol)
                cnt3++;
            else if(board[ax - i][ay + i]==NONE) {
                noneDol[3][1]=true;
                break;
            }
            else
                break;
        }
        if (noneDol[3][0]&&noneDol[3][1]&&cnt3==3)
            cntThree++;
        if (cnt3 == 5) {
            panjeong = dol;
            return true;
        }

        if(cntThree>=2) {
            board[ax][ay] = NONE;
            return false;
        }

        return true;
    }

    // ***************************************************************
    // �� �׸���
    public void drawSite(int x, int y, int dol) {
        Graphics g = gp.getGraphics();

        if (dol == BLACK)
            g.setColor(new Color(0, 0, 0));
        else
            g.setColor(new Color(255, 255, 255));
        if (dol != NONE)
            g.fillOval(x * 20 + 2, y * 20 + 2, 16, 16);
    }
}
