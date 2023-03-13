package cn.wangdpwin.validator.domain.dto;

import cn.wangdpwin.validator.group.ValidGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;

/**
 * @Author wangdongpeng
 * @Date 2023/3/13 18:56
 * @Version 1.0
 */
@Data
public class UserDTO {
    /**
     * 用户id
     */
    @Null(groups = ValidGroup.Add.class, message = "用户id必须为空")
    @NotNull(groups = ValidGroup.Edit.class, message = "用户id不能为空")
    private Long id;

    /**
     * 用户名
     */
    @NotBlank(groups = {ValidGroup.Add.class, ValidGroup.Edit.class},
            message = "用户名不能为空")
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    private String email;

    /**
     * 创建时间
     */
    @Null(message = "创建时间必须为空")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @NotNull(message = "更新时间不能为空")
    private LocalDateTime updateTime;
}