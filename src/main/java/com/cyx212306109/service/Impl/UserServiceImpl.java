package com.cyx212306109.service.Impl;


import com.cyx212306109.common.Result;
import com.cyx212306109.common.ResultCode;
import com.cyx212306109.dto.UserDTO;
import com.cyx212306109.service.UserService;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service // 必须添加该注解，将业务类交给Spring容器管理
public class UserServiceImpl implements UserService {

    // 暂时使用Map模拟数据库。下节课将在这里@Autowired注入UserMapper
    private static final Map<String, String> userDb = new HashMap<>();

    @Override
    public Result<String> register(UserDTO userDTO) {
        // 1. 校验用户是否已存在
        if (userDb.containsKey(userDTO.getUsername())) {
            return Result.error(ResultCode.USER_HAS_EXISTED);
        }
        // 2. 存入模拟数据库
        userDb.put(userDTO.getUsername(), userDTO.getPassword());
        return Result.success("注册成功");
    }

    @Override
    public Result<String> login(UserDTO userDTO) {
        // 1. 校验用户是否存在
        if (!userDb.containsKey(userDTO.getUsername())) {
            return Result.error(ResultCode.USER_NOT_EXIST);
        }
        // 2. 校验密码是否正确
        String dbPassword = userDb.get(userDTO.getUsername());
        if (!dbPassword.equals(userDTO.getPassword())) {
            return Result.error(ResultCode.PASSWORD_ERROR);
        }
        // 3. 生成 Token（这里用 UUID 模拟）
        String token = UUID.randomUUID().toString();
        // 4. 返回 Token 给前端
        return Result.success("Bearer " + token);
    }
}