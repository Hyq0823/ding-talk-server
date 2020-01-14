package com.hyq.pojo;

public class MarkDownMsg {

    private String msgtype;
    private Markdown markdown;
    private At at;
    public void setMsgtype(String msgtype) {
         this.msgtype = msgtype;
     }
     public String getMsgtype() {
         return msgtype;
     }

    public void setMarkdown(Markdown markdown) {
         this.markdown = markdown;
     }
     public Markdown getMarkdown() {
         return markdown;
     }

    public void setAt(At at) {
         this.at = at;
     }
     public At getAt() {
         return at;
     }



    public static class Markdown {

        private String title;
        private String text;
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

    }
}