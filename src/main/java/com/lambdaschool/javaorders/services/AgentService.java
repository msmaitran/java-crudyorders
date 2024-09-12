package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Agents;

public interface AgentService {
    Agents findAgentById(long id);
}
