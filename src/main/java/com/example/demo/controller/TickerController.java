package com.example.demo.controller;

import com.example.demo.entity.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TickerController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/api/v1/")
    @ResponseBody
    public ResponseEntity<List<Ticket>> search(@RequestParam(value = "search") String search) {
        return ResponseEntity.ok(ticketService.search(search));
    }
}
