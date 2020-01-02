import org.opencv.core.Core;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.BatchUpdateException;

public class visual_interface{
    visual_interface(){
        new MyWindow();
    }
}

class MyWindow extends JFrame implements ActionListener{
    private JTabbedPane p;
    private JPanel jp1,jp2;
    Box  jp1_box1, jp1_box2,jp1_box3,jp1_box4,jp1_box;;
    JButton jp1_order1, jp1_order2, jp1_acquire;
    JTextField jp1_jf1,jp1_jf2,jp1_result;
    JLabel jp1_jl1, jp1_jl2;
    String jp1_address1,jp1_address2;

    Box jp2_box1, jp2_box2, jp2_box3, jp2_box4, jp2_box;
    JButton jp2_order1, jp2_order2, jp2_acquire;
    JTextField jp2_jf1,jp2_jf2;
    JTextArea jp2_result;
    JLabel jp2_jl1;
    String jp2_address1,jp2_address2;
    public MyWindow(){
        setBounds(100,100,800,500);
        setVisible(true);
        jp1 = new JPanel();
        jp2 = new JPanel();

        //jp1里的内容
        jp1_order1 = new JButton("选择第一张图片");
        jp1_order1.setSize(400,30);
        jp1_order2 = new JButton("选择第二张图片");
        jp1_acquire = new JButton("查询两张图片的相似度");
        jp1_jf1 = new JTextField();
        jp1_jf2 = new JTextField();
        jp1_result = new JTextField();
        jp1_jl1 = new JLabel();
        jp1_jl2 = new JLabel();
        jp1_jl1.setSize(300,300);
        jp1_jl2.setSize(300,300);
        setIcon("C:\\Users\\19093\\Desktop\\nmiTest\\null.png",jp1_jl1);
        setIcon("C:\\Users\\19093\\Desktop\\nmiTest\\null.png",jp1_jl2);
        jp1_order1.addActionListener(this);
        jp1_order2.addActionListener(this);
        jp1_acquire.addActionListener(this);

        jp1_box1 = Box.createHorizontalBox();
        jp1_box1.add(jp1_order1);
        jp1_box1.add(Box.createHorizontalStrut(8));
        jp1_box1.add(jp1_jf1);

        jp1_box2 = Box.createHorizontalBox();
        jp1_box2.add(jp1_order2);
        jp1_box2.add(Box.createHorizontalStrut(8));
        jp1_box2.add(jp1_jf2);

        jp1_box3 = Box.createHorizontalBox();
        jp1_box3.add(jp1_acquire);
        jp1_box3.add(Box.createHorizontalStrut(8));
        jp1_box3.add(jp1_result);

        jp1_box4 = Box.createHorizontalBox();
        jp1_box4.add(jp1_jl1);
        jp1_box4.add(Box.createHorizontalStrut(8));
        jp1_box4.add(jp1_jl2);

        jp1_box = Box.createVerticalBox();
        jp1_box.add(jp1_box1);
        jp1_box.add(Box.createVerticalStrut(8));
        jp1_box.add(jp1_box2);
        jp1_box.add(Box.createVerticalStrut(8));
        jp1_box.add(jp1_box3);
        jp1_box.add(Box.createVerticalStrut(8));
        jp1_box.add(jp1_box4);
        jp1.add(jp1_box);


        //jp2里的内容
        jp2_order1 = new JButton("  选择目标图片  ");
        jp2_order2 = new JButton("选择目标文件夹");
        jp2_acquire = new JButton("查询相似的图片");
        jp2_jl1 = new JLabel();
        jp2_jl1.setSize(300,300);
        setIcon("C:\\Users\\19093\\Desktop\\nmiTest\\null.png",jp2_jl1);
        jp2_jf1 = new JTextField();
        jp2_jf2 = new JTextField();
        jp2_result = new JTextArea();
        jp2_order1.addActionListener(this);
        jp2_order2.addActionListener(this);
        jp2_acquire.addActionListener(this);

        jp2_box1 = Box.createHorizontalBox();
        jp2_box1.add(jp2_order1);
        jp2_box1.add(Box.createHorizontalStrut(8));
        jp2_box1.add(jp2_jf1);

        jp2_box2 = Box.createHorizontalBox();
        jp2_box2.add(jp2_order2);
        jp2_box2.add(Box.createHorizontalStrut(8));
        jp2_box2.add(jp2_jf2);

        jp2_box3 = Box.createHorizontalBox();
        jp2_box3.add(jp2_acquire);

        jp2_box4 = Box.createHorizontalBox();
        jp2_box4.add(jp2_jl1);
        jp2_box4.add(Box.createHorizontalStrut(8));
        JPanel jp2_temp = new JPanel();
        jp2_temp.setPreferredSize(new Dimension(300, 300));
        jp2_temp.setLayout(new GridLayout(1,1));
        jp2_temp.add(jp2_result);
        jp2_box4.add(jp2_temp);

        jp2_box = Box.createVerticalBox();
        jp2_box.add(jp2_box1);
        jp2_box.add(Box.createVerticalStrut(8));
        jp2_box.add(jp2_box2);
        jp2_box.add(Box.createVerticalStrut(8));
        jp2_box.add(jp2_box3);
        jp2_box.add(Box.createVerticalStrut(8));
        jp2_box.add(jp2_box4);

        jp2.add(jp2_box);

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
        if(actionEvent.getSource() == jp1_order1){
            jp1_address1 = acquireAddress();
            setIcon(jp1_address1,jp1_jl1);
            jp1_jf1.setText(jp1_address1);
        }
        else if(actionEvent.getSource() == jp1_order2){
            jp1_address2 = acquireAddress();
            setIcon(jp1_address2,jp1_jl2);
            jp1_jf2.setText(jp1_address1);
        }
        else if(actionEvent.getSource() == jp1_acquire){
            function1 function = new function1(jp1_address1,jp1_address2);
            jp1_result.setText("两张图片的相似度为："+String.valueOf(function.run()));
        }
        else if(actionEvent.getSource() == jp2_order1){
            jp2_address1 = acquireAddress();
            setIcon(jp2_address1,jp2_jl1);
            jp2_jf1.setText(jp2_address1);
        }
        else if(actionEvent.getSource() == jp2_order2){
            jp2_address2 = acquireAddress();
            jp2_jf2.setText(jp2_address2);
        }
        else if(actionEvent.getSource() == jp2_acquire){
            SeekForImage seekForImage = new SeekForImage(jp2_address1,jp2_address2+"\\",8);
            System.out.println(jp2_address1);
            System.out.println(jp2_address2);
            String result = "与目标图片相似的图片有：\n" + seekForImage.run();
            jp2_result.setText(result);
        }
        else{
            System.out.println("unknown error!");
        }
    }



    public void setIcon(String file, JLabel iconButton){
        ImageIcon icon = new ImageIcon(file);
        Image temp = icon.getImage().getScaledInstance(iconButton.getWidth()
                ,iconButton.getHeight(),
                icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(temp);
        iconButton.setIcon(icon);
    }

    public String acquireAddress() {
        String ret = "";
        JFileChooser jfc = new JFileChooser();
        //设置当前路径为桌面路径,否则将我的文档作为默认路径
        FileSystemView fsv = FileSystemView.getFileSystemView();
        jfc.setCurrentDirectory(fsv.getHomeDirectory());
        //JFileChooser.FILES_AND_DIRECTORIES 选择路径和文件
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //用户选择的路径或文件
        if (jfc.showOpenDialog(MyWindow.this) == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            if (file.isDirectory()) {
                ret = file.getAbsolutePath();
                //System.out.println("文件夹:" + file.getAbsolutePath());
            } else if (file.isFile()) {
                ret = file.getAbsolutePath();
                //System.out.println("文件:" + file.getAbsolutePath());
            }
        }
        return ret;
    }
}
