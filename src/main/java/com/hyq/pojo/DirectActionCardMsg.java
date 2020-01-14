package com.hyq.pojo;

public class DirectActionCardMsg {

    private ActionCard actionCard;
    private String msgtype;
    public void setActionCard(ActionCard actionCard) {
         this.actionCard = actionCard;
     }
     public ActionCard getActionCard() {
         return actionCard;
     }

    public void setMsgtype(String msgtype) {
         this.msgtype = msgtype;
     }
     public String getMsgtype() {
         return msgtype;
     }


    public static class ActionCard {

        private String title;
        private String text;
        private String hideAvatar;
        private String btnOrientation;
        private String singleTitle;
        private String singleURL;
        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setText(String text) {
            this.text = text;
        }
        public String getText() {
            return text;
        }

        public void setHideAvatar(String hideAvatar) {
            this.hideAvatar = hideAvatar;
        }
        public String getHideAvatar() {
            return hideAvatar;
        }

        public void setBtnOrientation(String btnOrientation) {
            this.btnOrientation = btnOrientation;
        }
        public String getBtnOrientation() {
            return btnOrientation;
        }

        public void setSingleTitle(String singleTitle) {
            this.singleTitle = singleTitle;
        }
        public String getSingleTitle() {
            return singleTitle;
        }

        public void setSingleURL(String singleURL) {
            this.singleURL = singleURL;
        }
        public String getSingleURL() {
            return singleURL;
        }

    }
}