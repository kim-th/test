package com.msnks.solr.api.repository;

import java.io.Serializable;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.msnks.solr.api.model.User;

public interface UserRepository extends SolrCrudRepository<User, Serializable>{

	User findByName(String name);

}
