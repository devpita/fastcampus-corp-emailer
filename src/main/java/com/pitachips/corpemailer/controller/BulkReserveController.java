package com.pitachips.corpemailer.controller;

import com.pitachips.corpemailer.controller.dto.BulkReserveRequest;
import com.pitachips.corpemailer.controller.dto.BulkReserveResponseData;
import com.pitachips.corpemailer.controller.dto.BulkReserveTemplateContent;
import com.pitachips.corpemailer.controller.dto.common.ApiResponse;
import com.pitachips.corpemailer.controller.dto.common.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;

@Slf4j
@RestController
public class BulkReserveController {

    @PostMapping("/bulk-reserve")
    public ApiResponse<BulkReserveResponseData> bulkReserve(@RequestBody BulkReserveRequest requestDto) {

        int templateId = requestDto.getTemplateId();
        LocalDateTime sendAt = requestDto.getSendAt();
        LinkedHashMap<Long, BulkReserveTemplateContent> templateData = requestDto.getTemplateData();
        log.info("templateId: {}, sendAt: {}, templateData size: {}", templateId, sendAt, templateData.size());

        var dummyResponseData = new BulkReserveResponseData(Instant.now().toEpochMilli(), templateData.size());
        return new ApiResponse<>(ResponseCode.SUCCESS, "Bulk email reserved successfully", dummyResponseData);
    }

}
