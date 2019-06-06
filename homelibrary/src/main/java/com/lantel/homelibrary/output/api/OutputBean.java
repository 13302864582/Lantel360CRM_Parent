package com.lantel.homelibrary.output.api;


import java.util.List;

public class OutputBean {
    private int error;
    private String message;
    private DataBean data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int total;
        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * sart_id : 2
             * og_id : 0
             * bid : 1
             * eid : 10003
             * cid : 0
             * sid : 21
             * art_name : fz
             * art_desc : fzfzfz
             * create_time : 2019-06-04 10:10:35
             * student_artwork_attachment : [{"sarta_id":3,"og_id":0,"sart_id":2,"file_id":135,"file_url":"http://s10.xiao360.com/qms/student_avatar/1/19/05/18/66e97e6dcad5f137bd22b531a1e8aa76.png","file_type":"png","file_size":504365,"file_name":"648a44cdddcd1a5aabfecb72ff760a54.jpg","media_type":"image","duration":"","create_uid":1},{"sarta_id":4,"og_id":0,"sart_id":2,"file_id":138,"file_url":"http://s10.xiao360.com/qms//base/wechat_media/Gz9xoUydk6DR97DMt_srgz4K4pQxFUdmcXqvlDYwhKAasN4m7IlZ_zJaE9vgWPDP.mp4","file_type":"mp4","file_size":1764596,"file_name":"","media_type":"video","duration":"10.833333","create_uid":1},{"sarta_id":5,"og_id":0,"sart_id":2,"file_id":133,"file_url":"http://s10.xiao360.com/qms/1/0/WJ31KrqPSga5yWF44epLQpgH6SAc3jQq.jpg","file_type":"jpg","file_size":37065,"file_name":"tusaJDAxJDIzL1RCMW1HMjVMcCQ2YzNYRiQ1JDM.jpg","media_type":"image","duration":"","create_uid":1},{"sarta_id":6,"og_id":0,"sart_id":2,"file_id":136,"file_url":"http://s10.xiao360.com/qms/student_avatar/1/19/05/18/ef14abe724b4fd874d9986158d70774e.png","file_type":"png","file_size":946084,"file_name":"yz2.png","media_type":"image","duration":"","create_uid":1},{"sarta_id":7,"og_id":0,"sart_id":2,"file_id":142,"file_url":"http://s10.xiao360.com/qms/1/0/U1CXOeTMl9iCdnzwGfh13xyhdOnXARxk.pptx","file_type":"pptx","file_size":15007901,"file_name":"lesson1.pptx","media_type":"file","duration":"","create_uid":1},{"sarta_id":8,"og_id":0,"sart_id":2,"file_id":140,"file_url":"http://s10.xiao360.com/qms/1/0/n2etB1wWU5dhr3OxrNiSxmkQx0kHiNNt.m4a","file_type":"m4a","file_size":208738,"file_name":"1111.m4a","media_type":"file","duration":"","create_uid":1},{"sarta_id":9,"og_id":0,"sart_id":2,"file_id":145,"file_url":"http://s10.xiao360.com/qms//1/19/05/29/14c8cf0abe84a1c919c60e90bbc225f7.png","file_type":"png","file_size":315465,"file_name":"2078449371978d85fbb9e5524e038fef.png","media_type":"image","duration":"","create_uid":1},{"sarta_id":10,"og_id":0,"sart_id":2,"file_id":144,"file_url":"http://s10.xiao360.com/qms//1/19/05/28/6cfaf0d3a344ed6267b10afb28a87da5.png","file_type":"png","file_size":244377,"file_name":"90528175449.png","media_type":"image","duration":"","create_uid":1},{"sarta_id":11,"og_id":0,"sart_id":2,"file_id":143,"file_url":"http://s10.xiao360.com/qms//1/19/05/28/31ba523bfc66f2b4eae4b97497a2c366.jpg","file_type":"jpg","file_size":37330,"file_name":"11.jpg","media_type":"image","duration":"","create_uid":1},{"sarta_id":12,"og_id":0,"sart_id":2,"file_id":137,"file_url":"http://s10.xiao360.com/qms/1/0/yEVAY6iyE65vvB5xVW8FxmxMcSUEmdHZ.png","file_type":"png","file_size":52389,"file_name":"屏幕快照 2019-05-18 下午5.34.28.png","media_type":"image","duration":"","create_uid":1},{"sarta_id":13,"og_id":0,"sart_id":2,"file_id":131,"file_url":"http://s10.xiao360.com/qms/1/0/TYbL8je04GGIMJIECa8YBxQDHzBof1Sj.jpg","file_type":"jpg","file_size":37065,"file_name":"tusaJDAxJDIzL1RCMW1HMjVMcCQ2YzNYRiQ1JDM.jpg","media_type":"image","duration":"","create_uid":1},{"sarta_id":14,"og_id":0,"sart_id":2,"file_id":130,"file_url":"http://s10.xiao360.com/qms/1/0/nsp5FxjwQ6TeYonhuOlOg6TjFdO8XUeX.jpg","file_type":"jpg","file_size":26945,"file_name":"1480344881-1_w_1.jpg","media_type":"image","duration":"","create_uid":1},{"sarta_id":15,"og_id":0,"sart_id":2,"file_id":129,"file_url":"http://s10.xiao360.com/qms//1/19/05/13/8660e12aec8798d218f3650cd09b3799.png","file_type":"png","file_size":902,"file_name":"ketang.png","media_type":"image","duration":"","create_uid":1},{"sarta_id":16,"og_id":0,"sart_id":2,"file_id":117,"file_url":"http://s10.xiao360.com/qms//1/19/05/08/0b33ced8ab6d07453c32a75e36deac9e.jpg","file_type":"jpg","file_size":83305,"file_name":"648a44cdddcd1a5aabfecb72ff760a54.jpg","media_type":"image","duration":"","create_uid":1}]
             */
            private int sid;
            private String art_name;
            private String art_desc;
            private String create_time;
            private List<StudentArtworkAttachmentBean> student_artwork_attachment;

            public int getSid() {
                return sid;
            }

            public void setSid(int sid) {
                this.sid = sid;
            }

            public String getArt_name() {
                return art_name;
            }

            public void setArt_name(String art_name) {
                this.art_name = art_name;
            }

            public String getArt_desc() {
                return art_desc;
            }

            public void setArt_desc(String art_desc) {
                this.art_desc = art_desc;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public List<StudentArtworkAttachmentBean> getStudent_artwork_attachment() {
                return student_artwork_attachment;
            }

            public void setStudent_artwork_attachment(List<StudentArtworkAttachmentBean> student_artwork_attachment) {
                this.student_artwork_attachment = student_artwork_attachment;
            }

            public static class StudentArtworkAttachmentBean {
                /**
                 * file_id : 135
                 * file_url : http://s10.xiao360.com/qms/student_avatar/1/19/05/18/66e97e6dcad5f137bd22b531a1e8aa76.png
                 * file_type : png
                 * file_size : 504365
                 * file_name : 648a44cdddcd1a5aabfecb72ff760a54.jpg
                 * media_type : image
                 * duration :
                 * create_uid : 1
                 */

                private int file_id;
                private String file_url;
                private String file_type;
                private int file_size;
                private String file_name;
                private String media_type;
                private String duration;
                private int create_uid;

                public int getFile_id() {
                    return file_id;
                }

                public void setFile_id(int file_id) {
                    this.file_id = file_id;
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

                public int getFile_size() {
                    return file_size;
                }

                public void setFile_size(int file_size) {
                    this.file_size = file_size;
                }

                public String getFile_name() {
                    return file_name;
                }

                public void setFile_name(String file_name) {
                    this.file_name = file_name;
                }

                public String getMedia_type() {
                    return media_type;
                }

                public void setMedia_type(String media_type) {
                    this.media_type = media_type;
                }

                public String getDuration() {
                    return duration;
                }

                public void setDuration(String duration) {
                    this.duration = duration;
                }

                public int getCreate_uid() {
                    return create_uid;
                }

                public void setCreate_uid(int create_uid) {
                    this.create_uid = create_uid;
                }
            }
        }
    }
}
