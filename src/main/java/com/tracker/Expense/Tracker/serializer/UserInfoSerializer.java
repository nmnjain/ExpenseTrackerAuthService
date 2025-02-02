package com.tracker.Expense.Tracker.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracker.Expense.Tracker.eventProducer.UserInfoEvent;
import com.tracker.Expense.Tracker.model.UserInfoDto;
import org.apache.catalina.User;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class UserInfoSerializer implements Serializer<UserInfoEvent> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }



    @Override
    public byte[] serialize(String args0, UserInfoEvent args1) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
            try{
                retVal = objectMapper.writeValueAsString(args1).getBytes();
            }catch(Exception e){
                e.printStackTrace();

            }
            return retVal;


    }

    @Override
    public void close(){}
}












