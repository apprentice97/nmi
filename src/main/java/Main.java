

import org.opencv.core.*;
import java.io.File;
import java.util.Scanner;

public class Main{
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    public static void main(String[] args) {
        new visual_interface();
    }
}