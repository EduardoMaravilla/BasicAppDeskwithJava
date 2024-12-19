package org.eduardomaravill.data_analyze.services.implementations;

import lombok.extern.log4j.Log4j2;
import org.eduardomaravill.data_analyze.models.Link;
import org.eduardomaravill.data_analyze.repository.ILinkRepository;
import org.eduardomaravill.data_analyze.services.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class LinkServiceImpl implements ILinkService {

    private final ILinkRepository linkRepository;

    @Autowired
    public LinkServiceImpl(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public List<Link> getLinks() {
        return linkRepository.findAll();
    }

    @Override
    public List<Link> saveLinks(List<Link> links) {
        List<Link> linkIds = new ArrayList<>();
        for (Link link: links){
            Link savedLink = saveLink(link);
            if(savedLink != null){
                linkIds.add(savedLink);
            }  else {
                log.info("Link already exists ");
            }
        }
        return linkIds;
    }

    @Override
    public Link saveLink(Link link) {
        if(!linkRepository.existsByTitleAndDateCreated(link.getTitle(),link.getDateCreated())){
            return linkRepository.save(link);
        }
        return null;
    }
}
