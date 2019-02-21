package com.zms.push.messagepush.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @ClassName HotSearchService
 * @Description 微博热搜推送（只推送前5条，置顶的那条不推）
 * @Author zmszsj
 * @Date 2019/2/21 17:12
 * @Version 1.0
 **/
@Service
public class HotSearchService {
	public String hotSearch() {
		StringBuffer sb = new StringBuffer();
		try {
			Document doc = Jsoup.connect("https://s.weibo.com/top/summary?cate=realtimehot").get();
			Elements elements = doc.getElementsByClass("td-02");
			int i = 0;
			for (Element e : elements) {
				if (i != 0) {
					sb.append(e.child(0).text() + "\n");
				}
				i++;
				if (i > 5) break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
