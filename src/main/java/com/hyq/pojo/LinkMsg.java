package com.hyq.pojo;


public class LinkMsg {

    private String msgtype;
    private Link link;
    public void setMsgtype(String msgtype) {
         this.msgtype = msgtype;
     }
     public String getMsgtype() {
         return msgtype;
     }

    public void setLink(Link link) {
         this.link = link;
     }
     public Link getLink() {
         return link;
     }



    public static class Link {

        private String text;
        private String title;
        private String picUrl;
        private String messageUrl;
        public void setText(String text) {
            this.text = text;
        }
        public String getText() {
            return text;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }
        public String getPicUrl() {
            return picUrl;
        }

        public void setMessageUrl(String messageUrl) {
            this.messageUrl = messageUrl;
        }
        public String getMessageUrl() {
            return messageUrl;
        }

    }
}