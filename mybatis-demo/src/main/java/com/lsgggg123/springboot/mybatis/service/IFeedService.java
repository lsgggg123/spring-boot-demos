package com.lsgggg123.springboot.mybatis.service;


import com.lsgggg123.springboot.mybatis.domain.Feed;

import java.util.List;

/**
 * Created by liushun on 16/1/31.
 */
public interface IFeedService {
    /**
     * 获取用户的动态
     * @param userId 用户id
     * @return
     */
    List<Feed> findFeeds(Integer userId);
}
