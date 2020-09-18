package io.icefox.dmdemo.service.impl;

import io.icefox.dmdemo.dao.UserDao;
import io.icefox.dmdemo.entity.User;
import io.icefox.dmdemo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
}
