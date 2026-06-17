package com.nexacorp.deployment.controller;

import com.nexacorp.deployment.model.Deployment;
import com.nexacorp.deployment.model.DeploymentEnvironment;
import com.nexacorp.deployment.service.DeploymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/deployments")
@RequiredArgsConstructor
class DeploymentController {
    private final DeploymentService deploymentService;

    @GetMapping
    public List<Deployment> getAllDeployments() {
        return deploymentService.getDeployments();
    }

    @GetMapping("/{id}")
    public Deployment getDeployment(@PathVariable Long id) {
        return deploymentService.getDeployment(id);
    }

    @PostMapping
    public Deployment createDeployment(
            @RequestParam String serviceName,
            @RequestParam DeploymentEnvironment environment,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime scheduledTime,
            @RequestParam String owner) {

        return deploymentService.createDeployment(serviceName, environment, scheduledTime, owner);
    }


   

}