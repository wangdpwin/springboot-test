package cn.wangdpwin.validator.controller;

import cn.wangdpwin.validator.domain.dto.UserAddDTO;
import cn.wangdpwin.validator.domain.dto.UserDTO;
import cn.wangdpwin.validator.domain.dto.UserEditDTO;
import cn.wangdpwin.validator.domain.dto.UserQueryDTO;
import cn.wangdpwin.validator.domain.vo.UserVO;
import cn.wangdpwin.validator.group.ValidGroup;
import cn.wangdpwin.validator.util.ValidateUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangdongpeng
 * @Date 2023/3/13 18:48
 * @Version 1.0
 */
@RequestMapping("/manual")
@RestController
public class ManualValidateController {

    @ApiOperation("添加")
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

    @ApiOperation("修改")
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

    @ApiOperation("查找")
    @GetMapping("/find")
    public List<UserVO> find(UserQueryDTO userQueryDTO) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userQueryDTO, userDTO);
        ValidateUtil.validate(userDTO, ValidGroup.Query.class);

        return new ArrayList<>();
    }

    @ApiOperation("删除")
    @PostMapping("/delete")
    public void delete(Long id) {

    }
}
