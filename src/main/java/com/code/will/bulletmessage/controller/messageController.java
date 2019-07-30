package com.code.will.bulletmessage.controller;


import com.code.will.bulletmessage.dto.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/message")
public class messageController {


    @RequestMapping("/startFetch/{roomId}")
    public ResponseEntity start(@PathVariable String roomId){



        return new ResponseEntity(new CommonResponse(String.valueOf(HttpStatus.OK.value()), CommonResponse.ResultDescription.SUCCESS.toString(), null), HttpStatus.OK);

    }


}
