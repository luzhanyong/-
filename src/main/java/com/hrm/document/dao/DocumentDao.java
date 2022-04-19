package com.hrm.document.dao;

import com.hrm.commons.benas.Document;
import com.hrm.utils.PageModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DocumentDao {
    List<Document> selectDocument(@Param("title") String title, @Param("pageModel") PageModel pageModel);

    int selectDocumentCount(@Param("title") String title);

    int insertDocument(Document document);

    Document selectDocumentById(Integer id);

    int updateDocument(Document document);

    int deleteDocument(Integer id);
}
