package com.kafkaproject.estoque_consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkaproject.estoque_consumer.constants.KafkaConstants;
import com.kafkaproject.estoque_consumer.dto.VendaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EstoqueListener {

    @Autowired
    private ObjectMapper objectMapper;

    // usando o KafkaConsumerConfig - ConsumerFactory
    @KafkaListener(topics = KafkaConstants.TOPIC_PRODUCT_UODATE, groupId = "estoque-group")
    public void processSale1(String message) throws JsonProcessingException {
        VendaDTO vendaDTO = objectMapper.readValue(message, VendaDTO.class);
        log.info("Info de Venda recebida: "
                .concat("IdVenda: ").concat(vendaDTO.getIdVenda())
                .concat(", IdProduto: ").concat(String.valueOf(vendaDTO.getIdProduto()))
                .concat(", Quantidade: ").concat(String.valueOf(vendaDTO.getQuantidade()))
                .concat(", ValorTotal: ").concat(String.valueOf(vendaDTO.getValorTotal()))
                .concat(", DataVenda: ").concat(String.valueOf(vendaDTO.getDataVenda()))
                .concat(", Tipo: ").concat(String.valueOf(vendaDTO.getTipo()))
        );
        log.info("jsonMessage: ".concat(message));
    }
}
