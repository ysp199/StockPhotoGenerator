package com.ysp.StockPhotoDemo.controller;

import com.ysp.StockPhotoDemo.service.ImageService;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

//    @GetMapping("/generate-image")
//    public void generateImages(HttpServletResponse response, @RequestParam String prompt) throws IOException {
//        ImageResponse imageResponse = imageService.generateImage(prompt);
//        String url = imageResponse.getResult().getOutput().getUrl();
//        response.sendRedirect(url);
//    }

    @GetMapping("/generate-image")
    public List<String> generateImages(@RequestParam(name = "prompt") String prompt,
                                       @RequestParam(name = "n", defaultValue = "1") int n,
                                       @RequestParam(name = "temperature", defaultValue = "0.2") float temperature,
                                       @RequestParam(name = "aspectRatio", defaultValue = "1:1") String aspectRatio,
                                       @RequestParam(name = "seed", defaultValue = "1") int seed) {
        ImageResponse imageResponse = imageService.generateImage(prompt, n, temperature, aspectRatio, seed);
        List<String> imageUrls =  imageResponse.getResults().stream()
                .map(result -> result.getOutput().getUrl())
                .toList();
        return imageUrls;
    }
}
