package com.lantel.homelibrary.homework.api;

import java.util.List;

public class CommitHomeReq {
    private String content;
    private int sid;
    private int star;
    private String ht_id;
    private List<HomeworkAttachmentBean> homework_attachment;

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getHt_id() {
        return ht_id;
    }

    public void setHt_id(String ht_id) {
        this.ht_id = ht_id;
    }

    public List<HomeworkAttachmentBean> getHomework_attachment() {
        return homework_attachment;
    }

    public void setHomework_attachment(List<HomeworkAttachmentBean> homework_attachment) {
        this.homework_attachment = homework_attachment;
    }
}
