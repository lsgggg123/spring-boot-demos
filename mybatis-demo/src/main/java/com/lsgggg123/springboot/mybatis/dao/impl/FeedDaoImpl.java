package com.lsgggg123.springboot.mybatis.dao.impl;


import com.lsgggg123.springboot.mybatis.dao.IFeedDao;
import com.lsgggg123.springboot.mybatis.dao.mapper.FeedMapper;
import com.lsgggg123.springboot.mybatis.domain.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by liushun on 16/1/31.
 */
@Repository
public class FeedDaoImpl implements IFeedDao {

    @Autowired
    private FeedMapper feedMapper;

    @Override
    public List<Feed> getFeedsById(Integer userId) {
        return feedMapper.getFeeds(userId);
    }
}
