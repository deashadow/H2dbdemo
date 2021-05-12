package com.therealdanvega.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.therealdanvega.domain.Author;
import com.therealdanvega.domain.Post;
import com.therealdanvega.repository.AuthorRepository;
import com.therealdanvega.repository.PostRepository;

@Service
public class DataLoader {

    private PostRepository postRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public DataLoader(PostRepository postRepository,AuthorRepository authorRepository){
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    @PostConstruct
    private void loadData(){
        // create an author
        Author rr = new Author("Ron","Rendessy");
        authorRepository.save(rr);
        Author ss = new Author("Renee","Rendessy");
        authorRepository.save(ss);

        // create a post
        Post post = new Post("Spring Data is Awesome!");
        post.setBody("Post Body here...");
        post.setPostedOn(new Date());
        post.setAuthor(rr, ss);
        postRepository.save(post);
    }

}
