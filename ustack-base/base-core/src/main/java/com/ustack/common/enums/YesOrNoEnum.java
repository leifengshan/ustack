package com.ustack.common.enums;

/**
 * Description: YesOrNoEnum
 *
 * @author ferris
 * @date 2021/1/6 15:23
 * @Version 1.0
 */
public enum YesOrNoEnum implements EnumValue {

    YES(1, "是"),
    NO( 0, "否"),

    ;

    private int index;
    private String name;

    YesOrNoEnum(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public String getName() {
        return name;
    }

    public static YesOrNoEnum of (int index) {
        for (YesOrNoEnum e : YesOrNoEnum.values()) {
            if (e.getIndex() == index) {
                return e;
            }
        }
        return null;
    }
}
