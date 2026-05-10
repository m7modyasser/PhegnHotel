package com.phegondev.phegnhotel.service.interfac;

import com.phegondev.phegnhotel.dto.LoginRequest;
import com.phegondev.phegnhotel.dto.Response;
import com.phegondev.phegnhotel.entity.User;

public interface IUserService {
    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);



}