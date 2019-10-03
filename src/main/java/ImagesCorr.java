import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;

public class ImagesCorr {

    public static double getImagesCorr(String img1, String img2, int interval) {
        Mat mat1 = Imgcodecs.imread(img1,Imgcodecs.IMREAD_GRAYSCALE);
        Mat mat2 = Imgcodecs.imread(img2,Imgcodecs.IMREAD_GRAYSCALE);
        double[] arr1 = new NMISequence(mat1,interval).getGaNormal();
        double[] arr2 = new NMISequence(mat2,interval).getGaNormal();
        return getCorr(arr1,arr2);
    }

    /*
     检索时,提取待检索图像的规范化 NMI 特征序列,
     与图 像特征信息库中的序列进行相关性比较,
      根据比较结果输出检 索结果。
      相关性比较时, 采用 Pearson 积矩相关公式。
     */

    private static double getCorr(double[] arr1, double[] arr2){
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
