package com.example.app.service;

import com.example.app.dto.PostDTO;
import com.example.app.model.Post;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @PersistenceContext
    private EntityManager entityManager;

    private int pageSize = 2;

    public List<PostDTO> listPostTitlesAndTopics(int pageNumber) {
        List<Post> posts = entityManager
                .createQuery("SELECT p FROM Post p")
                .setFirstResult((pageNumber - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
        List<PostDTO> result = new ArrayList(posts.size());

        for(Post post : posts) {
            PostDTO postDto = new PostDTO();
            postDto.setId(post.getId());
            postDto.setTitle(post.getTitle());
            postDto.setTopicName(post.getTopic().getName());
            result.add(postDto);
        }

        return result;
    }

    public List listPostTitlesAndTopicsV2(int pageNumber) {
        final String sql = "select new com.example.app.dto.PostDTO(p.id, p.title, t.name) " +
                " from Post p " +
                " join p.topic t";

        return entityManager
                .createQuery(sql)
                .setFirstResult((pageNumber - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }
}

