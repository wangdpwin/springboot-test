package cn.wangdpwin.validator.domain.model;

import lombok.Data;

/**
 * @Author wangdongpeng
 * @Date 2023/3/21 15:25
 * @Version 1.0
 */
@Data
public class ApiResultI18n {

    private int code;

    private String msg;

    private String language;

    public ApiResultI18n(int code, String language) {
        this.code = code;
        this.language = language;
    }

    public ApiResultI18n(int code, String msg, String language) {
        this.code = code;
        this.msg = msg;
        this.language = language;
    }

    public ApiResultI18n failure(int code, String msg, String language) {
        return new ApiResultI18n(code,msg,language);
    }

    public ApiResultI18n failure(int code, String language) {
        return new ApiResultI18n(code,msg,language);
    }
}
