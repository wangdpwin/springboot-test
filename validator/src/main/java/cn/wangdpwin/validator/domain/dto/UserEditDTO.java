package cn.wangdpwin.validator.domain.dto;

import lombok.Data;

/**
 * @Author wangdongpeng
 * @Date 2023/3/13 18:55
 * @Version 1.0
 */
@Data
public class UserEditDTO {

    private Long id;

    private String userName;

    private String nickName;

    private String email;
}