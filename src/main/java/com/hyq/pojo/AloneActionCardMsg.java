package com.hyq.pojo;

import java.util.List;

/**
 * 独立跳转ActionCard类型
 */
public class AloneActionCardMsg {

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

    public class Btns {

        private String title;
        private String actionURL;
        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setActionURL(String actionURL) {
            this.actionURL = actionURL;
        }
        public String getActionURL() {
            return actionURL;
        }

    }

    public class ActionCard {

        private String title;
        private String text;
        private String hideAvatar;
        private String btnOrientation;
        private List<Btns> btns;
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

        public void setBtns(List<Btns> btns) {
            this.btns = btns;
        }
        public List<Btns> getBtns() {
            return btns;
        }

    }

}