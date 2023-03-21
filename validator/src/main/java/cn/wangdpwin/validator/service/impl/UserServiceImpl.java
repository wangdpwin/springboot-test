package cn.wangdpwin.validator.service.impl;

import cn.wangdpwin.validator.domain.model.ApiResultI18n;
import cn.wangdpwin.validator.domain.model.UserSignUpBean;
import cn.wangdpwin.validator.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author wangdongpeng
 * @Date 2023/3/21 15:22
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public ApiResultI18n signUp(UserSignUpBean userSignUpBean) {
        return new ApiResultI18n(200,"cn");
    }
}
