package com.web.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class ResponseHttp<T> {

   private boolean status;

   private List<String> messages = new ArrayList<String>();

   private T payload;
   
}
