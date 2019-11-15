package com.ronccc.bullshit.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ronccc.bullshit.models.Article;
import com.ronccc.bullshit.models.BullshitWord;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BullshitService {

    private BullshitWord words;

    public BullshitService() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.words = objectMapper.readValue(this.getClass().getClassLoader().getResourceAsStream("data.json"), BullshitWord.class);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String generate(Article article) {
        // 设定上限
        if (article.getLength() > 65536) article.setLength(65536);

        List<String> 文章 = new ArrayList<String>();
        String 段落 = "";
        String 文本 = "";
        int 段落总长度 = 0;
        while (段落总长度 < article.getLength()) {
            int 分支 = RandomUtils.nextInt(0, 100);
            if (分支 < 5 && 段落.length() > 50) { // 另起一段，每段至少五十字
                文章.add("　　" + 段落.substring(0, 段落.length() - 1) + "。");
                文本 = "";
                段落 = "";
            } else if (分支 < 20) { // 名人名言
                文本 = 替换标点(垫话(words.getRandomFamous()));
            } else { // 废话
                文本 = 替换标点(words.getRandomBosh());
            }
            段落 += 文本;
            段落总长度 += 文本.length();
        }

        // 把最后一段也加上
        文章.add("　　" + 段落.substring( 0, 段落.length()-1) + "。");
        return  String.join("<br>", 文章).replace("x", article.getTitle());
    }

    private String 替换标点(String 文本) {

        String[] 逗号 = new String[]{"， ", ", ", ","};
        String[] 句号 = new String[]{"。 ", ". ", "."};
        String[] 冒号 = new String[]{"： ", ": ", ":"};
        String[] 问号 = new String[]{"？ ", "? ", "?"};

//        文本 = 文本.replaceAll("[|]")
        for (String item : 逗号) 文本 = 文本.replace(item, "，");
        for (String item : 句号) 文本 = 文本.replace(item, "。");
        for (String item : 冒号) 文本 = 文本.replace(item, "：");
        for (String item : 问号) 文本 = 文本.replace(item, "？");

        return 文本;
    }

    private String 垫话(String 文本) {
        return 文本.replace("a", words.getRandomBefore()).replace("b", words.getRandomAfter());
    }
}
