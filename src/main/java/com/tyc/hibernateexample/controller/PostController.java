package com.tyc.hibernateexample.controller;

import java.util.Date;

import com.tyc.hibernateexample.entity.Post;
import com.tyc.hibernateexample.repository.PostRepository;

public class PostController {
	public static void main(String[] args) {
		PostRepository postRepository = new PostRepository();
		postRepository.save(new Post("�cerik - 1", new Date()));
	}
}
