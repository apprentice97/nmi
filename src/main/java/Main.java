

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;

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

    public static void main(String[] args) {
        String path = "C:\\Users\\19093\\Desktop\\nmiTest\\";
        String [] fileName = getFileName(path);
        img = new Mat[fileName.length];
        for(int i = 0; i < fileName.length; i ++){
            img[i] = Imgcodecs.imread(path+fileName[i],Imgcodecs.IMREAD_GRAYSCALE);
        }
        double arr1[], arr2[];
        interval = 32;
        arr1 = new NMISequence(img[0],interval).getNMISequence();
        for(int i = 0; i < fileName.length; i ++){
            arr2 = new NMISequence(img[i],interval).getNMISequence();
            System.out.println(fileName[0] + "和" + fileName[i] + "的相关度Corr:" + getCorr(arr1,arr2));
        }
    }

    /*
     检索时,提取待检索图像的规范化 NMI 特征序列,
     与图 像特征信息库中的序列进行相关性比较,
      根据比较结果输出检 索结果。
      相关性比较时, 采用 Pearson 积矩相关公式。
     */

    public static double getCorr(double[] arr1, double[] arr2){
            double numerator = 0, denominator;
            double average1 = 0, average2 = 0;
            for(int i = 0; i < arr1.length; i ++){
                average1 += arr1[i];
                average2 += arr2[i];
            }
            average1 /= arr1.length * 1.0;
            average2 /= arr2.length * 1.0;
            for(int i = 0; i < arr1.length; i ++){
                numerator += (arr1[i] - average1) * (arr2[i] - average2);
            }
            double tmp1 = 0,tmp2 = 0;
            for(int i = 0; i < arr1.length; i ++){
                tmp1 += (arr1[i] - average1) * (arr1[i] - average1);
                tmp2 += (arr2[i] - average2) * (arr2[i] - average2);
            }
            tmp1 = Math.sqrt(tmp1);
            tmp2 = Math.sqrt(tmp2);
            denominator = tmp1 * tmp2;
            return numerator / denominator;
    }

}