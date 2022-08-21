package com.web.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PostDto {
   
   @NotEmpty(message = "please fill the message content")
   private String message_content;

   private String image;

   @NotNull(message = "user id is required")
   private long user_id;
}
