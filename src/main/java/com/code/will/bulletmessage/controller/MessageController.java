package com.code.will.bulletmessage.controller;


import com.code.will.bulletmessage.dto.CommonResponse;
import com.code.will.bulletmessage.service.BulletMessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    BulletMessageManager messageManager;

    @RequestMapping("/startFetch/{roomId}")
    public ResponseEntity start(@PathVariable int roomId) throws Exception{
        messageManager.startClient(roomId);
        return new ResponseEntity(new CommonResponse(String.valueOf(HttpStatus.OK.value()), CommonResponse.ResultDescription.SUCCESS.toString(), null), HttpStatus.OK);
    }

    @RequestMapping("/stopRoom/{roomId}")
    public ResponseEntity stopSpecificRoom(@PathVariable String roomId) throws Exception{
        messageManager.stopSpecificRoom(roomId);
        return new ResponseEntity(new CommonResponse(String.valueOf(HttpStatus.OK.value()), CommonResponse.ResultDescription.SUCCESS.toString(), null), HttpStatus.OK);
    }

    @RequestMapping("/stopAllRoom")
    public ResponseEntity stopAllRoom() throws Exception{
        String result = messageManager.stopAllRoom();
        return new ResponseEntity(new CommonResponse(String.valueOf(HttpStatus.OK.value()), CommonResponse.ResultDescription.SUCCESS.toString(), result), HttpStatus.OK);
    }

    @RequestMapping("/listAllRoom")
    public ResponseEntity listAllRoom() throws Exception{
        String result = messageManager.listAllRoom();
        return new ResponseEntity(new CommonResponse(String.valueOf(HttpStatus.OK.value()), CommonResponse.ResultDescription.SUCCESS.toString(), result), HttpStatus.OK);
    }

}
