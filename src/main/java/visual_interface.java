import org.opencv.core.Core;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLOutput;
import java.util.function.Function;

public class visual_interface{
    visual_interface(){
        new MyWindow();
    }
}

class MyWindow extends JFrame implements ActionListener{
    private JTabbedPane p;
    private JPanel jp1,jp2;
    Box jp1_baseBox,jp1_boxV1,jp1_boxV2,jp1_boxH,jp1_Box;
    JButton jp1_acquire;
    JTextField jp1_text1,jp1_text2,jp1_text3;
    Icon jp1_icon1, jp1_icon2;
    JButton jp1_bt1, jp1_bt2;

    Box jp2_baseBox,jp2_boxV1,jp2_boxV2;
    JButton jp2_acquire;
    JTextField jp2_text1,jp2_text2,jp2_text3;
    public MyWindow(){
        setBounds(100,100,800,500);
        setVisible(true);
        jp1 = new JPanel();
        jp2 = new JPanel();

        //jp1里的内容
        jp1_text1 = new JTextField(40);
        jp1_text2 = new JTextField(40);
        jp1_text3 = new JTextField(40);
        jp1_boxV1 = Box.createVerticalBox();
        jp1_boxV1.add(new JLabel("第一张图片的位置"));
        jp1_boxV1.add(Box.createVerticalStrut(8));
        jp1_boxV1.add(new JLabel("第二张图片的位置"));
        jp1_boxV1.add(Box.createVerticalStrut(8));
        jp1_acquire = new JButton("查询相似度");
        jp1_acquire.addActionListener(this);
        jp1_boxV1.add(jp1_acquire);
        jp1_boxV2 = Box.createVerticalBox();
        jp1_boxV2.add(jp1_text1);
        jp1_boxV2.add(Box.createVerticalStrut(8));
        jp1_boxV2.add(jp1_text2);
        jp1_boxV2.add(Box.createVerticalStrut(8));
        jp1_boxV2.add(jp1_text3);

        jp1_baseBox = Box.createHorizontalBox();
        jp1_baseBox.add(jp1_boxV1);
        jp1_baseBox.add(Box.createHorizontalStrut(10));
        jp1_baseBox.add(jp1_boxV2);
        jp1_bt1 = new JButton("niahao");
        jp1_bt2 = new JButton("ni");
        jp1_boxH = Box.createHorizontalBox();
        jp1_boxH.add(jp1_bt1);
        jp1_boxH.add(jp1_bt2);
        jp1_Box = Box.createVerticalBox();
        jp1_Box.add(jp1_baseBox);
        jp1_Box.add(jp1_boxH);
        jp1.setLayout(new FlowLayout());
        jp1.add(jp1_Box);

        //jp2里的内容
        jp2_text1 = new JTextField(40);
        jp2_text2 = new JTextField(40);
        jp2_text3 = new JTextField(40);
        jp2_boxV1 = Box.createVerticalBox();
        jp2_boxV1.add(new JLabel("目标图片的位置"));
        jp2_boxV1.add(Box.createVerticalStrut(8));
        jp2_boxV1.add(new JLabel("目标文件夹的位置"));
        jp2_boxV1.add(Box.createVerticalStrut(8));
        jp2_acquire = new JButton("查询相似的图片");
        jp2_acquire.addActionListener(this);
        jp2_boxV1.add(jp2_acquire);
        jp2_boxV2 = Box.createVerticalBox();
        jp2_boxV2.add(jp2_text1);
        jp2_boxV2.add(Box.createVerticalStrut(8));
        jp2_boxV2.add(jp2_text2);
        jp2_boxV2.add(Box.createVerticalStrut(8));
        jp2_boxV2.add(jp2_text3);
        jp2_baseBox = Box.createHorizontalBox();
        jp2_baseBox.add(jp2_boxV1);
        jp2_baseBox.add(Box.createHorizontalStrut(10));
        jp2_baseBox.add(jp2_boxV2);
        jp2.setLayout(new FlowLayout());
        jp2.add(jp2_baseBox);

        p = new JTabbedPane(JTabbedPane.LEFT);
        p.add("比较两个图片的相似度",jp1);
        p.add("查找相似图片",jp2);
        p.validate();
        add(p,BorderLayout.CENTER);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == jp1_acquire){
            jp1_text1.setText("C:\\Users\\19093\\Desktop\\nmiTest\\aud000.png");
            jp1_text2.setText("C:\\Users\\19093\\Desktop\\nmiTest\\aud004.png");
            System.out.println("功能1");
            jp1_icon1 = new ImageIcon("C:\\Users\\19093\\Desktop\\nmiTest\\aud000.png");
            jp1_icon2 = new ImageIcon("C:\\Users\\19093\\Desktop\\nmiTest\\aud004.png");
            //TODO 设置图片大小
            jp1_bt1.setIcon(jp1_icon1);
            jp1_bt2.setIcon(jp1_icon2);
            jp1_bt1.setSize(50,50);
            jp1_bt2.setSize(50,50);
            String s1 = jp1_text1.getText();
            String s2 = jp1_text2.getText();
            //function1 function = new function1(s1,s2);
            //jp1_text3.setText(String.valueOf(function.run()));
        }
        else{
            System.out.println("hello world!");
        }
    }
}
