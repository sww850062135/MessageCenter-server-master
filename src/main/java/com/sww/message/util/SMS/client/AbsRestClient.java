
package com.sww.message.util.SMS.client;



public abstract class AbsRestClient {
	private  static final String  server = "open.ucpaas.com";
	
	/**
	 * 指定模版单发
	 * @param sid			用户的账号唯一标识
	 * @param token			用户密钥
	 * @param appid			创建应用时系统分配的唯一标识
	 * @param templateid	模板ID
	 * @param temp			模板中的替换参数
	 * @param mobile		接收的单个手机号
	 * @param uid			用户透传ID，随状态报告返回
	 * @return
	 */
	public abstract String sendSms(String sid, String token, String appid, String templateid, String temp, String mobile, String uid);


	/**
	 * 指定模版群发
	 * @param sid			用户的账号唯一标识
	 * @param token			用户密钥
	 * @param appid			创建应用时系统分配的唯一标识
	 * @param templateid	模板ID
	 * @param temp			模板中的替换参数
	 * @param mobile		接收的手机号,多个手机号码以英文逗号分隔
	 * @param uid			用户透传ID，随状态报告返回
	 * @return
	 */
    public abstract String sendSmsBatch(String sid, String token, String appid, String templateid, String temp, String mobile, String uid);

	/**
	 * 增加短信模版
	 * @param sid			用户的账号唯一标识
	 * @param token			用户密钥
	 * @param appid			创建应用时系统分配的唯一标识
	 * @param type			模版类型
	 * @param template_name	模版名称
	 * @param autograph		短信签名
	 * @param content		短信内容
	 * @return
	 */
	public abstract String addSmsTemplate(String sid, String token, String appid, String type, String template_name, String autograph, String content);

	/**
	 * 查询短信模版
	 * @param sid			用户的账号唯一标识
	 * @param token			用户密钥
	 * @param appid			创建应用时系统分配的唯一标识
	 * @param templateid	模版ID
	 * @param page_num		当前页
	 * @param page_size		每页显示的页数
	 * @return
	 */
	public abstract String getSmsTemplate(String sid, String token, String appid, String templateid, String page_num, String page_size);

	/**
	 * 编辑短信模版
	 * @param sid			用户的账号唯一标识
	 * @param token			用户密钥
	 * @param appid			创建应用时系统分配的唯一标识
	 * @param templateid	模版ID
	 * @param type			模版类型
	 * @param template_name	模版名称
	 * @param autograph		短信签名
	 * @param content		短信内容
	 * @return
	 */
	public abstract String editSmsTemplate(String sid, String token, String appid, String templateid, String type, String template_name, String autograph, String content);

	/**
	 * 删除短信模版
	 * @param sid			用户的账号唯一标识
	 * @param token			用户密钥
	 * @param appid			创建应用时系统分配的唯一标识
	 * @param templateid    模版ID
	 * @return
	 */
	public abstract String deleterSmsTemplate(String sid, String token, String appid, String templateid);


	public StringBuffer getStringBuffer() {
		StringBuffer sb = new StringBuffer("https://");
		sb.append(server).append("/ol/sms");
		return sb;
	}
}

