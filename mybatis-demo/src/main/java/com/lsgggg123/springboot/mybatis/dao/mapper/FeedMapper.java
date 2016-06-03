package com.lsgggg123.springboot.mybatis.dao.mapper;


import com.lsgggg123.springboot.mybatis.domain.Feed;

import java.util.List;

/**
 * Created by liushun on 16/1/31.
 */
public interface FeedMapper {
    List<Feed> getFeeds(Integer userId);
}
