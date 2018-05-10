package com.sww.message.controller;

import com.sww.message.entity.JsonResult;
import com.sww.message.entity.Sms;
import com.sww.message.entity.Template;
import com.sww.message.service.SmsService;
import com.sww.message.service.TemplateService;
import com.sww.message.util.ResultMapUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/sms")
public class SmsController {
    @Resource
    private SmsService smsService;
    @Resource
    private TemplateService templateService;

    /**
     * 指定模版单发
     * @param sms
     * @return
     * @throws Exception
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/sendSms", method = RequestMethod.POST)
    public ResultMapUtil sendSms(@RequestBody Sms sms) throws Exception{
        ResultMapUtil result = new ResultMapUtil();
        int code = smsService.SendSms(sms);
        if (code==1) {
            String templateid = sms.getTemplateid();
            String temp = sms.getTemp();
            if (temp.isEmpty()){
                sms.setSmsType("通知模版");
            }
            else {
                sms.setSmsType("验证码模版");
            }
            if ("314338".equals(templateid)){
                sms.setSms_content("【Aeiherumuh】尊敬的用户，您已成功报名我司的活动，请准时参加");
            }else if ("314404".equals(templateid)){
                sms.setSms_content("【安居家园消息推送中心】温馨提示，您的密码已过期，请及时登录处理。");
            }else if ("314402".equals(templateid)){
                sms.setSms_content("【Aeiherumuh】尊敬的用户，您已成功接收我的消息。");
            }else if ("314379".equals(templateid)){
                sms.setSms_content("【Aeiherumuh】您的验证码是"+sms.getTemp()+"。如非本人操作，请忽略本短信。");
            }
            sms.setSms_status("success");
            smsService.add(sms);
            result.success();
            result.message("成功发送短信消息!");
        }else {
            result.fail(1001);
            result.message("发送失败!");
        }
        return result;
    }

    /**
     * 指定模版群发
     * @param sms
     * @return
     * @throws Exception
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/sendSmsBatch", method = RequestMethod.POST)
    public ResultMapUtil sendSmsBatch(@RequestBody Sms sms) throws Exception{
        ResultMapUtil result = new ResultMapUtil();
        int code = smsService.SendSmsBatch(sms);
        if (code==1){
            String templateid = sms.getTemplateid();
            String temp = sms.getTemp();
            if (temp.isEmpty()){
                sms.setSmsType("通知模版");
            }
            else {
                sms.setSmsType("验证码模版");
            }

            if ("314338".equals(templateid)){
                sms.setSms_content("【Aeiherumuh】尊敬的用户，您已成功报名我司的活动，请准时参加");
            }else if ("314404".equals(templateid)){
                sms.setSms_content("【安居家园消息推送中心】温馨提示，您的密码已过期，请及时登录处理。");
            }else if ("314402".equals(templateid)) {
                sms.setSms_content("【Aeiherumuh】尊敬的用户，您已成功接收我的消息。");
            }else if ("314379".equals(templateid)){
                sms.setSms_content("【Aeiherumuh】您的验证码是"+sms.getTemp()+"。如非本人操作，请忽略本短信。");
            }
            sms.setSms_status("success");
            smsService.add(sms);
            result.success();
            result.message("成功发送短信消息!");
        }else {
            result.fail(1001);
            result.message("发送失败!");
        }
        return result;
    }

    /**
     * 增加短信模版
     * @param template
     * @return
     * @throws Exception
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/addSmsTemplate", method = RequestMethod.POST)
    public ResultMapUtil addSmsTemplate(@RequestBody Template template) throws Exception{
        ResultMapUtil result = new ResultMapUtil();
        int code = smsService.AddSmsTemplate(template);
        if (code==1){
            templateService.addSmsTemplate(template); //向数据库插入一条短信模版数据
            result.success();
            result.message("成功增加一条短信模版");
        }else {
            result.fail(1001);
            result.message("创建模版失败!");
        }
        return result;
    }

    /**
     * 查询短信模版
     * @param template
     * @param page_num
     * @param page_size
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/getSmsTemplate", method = RequestMethod.GET)
    public String getSmsTemplate(@RequestBody Template template, String page_num, String page_size){
        String result = smsService.GetSmsTemplate(template, page_num, page_size);
        return result;
    }

    /**
     * 编辑短信模版
     * @param template
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/editSmsTemplate", method = RequestMethod.POST)
    public String editSmsTemplate(@RequestBody Template template){
        String result = smsService.EditSmsTemplate(template);
        return result;
    }

    /**
     * 删除短信模版
     * @param template
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public String deleterSmsTemplate(@RequestBody Template template){
        String result = smsService.DeleterSmsTemplate(template);
        return result;
    }

    /**
     * 查询sms所有记录
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/smsList", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getSmsList(int pageNum, int pageSize){
        JsonResult jsonResult = new JsonResult();
        try {
            List<Sms> smsList = smsService.getSmsList(pageNum, pageSize);
            jsonResult.setResult(smsList);
            jsonResult.setStatus("success");
            jsonResult.setMsg("查询短信推送记录成功!");
        }catch (Exception e){
            jsonResult.setResult(e.getClass().getName() + ":" + e.getMessage());
            jsonResult.setStatus("error");
            jsonResult.setMsg("请求错误!");
            e.printStackTrace();
        }
        return ResponseEntity.ok(jsonResult);
    }


    /**
     * 根据手机号mobile查询sms记录
     * @param mobile
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/getSmsListByMobile", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getSmsListByMobile(String mobile){
        JsonResult jsonResult = new JsonResult();
        try {
            List<Sms> smsList = smsService.getSmsListByMobile(mobile);
            if (!smsList.isEmpty()){
                jsonResult.setResult(smsList);
                jsonResult.setStatus("success");
                jsonResult.setMsg("查询成功");
            }else {
                jsonResult.setResult(smsList);
                jsonResult.setMsg("查询结果为空，该记录不存在!");
            }
        }catch (Exception e){
            jsonResult.setResult(e.getClass().getName() + ":" + e.getMessage());
            jsonResult .setStatus("error");
            jsonResult .setMsg("请求错误!");
            e.printStackTrace();
        }
        return ResponseEntity.ok(jsonResult);
    }

}
