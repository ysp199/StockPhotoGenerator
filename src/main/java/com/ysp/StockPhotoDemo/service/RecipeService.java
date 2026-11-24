package com.ysp.StockPhotoDemo.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RecipeService {

    private final ChatModel chatModel;

    public RecipeService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String createRecipe(String ingredients,
                               String cuisine,
                               String dietaryRestrictions){
        var template = """
                I want to create a recipe using the following ingredients:{ingredients}.
                The cuisine type I prefer is {cuisine}.
                Please consider the following dietary restrictions: {dietaryRestrictions}.
                Please provide me a detailed recipe including title, list of ingredients,
                and cooking instructions
                """;

        PromptTemplate promptTemplate = new PromptTemplate(template);
        //internally using Map<String, Object> as  var
        var prompt = promptTemplate.create(Map.of(
                "ingredients", ingredients,
                "cuisine", cuisine,
                "dietaryRestrictions", dietaryRestrictions
        ));

        return chatModel.call(prompt).getResult().getOutput().getText();
    }
}
