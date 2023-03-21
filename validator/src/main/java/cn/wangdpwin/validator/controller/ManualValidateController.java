package cn.wangdpwin.validator.controller;

import cn.wangdpwin.validator.domain.dto.UserAddDTO;
import cn.wangdpwin.validator.domain.dto.UserDTO;
import cn.wangdpwin.validator.domain.dto.UserEditDTO;
import cn.wangdpwin.validator.domain.dto.UserQueryDTO;
import cn.wangdpwin.validator.domain.vo.UserVO;
import cn.wangdpwin.validator.group.ValidGroup;
import cn.wangdpwin.validator.util.ValidateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangdongpeng
 * @Date 2023/3/13 18:48
 * @Version 1.0
 * Validater手动校验，https://blog.csdn.net/feiying0canglang/article/details/124282297
 */
@RequestMapping("/manual")
@RestController
public class ManualValidateController {

    @PostMapping("/add")
    public UserVO add(@RequestBody UserAddDTO userAddDTO) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userAddDTO, userDTO);
        // ValidUtil.validate(userDTO);
        ValidateUtil.validate(userDTO, ValidGroup.Add.class);

        // 将数据写到数据库
        userDTO.setId(1L);
        userDTO.setCreateTime(LocalDateTime.now());
        userDTO.setUpdateTime(LocalDateTime.now());

        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userDTO, userVO);
        return userVO;
    }

    @PostMapping("/edit")
    public UserVO edit(@RequestBody UserEditDTO userEditDTO) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userEditDTO, userDTO);
        ValidateUtil.validate(userDTO, ValidGroup.Edit.class);

        // 修改数据库的数据
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userEditDTO, userVO);
        userVO.setUpdateTime(LocalDateTime.now());
        return userVO;
    }

    @GetMapping("/find")
    public List<UserVO> find(UserQueryDTO userQueryDTO) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userQueryDTO, userDTO);
        ValidateUtil.validate(userDTO, ValidGroup.Query.class);

        return new ArrayList<>();
    }

    @PostMapping("/delete")
    public void delete(Long id) {

    }
}
