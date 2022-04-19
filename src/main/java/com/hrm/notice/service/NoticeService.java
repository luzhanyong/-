package com.hrm.notice.service;

import com.hrm.commons.benas.Notice;
import com.hrm.utils.PageModel;

import java.util.List;

public interface NoticeService {

    List<Notice> findNotice(PageModel pageModel, Notice notice);

    int findNoticeCount(Notice notice);

    Notice findNoticeById(Integer id);

    int modifyNotice(Notice notice);

    int removeNotice(Integer[] ids);

    int addNotice(Notice notice);
}
