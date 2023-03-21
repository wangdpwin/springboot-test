package cn.wangdpwin.validator.domain.model;

import lombok.Data;

/**
 * @Author wangdongpeng
 * @Date 2023/3/21 15:23
 * @Version 1.0
 */
@Data
public class ResponseCodeI18n {

    /**
     * 异常编码
     */
    private int code;

    /**
     * 异常信息
     */
    private String message;
}
