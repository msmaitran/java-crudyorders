package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Agents;
import com.lambdaschool.javaorders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "agentService")
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentrepo;

    @Override
    public Agents findAgentById(long id) {
        return agentrepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException(Long.toString(id)));
    }
}
