package cn.wangdpwin.validator.domain.model;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author wangdongpeng
 * @Date 2023/3/21 15:17
 * @Version 1.0
 */
@Data
public class BaseBean implements Serializable {

    private static final long serialVersionUID = 6877955227522370690L;

    /**
     * 语言类型
     */
    @Pattern(regexp = "^\\w{2,10}$", message = "api.response.code.languageTypeError")
    private String language;

}