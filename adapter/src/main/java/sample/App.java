package sample;

import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class App {

  private static final int TIMEOUT = (int) TimeUnit.SECONDS.toMillis(10);

  public static void main(String[] args) throws Exception {
    URL url = new URL("http://haowanba.com");
    Document document = Jsoup.parse(url, TIMEOUT);
    Elements elements = document.body().select("a[href]");
    List<String> names = elements.eachText();
    List<String> links = elements.eachAttr("href");
    System.out.println("已找到：");
    System.out.println(addIndexForList(names));

    String link = null;
    while (true) {
      int index = 0;
      Scanner in = new Scanner(System.in);
      if (link == null) {
        System.out.println("请选择一个序号作为入口（输入非法将退出程序）：");
        try {
          index = in.nextInt() - 1;
        } catch (Exception ignore) {
          continue;
        }
      } else {
        System.out.println("您选择的是："+link+"，请输入OK确认！");
        String line = in.nextLine();
        if ("OK".equalsIgnoreCase(line)) {
          break;
        }
      }
      if (index < 0) {
        System.exit(0);
      }
      if (index < links.size()) {
        link = links.get(index);
      }
    }
    url = new URL(link);
    document = Jsoup.parse(url, TIMEOUT);
    System.out.println(document);
  }

  private static String addIndexForList(List<String> list) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      builder.append(String.format("%d.", i + 1)).append(list.get(i)).append("\n");
    }
    return builder.toString();
  }
}
