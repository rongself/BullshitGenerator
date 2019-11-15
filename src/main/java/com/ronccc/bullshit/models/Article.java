package com.ronccc.bullshit.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Article {
    @NotNull(message = "标题不能为空")
    private String title;
    @Max(65536)
    private Integer length = 65536;

    /**
     * @return 字数
     */
    public Integer getLength() {
        return length;
    }

    /**
     * @return 主题
     */
    public String getTitle() {
        return title;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
