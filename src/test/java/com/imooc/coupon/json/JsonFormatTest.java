package com.imooc.coupon.json;

/**
 * ClassName: JsonFormatTest
 * Description: 通过json数据生成对象
 * Author: Leo
 * Date: 2020/3/5-17:24
 * email 1437665365@qq.com
 */
public class JsonFormatTest {
    /**
     * activeStatus : 2
     * availablePoints : 1167
     * cookies : {"uc1":{"value":"pas=0&cookie21=VT5L2FSpczFp&cookie14=UoTUOaqHaABqeA%3D%3D&cookie16=VFC%2FuZ9az08KUQ56dCrZDlbNdA%3D%3D&lng=zh_CN&existShop=false&tag=8&cookie15=URm48syIIVrSKA%3D%3D"},"t":{"value":"3c310c648e15ededddef711ff771c923"},"unb":{"value":"658828669"}}
     * expiredPoints : 0
     * lastMessage :
     * lastMessageId : -99
     * lastMessageType : 1
     * lastMessageUrl : //vip.tmall.com/messagebox/index.htm?tab=shop&scm=1040.1.0.0
     * login : true
     * mallSeller : false
     * messagePopup : false
     * newMessage : -99
     * newMsgList : null
     * taskId :
     */

    private int activeStatus;
    private int availablePoints;
    private CookiesBean cookies;
    private int expiredPoints;
    private String lastMessage;
    private int lastMessageId;
    private int lastMessageType;
    private String lastMessageUrl;
    private boolean login;
    private boolean mallSeller;
    private boolean messagePopup;
    private int newMessage;
    private Object newMsgList;
    private String taskId;

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    public int getAvailablePoints() {
        return availablePoints;
    }

    public void setAvailablePoints(int availablePoints) {
        this.availablePoints = availablePoints;
    }

    public CookiesBean getCookies() {
        return cookies;
    }

    public void setCookies(CookiesBean cookies) {
        this.cookies = cookies;
    }

    public int getExpiredPoints() {
        return expiredPoints;
    }

    public void setExpiredPoints(int expiredPoints) {
        this.expiredPoints = expiredPoints;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public int getLastMessageId() {
        return lastMessageId;
    }

    public void setLastMessageId(int lastMessageId) {
        this.lastMessageId = lastMessageId;
    }

    public int getLastMessageType() {
        return lastMessageType;
    }

    public void setLastMessageType(int lastMessageType) {
        this.lastMessageType = lastMessageType;
    }

    public String getLastMessageUrl() {
        return lastMessageUrl;
    }

    public void setLastMessageUrl(String lastMessageUrl) {
        this.lastMessageUrl = lastMessageUrl;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public boolean isMallSeller() {
        return mallSeller;
    }

    public void setMallSeller(boolean mallSeller) {
        this.mallSeller = mallSeller;
    }

    public boolean isMessagePopup() {
        return messagePopup;
    }

    public void setMessagePopup(boolean messagePopup) {
        this.messagePopup = messagePopup;
    }

    public int getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(int newMessage) {
        this.newMessage = newMessage;
    }

    public Object getNewMsgList() {
        return newMsgList;
    }

    public void setNewMsgList(Object newMsgList) {
        this.newMsgList = newMsgList;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public static class CookiesBean {
        /**
         * uc1 : {"value":"pas=0&cookie21=VT5L2FSpczFp&cookie14=UoTUOaqHaABqeA%3D%3D&cookie16=VFC%2FuZ9az08KUQ56dCrZDlbNdA%3D%3D&lng=zh_CN&existShop=false&tag=8&cookie15=URm48syIIVrSKA%3D%3D"}
         * t : {"value":"3c310c648e15ededddef711ff771c923"}
         * unb : {"value":"658828669"}
         */

        private Uc1Bean uc1;
        private TBean t;
        private UnbBean unb;

        public Uc1Bean getUc1() {
            return uc1;
        }

        public void setUc1(Uc1Bean uc1) {
            this.uc1 = uc1;
        }

        public TBean getT() {
            return t;
        }

        public void setT(TBean t) {
            this.t = t;
        }

        public UnbBean getUnb() {
            return unb;
        }

        public void setUnb(UnbBean unb) {
            this.unb = unb;
        }

        public static class Uc1Bean {
            /**
             * value : pas=0&cookie21=VT5L2FSpczFp&cookie14=UoTUOaqHaABqeA%3D%3D&cookie16=VFC%2FuZ9az08KUQ56dCrZDlbNdA%3D%3D&lng=zh_CN&existShop=false&tag=8&cookie15=URm48syIIVrSKA%3D%3D
             */

            private String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        public static class TBean {
            /**
             * value : 3c310c648e15ededddef711ff771c923
             */

            private String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        public static class UnbBean {
            /**
             * value : 658828669
             */

            private String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }

}
