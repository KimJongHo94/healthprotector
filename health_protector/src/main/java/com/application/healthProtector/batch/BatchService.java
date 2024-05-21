package com.application.healthProtector.batch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.application.healthProtector.product.dto.ProductDTO;

@Service
public class BatchService {
	
//	@Scheduled(cron="*/10 * * * * *")
//	void tester() throws IOException {
//		
//		Document doc = Jsoup.connect("https://www.edkshop.com/goods/goods_list.php?cateCd=012001&sort=sellcnt").get();
//		Elements newsHeadlines = doc.select(".item_photo_box img");
//		
//		
//		List<ProductDTO> productList = new ArrayList<ProductDTO>();
//		
//		for (Element headline : newsHeadlines) {
//			//System.out.println(headline.attr("title") + " / " +  headline.absUrl("href"));
//			System.out.println(headline.attr("src"));
//			//System.out.println(headline.text());
//			//dto로만들고
//			ProductDTO product = new ProductDTO();
//			
//			productList.add(product);
//		}
//		//insert gogo
//		
//	}
	
}
