package com.zms.push.messagepush.mapper;

import com.zms.push.messagepush.domain.UserDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description 用户相关的mapper
 * @Author zmszsj
 * @Date 2019/2/26 13:59
 * @Version 1.0
 **/
public interface UserMapper {
	List<UserDomain> queryUser();

	UserDomain login(@Param("account") String account);

	int addUser(UserDomain userDomain);

	int deleteUser(@Param("id") String id);
}
