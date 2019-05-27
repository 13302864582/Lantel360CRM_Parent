package com.lantel.homelibrary.notify;

public class NotifyDesc {

    /**
     * p : {"span":{"style":"color:#92d050","content":"放假德生科技"}}
     */

    private PBean p;

    public PBean getP() {
        return p;
    }

    public void setP(PBean p) {
        this.p = p;
    }

    public static class PBean {
        /**
         * span : {"style":"color:#92d050","content":"放假德生科技"}
         */

        private SpanBean span;

        public SpanBean getSpan() {
            return span;
        }

        public void setSpan(SpanBean span) {
            this.span = span;
        }

        public static class SpanBean {
            /**
             * style : color:#92d050
             * content : 放假德生科技
             */

            private String style;
            private String content;

            public String getStyle() {
                return style;
            }

            public void setStyle(String style) {
                this.style = style;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }
}
