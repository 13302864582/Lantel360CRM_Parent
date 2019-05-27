package com.lantel.homelibrary.notify;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class a {

    /**
     * p : {"content":[33333333,"33333333784积分给大家首付款厚大司考返回看多少坑和客户客户发打瞌睡","副科级点击分类就废了看到结束六块腹肌打开链接开发来得及杀戮空间反倒是"],"img":[{"class":"img-responsive","src":"http://s10.xiao360.com/qms/data/uploads/file/20190522/1558521579192923.png","_src":"http://s10.xiao360.com/qms/data/uploads/file/20190522/1558521579192923.png"},{"class":"img-responsive","src":"http://s10.xiao360.com/qms/data/uploads/file/20190522/1558521603875538.png","_src":"http://s10.xiao360.com/qms/data/uploads/file/20190522/1558521603875538.png"}]}
     */

    private PBean p;

    public PBean getP() {
        return p;
    }

    public void setP(PBean p) {
        this.p = p;
    }

    public static class PBean {
        private List<Integer> content;
        private List<ImgBean> img;

        public List<Integer> getContent() {
            return content;
        }

        public void setContent(List<Integer> content) {
            this.content = content;
        }

        public List<ImgBean> getImg() {
            return img;
        }

        public void setImg(List<ImgBean> img) {
            this.img = img;
        }

        public static class ImgBean {
            /**
             * class : img-responsive
             * src : http://s10.xiao360.com/qms/data/uploads/file/20190522/1558521579192923.png
             * _src : http://s10.xiao360.com/qms/data/uploads/file/20190522/1558521579192923.png
             */

            @SerializedName("class")
            private String classX;
            private String src;
            private String _src;

            public String getClassX() {
                return classX;
            }

            public void setClassX(String classX) {
                this.classX = classX;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String get_src() {
                return _src;
            }

            public void set_src(String _src) {
                this._src = _src;
            }
        }
    }
}
