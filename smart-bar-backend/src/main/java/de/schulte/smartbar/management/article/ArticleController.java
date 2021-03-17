package de.schulte.smartbar.management.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleDto ArticleDto) {
        final ArticleDto resultingDto = articleService.saveArticle(ArticleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultingDto);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<ArticleDto> updateArticle(ArticleDto ArticleDto) {
        final ArticleDto resultingDto = articleService.saveArticle(ArticleDto);
        return ResponseEntity.ok(resultingDto);
    }

    @GetMapping
    public ResponseEntity<List<ArticleDto>> list() {
        return ResponseEntity.ok(articleService.listAll());
    }

}
