package com.unep.wcmc.helper;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.util.Map;

@Component
@SuppressWarnings("all")
public class MailUtils {

    private static final String TEMPLATE_DIR = "com/unep/wcmc/";
    private static final String TEMPLATE_ENCODING = "UTF-8";

    public static final String FORGOT_PASSWORD_TEMPLATE = "email.template.vm";

    public static final String CHANGE_REQUESTED_TEMPLATE = "change.requested.email.template.vm";
    public static final String CHANGE_APPROVED_TEMPLATE = "change.approved.email.template.vm";
    public static final String CHANGE_REJECTED_TEMPLATE = "change.rejected.email.template.vm";


    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private VelocityEngine velocityEngine;


    @Async
    public void sendEmail(String to, String from, String subject, String template, Map<String, Object> parameters) {
        final MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setSubject(subject);
                message.setTo(to);
                message.setFrom(from);
                String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, TEMPLATE_DIR + template,
                        TEMPLATE_ENCODING, parameters);
                message.setText(text, true);
            }
        };
        emailSender.send(preparator);
    }

}
