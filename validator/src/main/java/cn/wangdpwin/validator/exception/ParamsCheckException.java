package cn.wangdpwin.validator.exception;

import cn.wangdpwin.validator.domain.model.ResponseCodeI18n;
import lombok.Data;

/**
 * @Author wangdongpeng
 * @Date 2023/3/21 15:18
 * @Version 1.0
 */
@Data
public class ParamsCheckException extends Exception{

    private static final long serialVersionUID = 2684099760669375847L;

    /**
     * 异常编码
     */
    private int code;

    /**
     * 异常信息
     */
    private String message;

    public ParamsCheckException(){
        super();
    }

    public ParamsCheckException(int code, String message){
        this.code = code;
        this.message = message;
    }

    public ParamsCheckException(String message){
        this.message = message;
    }

    public ParamsCheckException(ResponseCodeI18n responseCodeI18n){
        this.code = responseCodeI18n.getCode();
        this.message = responseCodeI18n.getMessage();
    }

}
