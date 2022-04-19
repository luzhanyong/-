package com.hrm.document.service;

import com.hrm.commons.benas.Document;
import com.hrm.document.dao.DocumentDao;
import com.hrm.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    private DocumentDao documentDao;

    @Override
    public List<Document> findDocument(String title, PageModel pageModel) {
        return documentDao.selectDocument(title,pageModel);
    }

    @Override
    public int findDocumentCount(String title) {
        return documentDao.selectDocumentCount(title);
    }

    @Override
    public int addDocument(Document document) {
        return documentDao.insertDocument(document);
    }

    @Override
    public Document findDocumentById(Integer id) {
        return documentDao.selectDocumentById(id);
    }

    @Override
    public int modifyDocument(Document document) {
        return documentDao.updateDocument(document);
    }

    @Override
    public int removeDocument(Integer id) {
        return documentDao.deleteDocument(id);
    }
}
