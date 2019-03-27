package com.ercargo.learn.concurrency.algrithm;


import org.apache.commons.lang.StringUtils;

/**
 * @author ercargo  on 2019/1/28
 * @DESCRIBE
 */
public enum TestEnum {
    STUDENT("0101", "6"),
    TEACHER("0102", "6"),
    DOCTOR("0103", "6");

    private String occupationCode;
    private String grouppingCode;


    TestEnum(String occupationCode, String grouppingCode) {
        this.occupationCode = occupationCode;
        this.grouppingCode = grouppingCode;
    }

    public static TestEnum getOccupationCode(String occupationCode) {
        TestEnum[] enums = values();
        TestEnum[] codenums = enums;
        int var3 = enums.length;

        for (int i = 0; i < var3; ++i) {
            TestEnum e = codenums[i];
            if (StringUtils.equals(e.occupationCode, occupationCode)) {
                return e;
            }
        }
        return null;
    }

    public static TestEnum getGrouppingCode(String grouppingCode) {
        TestEnum[] enums = values();
        TestEnum[] codenums = enums;
        int var3 = enums.length;
        for (int i = 0; i < var3; ++i) {
            TestEnum e = codenums[i];
            if (StringUtils.equals(e.grouppingCode, grouppingCode)) {
                return e;
            }
        }
        return null;
    }
}
