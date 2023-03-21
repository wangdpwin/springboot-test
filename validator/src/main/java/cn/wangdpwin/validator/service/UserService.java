package cn.wangdpwin.validator.service;

import cn.wangdpwin.validator.domain.model.ApiResultI18n;
import cn.wangdpwin.validator.domain.model.UserSignUpBean;

/**
 * @Author wangdongpeng
 * @Date 2023/3/21 15:22
 * @Version 1.0
 */
public interface UserService {
    ApiResultI18n signUp(UserSignUpBean userSignUpBean);
}
