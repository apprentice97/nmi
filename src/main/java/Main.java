

import org.opencv.core.*;
import java.io.File;
import java.util.Scanner;

public class Main{
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    private static int interval;
    private static Mat[] img;

    private static String [] getFileName(String path)
    {
        return new File(path).list();
    }
    private static void showMenu(){
        System.out.println();
        System.out.println("#################################################");
        System.out.println("##    请选择服务                                 ##");
        System.out.println("##    1.比较两个图片的相似度                      ##");
        System.out.println("##    2.查找相似图片                             ##");
        System.out.println("##    3.退出程序                                 ##");
    }

    private static String getFilename(String address){
        int index = address.length() - 1;
        String ret = "";
        while(index!=0){
            if(address.charAt(index) == 92){
                break;
            }
            else{
                ret = address.charAt(index) + ret;
            }
            index--;
        }
        return ret;
    }
    public static void main(String[] args) {
        int server = 1;
        String address1, address2;
        int interval;
        Scanner scanner = new Scanner(System.in);
        while(true){
            showMenu();
            server = scanner.nextInt();
            if(server == 1){
                address1 = scanner.next();
                address2 = scanner.next();
                interval = scanner.nextInt();
                System.out.println(getFilename(address1) + "和" +getFilename(address2)+ "的相似度为："+ImagesCorr.getImagesCorr(address1,address2,interval));
                System.out.println("\n计算结束");
            }
            else if(server == 2){
                address1 = scanner.next();
                address2 = scanner.next();
                interval = scanner.nextInt();
                System.out.println("在文件夹"+address2+"中与"+getFilename(address1)+"相似的图像有：");
                SeekForImage seekForImage = new SeekForImage(address1,address2,interval);
                seekForImage.run();
                System.out.println("\n计算结束");
            }
            else if(server == 3){
                System.out.println("\n欢迎下次使用！");
                    break;
            }
        }
    }

}