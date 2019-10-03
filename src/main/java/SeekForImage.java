import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.File;

import static org.opencv.highgui.HighGui.imshow;

public class SeekForImage {
    private int interval;
    private String address1,address2;
    private double threshold;

    public SeekForImage(String address1, String address2, int interval){
        this.address1 = address1;
        this.address2 = address2;
        this.interval = interval;
        this.threshold = 0.7;
    }

    public SeekForImage(String address1, String address2, int interval, double threshold){
        this.address1 = address1;
        this.address2 = address2;
        this.interval = interval;
        this.threshold = threshold;
    }

    private String [] getFileName(String path) {
        return new File(path).list();
    }

    public void run(){
        String[] fileName = getFileName(this.address2);
        Mat[] mat = new Mat[fileName.length+1];
        mat[0] = Imgcodecs.imread(this.address1,Imgcodecs.IMREAD_GRAYSCALE);
        imshow("img1",mat[0]);
        for(int i = 1; i < fileName.length; i ++){
            mat[i] = Imgcodecs.imread(this.address2+fileName[i],Imgcodecs.IMREAD_GRAYSCALE);
        }
        double[] arr1,arr2;
        arr1 = new NMISequence(mat[0],interval).getGaNormal();
        int count = 0;
        for(int i = 0; i < fileName.length; i ++){
            arr2 = new NMISequence(mat[i],interval).getGaNormal();
            double corr = getCorr(arr1,arr2);
            if(Math.abs(corr) >= this.threshold){
                //System.out.println("目标图像与图像" + fileName[i] + "的相似度为：" + corr + ",可以认为是同一个物体");
                System.out.print(fileName[i]+" ");
                if(++count % 3 == 0) System.out.println();
            }
            else{
                //System.out.println("目标图像与图像" + fileName[i] + "的相似度为：" + corr + ",可以认为不是同一个物体");
            }
        }
    }

    /*
     检索时,提取待检索图像的规范化 NMI 特征序列,
     与图 像特征信息库中的序列进行相关性比较,
      根据比较结果输出检 索结果。
      相关性比较时, 采用 Pearson 积矩相关公式。
     */

    private double getCorr(double[] arr1, double[] arr2){
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
