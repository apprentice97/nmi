# nmi

实习任务
（1）学习NMI特征的基本原理。
（2）了解OpenCV的功能和使用方法，它是一个用于图像处理、分析、机器视觉方面的开源函数库，在Windows环境下搭建完成IntelliJ与OpenCV开发环境。
（3）搜集图片样本，设计实验并测试NMI特征向量是否具有的良好的平移不变性，旋转不变性和缩放不变性，并将这些实验数据表格化以图表的形式展现出来。
（4）利用NMI的这些特性以及之前搭建好的开发环境，设计并实现一个基于NMI特征的图像识别的程序。该程序主要有两个功能：一个是比较两个图片的相似度，相似度α（0≤α≤1），α越接近1说明两张图片的相似度越高，反之，α越接近0则表明两张图片的相似度越低；另外一个是以一个图片为目标图片，在一堆图片中找出与之相似的图片，并将这些图片按相似度从高到底展现出来，至于具体的相似度为多大时才可以基本认为两张图片中的物体是同一个物体现在还无法确定，等到后面根据实际实验数据确定一个合适的阈值ε（0≤ε≤1），即当两张图片的相似度α大于ε时可以认为两张图片中的物体是同一个物体。
![image](https://github.com/xueweidongdong/nmi/blob/master/picture/%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE1.png)
![image](https://github.com/xueweidongdong/nmi/blob/master/picture/%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE2.png)
![image](https://github.com/xueweidongdong/nmi/blob/master/picture/%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE0.png)
![image](https://github.com/xueweidongdong/nmi/blob/master/picture/%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE4.png)
![image](https://github.com/xueweidongdong/nmi/blob/master/picture/%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE5.png)
![image](https://github.com/xueweidongdong/nmi/blob/master/picture/%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE6.png)
![image](https://github.com/xueweidongdong/nmi/blob/master/picture/%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE7.png)
![image](https://github.com/xueweidongdong/nmi/blob/master/picture/%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE8.png)
