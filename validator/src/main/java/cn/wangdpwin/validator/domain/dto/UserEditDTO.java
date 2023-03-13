package cn.wangdpwin.validator.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author wangdongpeng
 * @Date 2023/3/13 18:55
 * @Version 1.0
 */
@Data
@ApiModel("修改用户")
public class UserEditDTO {
    @ApiModelProperty(value = "用户ID", required = true)
    private Long id;

    @ApiModelProperty(value = "用户名", required = true)
    private String userName;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("邮箱")
    private String email;
}