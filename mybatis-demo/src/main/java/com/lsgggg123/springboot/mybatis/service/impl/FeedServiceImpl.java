package com.lsgggg123.springboot.mybatis.service.impl;

import com.lsgggg123.springboot.mybatis.dao.IFeedDao;
import com.lsgggg123.springboot.mybatis.domain.Feed;
import com.lsgggg123.springboot.mybatis.service.IFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liushun on 16/1/31.
 */
@Service
public class FeedServiceImpl implements IFeedService {

    @Autowired
    private IFeedDao feedDao;

    @Override
    public List<Feed> findFeeds(Integer userId) {
        if (userId != null) {
            return feedDao.getFeedsById(userId);
        } else {
            return null;
        }
    }
}
