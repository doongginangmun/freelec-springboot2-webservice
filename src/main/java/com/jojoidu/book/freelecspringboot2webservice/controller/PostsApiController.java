package com.jojoidu.book.freelecspringboot2webservice.controller;

import com.jojoidu.book.freelecspringboot2webservice.service.posts.PostsService;
import com.jojoidu.book.freelecspringboot2webservice.web.dto.PostsResponseDto;
import com.jojoidu.book.freelecspringboot2webservice.web.dto.PostsSaveRequestDto;
import com.jojoidu.book.freelecspringboot2webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {

        return postsService.save(requestDto);
    }
    @PostMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody PostsUpdateRequestDto requestDto) {

        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
