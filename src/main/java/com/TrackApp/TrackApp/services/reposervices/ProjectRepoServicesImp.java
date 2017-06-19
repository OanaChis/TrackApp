package com.TrackApp.TrackApp.services.reposervices;

import com.TrackApp.TrackApp.domain.Project;
import com.TrackApp.TrackApp.repository.ProjectRepository;
import com.TrackApp.TrackApp.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oana_ on 6/14/2017.
 */

@Service
@Transactional(readOnly = true)
public class ProjectRepoServicesImp implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<?> listAll() {
        List<Project> projects = new ArrayList<>();
        projectRepository.findAll().forEach(projects :: add);
        return projects;
    }

    @Override
    public Project getById(Integer id) {
        return projectRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = false)
    public Project saveOrUpdate(Project domainObject) {
        return projectRepository.save(domainObject);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        projectRepository.delete(id);
    }
}
