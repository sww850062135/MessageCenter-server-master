package com.sww.message.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



@Configuration
@PropertySource(value = {"classpath:application.yml"})
@ComponentScan(basePackages = {"com.sww.message"})
public class EmailConfig {
   /* @Autowired
    private Environment env;

    @Bean(name = "mailSender")
    public JavaMailSender mailSender(){
        // 创建邮件发送器, 主要提供了邮件发送接口、透明创建Java Mail的MimeMessage、及邮件发送的配置
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // 如果为普通邮箱, 非ssl认证等
        mailSender.setHost(env.getProperty("spring.mail.host").trim());
        mailSender.setPort(Integer.parseInt(env.getProperty("spring.mail.port").trim()));
        mailSender.setUsername(env.getProperty("spring.mail.username").trim());
        mailSender.setPassword(env.getProperty("spring.mail.password").trim());
        mailSender.setDefaultEncoding("utf-8");
        // 配置邮件服务器
        Properties props = new Properties();
        // 让服务器进行认证,认证用户名和密码是否正确
        props.put("spring.mail.smtp.auth", "true");
        props.put("spring.mail.smtp.timeout", "25000");
        mailSender.setJavaMailProperties(props);
        return mailSender;
    }*/
    /**
     * 发件箱
     */
    @Value("${spring.mail.username}")
    private String email_from;

    public String getEmail_from() {
        return email_from;
    }

    public void setEmail_from(String email_from) {
        this.email_from = email_from;
    }
}
