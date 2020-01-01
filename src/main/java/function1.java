import org.opencv.core.*;
import java.io.File;
import java.util.Scanner;

public class function1{
    String address1, address2;
    int interval;

    function1(String address1,String address2){
        this.address1 = address1;
        this.address2 = address2;
        this.interval = 8;
    }

    function1(String address1,String address2, int interval){
        this.address1 = address1;
        this.address2 = address2;
        this.interval = interval;
    }

    public double run(){
        return ImagesCorr.getImagesCorr(address1,address2,interval);
    }

}
