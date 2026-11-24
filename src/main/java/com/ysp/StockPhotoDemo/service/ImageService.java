package com.ysp.StockPhotoDemo.service;

import org.springframework.ai.google.genai.image.GoogleGenAiImageOptions;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private final ImageModel imageModel;

    public ImageService(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public ImageResponse generateImage(String prompt, int n, float temperature, String aspectRatio, int seed){
//        ImageResponse imageResponse = imageModel.call(
//                new ImagePrompt(prompt);

                        ImageResponse imageResponse = imageModel.call(
                new ImagePrompt(prompt, GoogleGenAiImageOptions.builder()
                                            .n(n)
                                            .temperature(temperature)
                                            .aspectRatio(aspectRatio)
                                            .seed(seed).build()
                        )
        );

        return imageResponse;
    }
}
