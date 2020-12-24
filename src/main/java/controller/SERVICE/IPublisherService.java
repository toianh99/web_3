package controller.SERVICE;

import model.Publisher;

public interface IPublisherService {
    int savePublisher (Publisher publisher);
    void updatePublisher (Publisher publisher);
    void deletePublisher (int id);
    Publisher getPublisherById(int id);
}
