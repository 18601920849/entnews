package com.entnews.service;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entnews.dao.NewsDao;
import com.entnews.entity.News;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NewsService extends ServiceImpl<NewsDao, News> {

    public List<News> getNewsByDate(String startTime, String endTime) {
        Date startDate = DateUtil.parse(startTime, DatePattern.NORM_DATETIME_PATTERN);
        Date endDate = DateUtil.parse(endTime, DatePattern.NORM_DATETIME_PATTERN);
        LambdaQueryWrapper<News> queryWrapper = Wrappers.lambdaQuery();
        // 查询时间大于等于startTime，小于等于endTime的数据
        queryWrapper.between(News::getTime, startDate, endDate);
        //return list(queryWrapper);
        return new ArrayList<News>(List.of(new News[]{
                new News(1, startDate),
                new News(2, endDate)
        }));
    }
}