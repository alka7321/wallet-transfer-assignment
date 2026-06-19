package com.example.wallet.web;

import com.example.wallet.service.TransferExecutionResult;
import com.example.wallet.service.TransferService;
import com.example.wallet.web.dto.TransferRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<?> createTransfer(@Valid @RequestBody TransferRequest request) {
        TransferExecutionResult result = transferService.createTransfer(request);
        return ResponseEntity.status(result.statusCode()).body(result.body());
    }
}
