package kr.excel.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


public class JsoupExample {

    public static void main(String[] args) {

        String url = "https://sum.su.or.kr:8888/bible/today";

        Document document = null;   //에외처리
        try {
            document = Jsoup.connect(url).get();


            Element bibleText= document.getElementById("bible_text");
            Element bibleInfoBox = document.getElementById("bibleinfo_box");

            System.out.println("Bible Text: "+bibleText.text());
            System.out.println("bibleInfo: "+bibleInfoBox.text());
            System.out.println();


            Elements numElements = document.select(".num");
            Elements infoElements = document.select(".info");


            for(int i = 0;i<numElements.size();i++){
                System.out.println(numElements.get(i).text()+" : "+infoElements.get(i).text());
            }




        } catch (IOException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);

        }

    }

}
