package com.cyx212306109.service;


import com.cyx212306109.common.Result;
import com.cyx212306109.dto.UserDTO;

public interface UserService {
    Result<String> register(UserDTO userDT0);
    Result<String> login(UserDTO userDT0);


}