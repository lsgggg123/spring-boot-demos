package com.lsgggg123.springboot.mybatis.dao;

import com.lsgggg123.springboot.mybatis.domain.Feed;

import java.util.List;

/**
 * Created by liushun on 16/1/31.
 */
public interface IFeedDao {

    /**
     * 根据用户Id查询用户动态
     * @param userId 用户id
     * @return
     */
    List<Feed> getFeedsById(Integer userId);

}
