package com.github.reactivespring.model;

import org.springframework.data.annotation.Id;

/**
 * @author iamsinghankit
 */
public record Product(@Id Integer id,String name) {}
