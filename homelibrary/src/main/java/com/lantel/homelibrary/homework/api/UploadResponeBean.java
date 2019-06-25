package com.lantel.homelibrary.homework.api;

import com.lantel.common.HttpResBean;

public class UploadResponeBean extends HttpResBean {

    /**
     * error : 0
     * message : success
     * data : {"og_id":0,"storage":"qiniu","file_url":"http://s10.xiao360.com/qms/1/0/XUgOk7PfpdBf2LdpT94pLrqNqeF92zQT.png","file_type":"png","file_name":"屏幕快照 2019-06-19 下午5.40.22.png","file_size":98065,"media_type":"image","create_uid":10028,"file_id":"191"}
     * authed : true
     */
    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * og_id : 0
         * storage : qiniu
         * file_url : http://s10.xiao360.com/qms/1/0/XUgOk7PfpdBf2LdpT94pLrqNqeF92zQT.png
         * file_type : png
         * file_name : 屏幕快照 2019-06-19 下午5.40.22.png
         * file_size : 98065
         * media_type : image
         * create_uid : 10028
         * file_id : 191
         */

        private int og_id;
        private String storage;
        private String file_url;
        private String file_type;
        private String file_name;
        private int file_size;
        private String media_type;
        private int create_uid;
        private String file_id;

        public int getOg_id() {
            return og_id;
        }

        public void setOg_id(int og_id) {
            this.og_id = og_id;
        }

        public String getStorage() {
            return storage;
        }

        public void setStorage(String storage) {
            this.storage = storage;
        }

        public String getFile_url() {
            return file_url;
        }

        public void setFile_url(String file_url) {
            this.file_url = file_url;
        }

        public String getFile_type() {
            return file_type;
        }

        public void setFile_type(String file_type) {
            this.file_type = file_type;
        }

        public String getFile_name() {
            return file_name;
        }

        public void setFile_name(String file_name) {
            this.file_name = file_name;
        }

        public int getFile_size() {
            return file_size;
        }

        public void setFile_size(int file_size) {
            this.file_size = file_size;
        }

        public String getMedia_type() {
            return media_type;
        }

        public void setMedia_type(String media_type) {
            this.media_type = media_type;
        }

        public int getCreate_uid() {
            return create_uid;
        }

        public void setCreate_uid(int create_uid) {
            this.create_uid = create_uid;
        }

        public String getFile_id() {
            return file_id;
        }

        public void setFile_id(String file_id) {
            this.file_id = file_id;
        }
    }
}
