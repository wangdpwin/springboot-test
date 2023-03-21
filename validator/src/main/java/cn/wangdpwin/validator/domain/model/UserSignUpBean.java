package cn.wangdpwin.validator.domain.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Author wangdongpeng
 * @Date 2023/3/21 15:17
 * @Version 1.0
 */
@Data
public class UserSignUpBean extends BaseBean {

    private static final long serialVersionUID = 6970430558841356592L;

    /**
     * 账号
     */
    @NotNull(message = "api.response.code.user.accountNullError")
    @Pattern(regexp = "^\\S{5,50}$", message = "api.response.code.user.accountFormatError")
    private String userName;

    /**
     * 密码
     */
    @NotNull(message = "api.response.code.user.passwordNullError")
    @Pattern(regexp = "^\\w{5,80}$", message = "api.response.code.user.passwordFormatError")
    private String userPasscode;


}
