package org.eduardomaravill.data_analyze.services;

import org.eduardomaravill.data_analyze.models.Link;

import java.util.List;

public interface ILinkService {

    List<Link> getLinks();
    List<Link> saveLinks(List<Link> links);
    Link saveLink(Link link);

}
