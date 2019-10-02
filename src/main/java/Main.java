

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;

public class Main{
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    public static void main(String[] args){
        String[][] address = new String[][]{
            {
                "C:\\Users\\19093\\Desktop\\s000.png",
                "C:\\Users\\19093\\Desktop\\s001.png",
                "C:\\Users\\19093\\Desktop\\s002.png",
                "C:\\Users\\19093\\Desktop\\s003.png",
                "C:\\Users\\19093\\Desktop\\s004.png",
                "C:\\Users\\19093\\Desktop\\s005.png"
            },
            {
                "C:\\Users\\19093\\Desktop\\aud000.png",
                "C:\\Users\\19093\\Desktop\\aud001.png",
                "C:\\Users\\19093\\Desktop\\aud002.png",
                "C:\\Users\\19093\\Desktop\\aud003.png",
                "C:\\Users\\19093\\Desktop\\aud004.png",
                "C:\\Users\\19093\\Desktop\\aud005.png"
            },
            {
                "C:\\Users\\19093\\Desktop\\x000.png",
                "C:\\Users\\19093\\Desktop\\x001.png",
                "C:\\Users\\19093\\Desktop\\x002.png",
                "C:\\Users\\19093\\Desktop\\x003.png",
                "C:\\Users\\19093\\Desktop\\x004.png",
                "C:\\Users\\19093\\Desktop\\x005.png"
            },
            {
                "C:\\Users\\19093\\Desktop\\l000.png",
                "C:\\Users\\19093\\Desktop\\l001.png",
                "C:\\Users\\19093\\Desktop\\l002.png",
                "C:\\Users\\19093\\Desktop\\l003.png",
                "C:\\Users\\19093\\Desktop\\l004.png",
                "C:\\Users\\19093\\Desktop\\l005.png"
            }
        };
        Mat[] img = new Mat[20];
        NMI[] nmi = new NMI[20];
        for(int j = 0; j < 4; j ++){
            for(int i = 0; i < address[j].length; i ++){
                img[i] = Imgcodecs.imread(address[j][i],Imgcodecs.IMREAD_GRAYSCALE);
                nmi[i] = new NMI(img[i]);
                //System.out.println(nmi[i].getNMIValue());
            }
            System.out.print(String.format("`%.5f ",nmi[0].getNMIValue()));
            for(int i = 1; i < address[j].length; i ++){
                System.out.print(String.format("`%.5f ",nmi[i].getNMIValue()));
                System.out.print(String.format("`%.5f ",(nmi[i].getNMIValue()-nmi[0].getNMIValue())/nmi[0].getNMIValue()));
               }
            System.out.println();
        }
       // NMI nmi = new NMI(img);
        //double NMIValue = nmi.getNMIValue();
       // System.out.println(NMIValue);
        //imshow("this a image", img[1]);
       // waitKey();
    }
}