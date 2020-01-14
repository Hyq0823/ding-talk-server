package com.hyq.pojo;

import java.util.List;

public  class At {

        private List<String> atMobiles;
        private boolean isAtAll;
        public void setAtMobiles(List<String> atMobiles) {
            this.atMobiles = atMobiles;
        }
        public List<String> getAtMobiles() {
            return atMobiles;
        }

        public void setIsAtAll(boolean isAtAll) {
            this.isAtAll = isAtAll;
        }
        public boolean getIsAtAll() {
            return isAtAll;
        }

    }