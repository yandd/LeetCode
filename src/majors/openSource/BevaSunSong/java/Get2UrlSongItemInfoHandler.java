package majors.openSource.BevaSunSong.java;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @project: majors.openSource.BevaSunSong.java
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/26 14:45
 **/
public class Get2UrlSongItemInfoHandler {
    private String url;

    public Get2UrlSongItemInfoHandler(String url) {
        this.url = url;
    }

    private JSONObject getJsonList(String url) {
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("Host", "g.beva.com");
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Connection", "keep-Alive");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.4549.400 QQBrowser/9.7.12900.400)");
//            connection.setRequestProperty("Referer", "http://g.beva.com/kan-erge--c10106.html");
//            connection.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
//            System.out.println(sb.toString());
            return JSONObject.fromObject(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public JSONObject getJsonArray() {
        JSONObject jsonObject = getJsonList(this.url);
        JSONObject jsonObject1 = JSONObject.fromObject(jsonObject.getString("data"));
        return jsonObject1;
    }

    public static void main(String[] args) {
        Get2UrlSongItemInfoHandler get2UrlSongItemInfoHandler = new Get2UrlSongItemInfoHandler("http://g.beva.com/kan-erge/data-itemInfo-i58.html ");
        System.out.println(get2UrlSongItemInfoHandler.getJsonArray().toString());

    }
}
