package com.hyq.pojo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TextMsg {

    private String msgtype = "text";
    @NotNull(message = "消息不能为空")
    private Text text;
    private At at;



    public void setMsgtype(String msgtype) {
         this.msgtype = msgtype;
     }
     public String getMsgtype() {
         return msgtype;
     }

    public void setText(Text text) {
         this.text = text;
     }
     public Text getText() {
         return text;
     }

    public void setAt(At at) {
         this.at = at;
     }
     public At getAt() {
         return at;
     }




   public static class Text {
        @NotEmpty(message = "消息内容不能为空")
        private String content;


        public void setContent(String content) {
            this.content = content;
        }
        public String getContent() {
            return content;
        }

    }



}