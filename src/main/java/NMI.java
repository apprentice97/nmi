import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import static java.lang.StrictMath.sqrt;

public class NMI {
    private Mat img;
    private double mass;
    private double centroidX;
    private double centroidY;
    private double NMIValue;
    double[] a;
    public NMI(){

    }
    public NMI(Mat img){
        this.img = img;
        this.mass = this.centroidX = this.centroidY = NMIValue = -1;
    }

    public double getMass(){
        if(mass < 0){
            mass = 0;
            for(int i = 0; i < img.height(); i ++){
                for(int j = 0; j < img.width(); j ++){
                    a = img.get(i,j);
                    mass += a[0];
                }
            }
        }
        return mass;
    }

    public double getCentroidX(){
        if(centroidX < 0){
            centroidX = 0;
            for(int i = 0; i < img.height(); i ++){
                for(int j = 0; j < img.width(); j ++){
                    a = img.get(i,j);
                    centroidX += i * a[0];
                }
            }
            centroidX/=getMass();
        }
        return centroidX;
    }

    public double getCentroidY(){
        if(centroidY < 0){
            centroidY = 0;
            for(int i = 0; i < img.height(); i ++){
                for(int j = 0; j < img.width(); j ++){
                    a = img.get(i,j);
                    centroidY += j * a[0];
                }
            }
            centroidY/=getMass();
        }
        return centroidY;
    }

    public double getNMIValue(){
        if(NMIValue < 0){
            NMIValue = 0;
            getMass();
            getCentroidX();
            getCentroidY();
            for(int i = 0; i < img.height(); i ++){
                for(int j = 0; j < img.width(); j ++){
                    NMIValue += sqrt((i-centroidX)*(i-centroidX) + (i-centroidY)*(i-centroidY));
                }
            }
            NMIValue = sqrt(NMIValue);
            NMIValue /= (double)(img.height()*img.width());
        }
        return NMIValue;
    }

    public void goNMI(){
        System.out.println("Welcome to OpenCV " + Core.VERSION);
        Mat img = Imgcodecs.imread("C:\\Users\\19093\\Desktop\\003.png",Imgcodecs.IMREAD_GRAYSCALE);
        //imshow("img", img);
        //waitKey(0);
        //Imgproc.circle(img, new Point(200,300),40,new Scalar(255,0,0),2);
        //Imgproc.circle(img, new Point(200,300),80,new Scalar(0,255,0),5);
        for(int i = 100; i < 200; i ++){
            for(int j = 100; j < 200; j ++){
                img.put(i,j,100);
            }
        }
        HighGui.namedWindow("image", HighGui.WINDOW_AUTOSIZE);
        HighGui.imshow("image", img);
        HighGui.waitKey();
    }
}
