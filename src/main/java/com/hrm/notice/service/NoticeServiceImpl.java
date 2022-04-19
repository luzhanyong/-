package com.hrm.notice.service;

import com.hrm.commons.benas.Notice;
import com.hrm.notice.dao.NoticeDao;
import com.hrm.utils.PageModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeDao noticeDao;

    @Override
    public List<Notice> findNotice(PageModel pageModel, Notice notice) {
        return noticeDao.selectNotice(pageModel,notice);
    }

    @Override
    public int findNoticeCount(Notice notice) {
        return noticeDao.selectNoticeCount(notice);
    }

    @Override
    public Notice findNoticeById(Integer id) {
        return noticeDao.selectNoticeById(id);
    }

    @Override
    public int modifyNotice(Notice notice) {
        return noticeDao.updateNotice(notice);
    }

    @Override
    public int removeNotice(Integer[] ids) {
        return noticeDao.deleteNotice(ids);
    }

    @Override
    public int addNotice(Notice notice) {
        return noticeDao.insertNotice(notice);
    }
}
