package demo.util;

import demo.domain.MsgInfo;


public class MsgUtil {

    public static MsgInfo buildMsg(String channelId, String msgContent) {
        return new MsgInfo(channelId,msgContent);
    }

}
