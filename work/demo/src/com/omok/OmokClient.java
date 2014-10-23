package com.omok;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class OmokClient extends Omok  implements Runnable{
    private static final long serialVersionUID = 6L;

    private ObjectInputStream ois = null;
    private ObjectOutputStream oos = null;

    private String host = "192.168.6.8";
    private int port = 5555;

    TextArea ta;

    //***************************************************************
    // ����
    public OmokClient() {
        setLayout(null);

        gp = new BadukPan(this);
        gp.setBounds(10, 30, 380, 380);
        add(gp);
        gp.repaint();

        ta = new TextArea();
        ta.setEditable(false);
        ta.setBounds(10, 420, 380, 100);
        add(ta);

        gp.addMouseListener(new MouseHandler());              //���콺 �̹�Ʈ �����ٰ� ���
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });

        gameInit();

        setTitle("Ŭ���̾�Ʈ");
        setSize(500, 550);
        setResizable(false);
        setVisible(true);

        try {
            Socket sock = new Socket(host, port);
            oos = new ObjectOutputStream(sock.getOutputStream());
            oos.flush(); // �߿�
            ois = new ObjectInputStream(sock.getInputStream());
            Thread th = new Thread(this);
            th.start();
        }catch(Exception e) {
        }
    }

    //***************************************************************
    // ���� �ʱ�ȭ
    public void gameInit() {
        int x, y;
        for(x=0; x<19; x++)
            for(y=0; y<19; y++)
                board[x][y]=NONE;
        panjeong = NONE;
        bWhTurn  = false;
        bFlag    =  true;

        ta.setText("");
    }

    //***************************************************************
    // main()
    public static void main(String[] args) {
        new OmokClient();
    }

    //***************************************************************
    // ������ �۾�
    public void run() {
        try{
            while(true) {
                Object ob = ois.readObject();
                if(ob instanceof PointMsg) {
                    PointMsg pm = (PointMsg)ob;

                    if(gamePlay(pm, ta))
                        bWhTurn = !bWhTurn;
                }
            }
        } catch(Exception e) {

        }
    }

    //***************************************************************
    // ���콺 �̺�Ʈ ó��
    class MouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent evt) {
            if(bFlag)	{
                int ax, ay;
                if(panjeong != NONE)
                    return;

                //�� ������ ��� ���ư�
                if(bWhTurn)
                    return;

                ax = evt.getX()/20;
                ay = evt.getY()/20;

                if((ax<0) ||(ax>=19) || (ay<0) || (ay>=19))
                    return;

                if (board[ax][ay]!=NONE)
                    return;

                PointMsg pm = new PointMsg();
                pm.setCode(100);
                pm.setX(ax);
                pm.setY(ay);

                // ���콺 ��ǥ ���
                try{
                    oos.writeObject(pm);
                    if(gamePlay(pm, ta))
                        bWhTurn = !bWhTurn;
                }catch(Exception e) {
                    //
                }
            }
        }
    }
} // class_end
