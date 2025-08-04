package com.comments.Comments.controller;

public record Comment(long postId, long id, String name, String email, String body) {
}
