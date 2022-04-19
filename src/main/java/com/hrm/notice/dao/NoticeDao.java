package com.hrm.notice.dao;

import com.hrm.commons.benas.Notice;
import com.hrm.utils.PageModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeDao {

    List<Notice> selectNotice(@Param("pageModel") PageModel pageModel, @Param("notice") Notice notice);

    int selectNoticeCount(Notice notice);

    Notice selectNoticeById(Integer id);

    int updateNotice(Notice notice);

    int deleteNotice(@Param("ids") Integer[] ids);

    int insertNotice(Notice notice);
}
