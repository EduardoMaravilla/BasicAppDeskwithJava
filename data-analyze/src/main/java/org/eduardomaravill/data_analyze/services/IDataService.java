package org.eduardomaravill.data_analyze.services;

import org.eduardomaravill.data_analyze.dtos.RequestLink;
import org.eduardomaravill.data_analyze.dtos.ResponseLink;

import java.util.List;

public interface IDataService {

    List<ResponseLink> getDataLinks(RequestLink requestLink);

    void downloadDataFiles();

    void generateRecords();
}
