package com.sww.message.controller;


import com.sww.message.entity.Jpush;
import com.sww.message.entity.JsonResult;
import com.sww.message.service.JpushService;
import com.sww.message.util.ResultMapUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/jpush")
public class JpushController {

    @Resource
    private JpushService jpushService;

    /**
     * jpush推送功能
     * @param jpush
     * @return
     * @throws Exception
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/push", method = RequestMethod.POST)
    public ResultMapUtil push(@RequestBody Jpush jpush)throws Exception{
        ResultMapUtil resultMapUtil = new ResultMapUtil();
        //System.out.println(jpush);
        int code = jpushService.push(jpush);
        if (code==1) {
            jpushService.add(jpush);
            resultMapUtil.success();
            resultMapUtil.message("成功向app推送一条消息!");
        }else {
            resultMapUtil.fail(1001);
            resultMapUtil.message("推送失败!");
        }
        return resultMapUtil;
    }

    /**
     * 查询jpush记录列表
     * @return
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/jpushList", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getJPushList(int pageNum, int pageSize){
        JsonResult jsonResult = new JsonResult();
        try {
            List<Jpush> jPushList = jpushService.getJPushList(pageNum, pageSize);
            if (!jPushList.isEmpty()){
                jsonResult.setResult(jPushList);
                jsonResult.setStatus("success");
                jsonResult.setMsg("查询jpush记录成功!");
            }else {
                jsonResult.setResult(jPushList);
                jsonResult.setMsg("查询结果为空，记录不存在!");
            }
        }catch (Exception e){
            jsonResult.setResult(e.getClass().getName() + ": " +e.getMessage());
            jsonResult.setStatus("error");
            jsonResult.setMsg("请求错误!");
            e.printStackTrace();
        }
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 根据主键 push_id查询jpush记录
     * @param push_id
     * @return
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getJPushById", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getJPushById(Integer push_id){
        JsonResult jsonResult = new JsonResult();
        try {
            Jpush jpush = jpushService.getJPushById(push_id);
            jsonResult.setResult(jpush);
            jsonResult.setStatus("success");
            jsonResult.setMsg("查询jpush记录成功!");
        }catch (Exception e){
            jsonResult.setResult(e.getClass().getName() + ":" + e.getMessage());
            jsonResult.setStatus("error");
            jsonResult.setMsg("请求错误!");
            e.printStackTrace();
        }
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 根据 notification 查询jpush记录
     * @param notification
     * @return
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getJPushListByNotification", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getJPushListByNotification(String notification){
        JsonResult jsonResult = new JsonResult();
        try {
            List<Jpush> jpushList = jpushService.getJPushListByNotification(notification);
            if (!jpushList.isEmpty()){
                jsonResult.setResult(jpushList);
                jsonResult.setStatus("success");
                jsonResult.setMsg("查询jpush记录成功!");
            }else{
                jsonResult.setResult(jpushList);
                jsonResult.setMsg("查询记录不存在!");
            }

        }catch (Exception e){
            jsonResult.setResult(e.getClass().getName() + ":" + e.getMessage());
            jsonResult.setStatus("error");
            jsonResult.setMsg("请求错误!");
            e.printStackTrace();
        }
        return ResponseEntity.ok(jsonResult);
    }
}
