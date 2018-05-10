package com.sww.message.controller;

import com.sww.message.entity.Email;
import com.sww.message.entity.JsonResult;
import com.sww.message.service.EmailService;
import com.sww.message.util.ResultMapUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController()
@RequestMapping(value = "/v1/emails")
public class EmailController {

    @Resource
    private EmailService emailService;

    /**
     * 发送邮件
     * @param email
     * @return
     * @throws Exception
     */
    @CrossOrigin("*")       //允许跨域请求
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public ResultMapUtil send(@RequestBody Email email) throws Exception{
        //System.out.println(email);
        ResultMapUtil resultMapUtil = new ResultMapUtil();
        //EmailRabbit emailRabbit = new EmailRabbit(email);
        //int code = emailService.sendEmailToEmailQueue(emailRabbit);
        int code = emailService.sendSimpleMail(email);
        //System.out.println(code);
        if (code==1){
            emailService.add(email);

            resultMapUtil.success();
            resultMapUtil.message("邮件发送成功!");
        }
        else{
            resultMapUtil.fail(1001);
            resultMapUtil.message("邮件发送失败!");
        }
        return resultMapUtil ;
    }

    /**
     * 查询邮件推送记录列表
     * @return
     */
    @CrossOrigin("*")        //允许跨域请求
    @RequestMapping(value = "/emailList", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getEmailList (int pageNum, int pageSize){
        JsonResult result = new JsonResult();
        try {
            List<Email> emails = emailService.getEmailList(pageNum, pageSize);
            result.setResult(emails);
            result.setStatus("success");
            result.setMsg("查询邮件推送记录成功!");

        }catch (Exception e){
            result.setResult(e.getClass().getName() + ":" + e.getMessage());
            result.setStatus("error");
            result.setMsg("请求错误!");
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);

    }

    /**
     * 根据ID查询邮件
     * @param mail_id
     * @return
     */
    @CrossOrigin("*")            //允许跨域请求
    @RequestMapping(value = "/getEmailById", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getEmailById (Integer mail_id){
        JsonResult result = new JsonResult();
        try {
            Email email = emailService.getEmailById(mail_id);
            result.setResult(email);
            result.setStatus("success");
            result.setMsg("查询成功!");
        }catch (Exception e){
            result.setResult(e.getClass().getName() + ":" + e.getMessage());
            result.setStatus("error");
            result.setMsg("查询失败!");
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 根据subject查询邮件
     * @param subject
     * @return
     */
    @CrossOrigin("*")            //允许跨域请求
    @RequestMapping(value = "/getEmailListBySubject", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getEmailListBySubject (String subject){
        JsonResult result = new JsonResult();
        try {
            List<Email> emails = emailService.getEmailListBySubject(subject);
            if (!emails.isEmpty()){
                result.setResult(emails);
                result.setStatus("success");
                result.setMsg("查询成功!");
            }else {
                result.setResult(emails);
                result.setMsg("查询结果为空，该记录不存在!");
            }
        }catch (Exception e){
            result.setResult(e.getClass().getName() + ":" + e.getMessage());
            result.setStatus("error");
            result.setMsg("请求错误!");
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 根据收件人 email_to 查询邮件记录
     * @param email_to
     * @return
     */
    @CrossOrigin("*")            //允许跨域请求
    @RequestMapping(value = "/getEmailListByEmail_to", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getEmailListByEmail_to (String email_to){
        JsonResult result = new JsonResult();
        try {
            List<Email> emails = emailService.getEmailListByEmail_to(email_to);
            if (!emails.isEmpty()){
                result.setResult(emails);
                result.setStatus("success");
                result.setMsg("查询成功!");
            }else {
                result.setResult(emails);
                result.setMsg("查询结果为空，该记录不存在!");
            }
        }catch (Exception e){
            result.setResult(e.getClass().getName() + ":" + e.getMessage());
            result.setStatus("error");
            result.setMsg("请求错误!");
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);
    }
}
