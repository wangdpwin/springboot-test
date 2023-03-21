package cn.wangdpwin.validator.controller;

import cn.wangdpwin.validator.domain.model.ApiResultI18n;
import cn.wangdpwin.validator.domain.model.ResponseCodeI18n;
import cn.wangdpwin.validator.domain.model.UserSignUpBean;
import cn.wangdpwin.validator.exception.ParamsCheckException;
import cn.wangdpwin.validator.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangdongpeng
 * @Date 2023/3/21 11:28
 * @Version 1.0
 */
@RestController
@RequestMapping("/auto/user")
public class AutoValidateController {

    private static final Logger logger = LoggerFactory.getLogger(AutoValidateController.class);

    @Autowired
    private UserService userService;


    /**
     * 用户注册
     *
     * @param userSignUpBean 注册信息
     * @return
     */
    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public ApiResultI18n signUp(@RequestBody UserSignUpBean userSignUpBean){
        ApiResultI18n apiResultI18n= null;
        try {
            apiResultI18n = userService.signUp(userSignUpBean);
        } catch (Exception e) {
            if (ParamsCheckException.class.isAssignableFrom(e.getClass())){
                logger.error("注册失败,参数错误");
                return apiResultI18n.failure(400, "参数错误", "cn");
            }
            logger.error("注册失败,未知异常",e);
            return apiResultI18n.failure(500, "cn");
        }
        return apiResultI18n;
    }

}