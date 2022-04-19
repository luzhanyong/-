package com.hrm.utils;

public class PageModel {

    private Integer pageIndex;
    private Integer pageSize = 4;
    private Integer totalSize;
    private Integer recordCount;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalSize() {
        if (recordCount%pageSize == 0){
            totalSize = recordCount/pageSize;
        }
        else {
            totalSize = recordCount/pageSize + 1;
        }
        return totalSize;
    }

    // public void settotalSize(Integer totalSize) {
    //     this.totalSize = totalSize;
    // }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public int getFirstLimitParam(){
        return (this.getPageIndex() - 1) * this.pageSize;
    }

}
