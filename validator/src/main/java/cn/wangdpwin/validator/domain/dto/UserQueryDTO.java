package cn.wangdpwin.validator.domain.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

/**
 * @Author wangdongpeng
 * @Date 2023/3/13 18:56
 * @Version 1.0
 */
@Data
public class UserQueryDTO {

    private Long id;

    private String userName;

    private String nickName;

    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}