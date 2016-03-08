package com.qiezi.hermes.api.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daniel on 3/7/16.
 */
public enum SalaryEnum {

    FirstLevelSalary(1, 0, 2000),
    SecondLevelSalary(2, 2000, 4000),
    ThirdLevelSalary(3, 4000, 6000),
    FourLevelSalary(4, 6000, 8000),
    FiveLevelSalary(5, 8000, 12000),
    SixLevelSalary(6, 12000, 16000),
    SevenLevelSalary(7, 16000, -1);     //-1 代表>16000

    private int level;
    private int minSalary;
    private int maxSalary;

    SalaryEnum(int level, int minSalary, int maxSalary) {
        this.level = level;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    private static Map<Integer, String> map = new HashMap<Integer, String>();

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

}
