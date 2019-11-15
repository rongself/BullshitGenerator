package com.ronccc.bullshit.models;

import org.apache.commons.lang3.RandomUtils;

public class BullshitWord {

    private String title;
    private String[] famous;
    private String[] bosh;
    private String[] after;
    private String[] before;

    /**
     * @return 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return 名人名言
     */
    public String[] getFamous() {
        return famous;
    }

    /**
     * @return 废话
     */
    public String[] getBosh() {
        return bosh;
    }

    /**
     * @return 后面垫话
     */
    public String[] getAfter() {
        return after;
    }

    /**
     * @return 前面垫话
     */
    public String[] getBefore() {
        return before;
    }

    public String getRandomAfter() {
        return after[RandomUtils.nextInt(0, after.length - 1)];
    }

    public String getRandomBefore() {
        return before[RandomUtils.nextInt(0, before.length - 1)];
    }

    public String getRandomFamous() {
        return famous[RandomUtils.nextInt(0, famous.length - 1)];
    }

    public String getRandomBosh() {
        return bosh[RandomUtils.nextInt(0, bosh.length - 1)];
    }
}
