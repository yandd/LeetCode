package majors.openSource.BevaSunSong.java;

import majors.openSource.BevaSunSong.test.testlog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @project: majors.openSource.BevaSunSong.java
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/26 15:11
 **/
public class DownVedioHandler {
    private String filePath;
    private String fileName;
    private String url;

    private static Logger logger = LogManager.getLogger(DownVedioHandler.class);
    public DownVedioHandler(String filePath, String fileName, String url) {
        this.filePath = filePath;
        this.fileName = fileName;
        this.url = url;
//        write2File();
        downloadNet();

    }

    public DownVedioHandler(String fileName, String url) {
        this.filePath = "./src/majors/openSource/BevaSunSong/resource/video";
        this.fileName = fileName;
        this.url = url;
//        write2File();
        downloadNet();
    }

    public DownVedioHandler(String url) {
        this.filePath = "./src/majors/openSource/BevaSunSong/resource/video";
        this.fileName = "temp.mp4";
        this.url = url;
//        write2File();
        downloadNet();
    }

    public void downloadNet() {
        if (!this.filePath.endsWith("/")) {
            this.filePath = filePath + "/";
        }
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;

//        URL url = new URL("http://bevavideo-web.beva.cn/baf23f798ec7bacb515ac20abc88a05a/5a93aa00/22e6492089/h360/video.mp4");
        try {
            URL url = new URL(this.url);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("Host", "bevavideo-web.beva.cn");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.4549.400 QQBrowser/9.7.12900.400)\")");
//            connection.setRequestProperty("Pragma", "no-cache");
//            connection.setConnectTimeout(5000);
//            connection.setReadTimeout(5000);
            // 建立实际的连接
            connection.connect();
            InputStream inStream = connection.getInputStream();
            FileOutputStream fs = new FileOutputStream(filePath + "" + fileName);
            byte[] buffer = new byte[1204];
            int length;
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
//                System.out.println(bytesum);
                fs.write(buffer, 0, byteread);
            }
            inStream.close();
            fs.close();
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DownVedioHandler downVedioHandler = new DownVedioHandler("xianzhizhuzhidawang.mp4", "http://bevavideo-web.beva.cn/0457315597dce9d3361f4c18de349e06/5a9467d0/9df5f63a7b/h360/video.mp4");

    }
}
