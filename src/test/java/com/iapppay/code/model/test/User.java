package com.iapppay.code.model.test;

import java.net.URLDecoder;

public class User {

    private int userId;
    private String userName;
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) throws Exception {
        String json = "transdata\u003d%7B%22goodsname%22%3A%22200%2C000%E7%B1%8C%E7%A2%BC%22%2C%22cporderid%22%3A%2215070818043953281%22%2C%22notifyurl%22%3A%22https%3A%5C%2F%5C%2Fwww.happiplay.com%5C%2Fpay%5C%2Fiapppay%5C%2Fmobile_callback%22%2C%22appuserid%22%3A%221681577%22%2C%22money%22%3A%222.00%22%2C%22appid%22%3A%223000589445%22%2C%22cpprivate%22%3A%221681577%22%2C%22currency%22%3A%22USD%22%7D\u0026sign\u003dGSkDn2TIfvKCcHRIL4ipQX%2B249Nps3iGcp55UzFtYiutJX9hLVGmOlmQIBVZrisWrY83%2F9dAC5BgjchyiMI3sc33rdL98b6YcSRSsY7phXSMcEU8FImt09T5c5rPXsUaU3bZD2k4%2FE%2BXaP%2FEDMRBVUtzlETiIJGU0y6ahIHZZbg%3D\u0026signtype\u003dRSA";
        System.out.println(URLDecoder.decode(json, "UTF-8"));
    }
}
