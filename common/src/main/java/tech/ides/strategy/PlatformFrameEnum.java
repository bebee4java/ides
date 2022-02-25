package tech.ides.strategy;

/**
 * 平台策略枚举类
 * Created by songgr on 2022/02/20.
 */
public enum PlatformFrameEnum {
    SPARK("spark"),
    FLINK("flink");

    public final String frame;

    private PlatformFrameEnum(String frame) {
        this.frame = frame;
    }
}
