package org.jt.sms.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "contacts")
public record ContactInfo(
        String message,
        Map<String, String> details,
        List<String> contactNumber
) {
}
