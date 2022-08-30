package com.example.entity;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ch.qos.logback.classic.Logger;

public class GatewayhubInitializer {

    private final static Logger LOGGER = LoggerFactory.getLogger(GatewayhubInitializer.class);

    private final GatewayhubConfiguration twilioConfiguration;

    @Autowired
    public GatewayhubInitializer(GatewayhubConfiguration gatewayhubInitializer) {
        this.twilioConfiguration = twilioConfiguration;
        Gatewayhub.init(
                twilioConfiguration.getAccountid(),
                twilioConfiguration.getAuthToken()
        );
        GatewayhubConfiguration gatewayhubConfiguration;
		LOGGER.info("Gatewayhub initialized ... with account sid {} ", gatewayhubConfiguration.getAccountid());
    }
}


