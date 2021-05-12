package com.therealdanvega.repository;

import com.therealdanvega.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
