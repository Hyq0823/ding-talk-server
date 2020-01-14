package com.hyq.pojo;

import java.util.List;

/**
 * FeedCard类型
 */
public class FeedCardMsg {

    private FeedCard feedCard;
    private String msgtype;
    public void setFeedCard(FeedCard feedCard) {
         this.feedCard = feedCard;
     }
     public FeedCard getFeedCard() {
         return feedCard;
     }

    public void setMsgtype(String msgtype) {
         this.msgtype = msgtype;
     }
     public String getMsgtype() {
         return msgtype;
     }



    public class FeedCard {

        private List<Links> links;
        public void setLinks(List<Links> links) {
            this.links = links;
        }
        public List<Links> getLinks() {
            return links;
        }

    }

    public class Links {

        private String title;
        private String messageURL;
        private String picURL;
        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setMessageURL(String messageURL) {
            this.messageURL = messageURL;
        }
        public String getMessageURL() {
            return messageURL;
        }

        public void setPicURL(String picURL) {
            this.picURL = picURL;
        }
        public String getPicURL() {
            return picURL;
        }

    }
}