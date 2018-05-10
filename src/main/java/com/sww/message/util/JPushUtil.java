package com.sww.message.util;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.*;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import java.util.Map;

public class JPushUtil {
    private static final String MASTER_SECRET = "c4867f6af42c4e80011cf268";
    private static final String APP_KEY = "8ffe2005644a3a00f0f4d08a";


    /**
     * 构建推送对象：对所有平台，所有设备，内容为 alert的通知
     * @param alter
     * @return
     */
    public static PushPayload buildPushObject_all_all_alert(String alter) {
        return PushPayload.alertAll(alter);
    }
    /**
     * 所有平台，推送目标是别名为 "alias"，通知内容为 alert
     * @param alias
     * @param alert
     * @return
     */
    public static PushPayload buildPushObject_all_alias_alert(String alias,Object alert) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.alert(alert))
                .build();
    }
    /**
     * 构建推送对象：平台是 Android，目标是 tag的设备，通知内容是alert，并且标题为title。
     * @param tag
     * @param alert
     * @param title
     * @param extras
     * @return
     */
    public static PushPayload buildPushObject_android_tag_alertWithTitle(String tag,String alert,String title,Map<String, String> extras) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag(tag))
                .setNotification(Notification.android(alert, title, extras))
                .build();
    }
    /**
     * 构建推送对象：平台是 iOS，推送目标是 tags(可以是一个设备也可以是多个设备)，推送内容同时包括通知与消息 - 通知信息是alert，消息内容是 msgContent，角标数字为badge(应用程序左上角或者右上角的数字)，通知声音为sound，并且附加字段 from = "JPushUtil"。
     * 通知是 APNs 推送通道的，消息是 JPushUtil 应用内消息通道的。
     * APNs 的推送环境是“生产”（如果不显式设置的话，Library 会默认指定为开发）
     * @param alert
     * @param msgContent
     * @param badge
     * @param sound
     * @param tags
     * @return
     */
    public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage(Object alert,String msgContent,int badge,String sound,String...tags) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.ios())
                .setAudience(Audience.tag_and(tags))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(alert)
                                .setBadge(badge)
                                .setSound(sound)
                                .addExtra("from", "JPushUtil")
                                .build())
                        .build())
                .setMessage(Message.content(msgContent))
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)
                        .build())
                .build();
    }
    /**
     * 构建推送对象：平台是 Andorid 与 iOS，推送的设备有（推送目标为tags和推送目标别名为aliases），推送内容是 - 内容为 msg_content的消息，并且附加字段 from = JPushUtil。
     * @param msg_content
     * @param tags
     * @param aliases
     * @return
     */
    public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras(String msg_content,String[] tags,String[] aliases) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.newBuilder()
                        .addAudienceTarget(AudienceTarget.tag(tags))
                        .addAudienceTarget(AudienceTarget.alias(aliases))
                        .build())
                .setMessage(Message.newBuilder()
                        .setMsgContent(msg_content)
                        .addExtra("from", "JPushUtil")
                        .build())
                .build();
    }
    /**
     * 构建推送对象：推送内容包含SMS信息
     * @param title
     * @param sendSMSContent
     * @param delayTime
     * @param aliases
     */
    public static void testSendWithSMS(String title,String sendSMSContent,int delayTime,String... aliases) {
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);
        try {
            SMS sms = SMS.content(sendSMSContent, delayTime);
            PushResult result = jpushClient.sendAndroidMessageWithAlias(title, sendSMSContent, sms, aliases);
            System.out.println("Got result - " + result);
        } catch (APIConnectionException e) {
            System.out.println("Connection error. Should retry later. "+e);
        } catch (APIRequestException e) {
            System.out.println("Error response from JPushUtil server. Should review and fix it. "+e);
            System.out.println("HTTP Status: " + e.getStatus());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Error Message: " + e.getErrorMessage());
        }
    }



}
