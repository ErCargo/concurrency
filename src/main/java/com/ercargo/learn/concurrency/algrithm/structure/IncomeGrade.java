package com.ercargo.learn.concurrency.algrithm.structure;

/**
 * @author ercargo  on 2019/1/29
 * @DESCRIBE
 */
public enum IncomeGrade {
    A("A", null, 500000),
    B("B", 500001, 1000000),
    C("C", 1000001, 2000000),
    D("D", 2000001, 3000000),
    E("E", 3000001, 4000000),
    F("F", 4000001, 5000000),
    G("G", 5000001, null)
    ;
    // 构造函数
    IncomeGrade(String gradeLevel, Integer minValue, Integer maxValue) {
        this.gradeLevel = gradeLevel;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    // 收入等级 - ABCDEF
    public String gradeLevel;
    // 最小收入
    public Integer minValue;
    // 最大收入
    public Integer maxValue;

    // 解析
    public static IncomeGrade parseByIncome(int income) {
        IncomeGrade[] enumConstants = IncomeGrade.class.getEnumConstants();
        for (IncomeGrade incomeGrade : enumConstants) {
            Integer min = incomeGrade.minValue;
            Integer max = incomeGrade.maxValue;
            if (null != min) {
                if (income < min) {
                    continue;
                }
            }
            if (null != max) {
                if (income > max) {
                    continue;
                }
            }
            return incomeGrade;
        }
        return null;
    }


}
