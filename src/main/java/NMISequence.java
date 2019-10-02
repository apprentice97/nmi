import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;

import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;

public class NMISequence {
    private int length;
    private double interval;
    private Mat[] mat;
    private double[] NMISequence;
    private Mat img;
    double a[];
    public NMISequence(Mat img, double interval){
        this.img = img;
        if(256 - 256.0/interval*interval < 1e-6){
            this.length = (int)(256.0/interval);
        }
        else{
            this.length = (int)(256.0/interval) + 1;
        }
        this.interval = interval;
        mat = new Mat[this.length];
        this.NMISequence = new double [this.length];
    }

    public double[] getNMISequence(){
        for(int i = 0; i < this.length; i ++){
            mat[i] = this.img.clone();
        }
        for(int k = 0; k < this.length; k ++){
            for(int i = 0; i < mat[k].height(); i ++){
                for(int j = 0; j < mat[k].width(); j ++){
                    a = mat[k].get(i,j);
                    if(k <= a[0] && a[0] < k + interval) mat[k].put(i,j,256);
                    else mat[k].put(i,j,0);
                }
            }
        }
        NMI[] nmi = new NMI[this.length];
        for(int i = 0; i < this.length; i ++){
            nmi[i] = new NMI(mat[i]);
            NMISequence[i] = nmi[i].getNMIValue();
        }
        return NMISequence;
    }

    //Gaussian normalization
    /*
     为了减少异常数据(特别大 或者特别小)在相关性比较中对其它正常数据的影响,
     利用以下公式对其进行高斯规范化处理:
     gNMI(l) = (NMI(l)-μ/(3×σ) + 1.0) /2.0), l =0,1, …, Te / Δ t 」
     其中, μ和σ分别是原特征序列的均值和标准差。
     由概率 论的知识可知: 经过高斯规范化处理之后,
     可以从概率意义上 保证上有99%的数据点落在[ 0,1 ] 区间内,
     对于少量的小于 0 或大于 1 的数据,则简单地置为 0 或 1。
     */
    public double[] getGaNormal(){
        getNMISequence();
        double[] gNMI = new double[this.length];
        double u = 0;
        double o = 0;
        for (double v : NMISequence) {
            u += v;
        }
        u /= NMISequence.length*1.0;
        for (double v : NMISequence) {
            o += (v - u) * (v - u);
        }
        o /= NMISequence.length;
        o = Math.sqrt(o);
        for(int i = 0; i < NMISequence.length; i ++){
            if(o != 0){
                gNMI[i] = ((NMISequence[i]-u)/(3*o) + 1.0)/2.0;
            }
            else{
                gNMI[i] = 0;
            }
        }
        return gNMI;
    }
}
