package com.farshad.importer.service.impl;

import com.farshad.importer.conf.QueueConstants;
import com.farshad.importer.dto.ProductDto;
import com.farshad.importer.service.Writer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductJmsWriter implements Writer<ProductDto> {

    @Autowired
    protected RabbitTemplate rabbitTemplate;

    @Override
    public void write(ProductDto productDto) {
        rabbitTemplate.convertAndSend(QueueConstants.PRODUCT_QUEUE_NAME, productDto);
    }
}
